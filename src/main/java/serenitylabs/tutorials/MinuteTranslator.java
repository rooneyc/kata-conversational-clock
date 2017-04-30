package serenitylabs.tutorials;


import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;

import static serenitylabs.tutorials.TimePhrases.*;

class MinuteTranslator {

    String wordForMinute(int minute) {

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

    private String wordForInt(int primitiveInt) {

        RuleBasedNumberFormat ruleBasedNumberFormat
                = new RuleBasedNumberFormat(
                        new Locale("EN", ""),
                        RuleBasedNumberFormat.SPELLOUT );

        String intStringWithHyphens = ruleBasedNumberFormat.format(primitiveInt); //twenty-four

        return intStringWithHyphens.replace("-", " ");          //twenty four
    }

    String relativeSeparator(int minute) {

        if (inFirstHalf(minute) && notInFirstFiveMin(minute)) {
            return " past ";
        }

        if (inSecondHalf(minute) && notInLastFiveMin(minute)) {
            return " to ";
        }

        return "";
    }

    String approxHourPrefix(int minute) {

        if (notOnTheHour(minute) && inFirstFiveMin(minute)) {
            return "just after ";
        }

        if (notOnTheHour(minute) && inLastFiveMin(minute)) {
            return "almost ";
        }

        return "";
    }

    String minutesQuantifier(int minutesPast) {

        if ((onTheHour(minutesPast))
        || multipleOfFive(minutesPast)
        || inFirstFiveMin(minutesPast)
        || inLastFiveMin(minutesPast))
        {
            return "";
        }

        return " minutes";

    }
}

