package org.houstonlinux.doorbell;

/**
 * Represents a door bell.
 *
 * @author edwbuck
 */
public class Doorbell {

    private final String id;

    private final String name;
    
    private boolean ringing;

    public Doorbell(String id, String name) {
        this.id = id;
        this.name = name;
        this.ringing = false;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public boolean isRinging() {
        return ringing;
    }
    
    public void ring() {
        ringing = true;
    }
 
    public void answer() {
        ringing = false;
    }
}
