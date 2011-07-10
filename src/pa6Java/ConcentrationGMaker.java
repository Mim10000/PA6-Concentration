package pa6Java;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;


public class ConcentrationGMaker 
{
	private int height;
	private int width;
	private HashMap <String,String> QA;
	private String[][] matrix;
	
	/**
	 *  Creates a valid Concentration game to be played by creating a HashMap which connects questions and answers and a valid matrix for the game
	 */
	public ConcentrationGMaker(int height, int width, LinkedList <String> questions, LinkedList <String> answers)
	{

		this.height = height;
		this.width = width;
	
		HashMap <String,String> QA = new HashMap <String,String>();
		
		//goes throught and assigns each key to value and each value to key
		for(int i = 0; i < questions.size(); i++)
		{
			QA.put(questions.get(i), answers.get(i));
			QA.put(answers.get(i)  , questions.get(i));
		}
		
		this.QA = QA;

		//Goes through to create a 2-D array that is randomized with each of the answers and questiona
		Random r = new Random();
		
		String [][] matrix = new String [height][width];
		
		for (int i = 0; i < height; i++)
		{
			for(int j=0; j< width; j++)
			{
				String n = "~";
				while (n.equals("~"))
				{
					int choose = r.nextInt(2);
					//System.out.println("QuestionsSize? " + questions.size() );
					//Chooses from Questions randomly
					if (choose == 0 && questions.size() > 0)
					{
						choose = r.nextInt(questions.size()); 
						n = (questions.get(choose));
						questions.remove(n);
					}
					//Chooses from answers
					else if(choose == 1 && answers.size() > 0)
					{
						choose = r.nextInt(answers.size()); 
						n = (answers.get(choose));
						answers.remove(n);
					}
				}
				matrix[i][j] = n;
			}
		}
		this.matrix = matrix;
	}
	public int getHeight()
	{
		return height;
	}
	public int getWidth()
	{
		return width;
	}
	public HashMap <String,String> getQA()
	{
		return QA;
	}
	public String[][] getMatrix()
	{
		return matrix;
	}
}
