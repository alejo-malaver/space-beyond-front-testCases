/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.playvox.automation.project.screenplay.questions.ValidateCostAndDate;
import org.playvox.automation.project.screenplay.questions.ValidatePayNowButton;
import org.playvox.automation.project.screenplay.tasks.CompleteCheckout;
import org.playvox.automation.project.screenplay.tasks.OpenApp;
import org.playvox.automation.project.screenplay.tasks.SelectRandomDestination;

public class BookingInSpaceAndBeyondStepDefinitions {
    private static String actorName = "Alejandro";

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("there is a user browsing the {string} web page in Space and Beyond")
    public void aUserBrowsingInTheWebPage(String page) {
        theActorCalled(actorName).attemptsTo(OpenApp.main(page));
    }

    @When("select a destination at random, without any filter")
    public void addItemsToShoppingCart() {
        theActorInTheSpotlight().attemptsTo(SelectRandomDestination.selectItem());
        ValidateCostAndDate.validateAmountToPaidAndDatesOfTravel();
    }

    @And("fill out the CHECKOUT form data")
    public void removeAllItemsToShoppingCart() {
        theActorInTheSpotlight().attemptsTo(CompleteCheckout.checkout());
    }

    @Then("the PAY NOW button is never enabled")
    public void validateIfShorppingCartIsEmpty() {
        ValidatePayNowButton.validatePayNowButtonIsDisable();
    }
}
