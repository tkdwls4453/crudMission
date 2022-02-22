package dev.yoonsangjin.crudMission.repository;

import dev.yoonsangjin.crudMission.domain.Board;

import java.util.List;

public interface BoardRepository {
    boolean save(Board board);
    List<Board> findAll();
    Board findById(int id);
    boolean update(int id, Board board);
    boolean delete(int id);
}
