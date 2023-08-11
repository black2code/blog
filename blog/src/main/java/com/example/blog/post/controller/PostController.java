package com.example.blog.post.controller;

import com.example.blog.post.dto.PostRequestDto;
import com.example.blog.post.dto.PostResponseDto;
import com.example.blog.post.model.Post;
import com.example.blog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;


    @PostMapping
    public ResponseEntity postWrite(@RequestBody PostRequestDto postRequestDto) {

        Post post = new Post();
        post.setTitle(postRequestDto.getTitle());
        post.setContent(postRequestDto.getContent());
        postService.postWrite(post);

        return ResponseEntity.status(HttpStatus.CREATED).body("success");
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto> postView(@PathVariable("postId") Long postId) {

        PostResponseDto postResponseDto = postService.postView(postId);

        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @PutMapping("/{postId}")
    public ResponseEntity postUpdate(@PathVariable("postId") Long postId,
                                     @RequestBody PostRequestDto postRequestDto) {

        postService.postUpdate(postId, postRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("success");
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity postDelete(@PathVariable("postId") Long postId) {

        postService.postDelete(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
