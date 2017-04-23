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

        this.relativeHour = time.hour();
        this.relativeMinute = -1;
        this.hour = time.hour();
        this.minute = time.minute();

        setRelativeHour();

        setRelativeMinute();
    }

    private void setRelativeHour() {
        if (minute > 30) {
            relativeHour = hour + 1;
        }
    }

    private void setRelativeMinute() {
        if (minute > 5 && minute <= 30) {
            relativeMinute = minute;
        }

        if (minute > 30 && minute < 55) {
            relativeMinute = 60 - minute;
        }
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
