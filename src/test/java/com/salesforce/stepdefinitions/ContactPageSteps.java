package com.salesforce.stepdefinitions;

import com.salesforce.context.TestContext;
import com.salesforce.pageObjectModel.ContactsPage;
import io.cucumber.java.en.Then;

public class ContactPageSteps {

    public TestContext testContext;
    public ContactsPage contactsPage;

    public ContactPageSteps(TestContext testContext) {

        this.testContext = testContext;
    }

    @Then("User completes fields on new contact")
    public void userCompletesFieldsOnNewContact() {
        contactsPage = testContext.pageObjectManager.getContactsPage();
        contactsPage.choseSalutationPickList("Mr.");
        contactsPage.enterFirstName("First");
        contactsPage.enterLastName("Last");
        contactsPage.choseAccount("Acme");
    }


}
