/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WoD.engine.Actors;

import com.WoD.engine.Board.Board;
import com.WoD.engine.Board.BoardUtils;
import com.WoD.engine.Board.Cell;
import com.WoD.engine.Board.Move;
import static com.WoD.engine.Board.BoardUtils.isValidCellCoordinate;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Metior
 */
public class Enemy extends Actor{
    
    private static final int[] CANDIDATE_MOVE_COORDINATES = {-11,-10,-9 
                                                             -1,      1, 
                                                              9,  10,11};
    
    Enemy(int initialPosition, int positionCoordinates, int health, int mana, int armor, Actor.status actorStatus){
        super(positionCoordinates, health, mana, armor, actorStatus);
        this.initialPosition = initialPosition;
    }

    @Override
    public List<Move> calculateLegalMoves(Board board) {
        final List<Move> legalMoves = new ArrayList<>();
        
        for(final int currentCandidate : CANDIDATE_MOVE_COORDINATES){
            final int candidateDestinationCoordinate = this.initialPosition + currentCandidate;
            
            if(isValidCellCoordinate(candidateDestinationCoordinate)){
                
                if((isLeftBorderExclusion(this.positionCoordinates, currentCandidate)) ||
                   (isRightBorderExclusion(this.positionCoordinates, currentCandidate))||
                   (isTopBorderExclusion(this.positionCoordinates, currentCandidate))  ||
                   (isBottomBorderExclusion(this.positionCoordinates, currentCandidate))){
                    continue;
                }                
                final Cell candidateDestinationCell = board.getCell(candidateDestinationCoordinate);
                final Actor actorAtDestination = candidateDestinationCell.getActor();
                final status actorDestinationStatus = actorAtDestination.getActorStatus();
                
                if((candidateDestinationCell.isCellOccupied()) && (this.actorStatus != status.NOT_ALIVE)){
                    legalMoves.add(new Move());
                    legalMoves.clear();
                    legalMoves.add(new Move());
                    return ImmutableList.copyOf(legalMoves);
                }else{
                    if(!candidateDestinationCell.isCellOccupied()){
                        legalMoves.add(new Move());
                    }
                }                
            }            
        }        
        return ImmutableList.copyOf(legalMoves);
    }
    private static boolean isLeftBorderExclusion(final int currentPosition, int candidateOffset){
        return BoardUtils.LEFT_BORDER[currentPosition] && (candidateOffset == -11 || candidateOffset == -1 ||
                candidateOffset == 9);
    }
    
    private static boolean isRightBorderExclusion(final int currentPosition, int candidateOffset){
        return BoardUtils.RIGHT_BORDER[currentPosition] && (candidateOffset == -9 || candidateOffset == 1 ||
                candidateOffset == 11);
    }
    
    private static boolean isTopBorderExclusion(final int currentPosition, int candidateOffset){
        return BoardUtils.TOP_BORDER[currentPosition] && (candidateOffset == -11 || candidateOffset == -10 ||
                candidateOffset == -9);
    }
    
    private static boolean isBottomBorderExclusion(final int currentPosition, int candidateOffset){
        return BoardUtils.BOTTOM_BORDER[currentPosition] && (candidateOffset == 9 || candidateOffset == 10 ||
                candidateOffset == 11);
    }
}
