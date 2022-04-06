package com.gfa.reddit.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    @OneToMany(mappedBy = "user")
    private Set<Post> posts;
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Set<Post> likedPosts;
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Set<Post> dislikedPosts;

    public User() {
        this.posts = new HashSet<>();
        this.likedPosts = new HashSet<>();
        this.dislikedPosts = new HashSet<>();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.posts = new HashSet<>();
        this.likedPosts = new HashSet<>();
        this.dislikedPosts = new HashSet<>();
    }

    public boolean doesUserLikePost(Post post) {
        return this.getLikedPosts().contains(post);
    }

    public boolean doesUserDislikePost(Post post) {
        return this.getDislikedPosts().contains(post);
    }
}
