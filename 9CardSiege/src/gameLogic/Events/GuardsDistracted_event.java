package gameLogic.Events;

import gameLogic.GameData;
import java.io.Serializable;


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
