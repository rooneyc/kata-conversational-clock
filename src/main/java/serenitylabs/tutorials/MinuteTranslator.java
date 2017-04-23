package serenitylabs.tutorials;


import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;

class MinuteTranslator {

    static String wordForMinute(int minute) {

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

    private static String wordForInt(int intPrimitive) {

        String intString;

        RuleBasedNumberFormat ruleBasedNumberFormat
                = new RuleBasedNumberFormat(
                        new Locale("EN", ""),
                        RuleBasedNumberFormat.SPELLOUT );

        String intStringWithHyphens = ruleBasedNumberFormat.format(intPrimitive);

        intString = intStringWithHyphens.replace("-", " ");

        return intString;
    }

}

