package com.spring.codeblog.utils;

import com.spring.codeblog.Repository.PostRepository;
import com.spring.codeblog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {
    @Autowired
    private PostRepository postRepository;


    public void SavePosts(){
        List<Post> postList =  new ArrayList<>();
        Post post = new Post();
        post.setAutor("Eduardo");
        post.setTitulo("Angular 8");
        post.setData(LocalDate.now());
        post.setTexto("Lorem ipsum ut morbi aliquam neque praesent justo adipiscing fusce, aliquam vestibulum gravida consectetur pharetra ultrices donec commodo, vehicula nullam donec orci laoreet accumsan fermentum rhoncus.");

        Post post2 = new Post();
        post2.setAutor("Eduardo");
        post2.setTitulo("Flutter ");
        post2.setData(LocalDate.now());
        post2.setTexto("Lorem ipsum ut morbi aliquam neque praesent justo adipiscing fusce, aliquam vestibulum gravida consectetur pharetra ultrices donec commodo, vehicula nullam donec orci laoreet accumsan fermentum rhoncus.");

        Post post3 = new Post();
        post3.setAutor("Eduardo");
        post3.setTitulo("React Native");
        post3.setData(LocalDate.now());
        post3.setTexto("Lorem ipsum ut morbi aliquam neque praesent justo adipiscing fusce, aliquam vestibulum gravida consectetur pharetra ultrices donec commodo, vehicula nullam donec orci laoreet accumsan fermentum rhoncus.");


        postList.add(post);
        postList.add(post2);
        postList.add(post3);

        for (Post item  : postList){
            Post postSave = postRepository.save(item);
            System.out.println(postSave.getId());
        }
    }
}
