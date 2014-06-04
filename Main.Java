package yammy.main;

import java.util.Scanner;

public class Main implements GuessANumberGame {
	boolean replay = false;
	Scanner tKeyboard = new Scanner(System.in);
	String input;
	int Guess;
	int Win,Lose,Tie;

	public static void main(String[] args) {
		Main main = new Main();		
		boolean replay = false;
		while(!main.replay){
			main.Game();
			main.PlayAgian();
		}


	}
	public void Game(){
		System.out.println("Would you like to play Blackjack or with Dice?");
		input = tKeyboard.next();	
		switch(input.toLowerCase()) 
		{
		case"dice":
		{
			System.out.println("Would you like to roll 1 or 2 dice?");
			Guess = tKeyboard.nextInt();
			if(Guess == 1){					
				GuessANumberOne();
				break;
			}
			else if(Guess == 2){		
				GuessANumberTwo();
				break;
			}
			else{
				System.out.println("Not a Choice!");
				Game();
				break;
			}
		}
		case"blackjack":
		{

		}
		}
	}
	public void GuessANumberOne() {
		System.out.println("Guess what number the dice will land on!");
		Guess = tKeyboard.nextInt();

		if(Guess == dice.GetValue()){
			System.out.println("You Win!");
			Win++;
		}
		else{
			System.out.println("You Lose! It was "+dice.GetValue());
			Lose++;
		}
	}

	public void GuessANumberTwo() {
		System.out.println("Guess what number the dice will land on!");
		Guess = tKeyboard.nextInt();

		if(Guess == dDice.GetValue()){
			System.out.println("You Win!");
			Win++;
		}
		else{
			System.out.println("You Lose! They landed on "+dDice.GetValue()+"!");
			Lose++;
		}
	}

	public void PlayAgian()
	{
		System.out.println("Current score is Wins:"+Win+"Loses: "+Lose+"Ties: "+Tie);
		System.out.println("Would you like to play agian?");
		input = tKeyboard.next();

		switch(input.toLowerCase()) 
		{

		case"yes":
		{
			replay=true;

			break;
		}
		case"no":
		{
			replay=false;

			break;
		}
		default:
		{
			System.out.println("Not a choice");						
			PlayAgian();
		}

		}

	}
}
