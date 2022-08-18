package com.devbrunorafael.project_blog.domain.service;

import com.devbrunorafael.project_blog.domain.model.PostModel;
import com.devbrunorafael.project_blog.domain.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private PostRepository postRepository;

    @Transactional
    public List<PostModel> findAllPosts(){
        return this.postRepository.findAll();
    }

    @Transactional
    public PostModel findPost(Long id){
        return this.postRepository.findById(id).get();
    }

    @Transactional
    public PostModel savePost(PostModel post){
        return this.postRepository.save(post);
    }
}
