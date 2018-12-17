package com.odilum.analytics.report.socket.handler.service;

import com.odilum.analytics.report.spark.processor.SparkProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SparkStreamingInitializerService {

    private SparkProcessor sparkProcessor;

    @Autowired
    public SparkStreamingInitializerService(SparkProcessor sparkProcessor) {
        this.sparkProcessor = sparkProcessor;
    }

    @PostConstruct
    public void startSparkStreamingContext(){
        sparkProcessor.sparkStreamProcessor();
    }
}
