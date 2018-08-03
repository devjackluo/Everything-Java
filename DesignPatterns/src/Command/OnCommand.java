package Command;

public class OnCommand implements Command {

    private Light light;

    public OnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute(){

        light.toggle();

//        if(light.isState()){
//            light.off();
//        }else {
//            light.on();
//        }
    }

}
