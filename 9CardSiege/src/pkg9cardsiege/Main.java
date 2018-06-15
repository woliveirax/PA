package pkg9cardsiege;

import GUI.GameFrame;
import IU.text.IUTexto;
import gameLogic.Model.ObservableGame;
import gameLogic.StateMachine._StateMachine;


public class Main {

    public static void main(String[] args) {
        _StateMachine a = new _StateMachine();
        new GameFrame(new ObservableGame(a));
        //IUTexto proj = new IUTexto(a);       
        //proj.run();
    }
}
