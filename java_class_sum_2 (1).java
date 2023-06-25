import java.util.*;
interface BasicAnimal{
    void eat();
    void sleep();
}
class Monkey {
    void jump() {
        System.out.println("Jump");
    }

    void bite() {
        System.out.println("Bite");
    }
}
    class Human extends Monkey implements BasicAnimal{
        void speak(){
            System.out.println("Hello");
        }
        @Override
        public void eat() {
            System.out.println("Eat");
        }
        public void sleep(){
            System.out.println("Sleep");
        }
    }

public class java_class_sum_2 {
    public static void main(String[] args) {
        Human h=new Human();
        h.sleep();
        h.jump();
        h.speak();



    }
}
