package com.nimgame.main;

import java.util.Scanner;

/*
 * This is the Main class demonstrate all the controls for 
 * managing game playing process like get player1 and player2 input and implementation logic 
 * Mohammed Atiq Mohammed Mashaq Shaikh 29/03/2017
 * */

public class Nimsys {

	public static void main(String args[]){
		
		String player1Input=null, player2Input=null, player1=null, player2=null;
		int upperBoundInput=0, stoneLeftInput=0, upperBound=0, stoneLeft=0;
		
		Scanner scanner = new Scanner(System.in);
		NimPlayer nimPlayer=new NimPlayer();
		Nimsys nimSys=new Nimsys();
		
		System.out.println("Welcome to Nim");
		System.out.println();
		
		player1=nimSys.getPlayer1Input(scanner,nimPlayer,player1,player1Input);

		player2=nimSys.getPlayer2Input(scanner,nimPlayer,player2,player2Input);

		upperBound=nimSys.getUpperBoundInput(scanner,nimPlayer,upperBound,upperBoundInput);

		stoneLeft=nimSys.getInitialMovesInput(scanner,nimPlayer,stoneLeft,stoneLeftInput);

		nimSys.play(scanner,nimPlayer,player1,player2,upperBound,stoneLeft);
		
		
		
	} //end of main
	
	//method to get player1 name as input 
	private String getPlayer1Input(Scanner scanner, NimPlayer nimPlayer, String player1, String player1Input) {
		// TODO Auto-generated method stub
		System.out.println("Please enter Player 1's name:");
		player1Input = scanner.next();
		nimPlayer.setPlayer1(player1Input);
		player1 = nimPlayer.getPlayer1();
		System.out.print("\n");
		return player1Input;		
	}
	
	//method to get player2 name as input
	private String getPlayer2Input(Scanner scanner, NimPlayer nimPlayer, String player2, String player2Input) {
		// TODO Auto-generated method stub
		System.out.println("Please enter Player 2's name:");
		player2Input = scanner.next();
		nimPlayer.setPlayer2(player2Input);
		player2 = nimPlayer.getPlayer2();
		System.out.println();
		return player2Input;
	}

	//method to get upper bound name as input
	private int getUpperBoundInput(Scanner scanner, NimPlayer nimPlayer, int upperBound, int upperBoundInput) {
		// TODO Auto-generated method stub
		System.out.println("Please enter upper bound of stone removal:");
		upperBoundInput = scanner.nextInt();
		nimPlayer.setUpperBound(upperBoundInput);
		System.out.println();
		return upperBound = nimPlayer.getUpperBound();
	}
	
	//method to get initial moves as input
	private int getInitialMovesInput(Scanner scanner, NimPlayer nimPlayer, int stoneLeft, int stoneLeftInput) {
		// TODO Auto-generated method stub
		System.out.println("Please enter initial number of stones:");
		stoneLeftInput = scanner.nextInt();
		nimPlayer.setStoneLeft(stoneLeftInput);
		return stoneLeft = nimPlayer.getStoneLeft();
	}
	
	//method that implement actual play logic
	private void play(Scanner scanner, NimPlayer nimPlayer, String player1, String player2, int upperBound, int stoneLeft) {
		// TODO Auto-generated method stub
		Nimsys nimSys =new Nimsys();
		int removeStone;
		boolean flag=true;
		
		while(stoneLeft>0){
			
			//Check for player turn
			if(flag==true){
				System.out.println();
				System.out.print(stoneLeft +" stones left:");
					for(int i=0;i<stoneLeft;i++)
						System.out.print(" *"); //Print stone by iterating no of stones available
					System.out.println();
				
				System.out.println(player1+"'s turn - remove how many?");
				removeStone = scanner.nextInt();
				
				//Check whether the stone is available or not and upper bound of stone removal from input provided
				if(removeStone <= upperBound && removeStone > 0){
					stoneLeft = nimPlayer.removeStone(removeStone, stoneLeft);
				}
				
				//check whether stone left is equal to 0 to declare the winner
				if(stoneLeft==0){
						System.out.println();
						System.out.println("Game Over");
						System.out.println(player2+" wins!");
						System.out.println();
						String playAgain;
						System.out.print("Do you want to play again (Y/N):");	
						playAgain = scanner.next();
						
						//Check with Y-Yes and N-No
						if(playAgain.equals("N")){
							System.exit(0);
						}
						else
						{  
							System.out.println();
							int upperBoundInput=0,stoneLeftInput=0;
							int newUpperBound = nimSys.getUpperBoundInput(scanner, nimPlayer, upperBound, upperBoundInput);
							int newStoneLeft = nimSys.getInitialMovesInput(scanner, nimPlayer, stoneLeft, stoneLeftInput);
							play(scanner,nimPlayer,player1,player2,newUpperBound,newStoneLeft); //call play method if player wishes to play again
						}
					}
			flag=false;
			}
			else{
				System.out.println();
				System.out.print(stoneLeft +" stones left:");
				for(int i=0;i<stoneLeft;i++)
					System.out.print(" *");
				System.out.println();
				
				System.out.println(player2+"'s turn - remove how many?");
				removeStone = scanner.nextInt();
				
				//Check whether the stone is available or not and upper bound of stone removal from input provided
				if(removeStone <= upperBound && removeStone > 0){
					stoneLeft = nimPlayer.removeStone(removeStone, stoneLeft);
				}
				
				//check whether stone left is equal to 0 to declare the winner
				if(stoneLeft==0){
					System.out.println();
					System.out.println("Game Over");
					System.out.println(player1+" wins!");
					System.out.println();
					String playAgain;
					System.out.print("Do you want to play again (Y/N):");	
					playAgain = scanner.next();

					
					//Check with Y-Yes and N-No
					if(playAgain.equals("N")){
						System.exit(0);
					}
					else
					{  
						System.out.println();
						int upperBoundInput=0,stoneLeftInput=0;
						int newUpperBound = nimSys.getUpperBoundInput(scanner, nimPlayer, upperBound, upperBoundInput);
						int newStoneLeft = nimSys.getInitialMovesInput(scanner, nimPlayer, stoneLeft, stoneLeftInput);
						play(scanner,nimPlayer,player1,player2,newUpperBound,newStoneLeft); //call play method if player wishes to play again
					}
				}
			flag=true;
			}
		} //end of while
	}//end of play method


}