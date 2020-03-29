package com.wonde.celebritiesofficialpageinfoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "social_medias")

public class SocialMedias {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "social_media_id")
    private Integer socialMediaId;
    private String facebook_info;
    private String linkedin_info;
    private String instagram_info;
    private String twiter_info;


    public SocialMedias(Integer socialMediaId, String facebook_info, String linkedin_info,
                        String instagram_info, String twiter_info) {
        this.socialMediaId = socialMediaId;
        this.facebook_info = facebook_info;
        this.linkedin_info = linkedin_info;
        this.instagram_info = instagram_info;
        this.twiter_info = twiter_info;
    }

    public SocialMedias() {

    }

    public int getId() {
        return socialMediaId;
    }

    public void setId(Integer socialMediaId) {
        this.socialMediaId = socialMediaId;
    }

    public String getFacebook_info() {
        return facebook_info;
    }

    public void setFacebook_info(String facebook_info) {
        this.facebook_info = facebook_info;
    }

    public String getLinkedin_info() {
        return linkedin_info;
    }

    public void setLinkedin_info(String linkedin_info) {
        this.linkedin_info = linkedin_info;
    }

    public String getInstagram_info() {
        return instagram_info;
    }

    public void setInstagram_info(String instagram_info) {
        this.instagram_info = instagram_info;
    }

    public String getTwiter_info() {
        return twiter_info;
    }

    public void setTwiter_info(String twiter_info) {
        this.twiter_info = twiter_info;
    }

}
