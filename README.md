//SQL Script

create database feed_information;

DROP TABLE feed_information.feed;
CREATE TABLE feed_information.feed (
    feed_id INT AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    address VARCHAR(255),
    skills VARCHAR(255),
    send_to_kafka CHAR(1),
    feed_load_date DATETIME,
    PRIMARY KEY (feed_id)
);
CREATE INDEX idx_send_to_kafka ON feed_information.feed (send_to_kafka);

Import Project

Build Application using Maven
Run Application using com.eficens.app.MainApp Java file


UI : http://localhost:8081/

POSTMAN Create New Feed : 
Method: POST:
Endpoint: http://localhost:8081/sendFeed
Request:
{
    "firstName" : "VIP",
    "lastName" : "DIN",
    "email" : "aj@ku.com",
    "address" :"15900", 
    "skills" : "75733"
}


Get Kafka Feed:

http://localhost:8081/getKafkaFeed
