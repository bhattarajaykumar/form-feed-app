package com.eficens.app.controller;

import com.eficens.app.entity.Feed;
import com.eficens.app.model.FeedRequest;
import com.eficens.app.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class FeedController {

    @Autowired
    private KafkaTemplate<String, Feed> kafkaTemplate;

    @Autowired
    private FeedRepository feedRepository;

    @PostMapping("/sendFeed")
    public ResponseEntity<Feed> sendEmail(@RequestBody FeedRequest feed) {
        String response = "";
        Feed newfeed = new Feed();
        try {

            newfeed.setAddress(feed.getAddress());
            newfeed.setEmail(feed.getEmail());;
            newfeed.setFirstName(feed.getFirstName());
            newfeed.setLastName(feed.getLastName());
            newfeed.setSkills(feed.getSkills());
            newfeed.setFeedLoadDate(new Date());
            newfeed.setSendToKafkaFlg(false);
            feedRepository.save(newfeed);
            kafkaTemplate.send("sb-form-data", newfeed);
        } catch (Exception e) {
            return new ResponseEntity<>(new Feed(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newfeed, HttpStatus.CREATED);
    }

    @GetMapping("/getKafkaFeed")
    public ResponseEntity<List<Feed>> getKafkaFeed() {
        List<Feed> feeds = feedRepository.findBySendToKafkaFalse();
        if (feeds.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            feedRepository.updateFeedsSentToKafka();
            return new ResponseEntity<>(feeds, HttpStatus.OK);
        }
    }
}
