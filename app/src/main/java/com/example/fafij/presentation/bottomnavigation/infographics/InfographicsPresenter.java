package com.example.fafij.presentation.bottomnavigation.infographics;

public class InfographicsPresenter implements InfographicsContract.InfographicsPresenterInterface {

    public InfographicsContract.InfographicsViewInterface view;

    public InfographicsPresenter(InfographicsContract.InfographicsViewInterface view) {
        this.view = view;
    }

}
