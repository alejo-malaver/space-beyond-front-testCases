/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package org.playvox.automation.project.screenplay.questions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import net.serenitybdd.screenplay.ensure.Ensure;
import org.playvox.automation.project.screenplay.pages.Checkout;

public class ValidatePayNowButton {

    public static void validatePayNowButtonIsDisable() {
        theActorInTheSpotlight()
                .attemptsTo(
                        Ensure.that(Checkout.APPLY_BUTTON).isDisplayed(),
                        Ensure.that(Checkout.APPLY_BUTTON).isDisabled(),
                        Ensure.that(Checkout.PAY_NOW_BUTTON).isDisplayed(),
                        Ensure.that(Checkout.PAY_NOW_BUTTON).isDisabled());
    }

    public static ValidatePayNowButton is() {
        return new ValidatePayNowButton();
    }
}
