package ru.omb;

public class AnotherLuckyTicketIterator {
    private static long MAX = 10000;
    private AnotherLuckyTicketProvider provider = new AnotherLuckyTicketProvider();
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
