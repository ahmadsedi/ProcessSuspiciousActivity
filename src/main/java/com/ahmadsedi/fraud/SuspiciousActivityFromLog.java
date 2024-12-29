package com.ahmadsedi.fraud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 08/11/2024
 * Time: 17:42
 */

public class SuspiciousActivityFromLog {

    /**
     * 1 2 50
     * 2 5 40
     * 1 2 30
     *
     * @param logRecords
     * @param threshold
     * @return
     */
    public static List<String> findSuspiciousRecords(List<String> logRecords, int threshold){
        return logRecords.stream().map(Transaction::new).collect(new LogAnalysisCollector()).entrySet().stream().
                filter(e->e.getValue()>=threshold).sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
