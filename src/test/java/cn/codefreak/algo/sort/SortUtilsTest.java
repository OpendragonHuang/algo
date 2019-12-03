package cn.codefreak.algo.sort;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class SortUtilsTest {
    private static Integer[] src;
    private static final int count = 5000;
    private static final int bound = 5000;
    
    public static Integer[] createRandomNumbers(int count, int bound){
        Random r = new Random();
        Integer[] randomNumbers = new Integer[count];
        for (int i = 0; i < count; i++) {
            randomNumbers[i] = Integer.valueOf(r.nextInt(bound));
        }
        return randomNumbers;
    }

    @BeforeClass
    public static void initNumbers(){
        src = createRandomNumbers(count, bound);
    }

    @Test
    public void bubble() {
        System.out.println("bubble sort test");
        
        Integer[] sort1 = Arrays.copyOf(src, src.length);
        Arrays.sort(sort1);

        Integer[] sort2 = Arrays.copyOf(src, src.length);
        long start = System.currentTimeMillis();
        SortUtils.bubble(sort2);
        long end = System.currentTimeMillis();

        assertArrayEquals(sort1, sort2);
        System.out.println("bubble sort test time:"+ (end - start) + "ms");
    }

    @Test
    public void insertion() {
        System.out.println("insertion sort test");
        Integer[] sort1 = Arrays.copyOf(src, src.length);
        Arrays.sort(sort1);

        Integer[] sort2 = Arrays.copyOf(src, src.length);
        long start = System.currentTimeMillis();
        SortUtils.insertion(sort2);
        long end = System.currentTimeMillis();

        assertArrayEquals(sort1, sort2);
        System.out.println("insertion sort test time:"+ (end - start) + "ms");
    }

    @Test
    public void selection() {
        System.out.println("selection sort test");
        Integer[] sort1 = Arrays.copyOf(src, src.length);
        Arrays.sort(sort1);

        Integer[] sort2 = Arrays.copyOf(src, src.length);

        long start = System.currentTimeMillis();
        SortUtils.selection(sort2);
        long end = System.currentTimeMillis();

        assertArrayEquals(sort1, sort2);
        System.out.println("selection sort test time:"+ (end - start) + "ms");
    }

    @Test
    public void merge() {
        System.out.println("merge sort test");
        Integer[] sort1 = Arrays.copyOf(src, src.length);
        Arrays.sort(sort1);

        Integer[] sort2 = Arrays.copyOf(src, src.length);

        long start = System.currentTimeMillis();
        SortUtils.merge(sort2);
        long end = System.currentTimeMillis();

        assertArrayEquals(sort1, sort2);
        System.out.println("merge sort test time:"+ (end - start) + "ms");
    }

    @Test
    public void quick() {
        System.out.println("quick sort test");
        Integer[] sort1 = Arrays.copyOf(src, src.length);
        Arrays.sort(sort1);

        Integer[] sort2 = Arrays.copyOf(src, src.length);

        long start = System.currentTimeMillis();
        SortUtils.quick(sort2);
        long end = System.currentTimeMillis();

        assertArrayEquals(sort1, sort2);
        System.out.println("quick sort test time:"+ (end - start) + "ms");
    }
}