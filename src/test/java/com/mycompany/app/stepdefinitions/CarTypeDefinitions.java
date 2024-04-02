package com.mycompany.app.stepdefinitions;

import com.mycompany.app.helpers.EnterARegPage;
import com.mycompany.app.helpers.EnterCarRegistration;
import com.mycompany.app.helpers.WhatIsMyCar;
import com.mycompany.app.helpers.WriteToVariable;
import com.mycompany.app.navigation.NavigateTo;
import com.mycompany.app.util.PrepCarList;
import com.mycompany.app.util.ReadFile;
import com.mycompany.app.util.ReadFileOutput;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class CarTypeDefinitions {

    private static ArrayList <String> carDetails;

    @Managed
    WebDriver driver;

    Actor K = Actor.named("Key");

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
        K.can(BrowseTheWeb.with(driver));
    }

    @Given("Kevin is on the carzoo value my car homepage")
    public void KevinIsOnCheckMyValuePage() {

        K.wasAbleTo(
                NavigateTo.theSearchHomePage());

        K.attemptsTo(
                Check.whether(Presence.of(EnterARegPage.BANNER))
                                .andIfSo(Click.on("//button//span[text()='Accept All']")),
                Ensure.thatTheCurrentPage().title().isEqualTo("Value my car - how much is my car worth? | Cazoo"));
    }


    @When("Kevin performs a search of car registrations from his list {string} to know how much the cars are worth")
    public void performsASearchOfCarRegistrationsFromHisListToKnowHowMuchTheCarsAreWorth(String filePath) {
        ArrayList<String> carReg = new ReadFile().processFile(filePath);
        carDetails = new ArrayList<>();

        for (String reg : carReg) {

            K.attemptsTo(Check.whether(Presence.of(EnterARegPage.GET_STARTED)),
                    EnterCarRegistration.carReg(reg),
                    EnterCarRegistration.getStarted(),
                    Check.whether(Presence.of(EnterARegPage.ERROR_MESSAGE))
                            .andIfSo(
                                    WriteToVariable.write("No info found for : " + reg, carDetails)
                            ));

            // Save car details from Carzoo Website
            String makeModel = K.asksFor(Text.of(WhatIsMyCar.MAKE_AND_MODEL));
            String makeSpec = K.asksFor(Text.of(WhatIsMyCar.MAKE_SPEC));
            String makeDetails = K.asksFor(Text.of(WhatIsMyCar.MAKE_DETAILS));

            // Remove "|" from the Data from the Cazoo Site
            PrepCarList prepCarList = new PrepCarList();

            carDetails.add(prepCarList.removeItem2(makeModel) + "," + prepCarList.removeItem2(makeSpec) + "," + prepCarList.removeItem2(makeDetails));

            //Continue
            K.attemptsTo(NavigateTo.theSearchHomePage());
            K.attemptsTo(WaitUntil.the(EnterARegPage.ENTER_A_REG_FIELD, isClickable()).forNoMoreThan(10).seconds());

        }
    }


    @Then("Kevin can compare what is present in his {string} against the data obtained from Carzoo website")
    public void kevinCanCompareWithIsPresentInHisAgainstTheDataObtainedFromCarzooWebsite(String filePath) {

        ArrayList<String> carDetailsFromList = new ReadFileOutput().processFile(filePath);

        for (String carDetail : carDetailsFromList){
            K.attemptsTo(
                    Ensure.that(carDetail).isIn(carDetails)
            );
        }
    }
}
