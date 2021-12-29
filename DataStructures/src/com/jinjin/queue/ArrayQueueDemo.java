package com.jinjin.queue;

import java.util.Scanner;

/**
 * @author 文进
 * @version 1.0
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        boolean loop = true;
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    try {
                        arrayQueue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    try{
                        System.out.println("输入一个数");
                        int n = scanner.nextInt();
                        arrayQueue.addQueue(n);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("头部数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出～");
    }
}

// 使用数组模拟队列
class ArrayQueue {
    private int maxSize; // 队列的最大容量
    private int front; // 队列的头部
    private int rear; // 队列的尾部
    private int[] arr; // 队列

    public ArrayQueue(int size) {
        maxSize = size;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    // 队列是否已满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 在队列中添加元素
    public void addQueue(int n) {
        // 先判断队列是否已满
        if (isFull()) {
            throw new RuntimeException("队列已满，无法添加元素");
        }
        rear++;
        arr[rear] = n;
    }

    // 获取队列的数据，出队列
    public int getQueue() {
        // 先判读队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取数据");
        }
        front++;
        return arr[front];
    }

    // 显示队列的所有数据
    public void showQueue() {
        // 先判读队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    // 得到队列的头部数据
    public int headQueue() {
        // 先判读队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取数据");
        }
        return arr[front + 1];
    }
}
