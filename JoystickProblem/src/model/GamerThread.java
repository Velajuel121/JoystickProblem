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
public class GamerThread implements Runnable{

    private Gamer gamer;
    public GamerThread(Gamer gamer){
        this.gamer = gamer;
    }
    @Override
    public void run() {
        while(true){
            
        }
    }
    
}
