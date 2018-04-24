/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic;
import java.io.Serializable;

public class Dice implements Serializable{
    
    int number;

    public int getNumber() {
        return number;
    }
    
    private void setNumber(int number){
        this.number = number;
    }
    
    public void DiceRollModification(int number)
    {
        int sum = this.number + number;
        
        if(sum < 1)
            sum = 1;
        
        else if(sum > 6)
            sum = 6;
        
        setNumber(sum);
    }
    
    public int roll_dice(){
        return number = (int) ((Math.random() * 6) + 1 );
    }
}
