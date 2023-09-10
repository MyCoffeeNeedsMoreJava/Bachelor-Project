
import java.util.*;

public class PointCreation {

    public double[][] createPoints(int d, int amount) {
        Random rand = new Random();
        double[][] points = new double[amount][d];
        if(d <= 1) {
            System.out.println("The dimension is below 1");
            return null;
        }
        for(int i = 0; i < amount; i++) {
            double[] coordList = new double[d+1];
            for(int j = 0; j <= d; j++) {
                coordList[j] = rand.nextDouble();
            }
            points[i] = coordList;
        }
        for(double[] array: points) {
            for(double i: array) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        return points;
    }
}
