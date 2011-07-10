package pa6Java;
import java.io.FileNotFoundException;
import java.util.LinkedList;


public class GameMain 
{
	public static void main (String args[]) throws FileNotFoundException
	{
		Concentration c = new Concentration();
		c.loadLevel();
		
		Player p1 = new Player ("Goku");
		Player p2 = new Player ("Vegeta");
		
		c.play(p1,p2);
		
	}
}
