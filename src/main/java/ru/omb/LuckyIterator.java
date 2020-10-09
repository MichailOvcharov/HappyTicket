package ru.omb;

import java.util.Iterator;

public class LuckyIterator implements Iterator<Lucky> {
    private static long MAX = 1000000;
    private LuckyProvider provider = new LuckyTicketProvider();
    private long current = 0;

    public boolean hasNext() {
        return current < MAX;
    }

    public Lucky next() {
        Lucky lucky = provider.get(current);
        current ++;
        return lucky;
    }
}
