package dev.yoonsangjin.crudMission.service;

import dev.yoonsangjin.crudMission.domain.Board;
import dev.yoonsangjin.crudMission.domain.Post;
import dev.yoonsangjin.crudMission.repository.BoardRepository;
import dev.yoonsangjin.crudMission.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final BoardRepository boardRepository;
    public PostService(
            @Autowired PostRepository postRepository,
            @Autowired BoardRepository boardRepository
    ){
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
    }

    public void createPost(int boardId, Post post){
        if (!this.postRepository.save(post)){
            throw new RuntimeException("save failed");
        }
        Board targetBoard = boardRepository.findById(boardId);
        targetBoard.setPosts(postRepository.findAll());
        this.boardRepository.update(boardId, targetBoard);
    }

    public List<Post> readPostAll(int boardId){
        Board targetBoard = boardRepository.findById(boardId);
        return targetBoard.getPosts();
    }

    public Post readPost(int boardId, int id){
        Board targetBoard = boardRepository.findById(boardId);
        return targetBoard.getPosts().get(id);
    }

    public void updatePost(int boardId, int postId, Post post){
        Board targetBoard = boardRepository.findById(boardId);
        postRepository.update(postId, post);
        targetBoard.setPosts(postRepository.findAll());
        this.boardRepository.update(boardId, targetBoard);
    }

    public void deletePost(int boardId, int postId){
        Board targetBoard = boardRepository.findById(boardId);
        postRepository.delete(postId);
        targetBoard.setPosts(postRepository.findAll());
        this.boardRepository.update(boardId, targetBoard);
    }

}
