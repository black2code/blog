package com.example.blog.post.model;


import com.example.blog.auditing.Auditable;
import com.example.blog.user.model.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "posts")
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Post extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @Builder
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
