package com.example.fafij.presentation.login;

public class LoginPresenter implements LoginContract.LoginPresenterInterface {

    public LoginContract.LoginViewInterface view;

    public LoginPresenter(LoginContract.LoginViewInterface view) {
        this.view = view;
    }

    /**
     * Проверяет логин и пароль на корректность,
     * проверяет наличие интернет соединения,
     * входит в аккаунт.
     * @param login логин пользователя
     * @param password пароль пользователя
     */
    @Override
    public void onAuthorizationClick(String login, String password) {

    }
}
