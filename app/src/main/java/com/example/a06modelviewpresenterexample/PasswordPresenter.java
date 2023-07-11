package com.example.a06modelviewpresenterexample;

public class PasswordPresenter {

    private PasswordModel passwordModel;

    private IViewPresenter iViewPresenter;

    public PasswordPresenter(IViewPresenter iViewPresenter) {
        this.iViewPresenter = iViewPresenter;

        passwordModel = new PasswordModel();
    }

    public void evaluatePassword(String password) {
        int level = passwordModel.validatePassword(password);

        if (level == PasswordModel.EMPTY) {
            this.iViewPresenter.showEmptyPassword();

        } else if (level == PasswordModel.WEAK) {
            this.iViewPresenter.showWeakPassword();

        } else if (level == PasswordModel.MEDIUM) {
            this.iViewPresenter.showMediumPassword();

        } else if (level == PasswordModel.STRONG) {
            this.iViewPresenter.showStrongPassword();

        } else {
            this.iViewPresenter.showErrorMessage();

        }
    }
}
