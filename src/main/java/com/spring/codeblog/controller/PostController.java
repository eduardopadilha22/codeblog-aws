package com.spring.codeblog.controller;

import com.spring.codeblog.Service.PostService;
import com.spring.codeblog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getAllPost(){
        ModelAndView modelAndView = new ModelAndView("posts");
        List<Post> posts = postService.findAll();
        modelAndView.addObject("posts",posts);
        return modelAndView;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPost(@PathVariable(value = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("postDetails");
        Post post = postService.findById(id);
        modelAndView.addObject("post",post);
        return modelAndView;
    }

    @RequestMapping(value = "/newPost",method = RequestMethod.GET)
    public String getNewPost(){
        return "newPost";
    }

    @RequestMapping(value = "newPost", method = RequestMethod.POST)
    public String registerPost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem","verifique se os campos obrigatórios foram preenchidos");
            return "redirect:/newPost";
        }
        post.setData(LocalDate.now());
        postService.save(post);
        return "redirect:/posts";
    }
}

