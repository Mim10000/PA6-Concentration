import java.util.LinkedList;
import java.util.Scanner;


public class Concentration
{
	private ConcentrationGMaker g;
	private boolean gameOver = false;
	
	public void loadLevel()
	{
		LinkedList <String> questions = new LinkedList<String>();
		questions.add("Burns?");
		questions.add("Chills?");
		
		LinkedList <String> answers = new LinkedList<String>();
		answers.add("Fire");
		answers.add("Ice");
		
		this.g = new ConcentrationGMaker(2,2, questions, answers); 
	}
	/**
	 *  Plays the game and keeps track of which cards were picked
	 */
	public void play()
	{
		Player p1 = new Player("Goku");
		Player p2 = new Player("Vegeta");
		
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
	public void checkState()
	{
		gameOver = true;
		for(int i = 0; i < g.getHeight() && gameOver == true ; i++)
		{
			for(int j=0; j < g.getWidth() && gameOver == true; j++)
			{
				if(g.getMatrix()[i][j] != "flipped")
				{
					System.out.println(g.getMatrix()[i][j]);
					gameOver = false;
				}
			}
		}
	}
}
