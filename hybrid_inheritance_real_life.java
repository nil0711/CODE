interface Radio{
    void radio();
}
class telePhone{
    void telephone(){
        System.out.println("Calling friend");
    }
}
class CellPhone extends telePhone implements Radio{
    void cellphone(){
        System.out.println("Is portable");
    }

    @Override
    public void radio() {
        System.out.println("Plays music");
    }
}
interface Wi_fi{
    void wifi();
}
interface Bluetooth{
    void bluetooth();
}
class smartPhone extends CellPhone implements Wi_fi,Bluetooth{
    void smart(){
        System.out.println("Is smart and touch screen");
    }

    @Override
    public void wifi() {
        System.out.println("Connect to internet");
    }

    @Override
    public void bluetooth() {
        System.out.println("Connect to devices via BT");
    }
}
public class hybrid_inheritance_real_life {
    public static void main(String[] args) {
        smartPhone myPhone = new smartPhone();
        myPhone.telephone();
        myPhone.radio();
        myPhone.cellphone();
        myPhone.smart();
        myPhone.wifi();
        myPhone.bluetooth();
    }
}
