package cn.codefreak.algo.sort;

import java.io.Serializable;
import java.util.Arrays;

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

    /**
     * 归并排序
     * @param elements
     * @param <E>
     */
    public static <E extends Comparable<E>> void merge(E[] elements) {
        mergeSort(elements, 0, elements.length-1);
    }

    /**
     * 归并排序重载方法
     * @param elements
     * @param start
     * @param end
     * @param <E>
     */
    private static <E extends Comparable<E>> void mergeSort(E[] elements, int start, int end) {
        if (start >= end) return;

        int mid = start + (end-start)/2;
        mergeSort(elements, start, mid);
        mergeSort(elements, mid+1, end);
        _merge(elements, start, mid, end);
    }

    /**
     * 合并数组两个有序的部分, 不带哨兵
     * @param elements
     * @param start
     * @param mid
     * @param end
     * @param <E>
     */
    private static <E extends Comparable<E>> void _merge(E[] elements, int start, int mid, int end) {
        E[] temps = (E[])new Comparable[end - start + 1];
        int i = start;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= end){
            if(elements[i].compareTo(elements[j]) < 0){
                temps[k++] = elements[i++];
            }else{
                temps[k++] = elements[j++];
            }
        }

        while (i <= mid)
            temps[k++] = elements[i++];
        while (j <= end)
            temps[k++] = elements[j++];

        i = start;k = 0;
        while (i <= end)
            elements[i++] = temps[k++];
    }

//    /**
//     * 合并数组中两个有序的部分，使用哨兵方式, 目前不完整
//     * @param elements
//     * @param start
//     * @param mid
//     * @param end
//     * @param <E>
//     */
//    private static <E extends Comparable<E>> void _merge(E[] elements, int start, int mid, int end) {
//        // 左边有序数组的大小
//        int leftSize = mid - start + 1;
//        // 右边有序数组的大小
//        int rightSize = end - mid;
//
//        E[] leftTemps = (E[])new Comparable[leftSize+1];
//        E[] rightTemps = (E[])new Comparable[rightSize+1];
//        System.arraycopy(elements, start, leftTemps, mid, leftSize);
//        System.arraycopy(elements, mid+1, rightTemps, end, rightSize);
//
//    }

    /**
     * 快速排序
     * @param elements
     * @param <E>
     */
    public static <E extends Comparable<E>> void quick(E[] elements) {
        quickSort(elements, 0, elements.length-1);
    }

    /**
     * 快速排序实现
     * @param elements
     * @param start
     * @param end
     * @param <E>
     */
    private static <E extends Comparable<E>> void quickSort(E[] elements, int start, int end){
        if(start >= end) return;

        int pivotIndex = partition(elements, start, end);
        quickSort(elements, start, pivotIndex-1);
        quickSort(elements, pivotIndex+1, end);
    }

    /**
     * 获取分区索引
     * @param elements
     * @param start
     * @param end
     * @param <E>
     * @return
     */
    private static <E extends Comparable<E>> int partition(E[] elements, int start, int end){
        E pivot = elements[end];
        int i = start;
        int j = start;
        while (j <= end){
            if(elements[j].compareTo(pivot) < 0){
                swap(elements, i, j);
                i++;
            }
            j++;
        }
        swap(elements, i, end);
        return i;
    }



}