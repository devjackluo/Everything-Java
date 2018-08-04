package Mediator;

public class Light {

    private String name;
    private boolean state = false;


    public Light(String name){
        this.name = name;
    }

    public void on(){
        this.state = true;
        System.out.println(name + " is on");
    }

    public void off(){
        this.state = false;
        System.out.println(name + " is off");
    }

    public boolean isOn() {
        return state;
    }

    public void toggle(){
        if(this.state){
            this.off();
        }else {
            this.on();
        }
    }

}
