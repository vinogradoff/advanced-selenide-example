package by.comaqa.advanced.tests.pagewidgets.contacts;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SearchContacts {

  SelenideElement searchField=$("#filter_text");

  public void filterText(String text) {
    searchField.setValue(text);
    sleep(500);
    searchField.pressEnter();

  }


}
