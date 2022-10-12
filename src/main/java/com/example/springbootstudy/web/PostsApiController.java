package com.example.springbootstudy.web;

import com.example.springbootstudy.service.posts.PostService;
import com.example.springbootstudy.web.dto.PostsResponseDto;
import com.example.springbootstudy.web.dto.PostsSaveRequestDto;
import com.example.springbootstudy.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController
{
    private final PostService postServ;

    // Insert
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto reqDto)
    {
        return postServ.save(reqDto);
    }

    // Modify
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto reqDto)
    {
        return postServ.update(id, reqDto);
    }

    // Select
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id)
    {
        return postServ.findById(id);
    }

    // delete
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id)
    {
        postServ.delete(id);
        return id;
    }
}
