package br.com.cantarutti.model.user;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeDiff extends TimeWorked {

    public TimeDiff(long hour, long minute) {}
    

    public TimeDiff calculateDiffTime(LocalDateTime start, LocalDateTime end) {

        TimeWorked tw = new TimeWorked();

        // verify with the worker worked 8 hour/day
        long hour = ChronoUnit.HOURS.between(tw.getFirstMarker(), tw.getForthMarker());
        long minute = ChronoUnit.MINUTES.between(tw.getFirstMarker(), tw.getForthMarker());

        return new TimeDiff(hour, minute);
    }

}
