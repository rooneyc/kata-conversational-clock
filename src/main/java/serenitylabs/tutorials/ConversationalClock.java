package serenitylabs.tutorials;

import static serenitylabs.tutorials.HourTranslator.hourSuffix;
import static serenitylabs.tutorials.HourTranslator.wordForHour;
import static serenitylabs.tutorials.MinuteTranslator.wordForMinute;

public class ConversationalClock {

    private final SystemTime now;
    private int relativeHour;
    private int relativeMinute;

    private final String beginning = "it's ";

    public ConversationalClock(SystemTime time) {
        this.now = time;
        this.relativeHour = time.hour();
        this.relativeMinute = time.minute();
    }

    String currentTime() {

        if (now.minute() > 30) {
            relativeHour = now.hour() + 1;
        }

        if (relativeMinute == 0) {
           //return beginning + wordForHour(relativeHour) + hourSuffix(relativeHour);
            return sentence("", -1, "", relativeHour);
        }

        if (relativeMinute > 55 || relativeMinute < 5) {
            return lessThanFiveMinFromAnHour();
        }

        return moreThanFiveMinFromAnHour();
    }

    private String lessThanFiveMinFromAnHour() {
        String relativePrefix = "";
        if (relativeMinute < 5) {
            relativePrefix = "just after ";
        }
        if (relativeMinute > 55) {
            relativePrefix = "almost ";
        }
        //return beginning + relativePrefix + wordForHour(relativeHour) + hourSuffix(relativeHour, relativeMinute);
        return  sentence(relativePrefix, -1, "", relativeHour);
    }

    private String moreThanFiveMinFromAnHour() {
        String relativeSeparator;
        if (this.relativeMinute <= 30) {
            relativeSeparator = " past ";
        } else {
            relativeSeparator = " to ";
            relativeMinute = 60 - this.relativeMinute;

        }
        //return beginning + wordForMinute(relativeMinute) + relativeSeparator + wordForHour(relativeHour);
        return sentence("", relativeMinute, relativeSeparator, relativeHour);
    }

    private String sentence(String relativePrefix, int relativeMinute, String relativeSeparator, int relativeHour) {
        return new StringBuilder(beginning)
                .append(relativePrefix)
                .append(wordForMinute(relativeMinute))
                .append(relativeSeparator)
                .append(wordForHour(relativeHour))
                .append(hourSuffix(relativeHour, relativeMinute))
                .toString();
    }

}
