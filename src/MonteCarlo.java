import java.util.Random;

public class MonteCarlo 
{
	// Throws darts in a rectangular region around the function: f(x) = sin(x^2)+3
	// with the rectangle being from (-2,0) to (2,0) with a height of 3. The method keeps
	// track of the number of darts that land under the function within the rectangular region
	// and returns the calculated approximate interval.
	public double throwDarts(int numThrows)
	{
		int totalThrows = 0;
		double underFunction = 0;
		Random random = new Random();
		
		double height = 3;
		double area = 4 * height;
		
		// Generates a random x/y pair. The random x gets substituted in the function to calculate y.
		while(totalThrows != numThrows)
		{
			double randomX = random.nextDouble() * (2 + 2) - 2;;
			double randomY = random.nextDouble() * 3;
			
			double calculatedY = (Math.sin(Math.pow(randomX,2)))+2;
			
			// If the random y is less than or equal to the calculated y, add to the running count.
			if(randomY <= calculatedY) 
			{
				underFunction++;
			}
			
			totalThrows++;
		}
		
		//Percentage of darts that land under the function.
		double percentage = underFunction/numThrows;
		
		return (percentage * area);
	}
	
	public static void main(String[] args)
	{
		MonteCarlo approxInt = new MonteCarlo();
		
		System.out.println("The equation used is: f(x) = sin(x^2) + 3\n");
		
		System.out.println("The approximate integral calculated from 100 dart throws is: " + approxInt.throwDarts(100));
		System.out.println("The approximate integral calculated from 1000 dart throws is: " + approxInt.throwDarts(1000));
		System.out.println("The approximate integral calculated from 10000 dart throws is: " + approxInt.throwDarts(10000));
		System.out.println("The approximate integral calculated from 100000 dart throws is: " + approxInt.throwDarts(100000));
	}
}
