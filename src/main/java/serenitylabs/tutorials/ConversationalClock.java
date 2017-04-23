package serenitylabs.tutorials;

public class ConversationalClock {

    private final SystemTime now;

    final String onAnHourSuffix = "o'clock";

    public ConversationalClock(SystemTime time) {
        this.now = time;
    }

    public String currentTime() {

        int hour = now.hour();

        String hourString = "";

        switch (hour) {
            case 1: hourString = "one " + onAnHourSuffix;
                    break;
            case 2: hourString = "two " + onAnHourSuffix;
                break;
            case 3: hourString = "three " + onAnHourSuffix;
                break;
            case 4: hourString = "four " + onAnHourSuffix;
                break;
            case 5: hourString = "five " + onAnHourSuffix;
                break;
            case 6: hourString = "six " + onAnHourSuffix;
                break;
            case 7: hourString = "seven " + onAnHourSuffix;
                break;
            case 8: hourString = "eight " + onAnHourSuffix;
                break;
            case 9: hourString = "nine " + onAnHourSuffix;
                break;
            case 10: hourString = "ten " + onAnHourSuffix;
                break;
            case 11: hourString = "eleven " + onAnHourSuffix;
                break;
            case 12: hourString = "noon";
                break;
            case 13: hourString = "one " + onAnHourSuffix;
                break;
            case 14: hourString = "two " + onAnHourSuffix;
                break;
            case 15: hourString = "three " + onAnHourSuffix;
                break;
            case 16: hourString = "four " + onAnHourSuffix;
                break;
            case 17: hourString = "five " + onAnHourSuffix;
                break;
            case 18: hourString = "six " + onAnHourSuffix;
                break;
            case 19: hourString = "seven " + onAnHourSuffix;
                break;
            case 20: hourString = "eight " + onAnHourSuffix;
                break;
            case 21: hourString = "nine " + onAnHourSuffix;
                break;
            case 22: hourString = "ten " + onAnHourSuffix;
                break;
            case 23: hourString = "eleven " + onAnHourSuffix;
                break;
            case 24: hourString = "midnight";
                break;
        }

        return "it's " + hourString;
}
}
