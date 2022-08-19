package com.devbrunorafael.project_blog.api.controllers;

import com.devbrunorafael.project_blog.domain.model.PostModel;
import com.devbrunorafael.project_blog.domain.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
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

    @GetMapping("/new-post")
    public ModelAndView postForm(){
        return new ModelAndView("create-post");
    }

    @PostMapping("/new-post")
    public String savePost(@Valid PostModel postModel, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()){
            return "redirect:/new-post";
        }
        postModel.setPostDate(LocalDate.now());
        this.postService.savePost(postModel);
        return "redirect:/posts/list";
    }

}
