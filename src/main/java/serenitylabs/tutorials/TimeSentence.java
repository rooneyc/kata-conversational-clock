package serenitylabs.tutorials;

import static serenitylabs.tutorials.HourTranslator.wordForHour;
import static serenitylabs.tutorials.MinuteTranslator.wordForMinute;

class TimeSentence {

    static String with(RelativeTime relativeTime) {

        return "it's "                                                  //its
                + relativeTime.approxHourPrefix()                       //almost, just after
                + wordForMinute(relativeTime.minutesFromClosestHour())  //five, seventeen
                + relativeTime.minutesQuantifier()                      //minutes
                + relativeTime.relativeSeparator()                      //past, to
                + wordForHour(relativeTime.closestHour())               //6, noon, midnight
                + relativeTime.hourSuffix()                             //o'clock
        ;
    }



}
