import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) throws InterruptedException {
		boolean stillPlaying = true;
		
		while (stillPlaying){
			String player1, player2;
			System.out.println("************************");
			System.out.println("*  Pots of Gold Coins  *");
			System.out.println("************************\n");
			Thread.sleep(2000);
			System.out.println("Rules:");
			System.out.println("- There are 20 pots full of gold coins.");
			Thread.sleep(2500);
			System.out.println("- Each player can pick either a pot of coins "
							+ "\n  from the FRONT or from the BACK during their turn.");
			Thread.sleep(4500);
			System.out.println("- Try to get the most gold coins.\n");
			Thread.sleep(1000);
			
			Scanner scn = new Scanner(System.in);
			System.out.println("Player 1, enter your name: ");
			player1 = scn.nextLine();
			System.out.println("Player 2, enter your name: ");
			player2 = scn.nextLine();
			
			System.out.println("\n"+player1+" vs "+player2);
			Thread.sleep(1000);
			System.out.println("Game begins in ... ");
			System.out.println("3");
			Thread.sleep(1000);
			System.out.println("2");
			Thread.sleep(1000);
			System.out.println("1");
			
			
			Thread.sleep(1000);
			System.out.println("Start!\n");
			
			int[] pot = new int[20];
			Random rng = new Random();
			for(int i=0; i<20; i++){
				pot[i]= rng.nextInt(9)+1;
			}
			
			int front = 0;
			int back = 19;
			
			int sum1 = 0;
			int sum2 = 0;
			String userInput;
			
			
			//Assumptions:
			//There are an even number of pots such that player1 and player 2
			//both get an equal number of pots (to be fair)
			int playerTurn = 0;
			
			while ((back-front)>0){
				
				
				if (playerTurn==0){
					System.out.println("\n****"+player1+"'s turn.****");
					printSums(sum1,sum2);
					printCurrent(front, back, pot);
					System.out.println("What pot will you pick? (front/back)");
					userInput = scn.nextLine();
					boolean validInput = false;
					while (!validInput){
						if(userInput.equalsIgnoreCase("front")){
							sum1 += pot[front];
							front++;
							validInput = true;
						}
						else if (userInput.equalsIgnoreCase("back")){
							sum1 += pot[back];
							back--;
							validInput = true;
						}
						else {
							System.out.println("Not a valid input. What pot will you pick? (front/back)");
							userInput = scn.nextLine();
						}
					}
				}
				else {
					System.out.println("\n****"+player2+"'s turn.****");
					printSums(sum1,sum2);
					printCurrent(front, back, pot);
					System.out.println("What pot will you pick? (front/back)");
					userInput = scn.nextLine();
					boolean validInput = false;
					while (!validInput){
						if(userInput.equalsIgnoreCase("front")){
							sum2 += pot[front];
							front++;
							validInput = true;
						}
						else if (userInput.equalsIgnoreCase("back")){
							sum2 += pot[back];
							back--;
							validInput = true;
						}
						else {
							System.out.println("Not a valid input. What pot will you pick? (front/back)");
							userInput = scn.nextLine();
						}
					}
				}
				playerTurn++;
				playerTurn%=2;
				//System.out.println("player turn = "+playerTurn);
				
				
			}
			//Only one pot remains. This pot goes to player2 since player1 went first.
			Thread.sleep(1000);
			System.out.println("\nOnly one pot remains...\n");
			Thread.sleep(1000);
			System.out.println("Player 2 gets the remain pot of gold. "+"["+pot[front+1]+"]");
			sum2 += pot[front+1];
			
			System.out.println("\nFinal scores:\tPlayer1("+sum1+")"+"\tPlayer2("+sum2+")");
			Thread.sleep(1000);
			System.out.print("and the winner is ");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".\n");
			if (sum1>sum2)
				System.out.println(player1+"!!");
			else if (sum2>sum1)
				System.out.println(player2+"!!");
			else 
				System.out.println("A tie!!");
			
			
			Thread.sleep(2000);
			System.out.println("Thanks for playing. Play Again? (Y/N))");
			userInput= scn.nextLine();
			if (userInput.equalsIgnoreCase("y"))
				stillPlaying=true;
			else if(userInput.equalsIgnoreCase("n"))
				stillPlaying=false;
			else {
				System.out.println("Invalid input. Game will end.");
				stillPlaying=false;
			}
			scn.close();
		}
		
	}
	
	public static void printCurrent(int front, int back, int[] pot){
		System.out.print("Current pots: ");
		for (int i = front; i <= back; i++){
			System.out.print("["+pot[i]+"]");
		}
		System.out.println();
	}
	
	public static void printSums(int sum1, int sum2){
		System.out.println("Current score:\tPlayer1("+sum1+")"+"\tPlayer2("+sum2+")");
	}
	
}
