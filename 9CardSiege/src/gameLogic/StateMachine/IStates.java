package gameLogic.StateMachine;

import gameLogic.GameData;

public interface IStates{
    //IStates start();
    IStates restart();
    //IStates exit();
    IStates drawCard();
    IStates endOfTurn();
    IStates endOfGame();
    IStates endOfAction();
    IStates archerAttack();
    IStates extraAction();
    IStates rally();
    IStates extraMoral();
    IStates boilingWater();
    IStates closeCombat1();
    IStates closeCombat2();
    IStates coupure();
    IStates sabotage();
    IStates raid();
    IStates enterTunnel();
    IStates moveForward();
    IStates moveBackward();
    IStates fastTravel();
}
