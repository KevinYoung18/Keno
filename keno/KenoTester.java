package games.keno;


public class KenoTester 
{
	public static void main(String[] args) 
	{
		Keno k = new Keno(4000000);
		int[][] arr =
			{
					{34, 35, 36, 44, 45, 46},
					{34, 35, 44, 45, 54, 55},
					{35, 36, 45, 46, 55, 56},
					{44, 45, 46, 54, 55, 56}
			};
		
		k.addCard(new Card(arr[0]));
		k.addCard(new Card(arr[1]));
		k.addCard(new Card(arr[2]));
		k.addCard(new Card(arr[3]));
		
		for(int i = 0; i < 1000000; i++)
		{
			k.play(2);
			System.out.println(k.getCredits());
		}
		System.out.println(k.getCredits());
	}
}
