import java.util.Scanner;


public class Player 
{
	private String name;
	private int score;
	private int gameWon;
	private Scanner scanner = new Scanner (System.in);
	
	public Player(String name)
	{
		this.name = name;
		this.gameWon = 0;
		this.score = 0;
	}
	/**
	 *  Allows the user to choose cards from a Scanner to complete the game
	 */
	public String chooseCards()
	{	
		System.out.println(name + ", what Cards Would you like to choose (Ex A-3&C-4)");
		String pick = scanner.nextLine();
		return pick;
		
	}
	public String getName()
	{
		return name;
	}
	public void match()
	{
		score++;
	}
	
	public void win()
	{
		gameWon++;
	}
	public int getScore()
	{
		return score;
	}
	
	public int getGamesWon()
	{
		return gameWon;
	}
	
}
