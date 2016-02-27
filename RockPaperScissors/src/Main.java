/*
 * Git Homework
 * Team Members
 * Christine Gallarin
 * Amanda McCarty
 * Nicholas Merrell
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	static int scorePlayer, scoreCpu, choice;
	static Scanner in = new Scanner(System.in);
	
	public static void main (String[] args)
	{
		
		
		while (true)
		{
			choice = MainMenu();
			//handle wrong input possibility
			if (choice == 1 || choice == 2 || choice == 3)
			{
				switch (choice)
				{
				case 1: OneOfOne();
				break;
				case 2: Scores();
				break;
				case 3: ExitMessage();
				break;
				default: System.exit(0);
				break;
				}
			}
			else{
				System.out.println("Invalid choice. Try again");
			}
		}
	}
	

	private static void OneOfOne() {
		int move1, move2;
		int result;
		try{
			System.out.println("\n[1] Rock\t[2] Paper\t[3] Scissors");
			System.out.print("Which move do you choose? : ");
			move1 = in.nextInt();				// player's move choice
			
			if (move1 == 1 || move1 == 2 || move1 == 3){
				move2 = RandomMoveGenerator();		// computer's move choice

				System.out.println("Your opponent chose " +PrintMove(move2)+ "! ");

				result = CompareMoves(move1, move2);			// compare moves	

				if (result == 0)
					System.out.println("It's a draw.\n");
				else if (result == 1)
					System.out.println("You win!\n");
				else if (result == 2)
					System.out.println("You lost!\n");
			}
			else{
				System.out.println("Invalid move");
			}
		
		}
		catch (InputMismatchException e){
			System.out.println("Invalid move");
			in.nextLine();
		}
	}
	
	private static int CompareMoves(int playerMove, int cpuMove) {
		int outcome = 0;
		
		//player chose ROCK
		if (playerMove == 1) 
		{
			//cpu chose PAPER
			if (cpuMove == 2)
			{
				scoreCpu++;
				outcome = 2;
			}
			//cpu chose SCISSORS
			else if (cpuMove == 3)
			{
				scorePlayer++;
				outcome = 1;
			}
		}
		//player chose PAPER
		if (playerMove == 2)
		{
			//cpu chose SCISSORS
			if (cpuMove == 3)
			{
				scoreCpu++;
				outcome = 2;
			}
			//cpu chose ROCK
			else if (cpuMove == 1)
			{
				scorePlayer++;
				outcome = 1;
			}
		}
		//player chose SCISSORS
		if (playerMove == 3)
		{
			//cpu chose ROCK
			if (cpuMove == 1)
			{
				scoreCpu++;
				outcome = 2;
			}
			//cpu chose PAPER
			else if (cpuMove == 2)
			{
				scorePlayer++;
				outcome = 1;
			}
		}
		
		//outcome returns 0 (draw), 1 (you win), or 2 (cpu win)
		return outcome;
	}
	
	private static String PrintMove(int move)
	{
		String moveText = null;
		
		if (move == 1)
			moveText = "Rock";
		else if (move == 2)
			moveText = "Paper";
		else if (move == 3)
			moveText = "Scissors";
		
		return moveText;
	}

	//generates a random move: 1, 2, or 3
	private static int RandomMoveGenerator() {
		int randomMove = (int) Math.floor(Math.random() * (3-1 + 1)) + 1;
		return randomMove;
	}

	public static int MainMenu()
	{
		int decision = 0;
		try {
			System.out.println("Welcome to Rock Paper Scissors Bananza!\n\nWhat would you like to do?");
			System.out.println("[1] Best 1 out of 1");
			System.out.println("[2] View current scores");
			System.out.println("[3] Exit game\n");
			
			System.out.print("Enter choice here: ");
			decision = in.nextInt();
		}
		catch (InputMismatchException e){
			in.nextLine();
		}
		return decision;
	}
	
	private static void Scores() {
		System.out.println("Your score: " +scorePlayer);
		System.out.println("Computer score: " +scoreCpu+ "\n");
		
	}
	
	private static void ExitMessage() {
		System.out.println("Thanks for playing! :D");
		System.exit(0);
		
	}
}