/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.houstonlinux.doorbell;

import java.time.Instant;

/**
 *
 * @author edwbuck
 */
public class WaitingSession {
    
    private final Doorbell doorbell;
    
    private final Instant startTime;
    private Instant endTime;
    private boolean cancelled;
    private Proctor answerdBy;
    
    public WaitingSession(Doorbell doorbell) {
        this.doorbell = doorbell;
        this.startTime = Instant.now();
        this.endTime = null;
        this.answerdBy = null;
    }
    
    public void answer(Proctor proctor) {
        this.answerdBy = proctor;
        this.endTime = Instant.now();
    }
    
    public void cancel() {
        this.cancelled = true;
        this.endTime = Instant.now();
    }
    
}
