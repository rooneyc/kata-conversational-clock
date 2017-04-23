package serenitylabs.tutorials;

import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;

public class ConversationalClock {

    private final SystemTime now;

    public ConversationalClock(SystemTime time) {
        this.now = time;
    }

    public String currentTime() {

        int hour = now.hour();

        RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat( new Locale("EN", ""), RuleBasedNumberFormat.SPELLOUT );

        return "it's " + ruleBasedNumberFormat.format(hour) + " o'clock";
    }
}
