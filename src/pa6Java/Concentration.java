package pa6Java;
import java.util.*;
import java.io.*;

public class Concentration
{
	public static Scanner scanner = new Scanner (System.in);

	private ConcentrationGMaker g;
	private boolean gameOver = false;
	
	/**
	 * Loads a level based on a single string.  The levels are read from getting information from two seperate text files
	 */
	public void loadLevel() throws FileNotFoundException
	{
		System.out.println("Which set of cards would you like to choose?");
		String s = Concentration.scanner.nextLine();
		
		Scanner qlist = new Scanner(new File (s+"questions.txt"));
		Scanner alist = new Scanner(new File (s+"answers.txt"));
		
		LinkedList <String> questions = new LinkedList<String>();
		while(qlist.hasNextLine())
		{
			questions.add(qlist.nextLine());
		}
		
		LinkedList <String> answers = new LinkedList<String>();
		while(alist.hasNextLine())
		{
			answers.add(alist.nextLine());
		}
		if(s.equals("states"))
		{
			this.g = new ConcentrationGMaker(4,4, questions, answers); 
		}
		else if (s.equals("practice"))
		{
			this.g = new ConcentrationGMaker(2,3, questions, answers); 
		}
	}
	/**
	 *  Plays the game and keeps track of which cards were picked
	 */
	public void play(Player p1, Player p2)
	{
		
		System.out.println("Welcome to Concentration");
		while(gameOver == false)
		{
			String pick = p1.chooseCards();

			checkCards(p1 , pick);
			
			if(gameOver == true)
			{
				if(p1.getScore() > p2.getScore())
				{
					p1.win();
					System.out.println(p1.getName() + "Won"); 
				}
				else if (p2.getScore() > p1.getScore())
				{
					p2.win();
					System.out.println(p2.getName() + "Won"); 
				}
				else
				{
					System.out.println("It was a tie!");
				}
				p1.refreshScore();
				p2.refreshScore();
			}
			
			if(gameOver == false)
			{
				pick = p2.chooseCards();
				
				checkCards(p2 , pick);
	
				if(gameOver == true)
				{
					if(p1.getScore() > p2.getScore())
					{
						p1.win();
						System.out.println(p1.getName() + "Won"); 
					}
					else if (p2.getScore() > p1.getScore())
					{
						p2.win();
						System.out.println(p2.getName() + "Won"); 
					}
					else
					{
						System.out.println("It was a tie!");
					}
					p1.refreshScore();
					p2.refreshScore();
				}
			}
		}
	}
	/**
	 * Need to use ASCII values in order to get the correct numbers.  If its a valid choice then it will flip the cards and print what they were
	 */
	public void checkCards(Player player, String pick)
	{
		boolean check = false;
		
		while (check == false)
		{
			int c1 = pick.charAt(0)-65;
			int r1 = pick.charAt(2)-49;
		
			int c2 = pick.charAt(4)-65;
			int r2 = pick.charAt(6)-49;
			
			if(g.getMatrix()[c1][r1] != "flipped" && g.getMatrix()[c2][r2] != "flipped")
			{
				System.out.println("Card 1: " + g.getMatrix()[c1][r1] + " Card 2:" + g.getMatrix()[c2][r2]);
				check = true;
				
				//figures out whether the two points are connected within the map
				if(g.getQA().get(g.getMatrix()[c1][r1]) == g.getMatrix()[c2][r2] || g.getQA().get(g.getMatrix()[c2][r2]) == g.getMatrix()[c1][r1])
				{
					player.match();
					g.getMatrix()[c1][r1] = "flipped";
					g.getMatrix()[c2][r2] = "flipped";
				}
			}
			if(check == false)
			{
				player.chooseCards();
			}
		}
		//Tests whether the game is over or not
		checkState();
					
	}
	/**
	 *  Checks whether the game is over.  This is based on whether all of the cards are flipped or not
	 */
	public void checkState()
	{
		gameOver = true;
		for(int i = 0; i < g.getHeight() && gameOver == true ; i++)
		{
			for(int j=0; j < g.getWidth() && gameOver == true; j++)
			{
				if(g.getMatrix()[i][j] != "flipped")
				{
					gameOver = false;
				}
			}
		}
	}
}
