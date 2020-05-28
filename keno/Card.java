package games.keno;

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
	
}
