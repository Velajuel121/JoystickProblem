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
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import model.Gamer;
import model.GamerThread;
import model.JoyStick;

/**
 * FXML Controller class
 *
 * @author Alen
 */
public class MainController implements Initializable {

    @FXML
    private TextArea textArea;

    public TextArea getTextArea() {
        return textArea;
    }
    @FXML
    private ImageView view;
    @FXML
    private ImageView view1;
    @FXML
    private ImageView view2;
    @FXML
    private ImageView view3;
    @FXML
    private ImageView view4;
    @FXML
    private ImageView joyLeftBottom;
    @FXML
    private ImageView joyRightBottom;
    @FXML
    private ImageView joyRightTop;
    @FXML
    private ImageView joyLeftTop;
    @FXML
    private ImageView joyBottom;
    @FXML
    private ImageView greenRightTop;
    @FXML
    private ImageView greenRightBottom;
    @FXML
    private ImageView greenLeftBottom;
    @FXML
    private ImageView greenTop;
    @FXML
    private ImageView greenLeftTop;
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Gamer[] gamers = initializeGamers();
        textArea.setText("");
        JoyStick[] joySticks = initializeJoySticks();
        GamerThread[] gamerThreads = new GamerThread[5];
        for(int i = 0; i < gamers.length; i++){
            JoyStick left = joySticks[i];
            JoyStick right = joySticks[(i+1) % joySticks.length];
            if(i==gamers.length-1){
                gamers[i] = new Gamer(right,left);
            }else{
                gamers[i] = new Gamer(left,right);
            }
            gamerThreads[i] = new GamerThread(gamers[i], "Gamer " + (i+1),textArea);
            Thread t = new Thread(gamerThreads[i], "Gamer " + (i+1));
            t.start();
        }
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
    public void writeInLog(String text){
        textArea.appendText(text);
    }
}
