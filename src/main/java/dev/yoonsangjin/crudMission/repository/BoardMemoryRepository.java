package dev.yoonsangjin.crudMission.repository;

import dev.yoonsangjin.crudMission.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardMemoryRepository implements BoardRepository{
    private final List<Board> boardList;

    public BoardMemoryRepository() {
        this.boardList = new ArrayList<>();
    }

    @Override
    public boolean save(Board board) {
        this.boardList.add(board);
        return true;
    }

    @Override
    public List<Board> findAll() {
        return this.boardList;
    }

    @Override
    public Board findById(int id) {
        return this.boardList.get(id);
    }

    @Override
    public boolean update(int id, Board board) {
        this.boardList.set(id,board);
        return true ;
    }

    @Override
    public boolean delete(int id) {
        this.boardList.remove(id);
        return true;
    }
}
