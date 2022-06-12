package com.shenlimin;

import lombok.Data;

@Data
@SuppressWarnings("all")
public class Demo01 {

    //变量
    private String content;

    public static void main1(String[] args) {
        Demo01 demo01 = new Demo01();
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
     * 线程对应的数据对应不上
     *
     * 线程1--->:线程0的数据
     * 线程0--->:线程0的数据
     * 线程2--->:线程2的数据
     * 线程3--->:线程3的数据
     * 线程4--->:线程4的数据
     */
}
