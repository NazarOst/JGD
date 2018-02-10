/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WoD.engine.Board;

import com.WoD.engine.Actors.Actor;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Metior
 */
public abstract class Cell {
    
    protected final int cellCoordinate;
    
    private static final Map<Integer, EmptyCell> EMPTY_CELLS = createAllPossibleEmptyCells();
    
    private static Map<Integer, EmptyCell> createAllPossibleEmptyCells(){
        
        final Map<Integer, EmptyCell> emptyCellMap = new HashMap<>();
        
        for(int i=0; i<100; i++){
            emptyCellMap.put(i, new EmptyCell(i));
        }
                
        return ImmutableMap.copyOf(emptyCellMap);
    }
    
    public static Cell createCell(final int cellCoordinate, final Actor actorOnCell){
        return actorOnCell!= null ? new OccupiedCell(cellCoordinate, actorOnCell) : EMPTY_CELLS.get(cellCoordinate);
    }
    
    private Cell(int cellCoordinate){
        this.cellCoordinate = cellCoordinate;
    }
    
    public abstract boolean isCellOccupied(); 
    
    public abstract Actor getActor();
    
    public static final class EmptyCell extends Cell{

        EmptyCell(final int coordinate){
            super(coordinate);
        }
        @Override
        public boolean isCellOccupied(){
            return false;
        }
        @Override
        public Actor getActor(){
            return null;
        }
    }
    
    
    public static final class OccupiedCell extends Cell{
        
        private final Actor actorOnCell;
        
        OccupiedCell(int cellCoordinate, Actor actorOnCell){
            super(cellCoordinate);
            this.actorOnCell = actorOnCell;
        }
        
        @Override
        public boolean isCellOccupied(){
            return true;
        }
        
        @Override
        public Actor getActor(){
            return this.actorOnCell;
        }
    }
}
