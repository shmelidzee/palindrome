package com.palindrome.domain;

import java.util.List;
import java.util.Objects;

public class User {
    private final Long id;
    private final String name;
    private Long score;
    private final List<String> activeWords;

    public User(Long id, String name, Long score, List<String> activeWords) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.activeWords = activeWords;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getScore() {
        return score;
    }

    public void addScore(Long score) {
        this.score = this.score + score;
    }

    public List<String> getActiveWords() {
        return activeWords;
    }

    public void addNewWord(String word) {
        activeWords.add(word);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(score, user.score) && Objects.equals(activeWords, user.activeWords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, score, activeWords);
    }
}
