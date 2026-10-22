/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.houstonlinux.doorbell;

/**
 *
 * @author edwbuck
 */
public class Proctor {
    
    private String name;
    private boolean active;
    
    public Proctor(String name) {
        this.name = name;
        this.active = false;
    }
    
    public void checkIn() {
        this.active = true;
    }
    
    public void checkOut() {
        this.active = false;
    }
    
}
