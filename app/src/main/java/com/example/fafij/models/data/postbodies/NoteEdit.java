package com.example.fafij.models.data.postbodies;

public class NoteEdit {

    private long id;
    private String date;
    private long sum;
    private String category;
    private String comment;
    private String journalName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
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

    public NoteEdit(long id, String date, long sum, String category, String comment, String journalName) {
        this.id = id;
        this.date = date;
        this.sum = sum;
        this.category = category;
        this.comment = comment;
        this.journalName = journalName;
    }
}
