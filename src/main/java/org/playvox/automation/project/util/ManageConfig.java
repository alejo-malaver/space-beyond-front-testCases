/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package org.playvox.automation.project.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.configuration.SystemPropertiesConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.Configuration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ManageConfig {
    @SuppressWarnings("rawtypes")
    private static final Configuration CONFIGURATION =
            new SystemPropertiesConfiguration(
                    SystemEnvironmentVariables.createEnvironmentVariables());

    private static final EnvironmentVariables environmentVariables =
            CONFIGURATION.getEnvironmentVariables();

    public static final String BASE_URL =
            EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("base.url");
}
