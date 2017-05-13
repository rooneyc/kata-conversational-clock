package serenitylabs.tutorials;

class Snapshot {

    final int minute;
    final int hour;

    Snapshot(SystemTime now) {
        this.minute = now.minute();
        this.hour = now.hour();
    }

}
