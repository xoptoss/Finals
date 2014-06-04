package yammy.main;

import java.util.Arrays;
import java.util.Scanner;

public class Main implements GuessANumberGame , BlackJack {
	boolean replay = false;
	Scanner tKeyboard = new Scanner(System.in);
	String input;
	int Guess,PHand,DHand;
	int Win,Lose,Tie;
	boolean done = false;


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
			BlackJack();
			break;
		}
		default:
			System.out.println("Not a Choice");
			Game();
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
			return;
		}
		case"no":
		{
			replay=false;
			return;
		}
		default:
		{
			System.out.println("Not a choice");						
			PlayAgian();
		}

		}

	}
	public void BlackJack(){
		done = false;
		CardStart();
		while(!done)
		{
			ShowHand();

			System.out.println("Would you like to Hit or stay?");
			input = tKeyboard.next();
			switch(input.toLowerCase()) 
			{
			case"hit":
			{
				Hit();			
			}
			}

			DealerPlay();
			Score();

		}
	}
	public void Hit(){
		PHand += card.Throw();
	}
	public void Score(){
		if(PHand == 21 && DHand != 21)
		{
			ShowHand();
			System.out.println("You Win!");
			Win++;
			done = true;
		}
		else if(PHand <21 && DHand > 21){
			ShowHand();
			System.out.println("You Win!");
			Win++;
			done = true;
		}
		else if( (PHand >21 && DHand > 21)||(PHand == 21 && DHand == 21))
		{
			ShowHand();
			System.out.println("We Tied!");
			Tie++;
			done = true;
		}
		else if(PHand > 21 && DHand <= 21 )
		{
			ShowHand();
			System.out.println("You lose!");
			Lose++;
			done = true;
		}

	}
	public void CardStart(){
		PHand = card.Throw(); 
		PHand += card.Throw();
		DHand = card.Throw();
		DHand += card.Throw();
	}
	public void ShowHand(){
		System.out.println("Your hand adds up to "+PHand);
		System.out.println("My hand adds up to "+DHand);
	}
	public void DealerPlay(){
		if(DHand<21 && PHand > DHand)
			DHand += card.Throw();

		else if(DHand<21 && PHand<17)
			DHand += card.Throw();
	}
}
