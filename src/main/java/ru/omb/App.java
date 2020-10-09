package ru.omb;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.LongStream;

public class App {

    private static boolean isLucky(Lucky lucky) {
        return lucky.isLucky();
    }

    private static Long count2 = 0L;

    public static void main(String[] args) {

        Long count = 0L;
        // Функциональные интерфейсы и лямбда выражения
        Predicate<Lucky> predicate = lucky -> lucky.isLucky();
        Consumer<Long> consumer = aLong -> aLong++;
        Function<Long, Long> function1 = (aLong) -> ++aLong;
        Function<Long,Long> function2 = aLong -> {
            Long result=aLong;
            return ++result;
        };
        Supplier<Lucky> supplier = () -> new LuckyTicketImpl(count2);
        Action action = () -> count2++;

        LuckyIterator iterator = new LuckyIterator();
        while (iterator.hasNext()) {
            Lucky next = iterator.next();
            if (predicate.test(next)){
                action.perform();
                //  System.out.println(next);
            }
        }
        System.out.println("Конец (лямбда выражения): "+ count2);

        count2 = 0L;
        // Стрим объект конвеер - позволяет выполнить действия над группой объектов
        YetAnotherLuckyProvider yetAnotherLuckyProvider = new YetAnotherLuckyProvider();
        count2 = LongStream
                .range(0,1000000)
                .mapToObj(yetAnotherLuckyProvider::get)
                .filter(Lucky::isLucky)
                // .peek(System.out::println)
                .count();
        System.out.println("Конец (Stream 6 знаков): "+ count2);

        // Стрим для 4 знаков
        count2 = 0L;
        AnotherLuckyTicketProvider anotherLuckyTicketProvider = new AnotherLuckyTicketProvider();
        count2 = LongStream
                .range(0,10000)
                .mapToObj(anotherLuckyTicketProvider::get)
                .filter(Lucky::isLucky)
                // .peek(System.out::println)
                .count();
        System.out.println("Конец (Stream 4 знака): "+ count2);

        System.out.println(new LuckyTicketImpl(100500L));
        System.out.println(new LuckyTicketImpl(Long.valueOf( 100500L)));
        System.out.println(new LuckyTicketImpl(null));
    }
}
