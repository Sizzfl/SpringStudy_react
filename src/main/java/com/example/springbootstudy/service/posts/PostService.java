package com.example.springbootstudy.service.posts;

import com.example.springbootstudy.domain.posts.Posts;
import com.example.springbootstudy.domain.posts.PostsRepository;
import com.example.springbootstudy.web.dto.PostsListResponseDto;
import com.example.springbootstudy.web.dto.PostsResponseDto;
import com.example.springbootstudy.web.dto.PostsSaveRequestDto;
import com.example.springbootstudy.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService
{
    private final PostsRepository postsRepo;

    @Transactional
    public Long save(PostsSaveRequestDto reqDto)
    {
        return postsRepo.save(reqDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto reqDto)
    {
        Posts posts = postsRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. ID : " + id));
        posts.update(reqDto.getTitle(), reqDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id)
    {
        Posts entity = postsRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. ID : " + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc()
    {
        return postsRepo.findAllDesc().stream()
            .map(PostsListResponseDto::new)
            .collect(Collectors.toList());
    }

    // JpaRepository에서 delete메소드를 지원함
    @Transactional
    public void delete(Long id)
    {
        Posts posts = postsRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not exists topic ID = " + id));

        postsRepo.delete(posts);
    }
}
