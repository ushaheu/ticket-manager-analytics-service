package com.odilum.analytics.report.spark.processor;

import com.odilum.analytics.report.spark.processor.helpers.ComplaintStatusHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.odilum.analytics.report.spark.processor.helpers.TicketLogs;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class SparkProcessor {

    @Value("${kafka.analytics.topic}")
    private String destinationTopic;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.brokers}")
    String kafkaBrokerEndpoint;

    @Autowired
    private SparkSession sparkSession;

    @Autowired
    private JavaStreamingContext sparkStreamingContext;

    @Autowired
    private JavaInputDStream<ConsumerRecord<String,String>> logConsumerRecordStream;


    public void sparkStreamProcessor() {

        // Convert the streams of JavaRDD of ConsumerRecord to JavaRDD of Java Beans
        logConsumerRecordStream.foreachRDD((JavaRDD<ConsumerRecord<String,String>> logStreamConsumerRecordRDD) -> {

            JavaRDD<ComplaintStatusHelper> logRecordRDD = logStreamConsumerRecordRDD.map((logConsumerRecord) -> {
                System.out.println("The RDD here is "+logConsumerRecord);
                ComplaintStatusHelper complaintStatusHelper = new ComplaintStatusHelper();
                String logDeSerialized = logConsumerRecord.value();

                int indexOfString = logDeSerialized.indexOf("{");
                logDeSerialized = logDeSerialized.substring(indexOfString);
                System.out.println("The message retrieved is "+logDeSerialized);
                TicketLogs ticketLogs = new ObjectMapper().readValue(logDeSerialized, TicketLogs.class);

                complaintStatusHelper.setComplaintStatus(ticketLogs.getComplaintStatus());

                return complaintStatusHelper;

            }).distinct();//.filter(record -> record.getResponseCode() != null);

            // Create a Dataset of Rows (Dataframe) from the RDD of LoanDataRecord
            try {
                Dataset<Row> logDataset = sparkSession.createDataFrame(logRecordRDD, ComplaintStatusHelper.class);
                if (!logDataset.rdd().isEmpty()) {
                    List<String> listOfComplaintStatus = logDataset.javaRDD().map(row -> row.getString(0)).collect();
                    Map<String, Long> result = listOfComplaintStatus.stream().collect(Collectors.groupingBy(
                            Function.identity(), Collectors.counting()));
                    String jsonResult = new ObjectMapper().writeValueAsString(result);
                    kafkaTemplate.send(destinationTopic, result);
                    System.out.println("The spark result is " + jsonResult);

                }
            }catch (Exception ex){
                ex.printStackTrace();
            }

        });
        try {
            sparkStreamingContext.start();
            sparkStreamingContext.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
}

}
