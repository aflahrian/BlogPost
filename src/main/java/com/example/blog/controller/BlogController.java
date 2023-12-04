package com.example.blog.controller;

import com.example.blog.model.BlogPost;
import com.example.blog.repository.BlogPostRepository;
import com.example.blog.service.BlogService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/blog")
@Secured("ROLE_USER")
public class BlogController {

    @Autowired
    private BlogService blogService;
    
    @Autowired
    private BlogPostRepository blogPostRepository;

    @Operation(summary = "for save blog post")
    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
        BlogPost createdPost = blogService.createBlogPost(blogPost);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }
  
    @Operation(summary = "for get detail one blog post with id")
    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable Long id) {
        BlogPost blogPost = blogService.getBlogPostById(id);
        if(blogPost!=null) {
        	return ResponseEntity.ok(blogPost); 
        }else {
        	 return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "for get all blog post in list")
    @GetMapping
    public ResponseEntity<List<BlogPost>> getAllBlogPosts( @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size) {
        Page<BlogPost> blogPosts = blogService.getAllBlogPosts(
                PageRequest.of(
                        page,
                        size,
                       Sort.by(Sort.Direction.DESC, "id"))
                );
        return ResponseEntity.ok(blogPosts.getContent()); 
    }

    @Operation(summary = "for update blog post with id")
    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost updatedBlogPost) {
        BlogPost updatedPost = blogService.updateBlogPost(id, updatedBlogPost);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "for delete blog post with id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        blogService.deleteBlogPost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
