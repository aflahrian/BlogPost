package com.example.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class BlogPost {

   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String body;
    private String author;
    
    public BlogPost(long id, String title, String body, String author) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.author = author;
	}

    // getters and setters
}