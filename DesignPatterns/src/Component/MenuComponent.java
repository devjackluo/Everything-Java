package Component;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuComponent {

    String name;
    String url;
    List<MenuComponent> menuComponents = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

//    public abstract void add(MenuComponent menuComponent);
//    public abstract void remove(MenuComponent menuComponent);

    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException("Not implemented");
    }
    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException("Not implemented");
    }

    public abstract String toString();

    public String print(MenuComponent menuComponent){
        StringBuilder builder = new StringBuilder(name);
        builder.append(": ");
        builder.append(url);
        builder.append("\n");
        return builder.toString();
    }

}
