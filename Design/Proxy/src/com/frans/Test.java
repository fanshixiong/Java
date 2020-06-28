package com.frans;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test{
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一行整数值, 以逗号分隔:");
        String line = reader.readLine();
        String[] split = line.split(",");
        int sum = 0;
        for (String s : split) {
            if(s.trim().length() > 0) {
                //trim() 去掉头尾空格
                sum += Integer.parseInt(s.trim());
            }
        }
        System.out.println("和为：" + sum);
    }
}

/**
 * 输出第一个字符是‘?’
 * Windows 记事本的BOM头，有？，需要处理
 **/