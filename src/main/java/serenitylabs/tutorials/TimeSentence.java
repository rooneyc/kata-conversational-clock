package serenitylabs.tutorials;

import static serenitylabs.tutorials.TimePhrases.*;

class TimeSentence {

    static String with(RelativeTime relativeTime) {

        int closestHour = relativeTime.closestHour();
        int minutesFromClosestHour = relativeTime.minutesFromClosestHour();

        return "it's "                                                  //its
                + relativeTime.approxHourPrefix()          //almost, just after
                + MinuteTranslator.wordForMinute(minutesFromClosestHour)  //five, seventeen
                + relativeTime.minutesQuantifier()         //minutes
                + relativeTime.relativeSeparator()         //past, to
                + HourTranslator.wordForHour(closestHour)                 //6, noon, midnight
                + hourSuffix(closestHour, minutesFromClosestHour)         //o'clock
        ;
    }

    static private String hourSuffix(int hour, int minute) {

        if ((inFirstFiveMin(minute) || inLastFiveMin(minute))
                && notNoon(hour) && notMidnight(hour)) {
            return " o'clock";
        }

        return  "";
    }

}
