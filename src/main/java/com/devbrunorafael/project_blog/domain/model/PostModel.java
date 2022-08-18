package com.devbrunorafael.project_blog.domain.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_posts")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    @Lob
    private String text;
    
    @NotBlank
    private String author;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate postDate;

}
