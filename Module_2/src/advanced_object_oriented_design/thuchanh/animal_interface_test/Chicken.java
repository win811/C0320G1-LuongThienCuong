package advanced_object_oriented_design.thuchanh.animal_interface_test;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound () {
        return "Chicken: cluck-cluck!";
    }
    @Override
    public String howToEat () {
        return "Chicken could be fried";
    }
}
