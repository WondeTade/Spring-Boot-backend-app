package com.wonde.celebritiesofficialpageinfoservice.controller;

import com.wonde.celebritiesofficialpageinfoservice.model.SocialMedias;
import com.wonde.celebritiesofficialpageinfoservice.repository.SocialMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("secured/user/social-media")
public class SocialMediasController {


    private SocialMediaRepository socialMediaRepository;

    @Autowired
    public SocialMediasController(SocialMediaRepository socialMediaRepository) {
        this.socialMediaRepository = socialMediaRepository;
    }

    @GetMapping("all")
    public List<SocialMedias> getAllSocialMedia() {
        return socialMediaRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<SocialMedias> getSocialMediaById(@PathVariable("id") Integer id) {
        return socialMediaRepository.findById(id);
    }

}
