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
public class Gamer {
    private JoyStick leftJoyStick;
    private JoyStick rightJoyStick;
    private int id;

    public int getId() {
        return id;
    }

    public JoyStick getLeftJoyStick() {
        return leftJoyStick;
    }

    public JoyStick getRightJoyStick() {
        return rightJoyStick;
    }
    private int allGamers = 5;
    public Gamer(int id){
        this.id = id;
    }
    public Gamer(JoyStick left,JoyStick right,int id){
        this.leftJoyStick = left;
        this.rightJoyStick = right;
        this.id = id;
    }
    public void takeJoyStick(String type){
        if("left".equals(type))
            leftJoyStick.use();
        else if("right".equals(type)){
            rightJoyStick.use();
        }
    }
    public void freeJoyStick(String type){
        if("left".equals(type)){
            leftJoyStick.release();
        }
        if("right".equals(type)){
            rightJoyStick.release();
        }
    }
    
}
