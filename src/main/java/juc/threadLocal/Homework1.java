package juc.threadLocal;

import java.io.File;

/**
 * Created by wangxiang on 2022/8/2
 */
public class Homework1 {

    public static void main(String[] args) {
        File file = new File("D:/test");
        deleteFile(file);
        file.delete();//删除根目录
        if (!file.exists()) {
            System.out.println("删除成功");
        }
    }

    public static void deleteFile(File file) {
        File[] files = file.listFiles();// 将file子目录及子文件放进文件数组
        if (files == null || files.length == 0) {
            file.delete();
        }
        if (files != null) {// 如果包含文件进行删除操作
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {// 删除子文件
                    files[i].delete();
                } else if (files[i].isDirectory()) {// 通过递归方法删除子目录的文件
                    deleteFile(files[i]);
                }
            }
        }
    }
}
