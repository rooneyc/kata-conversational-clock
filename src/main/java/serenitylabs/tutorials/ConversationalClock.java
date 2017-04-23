package serenitylabs.tutorials;

public class ConversationalClock {

    private final SystemTime now;
    private int hour;
    private int minute;
    private int relativeHour;
    private int relativeMinute;
    private HourTranslator hourTranslator;
    private MinuteTranslator minuteTranslator;

    private final String beginning = "it's ";

    public ConversationalClock(SystemTime time, HourTranslator hourTranslator, MinuteTranslator minuteTranslator) {
        this.now = time;
        this.hourTranslator = hourTranslator;
        this.minuteTranslator = minuteTranslator;

        this.hour = time.hour();
        this.minute = time.minute();

        this.relativeHour = relativeHour();
        this.relativeMinute = relativeMinute();
    }

    private int relativeHour() {

        if (minute > 30) {
            return hour + 1;
        }
        return hour;
    }

    private int relativeMinute() {

        if (minute > 5 && minute <= 30) {
            return minute;
        }

        if (minute > 30 && minute < 55) {
            return 60 - minute;
        }

        return -1;
    }

    String currentTime() {

        return new StringBuilder(beginning)                                      //its
                .append(minuteTranslator.relativePrefix(minute))                 //almost, just after
                .append(minuteTranslator.wordForMinute(relativeMinute))          //five
                .append(minuteTranslator.relativeSeparator(minute))              //past, to
                .append(hourTranslator.wordForHour(relativeHour))                //6, noon, midnight
                .append(hourTranslator.hourSuffix(relativeHour, relativeMinute)) //o'clock
                .toString();
    }

}
