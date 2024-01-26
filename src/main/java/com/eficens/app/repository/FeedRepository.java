package com.eficens.app.repository;

import com.eficens.app.entity.Feed;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FeedRepository extends CrudRepository<Feed, Long> {

    @Query(value = "SELECT * FROM Feed f WHERE f.send_to_kafka = 'N'", nativeQuery = true)
    List<Feed> findBySendToKafkaFalse();

    @Modifying
    @Transactional
    @Query(value = "UPDATE Feed f SET f.send_to_kafka = 'Y' WHERE f.send_to_kafka = 'N'", nativeQuery = true)
    void updateFeedsSentToKafka();
}
