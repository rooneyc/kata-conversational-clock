package serenitylabs.tutorials;

public class ConversationalClock {

    private final SystemTime now;
    private int currentHour;
    private int minutesPast;
    private int nextHour;
    private int relativeMinute;
    private HourTranslator hourTranslator;
    private MinuteTranslator minuteTranslator;

    private final String beginning = "it's ";

    public ConversationalClock(SystemTime time, HourTranslator hourTranslator, MinuteTranslator minuteTranslator) {
        this.now = time;
        this.hourTranslator = hourTranslator;
        this.minuteTranslator = minuteTranslator;

        this.currentHour = time.hour();
        this.minutesPast = time.minute();

        this.nextHour = nextHour();
        this.relativeMinute = relativeMinute();
    }

    private int nextHour() {

        if (minutesPast > 30) {
            return currentHour + 1;
        }
        return currentHour;
    }

    private int relativeMinute() {

        if (minutesPast > 5 && minutesPast <= 30) {
            return minutesPast;
        }

        if (minutesPast > 30 && minutesPast < 55) {
            return 60 - minutesPast;
        }

        return -1;
    }

    String currentTime() {

        return new StringBuilder(beginning)                                      //its
                .append(minuteTranslator.relativePrefix(minutesPast))            //almost, just after
                .append(minuteTranslator.wordForMinute(relativeMinute))          //five
                .append(minuteTranslator.relativeSeparator(minutesPast))         //past, to
                .append(hourTranslator.wordForHour(nextHour))                    //6, noon, midnight
                .append(hourTranslator.hourSuffix(nextHour, relativeMinute))     //o'clock
                .toString();
    }

}
