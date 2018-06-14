package pkg9cardsiege;

import IU.text.IUTexto;
import gameLogic.StateMachine._StateMachine;


public class Main {

    public static void main(String[] args) {
        IUTexto proj = new IUTexto(new _StateMachine());
        
        proj.run();
    }
}
