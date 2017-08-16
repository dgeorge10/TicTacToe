package com.company;

/**
 * Created by dennisgeorge on 6/28/17.
 */
import java.util.Scanner;

public class Board {

    private char[][] gameboard;
    public char winner = ' ';
    public boolean gameRunning = true;  //dont like this
    public Board()
    {
        gameboard = new char[3][3];

        for(int row=0; row<gameboard.length; row++)      //fills "board" with empty spaces
            for(int col=0; col<gameboard.length; col++)
                gameboard[row][col]=' ';

    }
    public void displayBoard()
    {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++)
        {
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
                System.out.print(gameboard[i][j] + " | ");
            System.out.println();
            System.out.println("-------------");
        }
    }
    public void displayStartBoard()
    {
        System.out.println("-------------------");
        for (int i = 0; i < 3; i++)
        {
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
                System.out.print((i+1) +"," +(j+1) + " | ");
            System.out.println();
            System.out.println("-------------------");
        }
    }
    public void displayRemainingBoard()
    {
        System.out.println("-------------------");
        for (int i = 0; i < 3; i++)
        {
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
            {  if(gameboard[i][j] == ' ' )
                System.out.print((i+1) +"," +(j+1) + " | ");
            else
                System.out.print("    | ");
            }
            System.out.println();
            System.out.println("-------------------");
        }
    }
    private boolean makeMove(char player, int row, int col)//askPlayer() helper method
    {
        if(row >=0 && row <=2 && col>=0 && col <=2)
        {
            if(gameboard[row][col] != ' ')      //checks if the spot is empty
                return false;
            else
            {
                gameboard[row][col]=player;     //if its empty, change the spot to the player
                return true;
            }
        }
        else
            return false;
    }
    public void askPlayer(char player)
    {
        Scanner in = new Scanner(System.in);
        int row, col;
        System.out.print("Player " + player +" please enter a row(1-3): ");
        row = in.nextInt();
        System.out.print("Player " + player + " please enter a col(1-3): ");
        col = in.nextInt();
        while(inValid(row,col))
        {
            System.out.println("Invalid input. Re-enter: ");
            System.out.print("Player " + player +" please enter a row(1-3): ");
            row = in.nextInt();
            System.out.print("Player " + player + " please enter a col(1-3): ");
            col = in.nextInt();
        }
        makeMove(player, row-1, col-1);//-1 because the player doesn't count 0 indexed
    }
    private boolean inValid(int row, int col)//ask player helper method, input validation
    {
        if(row>3||row<1||col>3||col<1 || !isEmpty(row,col))
            return true;
        else
            return false;
    }

    private boolean isEmpty(int row, int col)   //helper method for inValid, checks if slot is empty
    {
        if(gameboard[row-1][col-1] == ' ')
            return true;
        else
        {
            System.out.println("That spot has already been taken.");
            return false;
        }
    }

    public boolean checkWinner()
    {
        for(int row=0; row<gameboard.length; row++)  //checks rows
        {
            if(gameboard[row][0] == gameboard[row][1] && gameboard[row][1] == gameboard[row][2]
                    && gameboard[row][0]!=' ')
            {
                // System.out.print("The winner is Player " + gameboard[row][0]);
                winner=gameboard[row][0];
                gameRunning=false;
                return true;
            }
        }
        for(int col=0; col<gameboard.length; col++)  //check cols
        {
            if(gameboard[0][col] == gameboard[1][col] && gameboard[1][col] == gameboard[2][col]
                    && gameboard[0][col]!=' ')
            {
                //System.out.print("The winner is Player " + gameboard[0][col]);
                winner=gameboard[0][col];
                gameRunning=false;
                return true;
            }
        }
        if(gameboard[0][0]==gameboard[1][1]&& gameboard[1][1] == gameboard[2][2] //checks crosses
                && gameboard[0][0] != ' ')
        {
            //   System.out.print("The winner is Player " + gameboard[1][1]);
            winner = gameboard[1][1];
            gameRunning=false;
            return true;
        }
        if(gameboard[0][2]==gameboard[1][1]&& gameboard[1][1] == gameboard[2][0] //checks crosses
                && gameboard[0][2] != ' ')
        {
            //   System.out.print("The winner is Player " + gameboard[1][1]);
            winner = gameboard[1][1];
            gameRunning=false;
            return true;
        }
        return false;
    }


}