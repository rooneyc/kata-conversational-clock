package serenitylabs.tutorials;

class TimePhrases {

    static boolean inFirstFiveMin(int minute) {
        return minute < 5;
    }

    static boolean notInFirstFiveMin(int minute) {
        return !inFirstFiveMin(minute);
    }

    static boolean inLastFiveMin(int minute) {
        return minute > 55;
    }

    static boolean notInLastFiveMin(int minute) {
        return !inLastFiveMin(minute);
    }

    static boolean inSecondHalf(int minute) {
        return !inFirstHalf(minute);
    }

    static boolean inFirstHalf(int minute) {
        return minute <= 30;
    }

    static boolean notOnTheHour(int minute) {
        return !onTheHour(minute);
    }

    static boolean onTheHour(int minute) {
        return minute == 0;
    }

    static boolean noon(int hour) {
        return hour == 12;
    }

    static boolean notNoon(int hour) {
        return !noon(hour);
    }

    static boolean midnight(int hour) {
        return hour == 0;
    }

    static boolean notMidnight(int hour) {
        return !midnight(hour);
    }

    static boolean multipleOfFive(int minute) {
        return (minute % 5) == 0;
    }

}
