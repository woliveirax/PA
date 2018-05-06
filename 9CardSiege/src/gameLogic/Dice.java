/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic;
import java.io.Serializable;

public class Dice implements Serializable{
    
    private int number;

    public int getNumber() {
        return number;
    }
    
    public int roll_dice(int drm){
        
        int sum = (int) (((Math.random() * 6) + 1 ) + drm);
        
        if(sum < 1)
            sum = 1;
        
        else if(sum > 6)
            sum = 6;
        
        this.number = sum;
        
        return number;
    }
    
    public int roll_dice(){
        return number = (int) ((Math.random() * 6) + 1 );
    }
}
