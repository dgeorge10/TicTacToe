package com.company;
public class Main {

    public static void main(String[] args) {
        Board game = new Board();
        int c = 1;//to tell which players turn it is
        System.out.println("Welcome!! Select your spot(row,col)");
        game.displayStartBoard();
        while(game.gameRunning && c< 10)
        {
            if(c % 2 ==0)
                game.askPlayer('O');
            else
                game.askPlayer('X');

            System.out.println("\n");
            game.displayRemainingBoard();
            game.displayBoard();
            if(game.checkWinner())
                break;
            c++;
        }
        // System.out.println(game.winner);
        if(game.winner == 'X')
            System.out.println("Player X Wins!");
        else if(game.winner == 'O')
            System.out.println("Player O Wins!");
        else
            System.out.println("Tie!");

    }
}
