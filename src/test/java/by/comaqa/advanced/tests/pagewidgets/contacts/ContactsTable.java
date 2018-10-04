package by.comaqa.advanced.tests.pagewidgets.contacts;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ContactsTable {

   public SelenideElement table=$("#content-main div.listview-body table.listView");

   public SelenideElement firstRow=table.$("tbody>tr");

   public ElementsCollection rows=table.$$("tbody>tr");

   public SelenideElement getNameOfContactFromRow(SelenideElement row) {
      row.shouldBe(visible);
      return row.$("a.listViewNameLink");
   }

   public void openDetailsOfContact(SelenideElement row){
      getNameOfContactFromRow(row).click();
   }
}
