package inheritance.baitap;

class Faculty extends Employee {
    public Faculty() {
        System.out.println("Faculty performing its tasks");
    }

    public static void main(String[] args) {
        int a = 10;
        String b = "abc";
        System.out.println(b.length());
        Integer c = new Integer("10");
        System.out.println(a == c);
//        new Faculty();
    }
}

class Employee extends Person {
    public Employee() {
        this("Employee overloading its tasks");
        System.out.println("Employee performing its tasks!");
    }

    public Employee(String s) {
        System.out.println(s);
    }
}

class Person {
    public Person() {
        System.out.println("Person performing its tasks!");
    }
}
