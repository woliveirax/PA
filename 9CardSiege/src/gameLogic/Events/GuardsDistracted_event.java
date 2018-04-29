/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic.Events;

import gameLogic.GameData;
import java.io.Serializable;

/**
 *
 * @author Skully
 */
public class GuardsDistracted_event extends _Event implements Serializable {
    
    public GuardsDistracted_event(GameData gameData)
    {
        super("Guards Distracted",
                "+1 to sabotage action\n+1 to morale action",
                gameData);
    }

    @Override
    public int getDRMSabotage() {
        return 1;
    }

    @Override
    public int getDRMMorale() {
        return 1;
    }
}
