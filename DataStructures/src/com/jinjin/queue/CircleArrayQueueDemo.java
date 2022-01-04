package com.jinjin.queue;

import java.util.Scanner;

/**
 * @author 文进
 * @version 1.0
 * 数组模拟环形队列
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        boolean loop = true;
        CircleArray arrayQueue = new CircleArray(4);
        char key = ' ';
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
class CircleArray {
    private int maxSize;
    private int front; // 指向队列的第一个元素
    private int rear;  // 指向队列的最后一个元素的后一个位置
    private int[] arr;
    public CircleArray(int circleArrayMaxSize) {
        maxSize = circleArrayMaxSize;
        arr = new int[maxSize];
    }

    // 判断环形队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }
    // 判断环形队列是否已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 在队列中添加元素
    public void addQueue(int n) {
        // 先判断队列是否已满
        if (isFull()) {
            throw new RuntimeException("队列已满，无法添加元素");
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    // 获取队列的数据，出队列
    public int getQueue() {
        // 先判读队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取数据");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 显示队列的所有数据
    public void showQueue() {
        // 先判读队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取数据");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear - front + maxSize) % maxSize;
    }
    // 得到队列的头部数据
    public int headQueue() {
        // 先判读队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取数据");
        }
        return arr[front];
    }
}
