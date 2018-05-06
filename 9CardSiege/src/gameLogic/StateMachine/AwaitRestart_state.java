/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic.StateMachine;

import gameLogic.GameData;

/**
 *
 * @author Olympus
 */
public class AwaitRestart_state extends StateAdapter{
    Boolean ganhou;
    public AwaitRestart_state(GameData gameData, Boolean ganhou) {
        super(gameData);
        this.ganhou = ganhou;
    }

    @Override
    public IStates restart() {
        return new AwaitTopCard_state(new GameData());
    }
    
    
    @Override
    public String toString() {
        String st="(1)Restart game\t(2)Leave\n";
        if(ganhou)
            return "Congrats! (づ｡◕‿‿◕｡)づ You've beaten the system (ง'̀-'́)ง !!\n"+st;
        return "Too bad! \\_( ° _ʖ °)_/ Better luck, next time ʕ•ᴥ•ʔ !" + st;
    }
}
