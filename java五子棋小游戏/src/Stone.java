
public class Stone {
	// The two numbers 0 and 1 are used to indicate white and black
	public final static int WHITE = 0;
	public final static int BLACK = 1;
	private int color=-1;
	public Stone(int color) {
	this.setColor(color);
	}
	public int getColor() {
	return color;
	}
	public void setColor(int color) {
	this.color = color;
	}
	// Sometimes it is necessary to convert color numbers into color terms
	public static String colorToString(int color) {
	return color == WHITE ? "white": "black";
	}
	//The shape information of the stone needs to be obtained when printing the chess board
    public char getShape() {
    return color == WHITE ? '\u25CF': '\u25CB';
    }
  }


