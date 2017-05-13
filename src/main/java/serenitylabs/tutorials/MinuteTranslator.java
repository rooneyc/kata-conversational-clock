package serenitylabs.tutorials;


import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;

import static serenitylabs.tutorials.TimePhrases.*;

class MinuteTranslator {

    static String wordForMinute(int minute) {

        if (inFirstFiveMin(minute)) {
            return "";
        }

        if (inLastFiveMin(minute)) {
            return "";
        }

        if (minute == 15) {
            return "a quarter";
        }

        if (minute == 30) {
            return "half";
        }

        if (notOnTheHour(minute)) {
            return wordForInt(minute);
        }

        return "";

    }

    static private String wordForInt(int primitiveInt) {

        RuleBasedNumberFormat ruleBasedNumberFormat
                = new RuleBasedNumberFormat(
                        new Locale("EN", ""),
                        RuleBasedNumberFormat.SPELLOUT );

        String intStringWithHyphens = ruleBasedNumberFormat.format(primitiveInt); //twenty-four

        return intStringWithHyphens.replace("-", " ");          //twenty four
    }

}

