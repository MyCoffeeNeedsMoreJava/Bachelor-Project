import java.util.*;
import java.lang.Object;

public class StreamAlgorithm {
    private double[][] arr;
    private int dimensions;
    private N_sphere h;


    public StreamAlgorithm() {
        
    }

    // The Algorithm to examine the array of points
    public N_sphere SimpleStreaming() {
        // Initialize the Hypersphere
        double radius = 0;
        double[] center = arr[0];
        h = new N_sphere(dimensions, center, radius);
        // Loop over point list

        //Changed the loop from i=0 to i=1 to ignore first point
        for(int i = 1; i < arr.length-1; i++) {
            if (arr.length <= 1) {
                System.out.println("The array must contain 2 or more points!");
            };
            double dist = DistanceCalc(h.getCenter(), arr[i]);
            if(!(h.getRadius() - dist >= 0)) {
                System.out.println("The Distance is: " + (h.getRadius() - dist));
                UpdateSphere(h, arr[i]);      
            } 
        }
        System.out.println(h.getRadius());
        System.out.println(h.getCenter());
    
        return h;
    }
    

    // Updates the center and radius of the sphere if a new point is found to have a longer distance than the radius
    public void UpdateSphere(N_sphere h, double[] p) {
        System.out.println("Update the Sphere!!!");

        double pointCenterDiff = DistanceCalc(p, h.getCenter());
        double delta = ((pointCenterDiff) - h.getRadius()) / 2;
        System.out.println("Delta is " + delta);
        // Update Radius
        double newRadius = h.getRadius() + delta;
        h.updateRadius(newRadius);

        // Update Center¨
        
        double centerCalc = delta / pointCenterDiff;
         
        System.out.println("CenterCalc is " + centerCalc);
        double[] newCenter = new double[h.getCenter().length];
        System.out.println("newcenter is before " + Arrays.toString(newCenter));

        double[] diffCenterP = new double[p.length];
        for(int i = 0; i < p.length-1; i++) {
            System.out.println("At this round: " + i + " p(i) is: " + p[i] + " and center(i) is: " + h.getCenter()[i]);
            diffCenterP[i] = p[i] - h.getCenter()[i];
            diffCenterP[i] *= centerCalc;
            
        }
        //Print to test:
        for(int i = 0; i < diffCenterP.length-1; i++) {
            System.out.println("Diffcenter values: " + diffCenterP[i]);
        }
        
        for(int i = 0; i < p.length-1; i++) {
            newCenter[i] = h.getCenter()[i] + diffCenterP[i];
        }
        System.out.println("newcenter is after " + Arrays.toString(newCenter));
        h.updateCenter(newCenter);
    }

    // Calculates the distance between the center of the ball and a newly identified point
    public double DistanceCalc(double[] center, double[] np) {
        double acc = 0;

        // Loop to calculate the formula: sqrt((x_2-x_1)^2+(y_2-y_1)^2)
        for(int i = 0; i < np.length - 1; i++) {
            System.out.println(i);
            double newPoint = np[i];
            double centerPoint = center[i];
            double ph = centerPoint - newPoint;
            acc += ph * ph;
        }
        return Math.sqrt(acc);
    }


    // Creates an array of arrays representing points and their dimensions
    public void CreateP(int d, int n) {
        dimensions = d;
        PointCreation pc = new PointCreation();
        arr = pc.createPoints(d, n);
        System.out.println(arr);
    }

    public void SetP(double[][] setArr) {
        arr = setArr;
    }

    public void setDimensions(int n) {
        dimensions = n;
    }

    public static void main(String[] args) {
        StreamAlgorithm alg = new StreamAlgorithm();
        alg.CreateP(10, 5);
        alg.SimpleStreaming();
    }

}


