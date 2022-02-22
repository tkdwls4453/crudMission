package dev.yoonsangjin.crudMission.repository;

import dev.yoonsangjin.crudMission.domain.Post;

import java.util.List;

public interface PostRepository {
    boolean save(Post post);
    List<Post> findAll();
    Post findById(int id);
    boolean update(int id, Post post);
    boolean delete(int id);
}
