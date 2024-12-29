package com.ahmadsedi.fraud;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 08/11/2024
 * Time: 17:59
 */

public class LogAnalysisCollector implements Collector<Transaction, Map<String, Integer>, Map<String, Integer>> {
    @Override
    public Supplier<Map<String, Integer>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<String, Integer>, Transaction> accumulator() {
        return (map, transaction) -> {
            String senderId = transaction.getSenderId();
            String receiverId = transaction.getReceiverId();
            Integer number = map.get(senderId);
            if(number==null){
                map.put(senderId, 1);
            }else{
                map.put(senderId, number+1);
            }
            if(!receiverId.equals(senderId)) {
                number = map.get(receiverId);
                if(number==null){
                    map.put(receiverId, 1);
                }else{
                    map.put(receiverId, number+1);
                }
            }
        };
    }

    @Override
    public BinaryOperator<Map<String, Integer>> combiner() {
        return (map1, map2) -> {
            map1.putAll(map2);
            return map1;
        };
    }

    @Override
    public Function<Map<String, Integer>, Map<String, Integer>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
    }
}
