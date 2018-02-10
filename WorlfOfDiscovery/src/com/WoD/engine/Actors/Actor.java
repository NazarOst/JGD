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
public abstract class Actor {
    private int health;
    private int mana;
    private int armor;
    protected int positionCoordinates;
    protected int initialPosition;
    protected status actorStatus;
    public enum status {RED, YELLOW, GREEN, NOT_ALIVE}
    
    Actor(int positionCoordinates , int health, int mana, int armor, status actorStatus){
        this.health = health;
        this.mana = mana;
        this.armor = armor;
        this.actorStatus = actorStatus;
    }
    
    public int getActorHealth(){
        return this.health;
    }
    
    public int getActorMana(){
        return this.mana;
    }
    
    public int getActorArmor(){
        return this.armor;
    }
    
    public status getActorStatus(){
        return this.actorStatus;
    }
    
    public abstract List<Move> calculateLegalMoves(final Board board);    
}
