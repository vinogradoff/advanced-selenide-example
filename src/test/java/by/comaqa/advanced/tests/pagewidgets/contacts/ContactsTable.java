package by.comaqa.advanced.tests.pagewidgets.contacts;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.$;

public class ContactsTable {

   SelenideElement table=$("#content-main div.listview-body table.listView");

   public SelenideElement firstRow=table.$("tbody>tr");

   public ElementsCollection rows=table.$$("tbody>tr");

}
