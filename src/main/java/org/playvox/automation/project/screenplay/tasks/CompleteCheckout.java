/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package org.playvox.automation.project.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.playvox.automation.project.screenplay.pages.Checkout;
import org.playvox.automation.project.util.RandomDataHelper;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CompleteCheckout implements Task {

    public static CompleteCheckout checkout() {
        return instrumented(CompleteCheckout.class);
    }

    @Step("{0} fill out the checkout form")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(RandomDataHelper.getRandomName()).into(Checkout.NAME_IN_FORM),
                Enter.theValue(RandomDataHelper.getRandomMail()).into(Checkout.EMAIL_IN_FORM),
                Enter.theValue(RandomDataHelper.getRandomSocialSecurityNumber())
                        .into(Checkout.SOCIAL_SECURITY_IN_FORM),
                Enter.theValue(RandomDataHelper.getRandomPhoneNumber())
                        .into(Checkout.PHONE_NUMBER_IN_FORM),
                Click.on(Checkout.CHECK_TERMS_AND_CONDITIONS));
    }
}
