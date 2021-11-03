package com.example.codefellowship.repository;

import com.example.codefellowship.model.PostModel;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostModel,Integer> {
}