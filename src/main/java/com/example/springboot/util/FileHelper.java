package com.example.springboot.util;

import java.io.*;

/**
 * 文件帮助类
 * @author maikec
 */
public class FileHelper {
    private static final String path = "C:\\Users\\Administrator\\IdeaProjects\\gdjmrh\\sql";
    public static void main(String[] args) throws RuntimeException{
        File file = new File(path);
        if (file.isDirectory()){
            File[] files = file.listFiles();
            if (null != files && files.length>0){
                for (File tmp : files) {
                    if (tmp.isFile()){

                    }
                }
            }
        }
    }
}
