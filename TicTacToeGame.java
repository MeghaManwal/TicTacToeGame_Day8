package ticTacToeGame;

import java.util.Scanner;

class TicTacToeGame {
	
	public static String  player;
	public static int playerSymbol;
	public static ArrayList<Integer> playerpositions=new ArrayList<Integer>();
	public static ArrayList<Integer> CPUpositions=new ArrayList<Integer>();
	
	public static void initializeBoard() {
		for (int i=0;i<5;i++) 
		{
			for(int j=0;j<5;j++) 
			{
				board[i][j]='-';
			}
		}
	}
	
	public static void printboard() {
		  for (int i=0; i<5; i++) 
		  {
		    for (int j=0; j<5; j++)
		    {
		     System.out.print(gameboard[i][j]);
		    }
		   System.out.println();
			  }
	}
	
	public static void TicTacToe(){
		  Scanner s = new Scanner(System.in);
		  
		  System.out.println("Enter Your Name : ");
		     player = s.nextLine();
		  System.out.println("Enter the choice for the symbol \n 1 . 'X' \n 2. 'O' \n\t\t : ");
		     playerSymbol = s.nextInt();
		  while(playerSymbol >2 || playerSymbol <=0) {
		     if(playerSymbol == 1 || playerSymbol == 2) {
		       playerSymbol = s.nextInt();
		      }
		      else {
		    	System.out.println("Wrong choice :( \n ");
		    	 System.out.println("Please select \n 1 . 'X' \n 2. 'O' \t : ");
		    	  playerSymbol = s.nextInt();
		       }
		    }
	 }
	
	public static void placepiece(char[][] gameboard, int place, String user) {
		char symbol;
		char cpuSign;
		char userSign;
		
		if(playerSymbol == 1) {
			cpuSign = 'O';
			userSign = 'X';
		} 
	    else {
		    cpuSign = 'X';
			userSign = 'O';
		}
		if(user.equals("cpu")) {
			symbol = cpuSign;
			CPUpositions.add(place);
			System.out.println("\n Cpu placed  at " + place + "\n");
		} 
		else {
			symbol = userSign;
			playerpositions.add(place);
			System.out.println("\n" + user + " Placed at " + place + "\n");
	    }
		
		switch(place) {
			case 1:
				gameboard[0][0]=symbol;
			    break;
			case 2:
				gameboard[0][2]=symbol;
			    break;
			case 3:
				gameboard[0][4]=symbol;
			    break;
			case 4:
				gameboard[2][0]=symbol;
			    break;
			case 5:
				gameboard[2][2]=symbol;
			    break;
			case 6:
				gameboard[2][4]=symbol;
			    break;
			case 7:
				gameboard[4][0]=symbol;
			    break;
			case 8:
				gameboard[4][2]=symbol;
			    break;
			case 9:
				gameboard[4][4]=symbol;
			    break;
		}
   }
	public static void main(String[] args) {
		//Scanner s=new Scanner(System.in);
		
		 char [][] gameboard= {{' ', '|', ' ', '|',' '},
				 				{'+', '-', '+', '-', '+'},
				 				{' ', '|', ' ', '|',' '},
				 				{'+', '-', '+', '-', '+'},
				 				{' ', '|', ' ', '|', ' '}};
		 initializeBoard();
		 printGameBoard(gameboard);
		 TicTacToe();
		 
		 Scanner sc=new Scanner(System.in);
		 
		 System.out.println("Enter the position:(1-9): ");
		 int playerplacement=sc.nextInt();
		 while(playerpositions.contains(playerplacement) || CPUpositions.contains(playerplacement)) {	
		  System.out.println("Position Taken! Enter a correct position");
		  playerplacement=sc.nextInt();
		 }
		 placepiece(gameboard, playerplacement, "Player");
		 printGameBoard(gameboard);
		 
		 int cpuPlacement=(int)Math.floor((Math.random()*10) % 9)+ 1;
		 while(playerpositions.contains(cpuPlacement) || CPUpositions.contains(cpuPlacement)) {
		  System.out.println("Position Taken! Enter a correct position");
		  cpuPlacement=(int)Math.floor((Math.random()*10) % 9)+ 1;			
		 }
		 placepiece(gameboard, cpuPlacement, "cpu");
		 printGameBoard(gameboard);
	}	 	
}

