package shape.shapeConcreteClass.threeD;

import shape.ThreeDShape;

public class Sphere extends ThreeDShape {
    public int radius;
    public String color;

    public Sphere(int radius,String color){
        this.radius = radius;
        this.color = color;
        System.out.println("HI iam sphere with color:"+this.color);
        System.out.println("sphere's volume and surfaceA: "+calculateVolume()+", "+calculateSurfaceArea());

    }
    @Override
    public int calculateVolume() {
        System.out.println("calculating sphere volume");
        return 3*radius*radius*radius;
    }

    @Override
    public int calculateSurfaceArea() {
        System.out.println("calculating sphere surface");
        return 12*radius*radius;
    }
}
