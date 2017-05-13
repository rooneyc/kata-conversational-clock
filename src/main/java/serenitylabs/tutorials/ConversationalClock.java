package serenitylabs.tutorials;

public class ConversationalClock {

    private SystemTime now;

    public ConversationalClock(SystemTime time) {
        this.now = time;
    }

    String currentTime() {
        Snapshot snapshot = new Snapshot(now);
        RelativeTime time = new RelativeTime(snapshot);
        return TimeSentence.with(time);
    }

}
