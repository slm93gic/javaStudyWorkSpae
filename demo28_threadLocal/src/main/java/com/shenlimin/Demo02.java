package com.shenlimin;

import lombok.Data;

/**
 * 优化
 */
@SuppressWarnings("all")
public class Demo02 {

    ThreadLocal<String> tl = new ThreadLocal<>();

    public void setContent(String content) {
        tl.set(content);
    }

    public String getContent() {
        return tl.get();
    }

    //变量
    private String content;

    public static void main(String[] args) {
        Demo02 demo01 = new Demo02();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    demo01.setContent(Thread.currentThread().getName() + "的数据");
                    System.out.println(Thread.currentThread().getName() + "--->" + demo01.getContent());
                }
            });
            thread.setName("线程" + i);
            thread.start();
        }
    }

    /**
     * 线程0--->线程0的数据
     * 线程1--->线程1的数据
     * 线程2--->线程2的数据
     * 线程3--->线程3的数据
     * 线程4--->线程4的数据
     */

}
