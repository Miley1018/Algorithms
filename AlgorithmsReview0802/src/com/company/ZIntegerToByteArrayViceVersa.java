package com.company;

import java.util.Arrays;

/**
 * Created by mileygao on 8/16/18.
 */
public class ZIntegerToByteArrayViceVersa {
    public byte[] intToByteArray(int num) {
        byte[] result = new byte[4];
        for (int i = 0; i < 4; i ++) {
            result[3 - i]  = (byte) (num >>> (8 * i));
        }
        return result;
    }

    public int byteArrayToInt(byte[] bytes) {
        if (bytes == null || bytes.length != 4) {
            return -1;
        }
        return bytes[0] << 24 | (bytes[1] & 0xFF) << 16 | (bytes[2] & 0xFF) << 8 | (bytes[3] & 0xFF); // ? why | , why &0xFF
    }
    public static void main(String[] args) {
        ZIntegerToByteArrayViceVersa zIntegerToByteArrayViceVersa = new ZIntegerToByteArrayViceVersa();
        int input = -120033126;
        byte [] res = zIntegerToByteArrayViceVersa.intToByteArray(input);
        for (byte i : res) {
            System.out.print(Integer.toString(i, 2) + " ");
        }
        System.out.println(zIntegerToByteArrayViceVersa.byteArrayToInt(res)); //really byte ???????
    }
}
