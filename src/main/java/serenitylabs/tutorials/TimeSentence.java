package serenitylabs.tutorials;

import static serenitylabs.tutorials.TimePhrases.*;

class TimeSentence {

    static String with(RelativeTime relativeTime) {

        int minutesPast = relativeTime.minutesPast();
        int closestHour = relativeTime.closestHour(minutesPast);
        int minutesFromClosestHour = relativeTime.minutesFromClosestHour(minutesPast);

        return "it's "                                                  //its
                + relativeTime.approxHourPrefix(minutesPast)          //almost, just after
                + MinuteTranslator.wordForMinute(minutesFromClosestHour)  //five, seventeen
                + relativeTime.minutesQuantifier(minutesPast)         //minutes
                + relativeTime.relativeSeparator(minutesPast)         //past, to
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
