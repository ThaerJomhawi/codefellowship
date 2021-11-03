package com.example.codefellowship.controller;


import com.example.codefellowship.model.PostModel;
import com.example.codefellowship.repository.ApplicationUserRepository;
import com.example.codefellowship.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PostController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PostRepository postRepository;


    @PostMapping("/addpost/{id}")
    public RedirectView addpost(@RequestParam(value = "body") String body, @PathVariable("id") int id){

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        PostModel newPostModel = new PostModel(body , formatter.format(date), applicationUserRepository.findById(id).get());

        postRepository.save(newPostModel);

        return new RedirectView("/myprofile");
    }

}