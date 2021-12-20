/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package org.playvox.automation.project.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import org.playvox.automation.project.util.Constants;
import org.playvox.automation.project.util.ManageConfig;

public class OpenApp implements Task {
    private String url;

    public OpenApp(String page) {
        if (page.equalsIgnoreCase(Constants.MAIN_PAGE_NAME)) url = ManageConfig.BASE_URL;
    }

    @Override
    @Step("{0} load the page to navigate")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }

    public static OpenApp main(String page) {
        return instrumented(OpenApp.class, page);
    }
}
