package ru.omb;

import java.util.Arrays;

public class AnotherLuckyTicketImpl implements Lucky {

    private int[] ticket;

    public AnotherLuckyTicketImpl(long i) {
        long t = i;
        int j = 3;
        this.ticket = new int[]{0, 0, 0, 0};
        while (t > 0) {
            ticket[j] = (int) t % 10;
            t = t / 10;
            j--;
        }
    }

    public boolean isLucky() {
        int count1 = ticket[0] + ticket[1];
        int count2 = ticket[2] + ticket[3];
        if (count1 == count2) return true;
        return false;
    }

    public int[] getTicket() {
        return this.ticket;
    }

    @Override
    public String toString() {
        return "LuckyTicketImpl{" +
                "ticket=" + Arrays.toString(ticket) +
                '}';
    }

}
