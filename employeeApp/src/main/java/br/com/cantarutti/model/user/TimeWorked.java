package br.com.cantarutti.model.user;

import java.time.LocalDateTime;

public class TimeWorked {
    
    private LocalDateTime firstMarker;
    private LocalDateTime secondMarker;
    private LocalDateTime thirdMarker;
    private LocalDateTime forthMarker;

    public TimeWorked() {}

    public TimeWorked(
        LocalDateTime firstMarker,
        LocalDateTime secondMarker,
        LocalDateTime thirdMarker,
        LocalDateTime forthMarker
    ) {
        this.firstMarker = firstMarker;
        this.secondMarker = secondMarker;
        this.thirdMarker = thirdMarker;
        this.forthMarker = forthMarker;
    }

    public LocalDateTime getFirstMarker() { return firstMarker; }
    public LocalDateTime getSecondMarker() { return secondMarker; }
    public LocalDateTime getThirdMarker() { return thirdMarker; }
    public LocalDateTime getForthMarker() { return forthMarker; }

}
