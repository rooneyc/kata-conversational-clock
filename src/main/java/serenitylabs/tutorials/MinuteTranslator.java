package serenitylabs.tutorials;


import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;

class MinuteTranslator {

    static String wordForMinute(int minute) {

        String minuteString = "";

        if (minute == 15) {
            minuteString = "a quarter";
        } else if (minute == 30) {
            minuteString = "half";
        } else {
            if (minute >= 0) {
                minuteString = wordForInt(minute);
            }
        }

        return minuteString;
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

