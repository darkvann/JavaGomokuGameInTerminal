import java.util.Scanner;


public class Gomoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("***************Welcome to GomokuGame*****************");
		Board board = new Board();
		// Enter and display the information of two players
		System.out.print("Enter player1 name:");
		String playerName1 = input.next();
		System.out.print("Enter player2 name:");
		String playerName2 = input.next();
		int playerColor1 = (int)(Math.random() * 2);
		int playerColor2 = Math.abs(playerColor1 - 1);
		Player player1 = new Player(playerName1, playerColor1);
		Player player2 = new Player(playerName2, playerColor2);
		System.out.printf("Player1[%s, %s] VS Player2[%s, %s]\n",player1.getName(), Stone.colorToString(player1.getColor()), player2.getName(),Stone.colorToString(player2.getColor()));
		// Play the game by the two players
		while(board.getWinColor()==-1) {
			if(board.getWhichColorToPlay() == player1.getColor()) {
				player1.play(board, input);
				}else {
				player2.play(board, input);
				}
				board.printBoard();
				}
				if(board.getWinColor()==-1) {
				System.out.println("***************Game Draw***************");
				}else if(board.getWinColor()==playerColor1){
				System.out.printf("Player2 %s[%s] won the game", player2.getName(),
				Stone.colorToString(player2.getColor()));
				}else {
				System.out.printf("Player1 %s[%s] won the game", player1.getName(),
				Stone.colorToString(player1.getColor()));
				}
				input.close();
				}	
		

}
