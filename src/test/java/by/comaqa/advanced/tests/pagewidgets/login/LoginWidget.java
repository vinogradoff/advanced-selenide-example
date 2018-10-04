package by.comaqa.advanced.tests.pagewidgets.login;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.$;

public class LoginWidget {

    SelenideElement username = $("#login_user"),
                    password=$("#login_pass"),
                    submitBtn=$("#login_button");

  public void login(String username, String password){
    this.username.setValue(username);
    this.password.setValue(password);
    submitBtn.click();
  }
}
