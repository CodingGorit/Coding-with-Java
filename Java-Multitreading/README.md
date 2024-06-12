# Java 多线程编程

提高程序的执行效率

## 一、线程基础

### 进程与线程


### 同步 与 异步
常见于 JavaScript 单线程语言中

### 并行 与 并发

并行：多个任务同步执行
并发：侧重于多个任务交替执行

<font color='red'>高并发</font>： 瞬时流量 （负载均衡，集群，主从复制）

### 线程生命周期

Thread thread = new Thread();
thread.start(); // 调用 start，线程并未执行

1. start
2. runnable 获取 CPU 调度才可以执行 （获取时间片）
3. running -> terminal (调用 stop) -> blocked （sleep 或 wait | 获得锁） -> runnable（CPU 调度，被放弃执行 | 主动调用 yield） -> running
4. sleep/await -> blocked （stop）  
5. notify, notifyAll

### 使用多线程  (unit2/Test2 | Test1)

1. 继承 Thread
2. 实现 Runnable 接口
3. 实现 Callable 接口
4. 线程池
5. Timer （不严谨）

重写 run 方法，编写自己的业务逻辑

> 创建线程的方式只有一种 new Thread

### 守护线程 （unit2/Test3)

用来处理后台任务

> 处理线程额外逻辑，附加逻辑
- GC

## 二、线程常见 API (unit2/Test4)