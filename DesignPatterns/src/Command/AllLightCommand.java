package Command;

import java.util.List;

public class AllLightCommand implements Command {

    private List<Light> lights;
    private boolean state;

    public AllLightCommand(List<Light> lights, boolean state){
        this.lights = lights;
        this.state = state;
    }

    @Override
    public void execute() {
        for(Light l : lights){
            if(l.isState() != state) {
                l.toggle();
            }
        }
    }

}
