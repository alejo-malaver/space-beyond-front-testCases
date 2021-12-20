/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package org.playvox.automation.project.util;

import com.github.javafaker.Faker;
import java.util.Locale;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RandomDataHelper {

    static Faker faker = new Faker(new Locale("es"));
    static String startingNumberForCellPhones = "419";
    static String formatNumberToString = "%10.0f";

    public static int getRandomRegister(int i) {
        return faker.number().numberBetween(0, i);
    }

    public static String getRandomName() {
        return faker.name().fullName();
    }

    public static String getRandomMail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomSocialSecurityNumber() {
        double random1 = faker.number().randomDouble(0, 000, 999);
        double random2 = faker.number().randomDouble(0, 00, 99);
        double random3 = faker.number().randomDouble(0, 0000, 9999);
        String numberRandom1 = String.format(formatNumberToString, random1).trim();
        String numberRandom2 = String.format(formatNumberToString, random2).trim();
        String numberRandom3 = String.format(formatNumberToString, random3).trim();
        String separator = "-";
        return numberRandom1 + separator + numberRandom2 + separator + numberRandom3;
    }

    public static String getRandomPhoneNumber() {
        long minValue = 1011111;
        long maxValue = 2399999;
        double random = faker.number().randomDouble(0, minValue, maxValue);
        String numberRandom = String.format(formatNumberToString, random).trim();
        return startingNumberForCellPhones + numberRandom;
    }
}
