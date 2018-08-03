package Command;

public class Light {

    private boolean state = false;

    public void on(){
        this.state = true;
        System.out.println("Light is on");
    }

    public void off(){
        this.state = false;
        System.out.println("Light is off");
    }

    public boolean isState() {
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
