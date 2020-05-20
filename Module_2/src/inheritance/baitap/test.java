package inheritance.baitap;

public class test {

    public static void main(String[] args) {
////        Point2D a = new Point3D(2.2f,3.3f,4.2f);
//        Point3D b = new Point3D(5.6f,6.3f,8.4f);
//        Point2D a = b;
//        System.out.println(a);
////        System.out.println(a.getZ);
//        String a = "a";
//        String b = "a";
//        System.out.println(a == b);
        Hinh h1 = new Tron();

        Hinh h2 = new TamGiac();

        Hinh h3 = new ChuNhat();
//        DaGiac h4 = h2;
        h2 = h3;


    }
}
abstract class Hinh{}

class Tron extends Hinh{}

abstract class DaGiac extends Hinh{}

class TamGiac extends DaGiac{}

class ChuNhat extends DaGiac{}
