/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WoD.engine.Actors;

import com.WoD.engine.Board.Board;
import com.WoD.engine.Board.Move;
import java.util.List;

/**
 *
 * @author Metior
 */
public class Hero extends Actor {
    
    Hero(int health, int mana, int armor, status actorStatus){
        super(health, mana, armor, actorStatus);
    }
    
    @Override
    public List<Move> calculateLegalMoves(final Board board){
        return null;
    }
    
}
