package dev.yoonsangjin.crudMission.service;

import dev.yoonsangjin.crudMission.domain.Board;
import dev.yoonsangjin.crudMission.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(
            @Autowired BoardRepository boardRepository
    ) {
        this.boardRepository = boardRepository;
    }

    public void createBoard(Board board){
        if(!this.boardRepository.save(board)){
            throw new RuntimeException("save faild");
        }
    }

    public List<Board> readBoardAll(){
        return boardRepository.findAll();
    }

    public Board readBoard(int id){
        return boardRepository.findById(id);
    }

    public void deleteBoard(int id){
        this.boardRepository.delete(id);
    }
}
