package com.example.blog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.blog.model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> , PagingAndSortingRepository<BlogPost, Long>{

}