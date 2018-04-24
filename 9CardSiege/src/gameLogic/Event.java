/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic;
import java.io.Serializable;

public class Event implements Serializable{
    private GameData gameData;
    
    public boolean triggerEvent(int type)
    {
        gameData.getCurrentCard().getDay(gameData.getCurrentDay()).decreseGamePoint();
    }   
}