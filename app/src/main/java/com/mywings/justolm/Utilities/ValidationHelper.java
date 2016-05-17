package com.mywings.justolm.Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tatyabhau Chavan on 5/17/2016.
 */
public class ValidationHelper {

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        if (email.length() > 100)
            return isValid;

        String expression = "^@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

}
