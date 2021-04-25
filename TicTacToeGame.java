package ticTacToeGame;

import java.util.Scanner;

class TicTacToeGame {
	
	private static char  [][] board;
	private static char  PlayerMark;
	
	
	public static void initializeBoard() {
		for (int i=0;i<3;i++) 
		{
			for(int j=0;j<3;j++) 
			{
				board[i][j]='-';
			}
		}
	}
	
	public static void choice() {
	     Scanner s=new Scanner(System.in);
	     System.out.println(" Enter 1 to choose X\n Enter 2 to choose O");

		 int n=s.nextInt();
		     if( n==1)
		       System.out.println(" The Player choose X");
		     else
		       System.out.println(" The Player choose O");
		  }
	
	public static void printboard() {
		 System.out.print("--------------\n");
		
		  for (int i=0; i<3; i++) {
			System.out.print("|");
			for (int j=0; j<3; j++) {
				System.out.print(board[i][j] + "|");
			}
			System.out.println();
			System.out.println("--------------");
		  }
	}
	
	public static void main(String[] args) {
	     board = new char[3][3];
		 initializeBoard ();
		 
	     System.out.println("Welcome to TicTacToe Game");
		 choice ();
		 printboard();
	}
}

