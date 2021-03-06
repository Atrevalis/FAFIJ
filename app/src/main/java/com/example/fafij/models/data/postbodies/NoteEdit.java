package com.example.fafij.models.data.postbodies;

public class NoteEdit {

    private Long id;
    private String date;
    private long sum;
    private String category;
    private String comment;
    private String login;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String journalName) {
        this.login = journalName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public NoteEdit(long id, String date, long sum, String category, String comment, String login) {
        this.id = id;
        this.date = date;
        this.sum = sum;
        this.category = category;
        this.comment = comment;
        this.login = login;
    }
}
