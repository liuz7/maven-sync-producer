package com.dianping.maven.sync.producer.controller;

import com.dianping.maven.sync.producer.model.GlobalAuditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.StringJoiner;

/**
 * Created by georgeliu on 2017/5/24.
 */
@RestController
@RequestMapping("/global")
public class GlobalAuditEventController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic}")
    private String kafkaTopic;

    public static final Logger logger = LoggerFactory.getLogger(GlobalAuditEventController.class);
    public static final String REPOSITORY_ASSET = "repository.asset";

    @RequestMapping(value = "/audit/", method = RequestMethod.POST)
    public ResponseEntity<?> postAuditEvent(@RequestBody GlobalAuditEvent globalAuditEvent) {
        logger.debug("Received Global Audit Event : {}", globalAuditEvent);
        if (globalAuditEvent.getAudit().getDomain().equalsIgnoreCase(REPOSITORY_ASSET)) {
            StringJoiner stringJoiner = new StringJoiner("|", "[", "]");
            String data = stringJoiner.add(globalAuditEvent.getAudit().getAttributes().getRepositoryName()).
                    add(globalAuditEvent.getAudit().getAttributes().getName()).
                    add(globalAuditEvent.getAudit().getType()).toString();
            this.kafkaTemplate.send(this.kafkaTopic, data);
        }
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
}
