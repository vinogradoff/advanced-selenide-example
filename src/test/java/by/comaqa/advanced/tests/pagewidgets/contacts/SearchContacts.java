package by.comaqa.advanced.tests.pagewidgets.contacts;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.$;

public class SearchContacts {

  SelenideElement searchField=$("#filter_text");
  public void filterText(String text) {
    searchField.setValue(text).pressEnter();
  }


}
