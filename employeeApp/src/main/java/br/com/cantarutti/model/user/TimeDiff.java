package br.com.cantarutti.model.user;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeDiff {

    private long firstMarker;
    private long forthMarker;

    public TimeDiff() {}

    public TimeDiff(long firstMarker) {
        this.firstMarker = firstMarker;
    }
    
    public TimeDiff(long firstMarker, long forthMarker) {
        this.firstMarker = firstMarker;
        this.forthMarker = forthMarker;
    }

    public long getfirstMarker() { return firstMarker; }
    public long getforthMarker() { return forthMarker; }


    public TimeDiff calculateDiffTime(LocalDateTime start, LocalDateTime end) {
        // verify with the worker worked 8 hour/day
        long hour = ChronoUnit.HOURS.between(start, end);
        long minute = ChronoUnit.MINUTES.between(start, end);

        return new TimeDiff(hour, minute);
    }

}
