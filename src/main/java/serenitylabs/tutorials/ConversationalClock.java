package serenitylabs.tutorials;

public class ConversationalClock {

    private RelativeTime relativeTime;

    public ConversationalClock(SystemTime time) {
        this.relativeTime = new RelativeTime(time);
    }

    String currentTime() {
        return TimeSentence.with(relativeTime);
    }

}
