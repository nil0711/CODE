class Animal{
    void eat(){
        System.out.println("Is eating");
    }
    void sleep(){
        System.out.println("Is sleeping");
    }
}
class Dog extends Animal{
    void bark(){
        System.out.println("Is barking");
    }
    void tail_wag(){
        System.out.println("Is wagging tail");
    }
}
public class single_inheritance_real_life {
    public static void main(String[] args) {
        Dog tommy = new Dog();
        tommy.sleep();
        tommy.bark();
        tommy.eat();
        tommy.tail_wag();
    }
}
