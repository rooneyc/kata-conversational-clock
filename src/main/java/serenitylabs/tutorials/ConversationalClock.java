package serenitylabs.tutorials;

public class ConversationalClock {

    private final SystemTime now;

    public ConversationalClock(SystemTime time) {
        this.now = time;
    }

    public String currentTime() {

        int hour = now.hour();

        String hourString = "";

        switch (hour) {
            case 1: hourString = "one";
                    break;
            case 2: hourString = "two";
                break;
            case 13: hourString = "one";
                break;
        }

        return "it's " + hourString + " o'clock";
    }
}
