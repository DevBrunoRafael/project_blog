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
        ModelAndView mv = new ModelAndView("posts");
        List<PostModel> posts = postService.findAllPosts();
        mv.addObject("posts", posts);
        return mv;
    }

    @PostMapping("/create")
    public PostModel createPost(@RequestBody @Valid PostModel postModel){
        return postService.savePost(postModel);
    }

}
