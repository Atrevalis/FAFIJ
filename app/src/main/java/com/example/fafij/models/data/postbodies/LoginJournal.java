package com.example.fafij.models.data.postbodies;

public class LoginJournal {
    private String login;

    public LoginJournal(String login, String journalName) {
        this.login = login;
        this.journalName = journalName;
    }

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    private String journalName;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
