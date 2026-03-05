package lambdaExpression;

interface vehical {
    public void engine();

    public void Break();

}
abstract class Bus implements vehical {

    @Override
    public void engine() {
        System.out.println("RB engine capacity 40KMPH");
    }

    @Override
    public void Break() {
        System.out.println("Bus has normal breaks");
    }

}

class RedBus extends Bus {
    @Override
    public void engine() {
        System.out.println("RB engine capacity 100KMPH");
    }
}

class ExpressBus extends Bus {

    @Override
    public void engine() {
        System.out.println("ExPress Bus as engine capacity 60 KMPH");
    }
}

class VolvoBus extends Bus {
    @Override
    public void engine() {
        System.out.println("Volvo engine capacity 110 KMPH");
    }

    @Override
    public void Break() {
        System.out.println("Volvo needs powerful beaks");
    }

}

class Car implements vehical {

    @Override
    public void engine() {
        System.out.println("RB engine capacity 150KMPH");
    }

    @Override
    public void Break() {
System.out.println("car has air breaks");
    }

}

class Bike implements vehical {

    @Override
    public void engine() {

    }

    @Override
    public void Break() {

    }

}

class Driver {

    public void Drive(vehical v) {
        v.engine();
        v.Break();
    }

}
public class mainVehical {
    public static void main(String[] args) {
          Driver surya=new Driver();
        surya.Drive(new VolvoBus());

    }
}
