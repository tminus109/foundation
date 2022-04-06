package com.gfa.reddit.repositories;

import com.gfa.reddit.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
