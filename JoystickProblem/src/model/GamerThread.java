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
    public GamerThread(Gamer gamer,String name){
        this.gamer = gamer;
        this.name = name;
        this.leftjoy = gamer.getLeftJoyStick();
        this.rightjoy = gamer.getRightJoyStick();
    }
    @Override
    public void run() {
        while(true){
            try {
                doAction(System.nanoTime() + ": Waiting");
                /*gamer.takeJoyStick("left");
                gamer.takeJoyStick("right");
                gamer.freeJoyStick("right");
                gamer.freeJoyStick("left");
*/
                synchronized(leftjoy){
                    doAction(System.nanoTime() + ": Took the left JoyStick");
                    gamer.takeJoyStick("left");
                    synchronized(rightjoy){
                        doAction(System.nanoTime() + ": Took the right JoyStick");
                        gamer.takeJoyStick("right");
                        doAction(System.nanoTime() + ": Freed right JoyStick");
                        gamer.freeJoyStick("right");
                    }
                    doAction(System.nanoTime() + ": Freed left JoyStick");
                    gamer.freeJoyStick("left");
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                return;
            }
            
        }
    }
    public void doAction(String action) throws InterruptedException{
        Platform.runLater(() -> {
            MainController.getInstance().writeInLog((Thread.currentThread().getName() + " " + action));
        });
        Thread.sleep(((int) (Math.random() * 100)));
    }
    
}
