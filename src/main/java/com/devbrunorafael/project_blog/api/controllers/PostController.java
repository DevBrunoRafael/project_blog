package com.devbrunorafael.project_blog.api.controllers;

import com.devbrunorafael.project_blog.domain.model.PostModel;
import com.devbrunorafael.project_blog.domain.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {

    private PostService postService;

    @GetMapping("/list")
    public ModelAndView postList(){
        ModelAndView modelAndView = new ModelAndView("posts");
        List<PostModel> posts = this.postService.findAllPosts();
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView postDetails(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("post-details");
        PostModel post = this.postService.findPost(id);
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    @PostMapping("/create")
    public PostModel createPost(@RequestBody @Valid PostModel postModel){
        return this.postService.savePost(postModel);
    }

}
