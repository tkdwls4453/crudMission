package dev.yoonsangjin.crudMission.domain;

import java.util.List;

public class Board {
    private String name;
    private List<Post> posts;

    public Board() {
    }

    public Board(String name, List<Post> posts) {
        this.name = name;
        this.posts = posts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Board{" +
                "name='" + name + '\'' +
                ", posts=" + posts +
                '}';
    }
}
