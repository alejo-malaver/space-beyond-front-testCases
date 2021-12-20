/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package org.playvox.automation.project.commons;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;
import lombok.Data;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

@Data
public class CommonsInLists {
    public static List<WebElementFacade> getAllElementsForList(Target target) {
        return BrowseTheWeb.as(theActorInTheSpotlight()).findAll(target.getCssOrXPathSelector());
    }
}
