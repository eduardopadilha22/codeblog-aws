package com.spring.codeblog.Service;

import com.spring.codeblog.model.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post findById(Long id);
    Post save(Post post);

}
