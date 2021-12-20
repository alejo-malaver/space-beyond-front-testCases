/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package org.playvox.automation.project.screenplay.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import org.playvox.automation.project.screenplay.pages.Main;

public class MoveMouseToDestinationList implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Scroll.to(Main.LIST_CARDS).andAlignToTop(), MoveMouse.to(Main.LIST_CARDS));
    }

    public static MoveMouseToDestinationList destinationList() {
        return instrumented(MoveMouseToDestinationList.class);
    }
}
