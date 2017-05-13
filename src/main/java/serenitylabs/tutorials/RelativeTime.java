package serenitylabs.tutorials;

import static serenitylabs.tutorials.TimePhrases.*;

class RelativeTime {

    private final Snapshot snapshot;

    RelativeTime(Snapshot snapshot) {
        this.snapshot = snapshot;
    }

    private int currentHour() {
        return snapshot.hour;
    }

    private int minutesPast() {
        return snapshot.minute;
    }

    int closestHour() {

        if (inSecondHalf(minutesPast())) {
            return currentHour() + 1;
        }
        return currentHour();
    }

    int minutesFromClosestHour() {

        if (inSecondHalf(minutesPast())) {
            return 60 - minutesPast();
        }

        return minutesPast();
    }

    String relativeSeparator() {

        if (inFirstHalf(minutesPast()) && notInFirstFiveMin(minutesPast())) {
            return " past ";
        }

        if (inSecondHalf(minutesPast()) && notInLastFiveMin(minutesPast())) {
            return " to ";
        }

        return "";
    }

    String approxHourPrefix() {

        if (notOnTheHour(minutesPast()) && inFirstFiveMin(minutesPast())) {
            return "just after ";
        }

        if (notOnTheHour(minutesPast()) && inLastFiveMin(minutesPast())) {
            return "almost ";
        }

        return "";
    }

    String minutesQuantifier() {

        if ((onTheHour(minutesPast()))
          || multipleOfFive(minutesPast())
          || inFirstFiveMin(minutesPast())
          || inLastFiveMin(minutesPast()))
        {
            return "";
        }

        return " minutes";
    }

}
