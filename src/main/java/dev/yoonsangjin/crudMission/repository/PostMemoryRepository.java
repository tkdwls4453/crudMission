package dev.yoonsangjin.crudMission.repository;

import dev.yoonsangjin.crudMission.domain.Board;
import dev.yoonsangjin.crudMission.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostMemoryRepository implements PostRepository{
    private final List<Post> postList;

    public PostMemoryRepository() {
        postList = new ArrayList<>();
    }

    @Override
    public boolean save(Post post) {
        return this.postList.add(post);
    }

    @Override
    public List<Post> findAll() {
        return this.postList;
    }

    @Override
    public Post findById(int id) {
        return this.postList.get(id);
    }

    @Override
    public boolean update(int id, Post post) {
        Post targetPost = this.postList.get(id);
        if (post.getTitle() != null){
            targetPost.setTitle(post.getTitle());
        }
        if (post.getContent() != null){
            targetPost.setContent(post.getContent());
        }
        if (post.getPassword() != null){
            targetPost.setPassword(post.getPassword());
        }
        this.postList.set(id, targetPost);

        return true;
    }

    @Override
    public boolean delete(int id) {
        this.postList.remove(id);
        return true;
    }
}
