/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic;
import java.io.Serializable;

public class Day{};

public class Card implements Serializable {
    private final int id;
    private Day[] days;

    public Card(int id, Day[] days){
        this.id = id;    
        this.days = days;
    }
    
    public int getId() {
        return id;
    }
    
    public Day getSpecificDay(int index)
    {
        if(index < 0 || index > days.length)
            return null;
        
        return days[index];
    }
    
    public Day[] getDays()
    {
        return days;
    }       
}
