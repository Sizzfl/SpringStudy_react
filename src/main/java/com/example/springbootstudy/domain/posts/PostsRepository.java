package com.example.springbootstudy.domain.posts;

import com.example.springbootstudy.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long>
{
    @Query("SELECT p FROM Posts AS p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
