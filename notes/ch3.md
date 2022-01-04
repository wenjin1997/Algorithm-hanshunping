- [第3章 稀疏数组和链表](#第3章-稀疏数组和链表)
  - [3.1 稀疏数组](#31-稀疏数组)
    - [应用实例](#应用实例)
  - [3.2 队列](#32-队列)
    - [队列介绍](#队列介绍)
    - [数组模拟队列的思路](#数组模拟队列的思路)
    - [数组模拟环形队列](#数组模拟环形队列)
# 第3章 稀疏数组和链表
## 3.1 稀疏数组
当一个数组中大部分元素为0，或者为同一个值的数组时，可以使用稀疏数组来保存该数组。
稀疏数组的处理方法是:
1) 记录数组**一共有几行几列，有多少个不同的值**
2) 把具有不同值的元素的行列及值记录在一个小规模的数组中，从而**缩小程序的规模**

<img src="/img/ch3/稀疏数组.png">

<img src="/img/ch3/二维数组与稀疏数组的转换.png">

😐**课后练习**(待完成)
1) 在前面的基础上，将稀疏数组保存到磁盘上，比如 map.data
1) 恢复原来的数组时，读取map.data进行恢复

### 应用实例
* [SparseArray.java](/DataStructures/src/com/jinjin/saprsearray/SparseArray.java)

## 3.2 队列
### 队列介绍
1) 队列是一个有序列表，可以用数组或是链表来实现。
2) 遵循先入先出的原则。即:先存入队列的数据，要先取出。后存入的要后取出 
3) 示意图:(使用数组模拟队列示意图)

<img src="/img/ch3/队列.png">

### 数组模拟队列的思路
* [ArrayQueueDemo.java](/DataStructures/src/com/jinjin/queue/ArrayQueueDemo.java)
* 队列本身是有序列表，若使用数组的结构来存储队列的数据，则队列数组的声明如上图, 其中 maxSize 是该队列的最大容量。
* 因为队列的输出、输入是分别从前后端来处理，因此需要两个变量 front 及 rear 分别记录队列前后端的下标， front 会随着数据输出而改变，而 rear 则是随着数据输入而改变。
* 当我们将数据存入队列时称为”addQueue”，addQueue 的处理需要有两个步骤： 
  1. 将尾指针往后移：rear+1 , 当front == rear 【空】
  2. 若尾指针 rear 小于队列的最大下标 maxSize-1，则将数据存入 rear所指的数组元素中，否则无法存入数据。 rear  == maxSize - 1[队列满]
* 问题分析并优化
  1) 目前数组使用一次就不能用， 没有达到复用的效果
  2) 将这个数组使用算法，改进成一个**环形的队列** 取模:%

### 数组模拟环形队列
* 代码：[CircleArrayQueueDemo.java](/DataStructures/src/com/jinjin/queue/CircleArrayQueueDemo.java)
* 尾索引的下一个为头索引时表示队列满，即将队列容量空出一个作为约定,这个在做判断队列满的时候需要注意 **(rear + 1) % maxSize == front [满]** 
* **rear == front [空]**
* 队列中有效元素的个数： **(rear - front + maxSize) % maxSize**

<img src="/img/ch3/数组模拟环形队列.png">
