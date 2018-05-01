package gameLogic.StateMachine;

import gameLogic.GameData;

public interface IStates{
    IStates start(GameData gameData);
    IStates restart(GameData gameData);
    IStates exit(GameData gameData);
    IStates endOfTurn(GameData gameData);
    IStates drawCard(GameData gameData);
    IStates endOfGame(GameData gameData);
    IStates endOfAction(GameData gameData);
    IStates archerAttack(GameData gameData);
    IStates extraAction(GameData gameData);
    IStates Rally(GameData gameData);
    IStates ExtraMoral(GameData gameData);
    IStates BoilingWater(GameData gameData);
    IStates CloseCombat1(GameData gameData);
    IStates CloseCombat2(GameData gameData);
    IStates Coupure(GameData gameData);
    IStates Sabotage(GameData gameData);
    IStates Raid(GameData gameData);
    IStates EnterTunnel(GameData gameData);
    IStates MoveForward(GameData gameData);
    IStates MoveBackward(GameData gameData);
    IStates FastTravelEnLine(GameData gameData);
}
