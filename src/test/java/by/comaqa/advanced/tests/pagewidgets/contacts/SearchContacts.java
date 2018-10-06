package by.comaqa.advanced.tests.pagewidgets.contacts;

import by.comaqa.advanced.tests.pagewidgets.StatusMessage;
import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SearchContacts {

  SelenideElement searchField=$("#filter_text");

  public void filterText(String text) {
    searchField.setValue(text);
    sleep(500);
    searchField.pressEnter();
    new StatusMessage().status.shouldHave(Condition.text("Loading"));
    new StatusMessage().status.should(disappear);

  }


}
