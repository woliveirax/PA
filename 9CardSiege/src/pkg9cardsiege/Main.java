/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege;

import gameLogic.GameData;

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
        
        data.drawCardFromDeck();
        data.drawCardFromDeck();
        
        System.out.println("output - " + data.getCurrentCard().getSpecificDay(data.getCurrentDay()).getEvent());
        System.out.println("\nDRM -> " + data.getDRMSabotage());
        
        
    }
}
