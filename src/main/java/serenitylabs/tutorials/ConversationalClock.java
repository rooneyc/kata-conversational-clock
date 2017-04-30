package serenitylabs.tutorials;

import static serenitylabs.tutorials.TimePhrases.*;

public class ConversationalClock {

    private final SystemTime now;
    private int currentHour;
    private int minutesPast;
    private int closestHour;
    private int minutesFromClosestHour;
    private HourTranslator hourTranslator;
    private MinuteTranslator minuteTranslator;

    private final String beginning = "it's ";

    public ConversationalClock(SystemTime time,
                               HourTranslator hourTranslator,
                               MinuteTranslator minuteTranslator) {

        this.now = time;
        this.hourTranslator = hourTranslator;
        this.minuteTranslator = minuteTranslator;

        this.currentHour = time.hour();
        this.minutesPast = time.minute();

        this.closestHour = closestHour();
        this.minutesFromClosestHour = minutesFromClosestHour();
    }

    private int closestHour() {

        if (inSecondHalf(minutesPast)) {
            return currentHour + 1;
        }
        return currentHour;
    }

    private int minutesFromClosestHour() {

        if (inSecondHalf(minutesPast)) {
            return 60 - minutesPast;
        }

        return minutesPast;

    }

    private String hourSuffix(int hour, int minute) {

        if ((inFirstFiveMin(minute) || inLastFiveMin(minute))
                && notNoon(hour) && notMidnight(hour)) {
            return " o'clock";
        }

        return  "";
    }

    String currentTime() {

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
