package games.keno;

import java.util.ArrayList;
import java.util.Scanner;

public class KenoCLI 
{
	private final static int MAX_CARDS = 20;
	static Keno keno;
	 
	public static void main(String[] args) 
	{
		keno = new Keno(1000);
		
		Scanner kb = new Scanner(System.in);
		
		//get cards
		getCards(kb);
		
		//
		getBets(kb);
		
		kb.close();
		
	}
	private static void getBets(Scanner kb)
	{
		while(true)
		{
			boolean exited = getBet(kb);
			if(exited) { break;}
		}
	}
	
	private static boolean getBet(Scanner kb)
	{
		
		//TODO handle invalid data
		System.out.println("Enter bet or e to exit: ");
		String input = kb.nextLine();
		if(input.equalsIgnoreCase("e"))
		{
			
			return true;
		}
		else
		{
			int bet = Integer.parseInt(input);
			System.out.println("Amount won: " + keno.play(bet));
		}
		System.out.println("Credits: " + keno.getCredits());
			
		return false;
		
	}
	
	
	// adds multiple cards to keno game
	private static void getCards(Scanner kb)
	{
		while(keno.getNumOfCards() < MAX_CARDS)
		{
			boolean exited = getCard(kb);
			if(exited) {break;}
		}
	}
	
	//	gets user input to add a card to the game of keno
	private static boolean getCard(Scanner kb)
	{
		
		System.out.println("Enter numbers on card " + (keno.getNumOfCards() + 1) + " separated by a space");
		System.out.println("Enter e to exit");
		
		String input = kb.nextLine();
		Scanner parser = new Scanner(input);
		
		ArrayList<Integer> shots = new ArrayList<Integer>();
		boolean invalid = false;
		while(parser.hasNext())
		{
			
			String str = parser.next();
			
			// handle numbers
			//TODO handle too many shots
			try
			{
				Integer num = Integer.parseInt(str);
				if(num < 1 || num >= Keno.SIZE)
				{
					throw new NumberFormatException();
				}
				
				shots.add(num);
			}
			catch( NumberFormatException e)
			{
				//handle invalid input
				if(str.equalsIgnoreCase("e"))
				{
					System.out.println("Exiting");
					
					parser.close();
					return true;
				}
				else
				{
					System.out.println("Invalid Input");
					invalid = true;
				}
				break;
				
			}
		
		}
		
		if(!invalid)
		{
			Card card = new Card(shots);
			keno.addCard(card);
			System.out.println(card);
		}
		parser.close();
		
		return false;
	}
}
