package com.wonde.celebritiesofficialpageinfoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "person")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //Json ignores the two methods hibernatLazyInitializer and handler
public class PersonsInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "person_id", updatable = false, nullable = false)
    private Integer personId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "age")
    private Integer personAge;

    @Column(name = "number_of_child")
    private Integer numberOfChild;

    @Column(name = "facebook_url")
    private String facebookUrl;

    @Column(name = "instagram_url")
    private String instagramUrl;

    @Column(name = "youtube_url")
    private String youtubeUrl;

    @Column(name = "telegram_url")
    private String telegramUrl;

    @Column(name = "twitter_url")
    private String twitterUrl;

    @Lob //Large object
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] personPhoto;

    public PersonsInfo(Integer personId, String fullName, String maritalStatus,
                       Integer personAge, Integer numberOfChild, String facebookUrl,
                       String instagramUrl, String youtubeUrl, String telegramUrl,
                       String twitterUrl, byte[] personPhoto) {
        this.personId = personId;
        this.fullName  = fullName;
        this.maritalStatus = maritalStatus;
        this.personAge = personAge;
        this.numberOfChild = numberOfChild;
        this.facebookUrl = facebookUrl;
        this.instagramUrl = instagramUrl;
        this.youtubeUrl = youtubeUrl;
        this.telegramUrl = telegramUrl;
        this.twitterUrl = twitterUrl;
        this.personPhoto = personPhoto;
    }

    public PersonsInfo() {
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getPersonAge() {
        return personAge;
    }

    public void setPersonAge(Integer personAge) {
        this.personAge = personAge;
    }

    public Integer getNumberOfChild() {
        return numberOfChild;
    }

    public void setNumberOfChild(Integer numberOfChild) {
        this.numberOfChild = numberOfChild;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public String getTelegramUrl() {
        return telegramUrl;
    }

    public void setTelegramUrl(String telegramUrl) {
        this.telegramUrl = telegramUrl;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    public byte[] getPersonPhoto() {
        return personPhoto;
    }

    public void setPersonPhoto(byte[] personPhoto) {
        this.personPhoto = personPhoto;
    }

    public String badRequestMessage() {
        return "Error Msg \n ID does not exist / ID can not be changed";
    }
}
