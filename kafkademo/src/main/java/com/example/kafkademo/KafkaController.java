package com.example.kafkademo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private static Logger logger= LoggerFactory.getLogger(KafkaController.class);
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    //writing to single partition
    @GetMapping
    public ResponseEntity<String> publish(@RequestParam String msg) throws ExecutionException, InterruptedException {


        ListenableFuture<SendResult<String, String>> kafkaResponseFutue=  kafkaTemplate.send("demo-topic",msg);
        logger.info("data pushed: "+ kafkaResponseFutue.get());
       return ResponseEntity.ok().body("published");
    }

    //writing to two partition

    @GetMapping("/2partition")
    public ResponseEntity<String> publishTo2partition(@RequestParam String msg, @RequestParam String userId) throws ExecutionException, InterruptedException {


        ListenableFuture<SendResult<String, String>> kafkaResponseFutue=  kafkaTemplate.send("java",userId,msg);
        logger.info("data pushed: "+ kafkaResponseFutue.get());
        return ResponseEntity.ok().body("published");
    }

}
