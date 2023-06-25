//import java.awt.geom.Area;
import java.util.*;
class
Circles{
    double radius;
    public double Area(){
        return 3.14*radius*radius;
    }
    public double Perimeter(){
        return 2*3.14*radius;
    }

}
//class Cylinder extends Circles{
//    double height;
//    public double Volume(){
//        return 3.14*radius*radius*height;
//    }
//    public double Surface_Area(){
//        return 2*3.14*radius*(radius+height);
//    }
//}
public class java_inheritence_sum1 {
    public static void main(String[] args) {
        Circles cir = new Circles();
        cir.radius=6;

        System.out.println(cir.Area());
        System.out.println(cir.Perimeter());

//        Cylinder cyn = new Cylinder();
//        cyn.height=6;
//        cyn.radius=7;
//        System.out.println(cyn.Surface_Area());
//        System.out.println(cyn.Volume());


    }
}
