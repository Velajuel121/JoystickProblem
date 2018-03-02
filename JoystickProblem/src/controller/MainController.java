/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Gamer;
import model.GamerThread;
import model.JoyStick;

/**
 * FXML Controller class
 *
 * @author Alen
 */
public class MainController implements Initializable {
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Gamer[] gamers = initializeGamers();
        JoyStick[] joySticks = initializeJoySticks();
        GamerThread[] gamerthreads = initializeGamerThreads(gamers);
    }
    private Gamer[] initializeGamers(){
        Gamer gamerOne = new Gamer(1);
        Gamer gamerTwo = new Gamer(2);
        Gamer gamerThree = new Gamer(3);
        Gamer gamerFour = new Gamer(4);
        Gamer gamerFive = new Gamer(5);
        Gamer[] gamers = new Gamer[] {gamerOne,gamerTwo,gamerThree,gamerFour,gamerFive};
        return gamers;
    }

    private JoyStick[] initializeJoySticks() {
        JoyStick joyOne = new JoyStick();
        JoyStick joyTwo = new JoyStick();
        JoyStick joyThree = new JoyStick();
        JoyStick joyFour = new JoyStick();
        JoyStick joyFive = new JoyStick();
        JoyStick[] joySticks = new JoyStick[] {joyOne,joyTwo,joyThree,joyFour,joyFive};
        return joySticks;
    }

    private GamerThread[] initializeGamerThreads(Gamer[] gamers) {
        GamerThread gamerOne = new GamerThread(gamers[0]);
        GamerThread gamerTwo = new GamerThread(gamers[1]);
        GamerThread gamerThree = new GamerThread(gamers[2]);
        GamerThread gamerFour = new GamerThread(gamers[3]);
        GamerThread gamerFive = new GamerThread(gamers[4]);
        GamerThread[] gamerThreads = new GamerThread[] {gamerOne,gamerTwo,gamerThree,gamerFour,gamerFive};
        return gamerThreads;
    }
    
}
