package CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuComponent {

    String name;
    List<MenuComponent> items;

    public Menu(String name) {
        this.name = name;
        items = new ArrayList<>();
    }

    public void add(MenuComponent menuComponent) {
        items.add(menuComponent);
    }

    public MenuComponent remove(MenuComponent menuComponent) {
        return items.remove(menuComponent) ? menuComponent : null;
    }

    public MenuComponent getChild(int i) {
        return items.get(i);
    }

    public String getName() {
        return this.name;
    }

    public void print() {
        print("");
    }

    public void print(String indent) {
        System.out.println(indent + "+ " + name);
        String childIndent = indent + "  ";
        for (MenuComponent menuComponent : items) {
            menuComponent.print(childIndent);
        }
    }
    
}
