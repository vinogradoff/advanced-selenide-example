package by.comaqa.advanced.tests.pagewidgets.contacts;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.$;

public class ActionsPanel {

  SelenideElement createBtn=$("#content-main [name=SubPanel_create]");
  public void create() {
    createBtn.click();
  }
}
