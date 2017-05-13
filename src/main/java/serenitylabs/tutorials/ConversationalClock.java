package serenitylabs.tutorials;

import static serenitylabs.tutorials.TimePhrases.*;

public class ConversationalClock {

    private RelativeTime relativeTime;

    private final String beginning = "it's ";

    public ConversationalClock(SystemTime time) {
        this.relativeTime = new RelativeTime(time);
    }

    private String hourSuffix(int hour, int minute) {

        if ((inFirstFiveMin(minute) || inLastFiveMin(minute))
                && notNoon(hour) && notMidnight(hour)) {
            return " o'clock";
        }

        return  "";
    }

    String currentTime() {

        int minutesPast = relativeTime.minutesPast();
        int closestHour = relativeTime.closestHour(minutesPast);
        int minutesFromClosestHour = relativeTime.minutesFromClosestHour(minutesPast);

        return beginning                                                  //its
                + RelativeTime.approxHourPrefix(minutesPast)          //almost, just after
                + MinuteTranslator.wordForMinute(minutesFromClosestHour)  //five, seventeen
                + RelativeTime.minutesQuantifier(minutesPast)         //minutes
                + RelativeTime.relativeSeparator(minutesPast)         //past, to
                + HourTranslator.wordForHour(closestHour)                 //6, noon, midnight
                + hourSuffix(closestHour, minutesFromClosestHour)         //o'clock
        ;
    }

}
