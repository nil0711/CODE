class Life_{
    void life(){
        System.out.println("Is alive");
    }
}
class animal_ extends Life_{
    void animal(){
        System.out.println("Can move and change places at will");
    }
}
class plant extends Life_{
    void plant(){
        System.out.println("Can produce oxygen");
    }
}
class Cow extends animal_{
    void cow(){
        System.out.println("Eats grass");
    }
}
class Tiger extends animal_{
    void tiger(){
        System.out.println("Eats meat");
    }
}
class Rose extends plant{
    void rose(){
        System.out.println("Is red");
    }
}
class Mango extends plant{
    void mango(){
        System.out.println("Is tasty");
    }
}
public class hierarchical_inheritance_real_life {
    public static void main(String[] args) {
        Cow gauri = new Cow();
        Tiger sheru=new Tiger();
        Rose red_rose=new Rose();
        Mango alphonso=new Mango();

        gauri.life();
        gauri.animal();
        gauri.cow();
        System.out.println();
        sheru.life();
        sheru.animal();
        sheru.tiger();
        System.out.println();
        red_rose.life();
        red_rose.plant();
        red_rose.rose();
        System.out.println();
        alphonso.life();
        alphonso.plant();
        alphonso.mango();
    }
}
