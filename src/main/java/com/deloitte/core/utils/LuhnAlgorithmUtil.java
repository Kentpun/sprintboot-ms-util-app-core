package com.deloitte.core.utils;

import java.util.Random;

public class LuhnAlgorithmUtil {
    // Returns true if given
    // card number is valid
    public static boolean checkLuhn(String cardNo) {
        int nDigits = cardNo.length();
        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--) {
            int d = cardNo.charAt(i) - '0';

            if (isSecond) {
                d = d * 2;
            }

            // We add two digits to handle
            // cases that make two digits
            // after doubling
            nSum += d / 10;
            nSum += d % 10;
            isSecond = !isSecond;
        }
        return (nSum % 10 == 0);
    }

    /**
     * 信用卡中间6位加密，生成新号码
     *
     * @param cardNo 信用卡号
     * @return 生成的新号码
     */
    public static String getNewNum(String cardNo) {
        int nDigits = cardNo.length();
        // 校验位
        int lastBitNum = cardNo.charAt(nDigits - 1) - '0';
        // 前6位和后4位不变
        String preSixBitNum = cardNo.substring(0, 6);
        String lastForBitNum = cardNo.substring(12);
        // 中间6位进行加密
        String midSixBitNum = cardNo.substring(6, 12);

        // 随机生成5位数字，第6位进行补位满足luhn算法
        String randomNum = String.valueOf((int)((Math.random()*9 + 1) * 10000));
        int sumNum = 0;
        for (int i = 0; i < randomNum.length(); i++) {
            int bitNum = randomNum.charAt(i) - '0';
            // 第1、3、5位需乘以2，每一位分别求和+第2、4位
            if (i % 2 == 0) {
                int tempNum = bitNum * 2;
                sumNum = sumNum + tempNum / 10;
                sumNum = sumNum + tempNum % 10;
            } else {
                sumNum += bitNum;
            }
        }

        // 加密第6位数字=(50+校验位-sumNum)%10
        int encryptSixBitNum = (50 + lastBitNum - sumNum) % 10;
        return preSixBitNum.concat(randomNum).concat(String.valueOf(encryptSixBitNum)).concat(lastForBitNum);
    }

//    public static  void main(String[] args) {
//        String cardnum = "9453677629008564"; // 9453677629008564   945367 376685 8564
//        String luhnNum = getNewNum(cardnum);
//        System.out.println(luhnNum);
//        boolean result = checkLuhn(luhnNum);
//        boolean result1 = checkLuhn(cardnum);
//        System.out.println(result1);
//        System.out.println(result);
//    }
}
