package by.comaqa.advanced.tests;

import by.comaqa.advanced.tests.pagewidgets.StatusMessage;
import by.comaqa.advanced.tests.pagewidgets.contacts.*;
import by.comaqa.advanced.tests.pagewidgets.menu.MainMenu;

import by.comaqa.advanced.tests.pagewidgets.login.LoginWidget;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import javax.xml.bind.SchemaOutputResolver;
import java.time.LocalDateTime;
import java.util.Date;

import static com.codeborne.selenide.Condition.*;
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
        new EditContactDetails().enterName("TestFN"+now,"TestLN"+now);
        // enter primary email
        new EditContactDetails().enterPrimaryEmail("mail"+now+"@host.by");
        new EditContactDetails().saveContact();
        new MainMenu().openInSalesAndMarketing("Contacts");

        // search contact in the table
        new SearchContacts().filterText("TestFN"+now);
        new ContactsTable().rows.shouldHaveSize(1);
        // assert name & email
        new ContactsTable().firstRow.shouldHave(text("TestFN"+now))
                .shouldHave(text("TestLN"+now))
                .shouldHave(text("host.by"));
                //.shouldHave(text("mail"+now+"@host.by"));
    }

    @Test
    public void editContact(){

        // find test contacts
        new SearchContacts().filterText("TestFN");
        //new StatusMessage().status.shouldHave(text("Loading..."));
        new ContactsTable().table.shouldBe(visible);
        int hits=new ContactsTable().rows.size();
        Assumptions.assumeTrue(hits>0, "no TestFN contacts found");
        // edit the first one
        String contractName=new ContactsTable().getNameOfContactFromRow(new ContactsTable().firstRow).getText();
        System.out.println(contractName);
        new ContactsTable().openDetailsOfContact(new ContactsTable().firstRow);
        new ContactDetails().startEditingContract();
        // edit first name & second name
        String editingTime=LocalDateTime.now().toString();
        new EditContactDetails().enterName("TestFN"+editingTime,"TestLN"+editingTime);
        // edit email
        new EditContactDetails().enterPrimaryEmail("edited@host.by");
        new EditContactDetails().saveContact();
        new MainMenu().openInSalesAndMarketing("Contacts");
        // search contact in the table
        new SearchContacts().filterText("TestFN"+editingTime);
        // assert changes
        new ContactsTable().rows.shouldHaveSize(1);
        new ContactsTable().firstRow.shouldHave(text("TestFN"+editingTime))
                .shouldHave(text("TestLN"+editingTime))
                .shouldHave(text("edited@host.by"));


    }
    @Test
    public void deleteContact(){
        // find test contacts
        new SearchContacts().filterText("TestFN");
        //sleep(1000);
        new ContactsTable().table.shouldBe(visible);
        int hits=new ContactsTable().rows.size();
        Assumptions.assumeTrue(hits>0, "no TestFN contacts found");
        // delete the first one
        String contractName=new ContactsTable().getNameOfContactFromRow(new ContactsTable().firstRow).getText();
        System.out.println(contractName);
        new ContactsTable().openDetailsOfContact(new ContactsTable().firstRow);
        new ContactDetails().deleteContact();
        // search contact in the table
        new SearchContacts().filterText(contractName);
        // assert nothing found
        new ContactsTable().rows.shouldHaveSize(0);

    }
}
