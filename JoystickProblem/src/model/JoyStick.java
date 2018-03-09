/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Alen
 */
public class JoyStick {
    private boolean joystick = false;
    
    public synchronized void use(){
        this.joystick = true;
    }
    public synchronized void release(){
        this.joystick = false;
    }
}