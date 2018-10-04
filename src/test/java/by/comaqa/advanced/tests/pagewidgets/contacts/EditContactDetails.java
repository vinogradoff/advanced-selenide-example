package by.comaqa.advanced.tests.pagewidgets.contacts;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.$;

public class EditContactDetails {

  SelenideElement firstNameInput=$("#DetailFormfirst_name-input"),
                 lastNameInput=$("#DetailFormlast_name-input"),
                primaryEmailInput=$("#DetailFormemail1-input"),
                    saveBtn=$("button#DetailForm_save");

  public void enterName(String firstName, String lastName) {
    firstNameInput.setValue(firstName);
    lastNameInput.setValue(lastName);
  }
  public void enterPrimaryEmail(String primaryEmail) {
    primaryEmailInput.setValue(primaryEmail);
  }
  public void saveContact(){
    saveBtn.click();
  }

}
