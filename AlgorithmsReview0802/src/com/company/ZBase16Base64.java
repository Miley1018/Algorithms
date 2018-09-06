package com.company;

/**
 * Created by mileygao on 8/14/18.
 */
public class ZBase16Base64 {
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    public String convertToHexString(byte[] array) {
        if (array == null) {
            return "";
        }
        char[] hexChars = new char[array.length * 2];
        for (int i = 0; i < array.length; i ++) {
            int v = array[i] & 0xFF; //?
            hexChars[2 * i] = hexArray[v >>> 4]; //?
            hexChars[2 * i + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public String convertToBase64String(byte[] array) {
        if (array == null) {
            return "";
        }
        char[] base64Chars = new char[array.length * 8 / 6];
        int index = 0;
        int remain = 0;
        int remainBitN = 0;
        for (int i = 0; i < array.length; i ++) {
            int v = array[i] & 0xFF; //?
            if (remainBitN == 2) {
                base64Chars[index++] = getBase64Char((remain << 4) + (v >>> 4));
                remain = v & 0x0F;
                remainBitN = 4;
            } else if (remainBitN == 4) {
                base64Chars[index++] = getBase64Char((remain << 2) + (v >>> 6));
                remain = v & 0x3F;
                base64Chars[index++] = getBase64Char(remain);
                remain = 0;
                remainBitN = 0;
            } else {
                base64Chars[index++] = getBase64Char(v >>> 2);
                remain = v & 0x03;
                remainBitN = 2;
            }
        }
        if (remainBitN == 2) {
            return new String(base64Chars) + "-" + getBase64Char(remain);
        } else if (remainBitN == 4) {
            return new String(base64Chars) + "+" + getBase64Char(remain);
        }
        return new String(base64Chars);
    }
    private char getBase64Char(int i) {
        if (i >= 0 && i <= 9) {
            return (char) ('0' + i); //!!
        }
        if (i > 9 && i < 36) {
            return (char) ('A' + (i - 10));
        }
        if (i > 35 && i < 62) {
            return (char) ('a' + (i - 36));
        }
        if (i == 62) {
            return '$';
        } else {
            return '*';
        }
    }
    public static void main(String[] args) {
        ZBase16Base64 base16Base64 = new ZBase16Base64();
        byte[] array = {8, 0x4f, (byte)0xd3, 9}; //?
        System.out.print(base16Base64.convertToBase64String(array));
    }
}
