package cn.codefreak.algo.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class SortUtilsTest {
    public Integer[] createRandomNumbers(int count, int bound){
        Random r = new Random();
        Integer[] randomNumbers = new Integer[count];
        for (int i = 0; i < count; i++) {
            randomNumbers[i] = Integer.valueOf(r.nextInt(bound));
        }
        return randomNumbers;
    }

    @Test
    public void bubble() {
        System.out.println("bubble sort test");
        Integer[] src = createRandomNumbers(10, 100);
        System.out.println("src:"+ Arrays.toString(src));

        Integer[] sort1 = Arrays.copyOf(src, src.length);
        Arrays.sort(sort1);
        System.out.println("sort1:"+Arrays.toString(sort1));

        Integer[] sort2 = Arrays.copyOf(src, src.length);
        SortUtils.bubble(sort2);
        System.out.println("sort2:"+Arrays.toString(sort2));

        assertArrayEquals(sort1, sort2);
    }

    @Test
    public void insertion() {
        System.out.println("insertion test");
        Integer[] src = createRandomNumbers(10, 100);
        System.out.println("src:"+ Arrays.toString(src));

        Integer[] sort1 = Arrays.copyOf(src, src.length);
        Arrays.sort(sort1);
        System.out.println("sort1:"+Arrays.toString(sort1));

        Integer[] sort2 = Arrays.copyOf(src, src.length);
        SortUtils.bubble(sort2);
        System.out.println("sort2:"+Arrays.toString(sort2));

        assertArrayEquals(sort1, sort2);
    }

    @Test
    public void selection() {
        System.out.println("selection test");
        Integer[] src = createRandomNumbers(10, 100);
        System.out.println("src:"+ Arrays.toString(src));

        Integer[] sort1 = Arrays.copyOf(src, src.length);
        Arrays.sort(sort1);
        System.out.println("sort1:"+Arrays.toString(sort1));

        Integer[] sort2 = Arrays.copyOf(src, src.length);
        SortUtils.selection(sort2);
        System.out.println("sort2:"+Arrays.toString(sort2));

        assertArrayEquals(sort1, sort2);
    }
}