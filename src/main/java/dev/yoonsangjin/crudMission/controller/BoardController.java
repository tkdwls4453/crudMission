package dev.yoonsangjin.crudMission.controller;

import dev.yoonsangjin.crudMission.domain.Board;
import dev.yoonsangjin.crudMission.service.BoardService;
import dev.yoonsangjin.crudMission.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("board")
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    private final BoardService boardService;

    public BoardController(
            @Autowired BoardService boardService
    ) {
        this.boardService = boardService;
    }

    @PostMapping("{name}")
    public void createBoard(@PathVariable("name") String name){
        Board board = new Board();
        board.setName(name);
        this.boardService.createBoard(board);
    }

    @GetMapping()
    public List<Board> readBoardAll(){
        logger.info("in read board all");
        return this.boardService.readBoardAll();
    }

    @GetMapping("{id}")
    public Board readBoardOne(@PathVariable("id") int id){
        logger.info("in read board");
        return this.boardService.readBoard(id);
    }

    @DeleteMapping("{id}")
    public void deleteBoard(@PathVariable("id") int id){
        this.boardService.deleteBoard(id);
    }
}
