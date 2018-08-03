package Command;

import java.util.ArrayList;
import java.util.List;

public class CommandDemo {

    public static void main(String[] args){

        Light light1 = new Light();
        Light light2 = new Light();
        Light light3 = new Light();
        Light light4 = new Light();


        Switch lSwitch = new Switch();

        System.out.println("Turning light1 on");
        Command onCommand = new OnCommand(light1);
        lSwitch.storeAndExecute(onCommand);
//        lSwitch.storeAndExecute(onCommand);
//        lSwitch.storeAndExecute(onCommand);
//        lSwitch.storeAndExecute(onCommand);
//        lSwitch.storeAndExecute(onCommand);

        List<Light> lights = new ArrayList<>();
        lights.add(light1);
        lights.add(light2);
        lights.add(light3);
        lights.add(light4);

        System.out.println("Turning all remaining lights on");
        Command allLightsCommand = new AllLightCommand(lights, true);
        lSwitch.storeAndExecute(allLightsCommand);

        System.out.println("Turning all lights on (none)");
        allLightsCommand = new AllLightCommand(lights, true);
        lSwitch.storeAndExecute(allLightsCommand);

        System.out.println("Turning all lights off");
        allLightsCommand = new AllLightCommand(lights, false);
        lSwitch.storeAndExecute(allLightsCommand);


    }

}
