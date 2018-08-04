package Mediator;

public class MediatorDemo {

    public static void main(String[] args){

        Mediator mediator = new Mediator();

        Light bedroomLight = new Light("Bedroom");
        Light kitchenLight = new Light("Kitchen");

        mediator.registerLight(bedroomLight);
        mediator.registerLight(kitchenLight);

        Command turnOn = new TurnOnAllLightCommand(mediator);
        turnOn.execute();

        Command turnOff = new TurnOffAllLightCommand(mediator);
        turnOff.execute();

    }

}
