package com.example.fafij.presentation.registration;

public class RegistrationPresenter implements RegistrationContract.RegistrationPresenterInterface {

    public RegistrationContract.RegistrationViewInterface view;

    public RegistrationPresenter(RegistrationContract.RegistrationViewInterface view) {
        this.view = view;
    }

    /**
     * Проверяет на наличие логина в БД,
     * хэширует пароль,
     * создаёт и входит в аккаунт.
     * @param login логин пользователя
     * @param password пароль пользователя
     */
    @Override
    public void onRegistrationClick(String login, String password) {

    }
}
