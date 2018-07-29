package Component;

public class MenuItem extends MenuComponent{

    public MenuItem(String name, String url){
        this.name = name;
        this.url = url;
    }

//    //@Override
//    public void add(MenuComponent menuComponent){
//        this.menuComponents.add(menuComponent);
//    }
//
//    //@Override
//    public void remove(MenuComponent menuComponent){
//        this.menuComponents.remove(menuComponent);
//    }


    @Override
    public String toString() {
        return print(this);
    }

}
