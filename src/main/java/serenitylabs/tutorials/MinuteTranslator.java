package serenitylabs.tutorials;


import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;

class MinuteTranslator {

    String wordForMinute(int minute) {

        if (minute < 5) {
            return "";
        }

        if (minute > 55) {
            return "";
        }

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

    private String wordForInt(int primitiveInt) {

        RuleBasedNumberFormat ruleBasedNumberFormat
                = new RuleBasedNumberFormat(
                        new Locale("EN", ""),
                        RuleBasedNumberFormat.SPELLOUT );

        String intStringWithHyphens = ruleBasedNumberFormat.format(primitiveInt); //twenty-four

        return intStringWithHyphens.replace("-", " ");          //twenty four
    }

    String relativeSeparator(int minute) {

        if (minute >= 5 && minute <= 30) {
            return " past ";
        }

        if (minute > 30 && minute < 55) {
            return " to ";
        }

        return "";
    }

    String approxHourPrefix(int minute) {

        if (minute != 0 && minute < 5) {
            return "just after ";
        }

        if (minute != 0 && minute > 55) {
            return "almost ";
        }

        return "";
    }

    String minutesQuantifier(int minutesPast) {

        if ((minutesPast == 0)
        || ((minutesPast % 5) == 0)
        || minutesPast < 5
        || minutesPast > 55)
        {
            return "";
        }

        return " minutes";

    }
}

