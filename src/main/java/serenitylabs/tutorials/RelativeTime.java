package serenitylabs.tutorials;

import static serenitylabs.tutorials.TimePhrases.inSecondHalf;

public class RelativeTime {

    private final SystemTime systemTime;

    public RelativeTime(SystemTime systemTime) {
        this.systemTime = systemTime;
    }

    private int currentHour() {
        return systemTime.hour();
    }

    public int minutesPast() {
        return systemTime.minute();
    }

    public int closestHour() {

        if (inSecondHalf(minutesPast())) {
            return currentHour() + 1;
        }
        return currentHour();
    }

    public int minutesFromClosestHour() {

        int minutesPast = minutesPast();

        if (inSecondHalf(minutesPast)) {
            return 60 - minutesPast;
        }

        return minutesPast;

    }

}
