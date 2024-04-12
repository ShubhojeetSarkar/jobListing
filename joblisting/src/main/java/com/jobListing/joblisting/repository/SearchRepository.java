package com.jobListing.joblisting.repository;

import com.jobListing.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String text);
;}
