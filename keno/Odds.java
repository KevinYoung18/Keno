package games.keno;

public class Odds 
{
	private static double[][] odds = {
			{},
			{0, 2.5},
			{0, 1, 5},
			{0, 0, 2.5, 25 },
			{0, 0, 1, 4, 100},
			{0, 0, 0, 2, 20, 450},
			{0, 0, 0, 1, 7, 50, 1600},
			{0, 0, 0, 1, 3, 20, 100, 5000,},
			{0, 0, 0, 0, 2, 10, 50, 1000, 15000},
			{0, 0, 0, 0, 1, 5, 25, 200, 4000, 40000},
			{2, 0, 0, 0, 0, 2, 20, 80, 500, 10000, 100000},
			{2, 0, 0, 0, 0, 1, 10, 50, 250, 1500, 15000, 500000},
			{4, 0, 0, 0, 0, 0, 5, 25, 150, 1000, 2500, 25000, 1000000}
	};
	
	// return the multiplier for number of shots and the number of matches
	public static double get(int shots, int match)
	{
		if(shots <= 0 || shots >= odds.length)
		{
			throw new IndexOutOfBoundsException("Invalid number of shots");
		}
		return odds[shots][match];
	}
	
	//return an array of multipliers for the number of shots
	public static double[] get(int shots)
	{
		if(shots <= 0 || shots >= odds.length)
		{
			throw new IndexOutOfBoundsException("Invalid number of shots");
		}
		return odds[shots];
	}

}
