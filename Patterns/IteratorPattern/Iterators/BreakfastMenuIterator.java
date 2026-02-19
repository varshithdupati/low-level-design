package IteratorPattern.Iterators;

import java.util.Iterator;

import IteratorPattern.Menus.MenuItem;

public class BreakfastMenuIterator implements Iterator<MenuItem> {

    MenuItem[] items;
    int idx;

    public BreakfastMenuIterator(MenuItem[] items) {
        this.items = items;
        idx = 0;
    }

    @Override
    public boolean hasNext() {
        if(idx>=items.length || items[idx]==null)
            return false;
        return true;
    }

    @Override
    public MenuItem next() {
        return items[idx++];
    }
    
}
