package com.gfa.reddit.services;

import com.gfa.reddit.models.Post;
import com.gfa.reddit.models.User;
import com.gfa.reddit.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    public final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts() {
        return (List<Post>) postRepository.findAll();
    }

    public void saveNewPost(String title, String url, User user) {
        postRepository.save(new Post(title, url, user));
    }

    public Post getPostById(long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElse(null);
    }

    public void updatePost(Post post) {
        postRepository.save(post);
    }
}
