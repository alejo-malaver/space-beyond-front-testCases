/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package org.playvox.automation.project.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.playvox.automation.project.commons.CommonsInLists;
import org.playvox.automation.project.screenplay.interactions.MoveMouseToDestinationList;
import org.playvox.automation.project.screenplay.pages.Main;
import org.playvox.automation.project.util.Constants;
import org.playvox.automation.project.util.RandomDataHelper;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class SelectRandomDestination implements Task {

    @Getter private static String amountToBePaid;

    public static SelectRandomDestination selectItem() {
        return instrumented(SelectRandomDestination.class);
    }

    @Step("{0} select a random destination")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(MoveMouseToDestinationList.destinationList());

        List<WebElementFacade> listNextDestinations =
                CommonsInLists.getAllElementsForList(Main.LIST_CARDS);
        theActorInTheSpotlight()
                .attemptsTo(Ensure.that(listNextDestinations.size()).isGreaterThan(0));
        int randomDestination = RandomDataHelper.getRandomRegister(listNextDestinations.size());
        WebElementFacade cardRandom = listNextDestinations.get(randomDestination);

        theActorInTheSpotlight().attemptsTo(Scroll.to(cardRandom).andAlignToBottom());
        WebElementFacade titleDestinationInCard =
                cardRandom.findBy(By.cssSelector(Main.TITLE_DESTINATION.getCssOrXPathSelector()));
        String titleDestination = titleDestinationInCard.getTextContent();
        Serenity.recordReportData()
                .withTitle(Constants.NAME_OF_THE_SELECTED_RANDOM_DESTINATION)
                .andContents(titleDestination);
        WebElementFacade amountOfDestinationInCard =
                cardRandom.findBy(By.cssSelector(Main.TICKET_COST.getCssOrXPathSelector()));
        amountToBePaid = amountOfDestinationInCard.getTextContent();
        WebElementFacade bookLinkInCard =
                cardRandom.findBy(By.cssSelector(Main.LINK_BOOK.getCssOrXPathSelector()));
        actor.attemptsTo(Click.on(bookLinkInCard));
    }
}
