/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic;

public class Dice {
    
    public int roll_dice(){
        return (int) ((Math.random() * 6) + 1 );
    }
}
