package dev.yoonsangjin.crudMission.controller;

import dev.yoonsangjin.crudMission.domain.Post;
import dev.yoonsangjin.crudMission.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(
            @Autowired PostService postService
    ){
        this.postService = postService;
    }

    @PostMapping("{id}")
    public void createPost(@PathVariable("id") int id,  @RequestBody Post post){
        logger.info(post.toString());
        this.postService.createPost(id, post);
    }

    @GetMapping("{id}")
    public List<Post> readPostAll(@PathVariable("id") int id){
        return this.postService.readPostAll(id);
    }

    @GetMapping("{boardId}/{postId}")
    public Post readPostOne(
            @PathVariable("boardId") int boardId,
            @PathVariable("postId") int postId)
    {
        return this.postService.readPost(boardId, postId);
    }
    @PutMapping("{boardId}/{postId}")
    public void updatePost(
            @PathVariable("boardId") int boardId,
            @PathVariable("postId") int postId,
            @RequestBody Post post
    ){
        this.postService.updatePost(boardId,postId,post);
    }

    @DeleteMapping("{boardId}/{postId}")
    public void deletePost(@PathVariable("boardId") int boardId,
                           @PathVariable("postId") int postId
    ){
        this.postService.deletePost(boardId,postId);
    }
}
