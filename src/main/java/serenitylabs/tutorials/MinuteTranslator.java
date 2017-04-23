package serenitylabs.tutorials;


import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;

class MinuteTranslator {

    String wordForMinute(int minute) {

        if (minute == 15) {
            return "a quarter";
        }

        if (minute == 30) {
            return "half";
        }

        if (minute >= 0) {
            return wordForInt(minute);
        }

        return "";

    }

    private String wordForInt(int intPrimitive) {

        String intString;

        RuleBasedNumberFormat ruleBasedNumberFormat
                = new RuleBasedNumberFormat(
                        new Locale("EN", ""),
                        RuleBasedNumberFormat.SPELLOUT );

        String intStringWithHyphens = ruleBasedNumberFormat.format(intPrimitive);

        intString = intStringWithHyphens.replace("-", " ");

        return intString;
    }

    String relativeSeparator(int minute) {

        if (minute > 5 && minute <= 30) {
            return " past ";
        }

        if (minute > 30 && minute < 55) {
            return " to ";
        }

        return "";
    }

    String relativePrefix(int minute) {

        if (minute != 0 && minute < 5) {
            return "just after ";
        }

        if (minute != 0 && minute > 55) {
            return "almost ";
        }

        return "";
    }

}

