package com.example.fafij.presentation.bottomnavigation.settings;

public class SettingsPresenter implements SettingsContract.SettingsPresenterInterface {

    public SettingsContract.SettingsViewInterface view;

    public SettingsPresenter(SettingsContract.SettingsViewInterface view) {
        this.view = view;
    }

}
