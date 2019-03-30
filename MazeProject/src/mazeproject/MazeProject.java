/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazeproject;

import java.util.Scanner;

/**
 *
 * @author DEVON
 */
public class MazeProject
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int rows=5;
        int columns=5;
        char[][] maze=new char[][]{
        {'1','1','1','1','1'},
        {'b','0','1','0','e'},
        {'1','0','1','0','1'},
        {'0','0','0','0','1'},
        {'1','1','1','1','1'}};
        Maze m = new Maze(rows,columns,maze);
        m.solve();     
        
         rows=11;
         columns=11;
       char[][] maze2 = new char[][]
            {
                {'1','1','1','1','1','1','1','1','1','1','1'},
                {'1','0','0','0','0','0','1','0','0','0','1'},
                {'1','0','1','0','0','0','1','0','1','0','1'},
                {'e','0','1','0','0','0','0','0','1','0','1'},
                {'1','0','1','1','1','1','1','0','1','0','1'},
                {'1','0','1','0','1','0','0','0','1','0','1'},      
                {'1','0','0','0','1','0','1','0','0','0','1'},
                {'1','1','1','1','1','0','1','0','0','0','1'},
                {'1','0','1','b','1','0','1','0','0','0','1'},
                {'1','0','0','0','0','0','1','0','0','0','1'},
                {'1','1','1','1','1','1','1','1','1','1','1'},  
            };
        Maze m2 = new Maze(rows,columns,maze2);
        m2.solve();


    }
    
}
