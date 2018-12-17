package com.odilum.analytics.report;

import com.odilum.analytics.report.spark.processor.SparkProcessor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
@PropertySource(value = { "classpath:application.properties" })
public class OdilumAnalyticsReportServiceConfiguration {

    @Autowired
    Environment environment;

    @Value("${kafka.logs.topic}")
    private String logsTopic;

    @Value("${spark.application.name}")
    private String applicationName;

    @Value("${master.uri}")
    private String masterUri;

    @Value("${kafka.brokers}")
    String kafkaBrokerEndpoint;

    @Value("${kafka.topic.group}")
    String groupId;

    @Value("${stream.interval}")
    String streamInterval;

    @Bean
    public SparkConf sparkConf() {
         return new SparkConf()
                 .setAppName(applicationName)
                 .setMaster(masterUri);
    }

    @Bean
    public JavaSparkContext javaSparkContext() {
        return new JavaSparkContext(sparkConf());
    }

    @Bean
    public JavaStreamingContext javaStreamingContext() {
        return new JavaStreamingContext(javaSparkContext(), Durations.seconds(Long.valueOf(streamInterval)));
    }

    @Bean
    public SparkSession sparkSession() {
        return SparkSession
                .builder()
                .sparkContext(javaSparkContext().sc())
                .appName(applicationName)
                .getOrCreate();
    }

    @Bean
    public JavaInputDStream<ConsumerRecord<String,String>> javaInputDStream(){
        return KafkaUtils.createDirectStream(
                javaStreamingContext(), LocationStrategies.PreferConsistent(),
                ConsumerStrategies.<String,String>Subscribe(Arrays.asList(logsTopic), getKafkaConfiguration())
        );
    }

    private Map<String, Object> getKafkaConfiguration() {

        Map<String, Object> kafkaConfig = new HashMap();

        kafkaConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBrokerEndpoint);
        kafkaConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        kafkaConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        kafkaConfig.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        kafkaConfig.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        kafkaConfig.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);

        return kafkaConfig;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public SparkProcessor sparkProcessor() {
        return new SparkProcessor();
    }

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    private Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBrokerEndpoint);
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return props;
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
