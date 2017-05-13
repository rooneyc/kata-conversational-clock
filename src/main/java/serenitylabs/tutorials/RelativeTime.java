package serenitylabs.tutorials;

import static serenitylabs.tutorials.TimePhrases.*;
import static serenitylabs.tutorials.TimePhrases.inLastFiveMin;

class RelativeTime {

    private final SystemTime systemTime;

    RelativeTime(SystemTime systemTime) {
        this.systemTime = systemTime;
    }

    private int currentHour() {
        return systemTime.hour();
    }

    int minutesPast() {
        return systemTime.minute();
    }

    int closestHour(int minutesPast) {

        if (inSecondHalf(minutesPast)) {
            return currentHour() + 1;
        }
        return currentHour();
    }

    int minutesFromClosestHour(int minutesPast) {

        if (inSecondHalf(minutesPast)) {
            return 60 - minutesPast;
        }

        return minutesPast;
    }

    String relativeSeparator(int minute) {

        if (inFirstHalf(minute) && notInFirstFiveMin(minute)) {
            return " past ";
        }

        if (inSecondHalf(minute) && notInLastFiveMin(minute)) {
            return " to ";
        }

        return "";
    }

    String approxHourPrefix(int minute) {

        if (notOnTheHour(minute) && inFirstFiveMin(minute)) {
            return "just after ";
        }

        if (notOnTheHour(minute) && inLastFiveMin(minute)) {
            return "almost ";
        }

        return "";
    }

    String minutesQuantifier(int minutesPast) {

        if ((onTheHour(minutesPast))
          || multipleOfFive(minutesPast)
          || inFirstFiveMin(minutesPast)
          || inLastFiveMin(minutesPast))
        {
            return "";
        }

        return " minutes";
    }

}
