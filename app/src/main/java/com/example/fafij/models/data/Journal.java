package com.example.fafij.models.data;

import java.util.ArrayList;

public class Journal {

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    private String journalName;

    public ArrayList<Login> getLogins() {
        return Logins;
    }

    public void setLogins(ArrayList<Login> logins) {
        Logins = logins;
    }

    private ArrayList<Login> Logins;

}

