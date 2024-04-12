package com.jobListing.joblisting.controller;


import com.jobListing.joblisting.repository.PostRepository;
import com.jobListing.joblisting.model.Post;
import com.jobListing.joblisting.repository.SearchRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {


    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }


   @GetMapping("/allPosts")
   @CrossOrigin(origins = "http://localhost:3000")
   public List<Post> getAllPosts(){
        return repo.findAll();
   }

     @GetMapping("/posts/{text}")
     @CrossOrigin
     public List<Post> search(@PathVariable String text){
         return srepo.findByText(text);
     }

    @PostMapping("/post")
    @CrossOrigin
    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }
















}
