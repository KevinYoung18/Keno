package games.keno;

import java.util.ArrayList;
import java.util.Random;

public class Keno 
{
	private ArrayList<Card> cards = new ArrayList<Card>();
	private double credits;
	final static int SIZE = 81;
	
	// constructors
	Keno() { this.credits = 1000;}
	Keno(double credits) { this.credits = credits; }
	
	// @param	card	the card to add to this game
	public void addCard(Card card)
	{
		cards.add(card);
	}
	
	// @param	betAmount		the amount to bet on each card
	//	adds the winnings from each card back to credits
	public void play(double betAmount)
	{
		double totalBet = betAmount * cards.size();
		if(totalBet > credits)
		{
			//TODO throw exeption
		}
		else
		{
			credits -= totalBet;
		}
		
		int[] winningNumbers = getWinningNumbers();
		
		// get winnings from each card
		double winnings = 0.0;
		for(Card card: cards)
		{
			winnings += card.getWinnings(betAmount, winningNumbers);
		}
		
		//add winnings back to credits
		credits += winnings;
		
	}
	
	private int[] getWinningNumbers()
	{
		int[] numbers = new int[20];
		Random rand = new Random();
		
		for(int i = 0; i < numbers.length; i++)
		{
			numbers[i] = rand.nextInt(SIZE-1) + 1;
		}
		
		return numbers;
	}
	
}
