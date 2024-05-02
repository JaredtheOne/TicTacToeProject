import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	// global Lists
	// array lists of integers for the player and CPU positions
static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
	
	public static void main(String[] args) {

		
		// 2d array, creating a game board
    char [] [] gameboard = {{' ', '|',' ','|',' '},
				{'-', '+','-','+','-'},
				{' ', '|',' ','|',' '},
				{'-', '+','-','+','-'},
				{' ', '|',' ','|',' '}};
    
    	// calling the method which displays the board
		displayTheBoard(gameboard);	
	
		
		
		// creating the game loop for the player 
		// The while loop prevents the user or the player from taking a position thats already taken 
		// The while loop iterates if the program is not complete
	while(true) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your square placement (1-9)");
		int playerPos = scan.nextInt();
		while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)) {
			System.out.println("The position is taken! Enter a different position");
			playerPos = scan.nextInt();
				
		}
		
		
		// calling the method that places the pieces for the player
		placeThePiece(gameboard, playerPos, "player");
		
		String result = checkTheWinner();
		if(result.length() > 0 ) {
			System.out.println(result);
			break;
		}
		
		// creating a game loop for the CPU 
		// The while loop prevents the user or the CPU from taking a position thats already taken 
		// The while loop iterates if the program is not complete
		Random rand = new Random();
		// 9 positions in total, So i add + 1 to loop through all the available positions  
		int cpuPos = rand.nextInt(9) + 1;
		while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
			System.out.println("The position is taken! Enter a different position");
			cpuPos = rand.nextInt(9) + 1;
				
		}
		
		// calling the method that places the pieces for the CPU
		placeThePiece(gameboard, cpuPos, "cpu");
		
		
		// calling the method which displays the board
		displayTheBoard(gameboard);	
			
		// the method that checks for the winner 
		result = checkTheWinner();
		if(result.length() > 0 ) {
			System.out.println(result);
			
			break;
		}
		
		
		}
		
		
	}
	// static method for displaying the board
	public static void displayTheBoard(char[][] gameboard) {
		// this displays/prints out the game board
		for(char[] row: gameboard) {
			for(char c: row) {
				System.out.print(c);
				}
			
			System.out.println();
		}

	}
	
	// static method for placing the piece in the game board
	// In the parameters I passed variables such as game board , position and the user 
	
	public static void placeThePiece(char [][] gameboard , int pos, String user) {
		
		char symbol = 'X';
		
		// The player symbol would be assigned X 
		// The CPUs symbol would be assigned O
		
		if(user.equals("player")) {
			symbol = 'X';
			playerPositions.add(pos);
			
	
		}else if(user.equals("cpu")) {
			symbol = 'O';
			cpuPositions.add(pos);
			
			
		}
		
		
		// A switch statement that will assist in choosing a position in the game board
		// rows and columns [][]
		// 9 cases = 9 positions
		switch(pos) {
		case 1:
			gameboard[0][0] = symbol;
			break;
		
		case 2:
			gameboard[0][2] = symbol;
			break;
		
		case 3:
			gameboard[0][4] = symbol;
			break;
		
		case 4:
			gameboard[2][0] = symbol;
			break;
	
		case 5:
			gameboard[2][2] = symbol;
			break;
			
		case 6:
			gameboard[2][4] = symbol;
			break;
			
		case 7:
			gameboard[4][0] = symbol;
			break;
			
		case 8:
			gameboard[4][2] = symbol;
			break;
				
		case 9:
			gameboard[4][4] = symbol;
			break;
		default:
			break;
				
		}
		
	}
	
	public static String checkTheWinner() {
		// checking the list to see the positions
		// storing all the win positions in a list 
		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List bottomRow = Arrays.asList(7, 8, 9);
		List leftColumn = Arrays.asList(1, 4, 7);
		List midColumn = Arrays.asList(2, 5, 8);
		List rightColumn = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(7, 5, 3);
		
		// A new array list 
		// Adding all the conditions in an array list
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(bottomRow);
		winning.add(leftColumn);
		winning.add(midColumn);
		winning.add(rightColumn);
		winning.add(cross1);
		winning.add(cross2);
		
		// A for loop that will run through the list winning 
		// For each list inside of the winning list
		
		for(List thelist: winning) {
			
			if(playerPositions.containsAll(thelist)) {
				return "Congratulations!! You won";
				
			}else if (cpuPositions.containsAll(thelist)) {
				return "CPU wins";
				
			}else if(playerPositions.size() + cpuPositions.size() == 9){
				return "Its a draw";
				
			}
			
		}
		
		// returning an empty string 
		return "";
		
	}
}


	


