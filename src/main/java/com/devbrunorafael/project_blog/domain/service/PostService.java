package com.devbrunorafael.project_blog.domain.service;

import com.devbrunorafael.project_blog.domain.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostService {

    private PostRepository postRepository;


}
