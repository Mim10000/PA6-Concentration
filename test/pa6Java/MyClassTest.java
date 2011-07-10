package pa6Java;


import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class MyClassTest 
{
	@Test
	public void testPlayer() 
	{
		Player p1 = new Player("Jeremy");
		assertEquals("Result", "Jeremy", p1.getName());
		
		p1.match();
		p1.match();
		
		assertEquals("Result", p1.getScore(), 2);
		
		p1.refreshScore();
		
		assertEquals("Result", p1.getScore(), 0);
	}
	@Test
	public void testGameMaker() 
	{
		LinkedList <String> questions = new LinkedList <String>(); 
		questions.add("Test");
		
		LinkedList <String> answers = new LinkedList <String>(); 
		answers.add("Test2");
		
		ConcentrationGMaker g = new ConcentrationGMaker(1,2,questions,answers);
		
		assertEquals("Result", g.getHeight(), 1);
		assertEquals("Result", g.getWidth(), 2);
		assertEquals("Result", g.getQA().containsKey("Test") &&  g.getQA().containsKey("Test2"), true);
		assertEquals("Result", g.getQA().get("Test"), "Test2");
		assertEquals("Result", g.getQA().get("Test2"), "Test");
	}
}
