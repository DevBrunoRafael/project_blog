package com.devbrunorafael.project_blog.domain.repository;

import com.devbrunorafael.project_blog.domain.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostModel,Long> {
}
