package com.ahmadsedi.fraud;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 08/11/2024
 * Time: 18:26
 */

public class SuspiciousActivityFromLogTest {

    @Test
    void findSuspiciousRecords(){
        List<String> list = List.of("1 5 5", "1 2 5", "2 3 6", "6 2 5");
        List<String> result = SuspiciousActivityFromLog.findSuspiciousRecords(list, 2);
        List<String> expected = List.of("1", "2");
        assertThat(expected).hasSameElementsAs(result);
    }
}
