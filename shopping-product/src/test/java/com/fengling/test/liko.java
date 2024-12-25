package com.fengling.test;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.HashMap;
import java.util.Map;

public class liko {

    @Test
    void liko9() throws AWTException {
        int[] xy = XY();
        Robot robot = new Robot();

        // 设置点击位置的坐标
        int x = xy[0];
        int y = xy[1];

        // 设置点击间隔时间（毫秒）
        int interval = 1;


        // 设置点击次数
        int clickCount = 500000000;

        // 循环进行点击操作
        for (int i = 0; i < clickCount; i++) {
            // 模拟鼠标移动到指定位置
            robot.mouseMove(x, y);


            // 模拟鼠标左键点击
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


            // 模拟鼠标右键点击
//            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
//            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

            /*
            // 模拟键盘按下Enter键
            robot.keyPress(KeyEvent.VK_ENTER);
            // 模拟键盘释放Enter键
            robot.keyRelease(KeyEvent.VK_ENTER);
             */

            // 等待指定时间间隔
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }


    public int[] XY() {
        int[] ints = new int[2];
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        java.awt.Point coordinates = pointerInfo.getLocation();
        int x = (int) coordinates.getX();
        int y = (int) coordinates.getY();
        System.out.println("鼠标位置：(" + x + ", " + y + ")");
        ints[0] = x;
        ints[1] = y;
        return ints;
    }


    @Test
    void liko1() {
        int[] a = {8, 5, 7, 9, 1, 5, 3, 1};
        int b = 9;
        System.out.println(twoSum(a, b).toString());
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
//        for (int num :
//                nums) {
//            System.out.println("11==" + num);
//            for (int num1 :
//                    nums) {
//                System.out.println("22==" + num1);
//                if (num != num1 && num + num1 == target) {
//                    System.out.println(num + "+" + num1);
//                    ints[0] = num;
//                    ints[1] = num1;
//                    return ints;
//                }
//            }
//        }
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            System.out.println(target - nums[i] + "+" + i);
            hashMap.put(target - nums[i], i);
        }

        return null;
    }

    @Test
    void liko2() {
        System.out.println(AutSun2());
        System.out.println(AutSun());

    }

    public String AutSun2() {
        String Url2 = ".rar";
        String s4 = "0";
        for (int a = 1; a < 10; a++) {
            String s3 = new StringBuilder().append(s4).append(a).append(Url2).toString();
            String s1 = "+";
            String s5 = s3 + s1;
            System.out.print(s5);
        }
        return "";
    }

    public String AutSun() {


        for (int i = 10; i < 41; i++) {

            String Url2 = ".rar";
            String s4 = "0";


            String s = new StringBuilder().append(i).append(Url2).toString();
            String s1 = "+";
            String s2 = s + s1;
            System.out.print(s2);
        }
        return "";
    }
}
//01.rar+02.rar+03.rar+04.rar+05.rar+06.rar+07.rar+08.rar+09.rar+10.rar+11.rar+12.rar+13.rar+14.rar+15.rar+16.rar+17.rar+18.rar+19.rar+20.rar+21.rar+22.rar+23.rar+24.rar+25.rar+26.rar+27.rar+28.rar+29.rar+30.rar+31.rar+32.rar+33.rar+34.rar+35.rar+36.rar+37.rar+38.rar+39.rar+40.rar