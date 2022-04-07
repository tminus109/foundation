package com.gfa.reddit.services;

import com.gfa.reddit.models.Post;
import com.gfa.reddit.models.User;
import com.gfa.reddit.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    public final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
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

    public Page<Post> listAll(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 5, Sort.by("score").descending());
        return postRepository.findAll(pageable);
    }
}
