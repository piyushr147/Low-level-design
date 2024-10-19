package shape.shapeConcreteClass.threeD;

import shape.ThreeDShape;

public class Cube extends ThreeDShape {
    public int length;
    public String color;

    public Cube(int length,String color){
        this.length = length;
        this.color = color;
        System.out.println("HI iam cube with color:"+this.color);
        System.out.println("cube's volume and surfaceA: "+calculateVolume()+", "+calculateSurfaceArea());
    }

    @Override
    public int calculateVolume() {
        System.out.println("calculating cube volume");
        return length*length*length;
    }

    @Override
    public int calculateSurfaceArea() {
        System.out.println("calculating cube surface");
        return 6*length*length;
    }
}
