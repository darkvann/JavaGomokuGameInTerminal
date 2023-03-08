import java.util.Scanner;
public class Player {
	private String name; // The name of the player
	private int color; // The color chosen by the player
	public Player(String name, int color) {
	this.setName(name);
	this.setColor(color);
	}
	// Getter and setter methods for the two attributes name and color
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	public int getColor() {
	return color;
	}
	public void setColor(int color) {
	this.color = color;
	}
	// Enter the position to place the chess piece
	public void play(Board board, Scanner input) {
	System.out.printf("Player %s[%s] put a stone at:", this.getName(),Stone.colorToString(color));
	int row = input.nextInt() - 1;
	int column = input.nextInt() - 1;
	// Call the putAStone method of the class Board to place chess pieces
//	if(board.getWhichColorToPlay()==0)
//	    {board.setWhichColorToPlay(1);
//	    }
//	else
//		{board.setWhichColorToPlay(0);
//		}
	boolean success = board.putAStone(row, column, new Stone(color));
	if(!success) {
	System.out.println("Illegal Input");
	// Re-entering
	}
	}

}
