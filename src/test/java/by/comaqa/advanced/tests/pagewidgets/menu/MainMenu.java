package by.comaqa.advanced.tests.pagewidgets.menu;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MainMenu {

  SelenideElement salesAndMarketing =$("li[data-tab-id=LBL_TABGROUP_SALES_MARKETING]"),
          salesAndMarketingSubMenu=$("#menu-source-2-popup");

  public void openInSalesAndMarketing(String module){
  salesAndMarketing.hover();
  salesAndMarketingSubMenu.$(byText(module)).click();
  }
}
