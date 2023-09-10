import java.lang.Object;

/*
    The Class and corresponding methods are taken from the Hypersphere java package. 
*/

public class N_sphere {
    double radius;
    final double[] center;
    int dimension;

    public N_sphere (int dimensions, double[] center, double radius ) {
        this.dimension = dimensions;
        this.center = new double[dimensions];
        this.radius = radius;
    }

    public void updateRadius(double radius) {
        this.radius = radius;
    }

    public void updateCenter(double[] center) {
        for(int i = 0; i < dimension; ++i) {
            this.center[i] = center[i];
        }
    }

    public double getRadius() {
        return radius;
    }

    public double[] getCenter() {
        return center;
    }

    
}
