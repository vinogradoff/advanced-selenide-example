package by.comaqa.advanced.tests;

import by.comaqa.advanced.tests.pagewidgets.contacts.*;
import by.comaqa.advanced.tests.pagewidgets.menu.MainMenu;

import by.comaqa.advanced.tests.pagewidgets.login.LoginWidget;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.Date;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
 * Simple Selenide Test with PageObjects
 */
public class CRMTest

{

    private static String now=LocalDateTime.now().toString();

    @BeforeAll
    static void init(){
        open("https://demo.1crmcloud.com/login.php");
        new LoginWidget().login("admin", "admin");
        new MainMenu().openInSalesAndMarketing("Contacts");

    }

    @Test
    public void createContact() {

        // create contact with name & email

        // click create
        new ActionsPanel().create();
        // enter first name & second name
        new EditContactDetails().enterName("TestFN"+now,"TestSN"+now);
        // enter primary email
        new EditContactDetails().enterPrimaryEmail("mail"+now+"@host.by");
        new EditContactDetails().saveContact();
        new MainMenu().openInSalesAndMarketing("Contacts");

        // search contact in the table
        new SearchContacts().filterText("TestFN"+now);
        new ContactsTable().rows.shouldHaveSize(1);
        // assert name & email
        new ContactsTable().firstRow.shouldHave(text("TestFN"+now))
                .shouldHave(text("TestSN"+now))
                .shouldHave(text("host.by"));
                //.shouldHave(text("mail"+now+"@host.by"));
    }

    public void editContact(){

        // find test contacts
        // edit the first one
        // search contact in the table
        // assert changes


    }
    public void deleteContact(){
        // find test contacts
        // delete the first one
        // search contact in the table
        // assert nothing found

    }
}
