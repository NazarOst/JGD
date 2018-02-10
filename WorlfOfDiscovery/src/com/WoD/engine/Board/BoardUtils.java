/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WoD.engine.Board;

/**
 *
 * @author Metior
 */
public class BoardUtils {

    public static boolean[] LEFT_BORDER;
    public static boolean[] RIGHT_BORDER;
    public static boolean[] TOP_BORDER;
    public static boolean[] BOTTOM_BORDER;
    
    private BoardUtils(){
        throw new RuntimeException("You cannot instantiate  me!");
    }
    
    public static boolean isValidCellCoordinate(int coordinate){
        return (coordinate >= 0) && (coordinate <100);
    }    
}
