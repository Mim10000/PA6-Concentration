import java.util.LinkedList;


public class GameMain 
{
	public static void main (String args[])
	{
		Concentration c = new Concentration();
		
		c.loadLevel();
		c.play();
		
	}
}
