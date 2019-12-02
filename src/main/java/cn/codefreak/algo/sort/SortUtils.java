package cn.codefreak.algo.sort;

import java.io.Serializable;

/**
 * 基本排序算法实现
 * @author CodeFreak
 * @version 1.0
 */
public class SortUtils implements Serializable {
    private final static long serialVersionUID = 1L;

    private static <E> void swap(E[] elements, int i, int j) {
        E temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    /**
     * 冒泡排序
     *
     * @param elements
     * @param <E>
     */
    public static <E extends Comparable<E>> void bubble(E[] elements) {
        for (int i = 0; i < elements.length - 1; i++) {
            boolean changeFlag = false;
            for (int j = 0; j < elements.length - 1 - i; j++) {
                if (elements[j].compareTo(elements[j + 1]) > 0) {
                    changeFlag = true;
                    swap(elements, j, j + 1);
                }
            }
            // 没有交换数据，表示数据已经有序
            if (!changeFlag)
                break;
        }
    }

    /**
     * 选择排序
     *
     * @param elements
     * @param <E>
     */
    public static <E extends Comparable<E>> void insertion(E[] elements) {
        // i 的初值为排序开始第一个无序的元素索引
        for (int i = 1; i < elements.length; i++) {
            // j 初值为有序表中最后一个元素的索引
            int j = i - 1;
            E temp = elements[i];
            while (j >= 0 && temp.compareTo(elements[j]) < 0) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = temp;
        }
    }

    /**
     * 插入排序
     * @param elements
     * @param <E>
     */
    public static <E extends Comparable<E>> void selection(E[] elements) {
        for (int i = 0; i < elements.length-1; i++) {
            for (int j = i+1; j < elements.length; j++) {
                if(elements[i].compareTo(elements[j]) > 0){
                    swap(elements, i, j);
                }
            }
        }
    }
}