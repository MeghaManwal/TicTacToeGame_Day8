package ticTacToeGame;

import java.util.Scanner;

class TicTacToeGame {
	
	public static int player1Symbol;
	public static ArrayList<Integer> playerpositions=new ArrayList<Integer>();
	public static ArrayList<Integer> CPUpositions=new ArrayList<Integer>();
	public static String  player1;
	public static String  player2;
	
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
	    System.out.println("Enter Your Name Player1 : ");
	     	 player1 = s.nextLine();
		System.out.println("Enter Your Name Player2 : ");
		     player2 = s.nextLine();
	    System.out.println("Enter the choice for the symbol Player 1 \n 1 . 'X' \n 2. 'O' \n\t\t : ");
	      player1Symbol = s.nextInt();
	    while(player1Symbol >2 || player1Symbol <=0) {
	    	 if(player1Symbol == 1 || player1Symbol == 2) {
	    		  player1Symbol = s.nextInt();
	    	 }
	    	 else {
	    		 System.out.println("Wrong choice :( \n ");
	    		 System.out.println("Please select \n 1 . 'X' \n 2. 'O' \t : ");
	    		 player1Symbol = s.nextInt();
	    	 }
	     }
      }

	
	  public static void placepiece(char[][] gameboard, int place, String user) {
		char symbol;
		char Player2Sign;
		char Player1Sign;
		
		if(player1Symbol == 1) {
			Player2Sign = 'O';
			Player1Sign = 'X';
		} 
	    else {
	    	Player2Sign = 'X';
	    	Player1Sign = 'O';
		}
		
		
		if(user.equals(player2)) {
			symbol = Player2Sign;
			player2positions.add(place);
			System.out.println("\n"+ player2 +" placed  at " + place + "\n");
		} 
		else {
			symbol = Player1Sign;
			player1positions.add(place);
			System.out.println("\n" + player1 + " placed at " + place + "\n");
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

	
	 public static String checkWinner() {
			
			List <List<Integer>> win=new ArrayList<List<Integer>>();
			win.add(Arrays.asList(1,2,3));
			win.add(Arrays.asList(4,5,6));
			win.add(Arrays.asList(7,8,9));
			win.add(Arrays.asList(1,4,7));
			win.add(Arrays.asList(2,5,8));
			win.add(Arrays.asList(3,6,9));
			win.add(Arrays.asList(1,5,9));
			win.add(Arrays.asList(3,5,7));
			
			for(List<Integer>l : win) {
				if (playerpositions.containsAll(l)) {
					return "Congratulation! You Won";
				}
				else if (CPUpositions.containsAll(l)) {
					return "CPU wins! Sorry ";
				}
				else if(playerpositions.size() + CPUpositions.size() == 9) {
					return "It's a Draw!";
				}
			 }
			return "";
	   }

	   public static void main(String[] args) {
		
		 char [][] gameboard= {{' ', '|', ' ', '|',' '},
				 				{'+', '-', '+', '-', '+'},
				 				{' ', '|', ' ', '|',' '},
				 				{'+', '-', '+', '-', '+'},
				 				{' ', '|', ' ', '|', ' '}};
		 initializeBoard();
		 printGameBoard(gameboard);
		 TicTacToe();
		 
		 while(true) {
		 Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter the position:(1-9): ");
			int player1placement=sc.nextInt();
			while(player1positions.contains(player1placement) || player2positions.contains(player1placement)) {	
				System.out.println("Position Taken! Enter a correct position");
				player1placement=sc.nextInt();
			 }
				String result=checkWinner();
				if(result.length() > 0) {
					System.out.println(result);
					break;
			     }
				placepiece(gameboard, player1placement, player1);
				printGameBoard(gameboard);
				result=checkWinner();
				if(result.length() > 0) {
					System.out.println(result);
					break;
				}
					
			System.out.println("Enter the position:(1-9): ");	
			int player2placement=sc.nextInt();
			while(player1positions.contains(player2placement) || player2positions.contains(player2placement)) {
				System.out.println("Position Taken! Enter a correct position");	
				player2placement=sc.nextInt();
		    }
				result=checkWinner();
				if(result.length() > 0) {
					System.out.println(result);
					break;
				 }
				placepiece(gameboard, player2placement, player2);
				printGameBoard(gameboard);
				result=checkWinner();
				if(result.length() > 0) {
				   System.out.println(result);
				   break;
				 }
		   }
	  }	 	
}

