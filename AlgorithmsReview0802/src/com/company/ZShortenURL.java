package com.company;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mileygao on 8/14/18.
 */
public class ZShortenURL {
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
    Map<String, String> map = new HashMap<>();
    int N = 10000;
    public String shortenURL(String url) {
        int shortIndex = (url.hashCode() & 0x0fffffff) % N;
        String shortURL = shortIndex + "";
        while (map.containsKey(shortURL) && !map.get(shortURL).equals(url)) {
            shortIndex += 1;
            shortURL = shortIndex % N + "";
        }
        map.put(shortURL, url);
        return shortURL;
    }
    public String shortenURLToHex(String url) {
        int shortIndex = (url.hashCode() & 0x0fffffff) % N;
        String shortURL = convertToHexString(ByteBuffer.allocate(4).putInt(shortIndex).array()) + "";
        while (map.containsKey(shortURL) && !map.get(shortURL).equals(url)) {
            shortIndex += 1;
            shortURL = convertToHexString(ByteBuffer.allocate(4).putInt(shortIndex % N).array()) + "";
        }
        map.put(shortURL, url);
        return shortURL;
    }
    public String getLong(String shortURL) {
        return map.get(shortURL);
    }
    public static void main(String[] args) {
        ZShortenURL zShortenURL = new ZShortenURL();
        System.out.println(zShortenURL.shortenURLToHex("https://docs.google.com/spreadsheets/d/1rcOvAtB2IodJUwA2vGKundyhyrFjRXd_HJrr-QaLrVg/edit#gid=0"));
        System.out.println(zShortenURL.shortenURLToHex("htt"));
        System.out.println(zShortenURL.getLong("00000E48"));
        System.out.println(0x00000E48 + "");
    }
}
//    private int hash(Key key){
  //return (key.hashCode()&0x0fffffff)%M;
   //             }
//why & ?