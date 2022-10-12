package com.example.springbootstudy.web;

import com.example.springbootstudy.service.posts.PostService;
import com.example.springbootstudy.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController
{
    private final PostService postServ;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("posts", postServ.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave()
    {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model)
    {
        PostsResponseDto dto = postServ.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
