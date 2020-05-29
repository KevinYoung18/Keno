package games.keno;

import java.util.ArrayList;

public class Card 
{
	double[] odds;
	boolean[] spots = new boolean[Keno.SIZE];
	
	
	
	Card(int[] bets)
	{
		for(int bet: bets)
		{
			if(bet <= 0 || bet >= Keno.SIZE)
			{
				throw new IndexOutOfBoundsException("Bets must be from 1-80");
			}
			spots[bet] = true;
		}
		odds = Odds.get(bets.length);
	}
	Card(ArrayList<Integer> bets)
	{
		for(int bet: bets)
		{
			if(bet <= 0 || bet >= Keno.SIZE)
			{
				throw new IndexOutOfBoundsException("Bets must be from 1-80");
			}
			spots[bet] = true;
		}
		odds = Odds.get(bets.size());
	}
	
	// @param	betAmount		the amount to bet on this card
	// @param	winningNumbers	an array of all the winning numbers
	// @return					the amount won based on the amount of matches and betAmount
	public double getWinnings(double betAmount, int[] winningNumbers)
	{
		int matches = 0;
		for(int number: winningNumbers)
		{
			if(number <= 0 || number >= Keno.SIZE)
			{
				throw new IndexOutOfBoundsException("winningNumbers must be from 1-80");
			}
			else if(spots[number])
			{
				matches++;
			}
		}
		
		double multiplier = odds[matches];
		
		return betAmount * multiplier;
	}
	
	@Override
	public String toString()
	{
		String str = "";
		for(int i = 1; i < Keno.SIZE; i++)
		{
			if(spots[i]) { str += "X\t"; }
			else { str += i + "\t"; }
			
			if(i % 10 == 0) 
			{ 
				str += System.lineSeparator(); 
				if(i % 40 == 0 ) { str += System.lineSeparator(); }
			}
		}
		return str;
	}
	
}
