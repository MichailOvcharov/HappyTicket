package ru.omb;

public class LuckyTicketProvider implements LuckyProvider {
    public LuckyTicketImpl get(long n) {
        return new LuckyTicketImpl(n);
    }
}
