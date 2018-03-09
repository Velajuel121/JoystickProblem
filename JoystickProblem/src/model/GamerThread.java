/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.MainController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

/**
 *
 * @author Alen
 */
public class GamerThread implements Runnable{
    private MainController controller;
    private final Gamer gamer;
    private final String name;
    private final Object leftjoy;
    private final Object rightjoy;
    private TextArea text;
    public GamerThread(Gamer gamer,String name,TextArea text){
        this.gamer = gamer;
        this.name = name;
        this.leftjoy = gamer.getLeftJoyStick();
        this.rightjoy = gamer.getRightJoyStick();
        this.text = text;
    }
    @Override
    public void run() {
        while(true){
            try {
                doAction(": Waiting");
                synchronized(leftjoy){
                    doAction(": Took the left JoyStick");
                    gamer.takeJoyStick("left");
                    synchronized(rightjoy){
                        doAction(": Took the right JoyStick");
                        gamer.takeJoyStick("right");
                        doAction(": Freed right JoyStick");
                        gamer.freeJoyStick("right");
                    }
                    doAction(": Freed left JoyStick");
                    gamer.freeJoyStick("left");
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                return;
            }
            
        }
    }
    public void doAction(String action) throws InterruptedException{
<<<<<<< HEAD
        Platform.runLater(new Runnable(){ @Override public void run(){
            text.appendText(name + " " + action +"\n");
=======
        Platform.runLater(new Runnable() { @Override public void run(){
         text.appendText(name + " " + action + "\n");
>>>>>>> master
            try {
                Thread.sleep(16);
            } catch (InterruptedException ex) {
                Logger.getLogger(GamerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
<<<<<<< HEAD
        }});
=======
    }});
>>>>>>> master
        Thread.sleep(((int) (Math.random() * 100)));
    }
    
}
