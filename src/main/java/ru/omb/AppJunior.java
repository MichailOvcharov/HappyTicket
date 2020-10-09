package ru.omb;

public class AppJunior {

    private static final long MAX_NUMBER = 999999;

    public static void main(String[] args) {
        long count = 0L;

        //Реализация - В лоб
        int k = 0;
        for (int i = 0; i <= 9; i++) {
            for (int i1 = 0; i1 <= 9; i1++) {
                for (int i2 = 0; i2 <= 9; i2++) {
                    for (int j = 0; j <= 9; j++) {
                        for (int j1 = 0; j1 <= 9; j1++) {
                            for (int j2 = 0; j2 <= 9; j2++) {
                                if (i + i1 + i2 == j + j1 + j2) {
                                    k = k + 1;
                                    //  System.out.println("" + i + i1 + i2 + j + j1 + j2);
                                }
                            }
                        }
                    }
                }
            }
            //
        }
        System.out.println("Конец:  " + k);

        //
        for (long i = 0; i <= MAX_NUMBER; i++) {
            Lucky luckyTicket = new LuckyTicketImpl(i);
            if (luckyTicket.isLucky()) {
                // System.out.println(luckyTicket.toString());
                count++;
            }
        }
        System.out.println("Конец 2:  " + count);

        //  Реализация через интерфейс и продюссера (второй урок)
        count = 0;
        LuckyProvider luckyProvider = new LuckyTicketProvider();
        for (long i=0; i<=MAX_NUMBER; i++){
            Lucky luckyCandidate = luckyProvider.get(i);
            if (luckyCandidate.isLucky()) {
                //  System.out.println(luckyCandidate);
                count++;
            }
        }
        System.out.println("Конец 3:  " + count);

        // Реализация через итератор
        count = 0L;
        LuckyIterator luckyIterator = new LuckyIterator();
        while (luckyIterator.hasNext()) {
            Lucky next = luckyIterator.next();
            // predicate.test(next)
            if (next.isLucky()){
                // System.out.println(next.toString());
                count ++;
            }
        }
        System.out.println("Конец 4: "+ count);

        // Реализация через итератор для 4 знаков
        count = 0L;
        AnotherLuckyTicketIterator anatherLuckyIterator = new AnotherLuckyTicketIterator();
        while (anatherLuckyIterator.hasNext()) {
            Lucky next = anatherLuckyIterator.next();
            if (next.isLucky()){
                // System.out.println(next.toString());
                count ++;
            }
        }
        System.out.println("Конец (для 4 знаков): "+ count);
    }

}
