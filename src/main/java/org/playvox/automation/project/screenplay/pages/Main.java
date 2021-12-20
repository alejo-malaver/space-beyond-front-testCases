/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package org.playvox.automation.project.screenplay.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class Main extends PageObject {
    public static final Target LIST_CARDS =
            Target.the("List of cards with destinations to select")
                    .locatedBy("//div[@data-react-toolbox='card']");
    public static final Target TITLE_DESTINATION =
            Target.the("Title of the destination to select")
                    .locatedBy(".GalleryItem__gallery-item___2P8g- h5");
    public static final Target TICKET_COST =
            Target.the("Ticket value for person")
                    .locatedBy(".GalleryItem__gallery-item___2P8g- span");
    public static final Target LINK_BOOK =
            Target.the("Link to book of destination to select")
                    .locatedBy(".GalleryItem__gallery-item___2P8g- [type]");
}
