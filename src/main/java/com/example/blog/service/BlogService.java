package com.example.blog.service;

import com.example.blog.model.BlogPost;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface BlogService {

    BlogPost createBlogPost(BlogPost blogPost);

    BlogPost getBlogPostById(Long id);

    Page<BlogPost> getAllBlogPosts(PageRequest of);

    BlogPost updateBlogPost(Long id, BlogPost updatedBlogPost);

    void deleteBlogPost(Long id);
}