package Controller;

import Models.AccountModel;
import Views.AccountView;

public class AccountController {
    private AccountModel accountModel;
    private AccountView accountView;

    public AccountController(AccountModel accountModel, AccountView accountView) {
        this.accountModel = accountModel;
        this.accountView = accountView;

        accountView.setVisible(true);
    }
}
