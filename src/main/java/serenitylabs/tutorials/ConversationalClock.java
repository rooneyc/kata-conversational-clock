package serenitylabs.tutorials;

import static serenitylabs.tutorials.HourTranslator.hourSuffix;
import static serenitylabs.tutorials.HourTranslator.wordForHour;
import static serenitylabs.tutorials.MinuteTranslator.wordForMinute;

public class ConversationalClock {

    private final SystemTime now;
    private int hour;
    private int minute;
    private int relativeHour;
    private int relativeMinute;
    private String relativeSeparator;
    private String relativePrefix;

    private final String beginning = "it's ";

    public ConversationalClock(SystemTime time) {
        this.now = time;
        this.relativeHour = time.hour();
        this.relativeMinute = -1;
        this.relativeSeparator = "";
        this.relativePrefix = "";
        this.hour = time.hour();
        this.minute = time.minute();
    }

    String currentTime() {

        if (minute != 0 && minute < 5) {
            relativePrefix = "just after ";
            relativeMinute = -1;
        }

        if (minute != 0 && minute > 55) {
           relativePrefix = "almost ";
            relativeMinute = -1;
        }

        if (minute > 30) {
            relativeHour = hour + 1;
        }

        if (minute > 5 && minute <= 30) {
            relativeSeparator = " past ";
            relativeMinute = now.minute();
        }

        if (minute > 30 && minute < 55) {
            relativeSeparator = " to ";
            relativeMinute = 60 - now.minute();
        }

        return sentence(relativePrefix, relativeMinute, relativeSeparator, relativeHour);
    }

    private String sentence(String relativePrefix, int relativeMinute, String relativeSeparator, int relativeHour) {
        return new StringBuilder(beginning) //its
                .append(relativePrefix) //almost, just after
                .append(wordForMinute(relativeMinute)) // five
                .append(relativeSeparator) // past, to
                .append(wordForHour(relativeHour)) // 6
                .append(hourSuffix(relativeHour, relativeMinute)) // o'clock
                .toString();
    }

}
