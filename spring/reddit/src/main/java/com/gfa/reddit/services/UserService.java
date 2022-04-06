package com.gfa.reddit.services;

import com.gfa.reddit.models.Post;
import com.gfa.reddit.models.User;
import com.gfa.reddit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    public final UserRepository userRepository;
    public final PostService postService;

    @Autowired
    public UserService(UserRepository userRepository, PostService postService) {
        this.userRepository = userRepository;
        this.postService = postService;
    }

    public boolean isUsernameAvailable(String username) {
        User user = userRepository.findByUsername(username);
        return user == null;
    }

    public void saveNewUser(User user) {
        userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public void upvotePost(long postId, long loggedUserId) {
        Post post = postService.getPostById(postId);
        User user = getUserById(loggedUserId);
        if (!user.doesUserLikePost(post)) {
            if (user.doesUserDislikePost(post)) {
                user.getDislikedPosts().remove(post);
                post.setDislikesCount(post.getDislikesCount() - 1);
            }
            user.getLikedPosts().add(post);
            post.setLikesCount(post.getLikesCount() + 1);
        } else {
            user.getLikedPosts().remove(post);
            post.setLikesCount(post.getLikesCount() - 1);
        }
        post.setScore(post.getLikesCount() - post.getDislikesCount());
        userRepository.save(user);
        postService.updatePost(post);
    }

    public void downvotePost(long postId, long loggedUserId) {
        Post post = postService.getPostById(postId);
        User user = getUserById(loggedUserId);
        if (!user.doesUserDislikePost(post)) {
            if (user.doesUserLikePost(post)) {
                user.getLikedPosts().remove(post);
                post.setLikesCount(post.getLikesCount() - 1);
            }
            user.getDislikedPosts().add(post);
            post.setDislikesCount(post.getDislikesCount() + 1);
        } else {
            user.getDislikedPosts().remove(post);
            post.setDislikesCount(post.getDislikesCount() - 1);
        }
        post.setScore(post.getLikesCount() - post.getDislikesCount());
        userRepository.save(user);
        postService.updatePost(post);
    }
}
