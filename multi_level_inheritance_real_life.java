class Life{
    void life() {
        System.out.println("Is alive");
    }

}
class animal extends Life{
    void animal(){
        System.out.println("Can move and change places at will");
    }
}
class Cat extends animal{
    void cat(){
        System.out.println("Meow");
    }
}
public class multi_level_inheritance_real_life {
    public static void main(String[] args) {
        Cat blue=new Cat();
        blue.life();
        blue.animal();
        blue.cat();
    }
}
