package ru.omb;


public interface LuckyProvider {
//    Lucky get(long n);
    default Lucky get(long n) {
        return new LuckyTicketImpl(n);
    }
}
