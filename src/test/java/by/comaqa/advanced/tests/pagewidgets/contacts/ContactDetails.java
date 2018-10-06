package by.comaqa.advanced.tests.pagewidgets.contacts;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class ContactDetails {

  SelenideElement deleteBtn=$("button#DetailForm_delete"),
              editBtn=$("button#DetailForm_edit");


  public void deleteContact() {
    deleteBtn.click();
    Selenide.confirm();
  }

  public void startEditingContract(){
    editBtn.click();
  }

}
