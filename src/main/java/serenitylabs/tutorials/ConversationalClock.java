package serenitylabs.tutorials;

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

        if (minutesPast > 30) {
            return currentHour + 1;
        }
        return currentHour;
    }

    private int minutesFromClosestHour() {

        if (minutesPast > 30) {
            return 60 - minutesPast;
        }

        return minutesPast;

    }

    String hourSuffix(int hour, int minute) {

        if ((minute == 0 || minute < 5  || minute > 55)
                &&
            (hour != 12 && hour != 0))
        {
            return " o'clock";
        }

        return  "";
    }

    String currentTime() {

        return new StringBuilder(beginning)                                      //its
                .append(minuteTranslator.approxHourPrefix(minutesPast))          //almost, just after
                .append(minuteTranslator.wordForMinute(minutesFromClosestHour))  //five, seventeen
                .append(minuteTranslator.minutesQuantifier(minutesPast))         //minutes
                .append(minuteTranslator.relativeSeparator(minutesPast))         //past, to
                .append(hourTranslator.wordForHour(closestHour))                 //6, noon, midnight
                .append(hourSuffix(closestHour, minutesFromClosestHour))         //o'clock
                .toString();
    }

}
