package com.example.blog.post.service;

import com.example.blog.post.dto.PostRequestDto;
import com.example.blog.post.dto.PostResponseDto;
import com.example.blog.post.model.Post;
import com.example.blog.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public void postWrite(Post post) {
        postRepository.save(post.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .build());
    }

    public PostResponseDto postView(Long postId) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Not found"));

        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setTitle(post.getTitle());
        postResponseDto.setContent(post.getContent());

        return postResponseDto;
    }

    public void postUpdate(Long postId, PostRequestDto postRequestDto) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Not found"));

        post.setTitle(postRequestDto.getTitle());
        post.setContent(postRequestDto.getContent());
        postRepository.save(post);
    }

    public void postDelete(Long postId) {

        postRepository.deleteById(postId);
    }
}
