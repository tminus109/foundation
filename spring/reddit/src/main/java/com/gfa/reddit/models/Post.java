package com.gfa.reddit.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String url;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private int likesCount;
    private int dislikesCount;
    private int score;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCreated;

    public Post() {
        this.likesCount = 0;
        this.dislikesCount = 0;
        this.score = 0;
        this.dateCreated = LocalDate.now();
    }

    public Post(String title, String url, User user) {
        this.title = title;
        this.url = url;
        this.user = user;
        this.likesCount = 0;
        this.dislikesCount = 0;
        this.score = 0;
        this.dateCreated = LocalDate.now();
    }
}
