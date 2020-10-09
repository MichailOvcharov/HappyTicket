package ru.omb;

import java.util.Arrays;
import java.util.Optional;

public class LuckyTicketImpl implements Lucky {

    private int[] ticket;

    public LuckyTicketImpl(long i) {
        long t = i;
        int j = 5;
        this.ticket = new int[]{0, 0, 0, 0, 0, 0};
        while (t > 0) {
            ticket[j] = (int) t % 10;
            t = t / 10;
            j--;
        }
    }

    public LuckyTicketImpl(Long ticket) {
        Optional<Long> optional = Optional.ofNullable(ticket);
        Long aLong = optional.orElseThrow(IllegalArgumentException::new);
            long t = aLong;
            int j = 5;
            this.ticket = new int[]{0, 0, 0, 0, 0, 0};
            while (t > 0) {
                this.ticket[j] = (int) t % 10;
                t = t / 10;
                j--;
            }
        //  Optional<Long> optional = Optional.ofNullable(ticket);
//        optional.orElseThrow(IllegalArgumentException::new);
//        optional.isPresent();
//        optional.get();
//        optional.orElse(0L);
//        optional.orElseThrow(RuntimeException::new);
//        optional.orElseGet(()->null);
//        optional.map(aLong -> aLong++).orElse(0L);
        optional.ifPresent(System.out::println);
    }


    public boolean isLucky() {
        int count1 = ticket[0] + ticket[1] + ticket[2];
        int count2 = ticket[3] + ticket[4] + ticket[5];
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

    public void printTicket(String ticketToString) {
        System.out.println(ticketToString);
    }

}
