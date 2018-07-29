package Component;

import java.util.Iterator;

public class Menu extends MenuComponent {


    public Menu(String name, String url){
        this.name = name;
        this.url = url;
    }

    @Override
    public void add(MenuComponent menuComponent){
        this.menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent){
        this.menuComponents.remove(menuComponent);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(print(this));

        Iterator<MenuComponent> itr = menuComponents.iterator();
        while(itr.hasNext()){
            MenuComponent menuComponent = itr.next();
            builder.append( menuComponent.toString());
        }

        return builder.toString();
    }

}
