package com.example.fafij.models.data;

import java.util.ArrayList;

public class Invitation {

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String role;

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public ArrayList<String> getLogins() {
        return logins;
    }

    public void setLogins(ArrayList<String> logins) {
        this.logins = logins;
    }

    private String journalName;
    private ArrayList<String> logins;
}
