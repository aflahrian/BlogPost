package com.example.blog.service;

import com.example.blog.model.BlogPost;
import com.example.blog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Override
    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @Override
    public BlogPost getBlogPostById(Long id) {
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog post not found"));
    }

    @Override
    public Page<BlogPost> getAllBlogPosts(PageRequest of) {
        return blogPostRepository.findAll(of);
    }

    @Override
    public BlogPost updateBlogPost(Long id, BlogPost updatedBlogPost) {
        BlogPost existingPost = getBlogPostById(id);
        existingPost.setTitle(updatedBlogPost.getTitle());
        existingPost.setBody(updatedBlogPost.getBody());
        existingPost.setAuthor(updatedBlogPost.getAuthor());
        return blogPostRepository.save(existingPost);
    }

    @Override
    public void deleteBlogPost(Long id) {
        blogPostRepository.deleteById(id);
    }
}