package serenitylabs.tutorials;

import static serenitylabs.tutorials.HourTranslator.hourSuffix;
import static serenitylabs.tutorials.HourTranslator.wordForHour;
import static serenitylabs.tutorials.MinuteTranslator.wordForMinute;

public class ConversationalClock {

    private final SystemTime now;
    private final int hour;
    private final int minute;

    private final String beginning = "it's ";

    public ConversationalClock(SystemTime time) {
        this.now = time;
        this.hour = time.hour();
        this.minute = time.minute();
    }

    String currentTime() {

        if (minute == 0) {
            return beginning + wordForHour(hour) + hourSuffix(hour);
        }

        if (minute > 55 || minute < 5) {
            return lessThanFiveMinFromAnHour();
        }

        return moreThanFiveMinFromAnHour();
    }

    private String lessThanFiveMinFromAnHour() {
        String relativePrefix = "";
        int relativeHour = hour;
        if (minute < 5) {
            relativePrefix = "just after ";
        }
        if (minute > 55) {
            relativePrefix = "almost ";
            relativeHour = hour + 1;
        }
        return beginning + relativePrefix + wordForHour(relativeHour) + hourSuffix(relativeHour);
    }

    private String moreThanFiveMinFromAnHour() {
        String relativeSeparator;
        int relativeHour = hour;
        int relativeMinute = minute;
        if (minute <= 30) {
            relativeSeparator = " past ";
        } else {
            relativeSeparator = " to ";
            relativeHour = hour + 1;
            relativeMinute = 60 - minute;

        }
        return beginning + wordForMinute(relativeMinute) + relativeSeparator + wordForHour(relativeHour);
    }

}
