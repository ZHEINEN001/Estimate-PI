/**
 * @author Zachary Heinen
 * version 1
 * 9/30/2020
 */
import java.util.*;


public class Darts {
	
	/**
	 * this distance method calculates the distance a point is to the center of the circle
	 * @param x
	 * @param y
	 * @return distance
	 */
	private static double distance(double x, double y) {
		
		double stuff = (x *x) + (y * y);
		double d = Math.sqrt(stuff);
		return d;
	}
	/**
	 * this method generates a random number between -0.5 and 0.5
	 * @return random number
	 */
	private static double randNum() {
		double x = 0;
	
		x = Math.random();
		x = x - 0.5;
		return x;
	}
	
	/**
	 * this method calculates the standard deviation of doubles in an ArrayList
	 * @param sdArgs
	 * @return standard deviation
	 */
	private static double calculateSD(ArrayList<Double> sdArgs) {
		
		
		double sum = 0.0, standardDeviation = 0.0;
        int length = sdArgs.size();

        for(double num : sdArgs) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: sdArgs) {
            standardDeviation += (num - mean) * (num - mean);
        }

        return Math.sqrt(standardDeviation/length);
		
	}
	/**
	 * the main method takes in the number of games and the amount of darts the user
	 * wants to throw at the imaginary board to estimate pi.
	 * 
	 * about 100,000 estimates pi accurately for 3 digits.
	 * 
	 * it then prints out the average estimation taken from all the games and the standard deviation
	 * of the estimations of each game
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Double> piEstimates = new ArrayList<Double>();
		Scanner sc = new Scanner(System.in);
		double numberOfGames, numberOfDarts, dartsInsidePerGame, piTotal;
		dartsInsidePerGame = 0.0;
		piTotal = 0.0;
		System.out.println("Enter number of games:");
		numberOfGames = sc.nextInt();
		System.out.println("Enter number of darts:");
		numberOfDarts = sc.nextInt();
		for(int i = 0; i < numberOfGames; i++) {
			for(int n = 0; n <= numberOfDarts; n++) {
				if(distance(randNum(), randNum()) <= 0.5) {

					dartsInsidePerGame++;
				}
			}
			double pi = 4 * (dartsInsidePerGame / numberOfDarts); 
			piEstimates.add(pi);
			dartsInsidePerGame = 0.0;
		}
		for(double i : piEstimates) {
			piTotal = piTotal + i;
		}
		piTotal = piTotal / numberOfGames;
		
		System.out.println("Estimation of PI: " + piTotal);
		
		System.out.println("Standard deviation: " + calculateSD(piEstimates));
		
		sc.close();
	}
	

}
