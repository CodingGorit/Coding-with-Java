# Java 多线程编程

提高程序的执行效率

## 线程基础

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
