package pa6Java;


public class Player 
{
	private String name;
	private int score;
	private int gameWon;
	
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
		String pick = Concentration.scanner.nextLine();
		return pick;
		
	}
	public String getName()
	{
		return name;
	}
	/**
	 * Increases the players score by 1
	 */
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
	/**
	 * The Players Score is set back to 0
	 */
	public void refreshScore()
	{
		score = 0;
	}
	
}
