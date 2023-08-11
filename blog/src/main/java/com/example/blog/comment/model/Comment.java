package com.example.blog.comment.model;

import com.example.blog.auditing.Auditable;
import com.example.blog.post.model.Post;
import com.example.blog.user.model.User;
import jakarta.persistence.*;
import lombok.Getter;


@Table(name = "comments")
@Getter
@Entity
public class Comment extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
