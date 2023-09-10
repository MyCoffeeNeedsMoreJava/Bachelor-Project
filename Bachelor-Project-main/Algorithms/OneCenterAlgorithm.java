import java.util.*;
import java.lang.Object;
import java.lang.Math;



public class OneCenterAlgorithm {
    private double[][] arr;
    private int dimensions;
    private N_sphere h;
    private double euc_dist;

    public N_sphere Algorithm(double eps) {
        //Create the initial hypersphere
        double[] center = arr[0];
        double radius = 0;
        h = new N_sphere(dimensions, center, radius);

        //Create the 1 divided by epsilon squared loop factor
        double epsres = (1/Math.pow(eps, 2));
        double loopfactor = Math.round(epsres);
        System.out.println("Loopfactor: " + loopfactor);
        //MApproximation loop
        for(int i = 0; i <= loopfactor; i++) {
            System.out.println("Currently doing iteration: " + i);
            //Loop for distance calculation
            double[] np = reduceDimDistanceCalc(center);
            UpdateSphere(center, np, i);

        }
        for(int i = 0; i <= h.getCenter().length-1; i++) {
            System.out.println(h.getCenter()[i]);
        }
        return h;
    }


    public double[] reduceDimDistanceCalc(double[] center) {
        System.out.println("Inside Distance Calculation");
        double acc = 0;
        double[] ret_point = null;
        for(int i = 0; i <= arr.length-1; i++) {
            double acc2 = 0;
            double[] point = arr[i];
            for(int j = 0; j <= point.length-1; j++) {
                double placeholder = center[j] - point[j];
                acc2 += placeholder * placeholder;
            }
            if(acc2 > acc) {
                System.out.println("Found a longer distance");
                acc = acc2;
                ret_point = point;
            }
        }
        System.out.println("The returning distance is: " + acc + " farthest point with following coordinates: " + ret_point);
        euc_dist = acc;
        return ret_point;
        
    }

    public void UpdateSphere(double[] center, double[] np, int indexRound) {
        System.out.println("Updating The Sphere");
        double[] DistVector = new double[center.length];
        double[] new_center = new double[center.length];

        // Center Update using the equation from Mihai
        for(int i = 0; i <= center.length-1; i++) {
            DistVector[i] = np[i] - center[i];
            System.out.println("DistVector is: " + DistVector);
        }
        for(int j = 0; j <= center.length-1; j++) {
            System.out.println("Updating The Center point ");
            new_center[j] = center[j] + DistVector[j] * (1/(indexRound+1));

        }
        System.out.println("Updating the sphere with the new center: " + new_center);
        h.updateCenter(new_center);

        // Radius update using the equation from Zarabi, due to Mihai's lack of equations.
        double delta = (1/2)*(euc_dist-h.getRadius());
        h.updateRadius(h.getRadius()+delta);
    }

    public void CreateP(int d, int n) {
        dimensions = d;
        PointCreation pc = new PointCreation();
        arr = pc.createPoints(d, n);
        System.out.println(arr);
    }

    public void setP(double[][] testArr)  {
        arr = testArr;
    }

    public void setDimension(int d) {
        dimensions = d;
    }

    public static void main(String[] args) {
        OneCenterAlgorithm OCA = new OneCenterAlgorithm();
        OCA.CreateP(2, 10);
        OCA.Algorithm(0.2);
    }
}
