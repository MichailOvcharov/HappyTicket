package ru.omb;

public class AnotherLuckyTicketProvider {
    public AnotherLuckyTicketImpl get(long n) {
        return new AnotherLuckyTicketImpl(n);
    }
}
