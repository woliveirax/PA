/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege;

import gameLogic.GameData;
import gameLogic.StateMachine._StateMachine;
import gameLogic.Typewriter;
import java.io.IOException;

/**
 *
 * @author Skully
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameData data = new GameData();
        
        //data.endOfDay();
        
        //data.removeTowerFromGame();
//        data.drawCardFromDeck();
//        System.out.println(""+data+"\n\n\n");
//      
    
        
        _StateMachine x = new _StateMachine();
        _StateMachine b = new _StateMachine();
        
//        x.drawCard();
//        System.out.println(""+ x.getGamedata().toString());
//        
//        Typewriter a = new Typewriter();
//        try{
//           a.saveGame(x,"C:\\Users\\Skully\\Desktop\\test2");
//        }catch(IOException e){
//            e.printStackTrace();
//        }
        
        
        
        Typewriter a = new Typewriter();
        try{
           b = a.loadGame("C:\\Users\\Skully\\Desktop\\test2");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //b.drawCard();
        
        System.out.println(""+ b.getGamedata().toString());
//        
//        x.drawCard();
        
    }
}
