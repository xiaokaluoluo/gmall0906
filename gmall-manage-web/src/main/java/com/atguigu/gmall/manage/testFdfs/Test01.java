package com.atguigu.gmall.manage.testFdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.IOException;

public class Test01 {
    public static void main(String[] args) throws IOException, MyException {
        ClientGlobal.init("tracker.conf");
        // 创建tracker
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer connection = trackerClient.getConnection();
        //创建storage
        StorageClient storageClient = new StorageClient(connection, null);
        String[] jpgs = storageClient.upload_file("D:\\111.jpg", "jpg", null);
        for (String jpg :jpgs){
            System.out.println(jpg);
        }


    }
}

