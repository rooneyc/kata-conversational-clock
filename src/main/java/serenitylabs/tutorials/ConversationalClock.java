package serenitylabs.tutorials;

import static serenitylabs.tutorials.TimePhrases.*;

public class ConversationalClock {

    private RelativeTime relativeTime;
    private HourTranslator hourTranslator;
    private MinuteTranslator minuteTranslator;

    private final String beginning = "it's ";

    public ConversationalClock(SystemTime time,
                               HourTranslator hourTranslator,
                               MinuteTranslator minuteTranslator) {

        this.relativeTime = new RelativeTime(time);
        this.hourTranslator = hourTranslator;
        this.minuteTranslator = minuteTranslator;
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
        int closestHour = relativeTime.closestHour();
        int minutesFromClosestHour = relativeTime.minutesFromClosestHour();

        return beginning                                                  //its
                + minuteTranslator.approxHourPrefix(minutesPast)          //almost, just after
                + minuteTranslator.wordForMinute(minutesFromClosestHour)  //five, seventeen
                + minuteTranslator.minutesQuantifier(minutesPast)         //minutes
                + minuteTranslator.relativeSeparator(minutesPast)         //past, to
                + hourTranslator.wordForHour(closestHour)                 //6, noon, midnight
                + hourSuffix(closestHour, minutesFromClosestHour)         //o'clock
        ;
    }

}
