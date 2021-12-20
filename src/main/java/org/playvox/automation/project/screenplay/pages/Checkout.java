/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package org.playvox.automation.project.screenplay.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Checkout extends PageObject {
    public static final Target DATES =
            Target.the("Travel dates")
                    .locatedBy(".OrderSummary__row-2___1gW1q .flexboxgrid__col-xs-5___1HkK5");
    public static final Target NUMBER_OF_TRAVELERS =
            Target.the("Number of travelers who are going to book")
                    .locatedBy(".OrderSummary__row-3___1s0Ls .flexboxgrid__col-xs-7___3o2m-");
    public static final Target COST_INDIVIDUAL =
            Target.the("Cost per passenger")
                    .locatedBy(".OrderSummary__row-3___1s0Ls .flexboxgrid__col-xs-5___1HkK5");
    public static final Target CHECK_TERMS_AND_CONDITIONS =
            Target.the("Check to accept terms and conditions").locatedBy(".theme__check___2B20W");
    public static final Target COST_TOTAL =
            Target.the("Total cost of the trip").locatedBy(".OrderSummary__headline-1___1lzsL");
    public static final Target NAME_IN_FORM =
            Target.the("Name of who is going to checkout")
                    .located(By.cssSelector("form > div:nth-of-type(1) > input"));
    public static final Target EMAIL_IN_FORM =
            Target.the("email of who is going to checkout")
                    .located(By.cssSelector("form > div:nth-of-type(2) > input"));
    public static final Target SOCIAL_SECURITY_IN_FORM =
            Target.the("Social security number of who is going to checkout")
                    .located(By.cssSelector("form > div:nth-of-type(3) > input"));
    public static final Target PHONE_NUMBER_IN_FORM =
            Target.the("Phone number of who is going to checkout")
                    .located(By.cssSelector("form > div:nth-of-type(4) > input"));
    public static final Target APPLY_BUTTON =
            Target.the("Button APPLY in Checkout")
                    .locatedBy(
                            "[class='OrderSummary__row-4___2JawU flexboxgrid__row___1y_mg'] button");
    public static final Target PAY_NOW_BUTTON =
            Target.the("Button PAY NOW in Checkout")
                    .locatedBy(
                            "[class='theme__button___1iKuo CTAButton__button___2nXRo theme__raised___ONZv6 CTAButton__raised___1nGcA theme__primary___2NhN1 CTAButton__primary___WQCBB OrderSummary__pay-button___1CG2e']");
}
