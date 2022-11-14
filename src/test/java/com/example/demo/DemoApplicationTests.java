package com.example.demo;

import com.example.demo.student.Testt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        String text = "some text to write code ADS".toLowerCase();
        Map<String, Integer> counting = new HashMap<>();

        for (char c : text.toCharArray()) {
            counting.merge(String.valueOf(c), 1, Integer::sum);
        }
        counting.remove(" ");
        System.out.printf(counting.toString());
        Optional<Map.Entry<String, Integer>> maxEntry = counting.entrySet().stream().max(Map.Entry.comparingByValue());
        maxEntry.get().getKey();
        maxEntry.get().getValue();
        Testt t= new Testt();
        t.doSomething();
    }

}
