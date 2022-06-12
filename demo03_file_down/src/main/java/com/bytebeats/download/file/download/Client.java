package com.bytebeats.download.file.download;

import java.util.concurrent.CountDownLatch;

public class Client {
    public static void main(String[] args) {
        int threadSize = 10;
        String serverPath = "https://cloud.centos.org/centos/7/vagrant/x86_64/images/CentOS-7-x86_64-Vagrant-2004_01.VirtualBox.box";
        String localPath = "VirtualBox.box";
        CountDownLatch latch = new CountDownLatch(threadSize);
        MutiThreadDownLoad m = new MutiThreadDownLoad(threadSize, serverPath, localPath, latch);
        long startTime = System.currentTimeMillis();
        try {
            m.executeDownLoad();
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("全部下载结束,共耗时" + (endTime - startTime) / 1000 + "s");
    }
}
