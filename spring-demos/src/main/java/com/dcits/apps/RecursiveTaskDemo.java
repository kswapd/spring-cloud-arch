package com.dcits.apps;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskDemo extends RecursiveTask<Integer> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 每个"小任务"最多只打印70个数
     */
    private static final int MAX = 30;
    private int arr[];
    private int start;
    private int end;


    public RecursiveTaskDemo(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        // 当end-start的值小于MAX时候，开始打印
       
        if((end - start) < MAX) {
            System.out.println(Thread.currentThread().getName()+"：计算线程");
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        }else {
            System.err.println(Thread.currentThread().getName() + "：任务分解线程");
            // 将大任务分解成两个小任务
            int middle = (start + end) / 2;
            RecursiveTaskDemo left = new RecursiveTaskDemo(arr, start, middle);
            RecursiveTaskDemo right = new RecursiveTaskDemo(arr, middle, end);
            // 并行执行两个小任务
            left.fork();
            right.fork();
            // 把两个小任务累加的结果合并起来
            return left.join() + right.join();
        }
    }


}
