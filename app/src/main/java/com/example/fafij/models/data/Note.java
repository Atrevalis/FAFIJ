package com.example.fafij.models.data;

public class Note {
    private long id;

    public Note(long id, String date, long sum, String comment, Category category) {
        this.id = id;
        this.date = date;
        this.sum = sum;
        this.comment = comment;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;
    private long sum;
    private String comment;
    private Category category;

}
