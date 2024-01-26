package com.eficens.app.entity;

import com.eficens.app.utility.BooleanToCharConverter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feed")
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feed_id")
    private int feedId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "skills")
    private String skills;

    @Convert(converter = BooleanToCharConverter.class)
    @Column(name = "send_to_kafka")
    private boolean sendToKafkaFlg;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "feed_load_date")
    private Date feedLoadDate;

    public int getFeedId() {
        return feedId;
    }

    public void setFeedId(int feedId) {
        this.feedId = feedId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public boolean isSendToKafkaFlg() {
        return sendToKafkaFlg;
    }

    public void setSendToKafkaFlg(boolean sendToKafkaFlg) {
        this.sendToKafkaFlg = sendToKafkaFlg;
    }

    public Date getFeedLoadDate() {
        return feedLoadDate;
    }

    public void setFeedLoadDate(Date feedLoadDate) {
        this.feedLoadDate = feedLoadDate;
    }
}
