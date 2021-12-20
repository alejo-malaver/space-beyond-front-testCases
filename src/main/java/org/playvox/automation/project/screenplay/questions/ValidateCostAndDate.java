/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package org.playvox.automation.project.screenplay.questions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.text.NumberFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.apache.commons.lang3.StringUtils;
import org.playvox.automation.project.screenplay.pages.Checkout;
import org.playvox.automation.project.screenplay.tasks.SelectRandomDestination;
import org.playvox.automation.project.util.Constants;

public class ValidateCostAndDate {

    public static void validateAmountToPaidAndDatesOfTravel() {
        ZoneId zoneId = ZoneId.of(Constants.ZONE_ID);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.now(), zoneId);
        String currentDate =
                zonedDateTime.format(
                        DateTimeFormatter.ofPattern(Constants.FORMAT_CURRENT_DATE, Locale.US));
        String currentDatePlusSixDays =
                zonedDateTime
                        .plusDays(6)
                        .format(
                                DateTimeFormatter.ofPattern(
                                        Constants.FORMAT_CURRENT_DATE_PLUS_SIX_DAYS, Locale.US));
        String datesDefault = currentDate + Constants.SEPARATOR_IN_DATE + currentDatePlusSixDays;
        Double amount =
                Double.valueOf(
                        SelectRandomDestination.getAmountToBePaid()
                                .replace(Constants.CURRENCY_SIGN, StringUtils.EMPTY));
        NumberFormat valueInCOPFormat = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        String amountToBePay = valueInCOPFormat.format(amount);

        theActorInTheSpotlight()
                .attemptsTo(
                        Ensure.that(Checkout.DATES).isDisplayed(),
                        Ensure.that(Checkout.DATES).text().isEqualTo(datesDefault),
                        Ensure.that(Checkout.NUMBER_OF_TRAVELERS).isDisplayed(),
                        Ensure.that(Checkout.NUMBER_OF_TRAVELERS)
                                .text()
                                .isEqualTo(Constants.NUMBER_OF_TRAVELERS_DEFAULT),
                        Ensure.that(Checkout.COST_INDIVIDUAL).isDisplayed(),
                        Ensure.that(Checkout.COST_INDIVIDUAL)
                                .text()
                                .isEqualTo(SelectRandomDestination.getAmountToBePaid()),
                        Ensure.that(Checkout.COST_TOTAL).isDisplayed(),
                        Ensure.that(Checkout.COST_TOTAL).text().isEqualTo(amountToBePay));
    }

    public static ValidateCostAndDate is() {
        return new ValidateCostAndDate();
    }
}
