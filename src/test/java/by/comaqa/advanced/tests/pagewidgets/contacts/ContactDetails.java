package by.comaqa.advanced.tests.pagewidgets.contacts;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class ContactDetails {

  SelenideElement deleteBtn=$("button#DetailForm_delete");

  public void deleteContact() {
    deleteBtn.click();
    Selenide.confirm();
  }

}
