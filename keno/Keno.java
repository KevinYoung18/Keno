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
	// @return					the amount won
	//	adds the winnings from each card back to credits
	public double play(double betAmount)
	{
		double totalBet = betAmount * cards.size();
		if(totalBet >= credits)
		{
			throw new IllegalArgumentException("Bets must be less than or equal to the amount of credits");
		}
		else
		{
			credits -= totalBet;
		}
		
		ArrayList<Integer> winningNumbers = getWinningNumbers();
		
		// get winnings from each card
		double winnings = 0.0;
		for(Card card: cards)
		{
			winnings += card.getWinnings(betAmount, winningNumbers);
		}
		
		//add winnings back to credits
		credits += winnings;
		return winnings;
		
	}
	
	public void removeCard(int index)
	{
		cards.remove(index);
	}
	
	public int getNumOfCards()
	{
		return cards.size();
	}
	
	public double getCredits()
	{
		return credits;
	}
	
	// @returns 		an array of winning numbers
	private ArrayList<Integer> getWinningNumbers()
	{
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Random rand = new Random();
		
		for(int i = 0; i < 20; i++)
		{
			int randNum = rand.nextInt(SIZE-1) + 1;
			while(numbers.contains(randNum))
			{
				randNum = rand.nextInt(SIZE-1) + 1;
			}
			numbers.add(randNum);
		}
		
		return numbers;
	}
	
}
