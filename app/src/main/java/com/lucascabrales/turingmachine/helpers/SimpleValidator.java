package com.lucascabrales.turingmachine.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lucascabrales on 11/30/17.
 */

/**
 * Utilizada para validar las entradas de acuerdo a una expresión regular
 */
public class SimpleValidator {
    public static final String NOT_EMPTY = "^(?=\\s*\\S).*$";
    public static final String BINARY = "^[01]+$";

    public static boolean validate(String patternText, String textToValidate) {
        Pattern pattern = Pattern.compile(patternText);
        Matcher matcher = pattern.matcher(textToValidate);
        return matcher.matches();
    }
}