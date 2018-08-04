package Mediator;

public class TurnOffAllLightCommand implements Command {

    private Mediator mediator;

    public TurnOffAllLightCommand(Mediator mediator){
        this.mediator = mediator;
    }

    @Override
    public void execute() {
        this.mediator.turnOffAllLights();
    }

}
