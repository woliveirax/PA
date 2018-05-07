/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege;

import IU.text.IUTexto;
import gameLogic.StateMachine._StateMachine;

/**
 *
 * @author Skully
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IUTexto proj = new IUTexto(new _StateMachine());
        
        proj.run();
    }
}
