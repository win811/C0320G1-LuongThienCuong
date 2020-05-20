package advanced_object_oriented_design.thuchanh.animal_interface_test;

public class test {
    public static void main(String[] args) { ;
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        if (animals[1] instanceof Chicken) {
            System.out.println("Đúng");
        }

    }
}
