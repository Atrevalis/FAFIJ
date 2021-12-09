package com.example.fafij.models.data.postbodies;

public class CategoryLoginJournal {
    private String category;
    private String login;
    private String journalName;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public CategoryLoginJournal(String category, String login, String journalName) {
        this.category = category;
        this.login = login;
        this.journalName = journalName;
    }
}
