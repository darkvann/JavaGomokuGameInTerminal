import java.util.Scanner;
public class Board {
	public final static int SIZE = 15;
	private Stone[][] board;
	private int remain; // How many free positions are left
	private int whichColorToPlay;
	private int winColor = -1; // No one win: -1
	// Create and initialize a chess-board
	public Board() {
	board = new Stone[SIZE][SIZE];
	remain = SIZE * SIZE;
	whichColorToPlay = (int)(Math.random() * 2);
	for(int i=0;i<SIZE;i++){
		for(int j=0;j<SIZE;j++){
			board[i][j]=new Stone(43);
		}
	}
	}
	
	// Display the chess-board
	public void printBoard() {
		for(int i=0;i<SIZE;i++){
			for(int j=0;j<SIZE;j++){
				if(board[i][j].getColor()!=0&&board[i][j].getColor()!=1)
				System.out.print( (char)(board[i][j].getColor()));
				else
				System.out.print((char)(board[i][j].getShape()));
			}
			System.out.println();
		}
	}
	// Put a piece at position (row, column) on the chess-board
	public boolean putAStone(int row, int column, Stone stone) {
	if(remain==0||winColor!=-1||board[row][column]==stone||row>SIZE||column>SIZE) {
	return false;
	}else {
	board[row][column] = stone;
	remain--;
	whichColorToPlay = stone.getColor() == Stone.WHITE ? Stone.BLACK:Stone.WHITE;
	if(stone.getColor()==0)
		stone.setColor(1);
		else
			stone.setColor(0);
	winColor = judge(row, column);
	return true;
	}
	}
	// Determine whether changes in the position (row, column) of the board will affect the game result
	
	public int judge(int row, int column) {
	// The kernel used for judging: "11111" or "00000"
	String kernel = new String(new char[5]).replace("\0",
	String.valueOf(board[row][column].getColor()));
	// Determine whether there are five consecutive colored stones in the horizontal direction
	
	StringBuffer lineX = new StringBuffer();
	for(int i = 0; i < SIZE; i++) {
	if(board[row][i].getColor() != -1) {
	lineX.append(board[row][i].getColor());
	}else {
	lineX.append("N");
	}
	}
	if(lineX.indexOf(kernel) >= 0){
		int flag=0;
		for(int a=lineX.indexOf(kernel);a<SIZE;a++){
			if(flag==5){return board[row][column].getColor();}
		    else if(board[row][a].getColor()==board[row][column].getColor()){
				flag+=1;
			}else{
				flag=0;
			}
		}
	}
	// Determine whether there are five consecutive colors of stones in the vertical direction
	
	StringBuffer lineY = new StringBuffer();
	for(int i = 0; i < SIZE; i++) {
		if(board[i][column].getColor() != -1) {
		lineY.append(board[i][column].getColor());
		}else {
		lineY.append("N");
		}
		}
	/*...*/
	if(lineY.indexOf(kernel) >= 0){
		int flag=0;
		for(int b=0;b<SIZE;b++){
			if(flag==5){
				return board[row][column].getColor();
			}
		    else if(board[b][column].getColor()==board[row][column].getColor()){
				flag+=1;
			}else{
				flag=0;
			}
		}
	}
	// Determine whether there are five consecutive colors of stones in the main diagonal direction
	
	StringBuffer lineDiagA = new StringBuffer();
//		if(row>column){
//			for(int i=row-column,j=0;i<SIZE;i++,j++)
//				if(board[i][j].getColor()!=-1){
//					lineDiagA.append(board[row-column+i][i].getColor());
//				}else{
//					lineDiagA.append("N");
//				}
//		}else{
//			for(int i=0;i<SIZE-(column-row);i++)
//				if(board[i][column-row+i].getColor()!=-1){
//					lineDiagA.append(board[i][column-row+i].getColor());
//				}else{
//					lineDiagA.append("N");
//				}
//		}

	/*...*/
	if(true){
		int flag=0;
		if(row>column){
		for(int i=row-column,j=0;i<SIZE;i++,j++){
			if(flag==5){return board[row][column].getColor();}
		    else if(board[i][j].getColor()==board[row][column].getColor()){
				flag+=1;
			}else{
				flag=0;
			}
		}
		}else{
			for(int j=column-row,i=0;j<SIZE;i++,j++){
				if(flag==5){return board[row][column].getColor();}
			    else if(board[i][j].getColor()==board[row][column].getColor()){
					flag+=1;
				}else{
					flag=0;
				}
			}
		}
	
	}
	// Determine whether there are five consecutive colors of stones in the back diagonal direction
	
	StringBuffer lineDiagB = new StringBuffer();
//	if(row>(SIZE-column)){
//		for(int i=0;i<SIZE-(row-(SIZE-column));i++)
//			if(board[row-(SIZE-column)+i][SIZE-i].getColor()!=-1){
//				lineDiagA.append(board[row-(SIZE-column)+i][SIZE-i].getColor());
//			}else{
//				lineDiagA.append("N");
//			}
//	}else{
//		for(int i=0;i<(column+row);i++)
//			if(board[i][column+row-i].getColor()!=-1){
//				lineDiagA.append(board[i][column+row-i].getColor());
//			}else{
//				lineDiagA.append("N");
//			}
//	}
	/*...*/
	if(true){
		int flag=0;
		if(row>(SIZE-column)){
		    for(int j=row+column-SIZE+1,i=SIZE-1;j<SIZE;i--,j++){
			    if(flag==5){return board[row][column].getColor();}
		        else if(board[i][j].getColor()==board[row][column].getColor()){
				    flag+=1;
			    }else{
				    flag=0;
			    }
		    }
		}else{
			for(int i=row+column,j=0;i>=0;j++,i--){
				    if(flag==5){return board[row][column].getColor();}
			        else if(board[i][j].getColor()==board[row][column].getColor()){
					    flag+=1;
				    }else{
					    flag=0;
				    }
			}
		}
	}
	// There are no consecutive stones of the same color
	return -1;
	}
	 /* Getter and setter methods for data fields*/
	public int getRemain() {
	return remain;
	}
	public void setRemain(int remain) {
	this.remain = remain;
	}
	public int getWhichColorToPlay() {
	return whichColorToPlay;
	}
	public void setWhichColorToPlay(int whichColorToPlay) {
	this.whichColorToPlay = whichColorToPlay;
	}
	public int getWinColor() {
	return winColor;
	}
	public void setWinColor(int winColor) {
	this.winColor = winColor;
	}

}
