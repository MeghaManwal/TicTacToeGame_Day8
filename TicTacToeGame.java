package ticTacToeGame;

class TicTacToeGame {
	
	private static char  [][] board;
	private static char  PlayerMark;
	
	
	public static void initializeBoard() {
		for (int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j]='-';
			}
		}
	}
	public static void main(String[] args) {
		board = new char[3][3];
		 initializeBoard ();
		 
		 System.out.println("Welcome to TicTacToe Game");
	}
}

