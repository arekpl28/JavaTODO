package it.studiuje.todo;

public class Task {

    private String content;

    private boolean completed;

    public Task(String content, boolean completed) {
        this.content = content;
        this.completed = completed;
    }

    public String getContent() {
        return content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCompleted() {
        this.completed = true;
    }

    public void setUncompleted() {
        this.completed = false;
    }
}
