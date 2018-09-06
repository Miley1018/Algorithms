package com.company;

public class STBinarySearch<Key extends Comparable,Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;
    public STBinarySearch(int Max){
        keys = (Key[])new Comparable[Max];
        vals = (Value[])new Object[Max];
    }
    public void put(Key key, Value value){
        int i = binarySearch(key,0,N-1);
        if (i<N && key.compareTo(keys[i] )== 0){
            vals[i] = value;
            return;
        }
        for (int j = N; j>i; j--){
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = value;
        N++;
    }
    public Value get(Key key){
        if (isEmpty()){
            return null;
        }
        int i = binarySearch(key,0,N-1);
        if (i < N && keys[i] .compareTo(key)==0){
            return vals[i];
        }
        return null;
    }
    public boolean contains(Key key){
        int i = binarySearch(key,0,N-1);
        if (i < N && keys[i] .compareTo(key)==0){
            return true;
        }
        return false;
    }
    public void delete(Key key){
        int i = binarySearch(key,0,N-1);
        if (i < N && keys[i] .compareTo(key)==0){
            for (int j = i; j<N; j++){
                keys[j] = keys[j+1];
                vals[j] = vals[j+1];
            }
            N--;
        }
    }
    public Key min(){
        for (Key s : keys){
            System.out.println(" "+s);
        }
        return keys[0];
    }
    public Key max(){
        return keys[N-1];
    }
    public Key ceiling(Key key){
        int i = binarySearch(key,0,N-1);
        return keys[i];
    }
    public Key floor(Key key){
        int i = binarySearch(key,0,N-1);
        if (i < N && keys[i].compareTo(key)==0){
            return keys[i];
        }
        if (i>0){
            return keys[i-1];
        }else {
            return null;
        }

    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int binarySearch(Key key, int lo, int hi){
        if (hi<lo){
            return lo;
        }
        int mid = lo + (hi - lo)/2;
        if (keys[mid].equals(key)){
            return mid;
        }else if (keys[mid].compareTo(key)<0){
            return binarySearch(key,mid+1,hi);
        }else{
            return binarySearch(key,lo, mid-1);
        }
    }

    public static void main(String[] args){
        String[] a = {"c","a","v","b","c","b","b","b"};
        STBinarySearch st = new STBinarySearch(100);
        for (String s: a){
            if (st.contains(s)){
                st.put(s,(int)st.get(s)+1);
                System.out.println("N"+st.size());
            }else {
                st.put(s,1);
                System.out.println("N"+st.size());
            }
        }
        String max = "";
        st.put(max,0);
        for (String s: a){
            if ((int)st.get(s)>(int)st.get(max)){
                st.put(max,st.get(s));
            }
        }
        System.out.println(st.get(max));
        st.delete("a");
        System.out.println("size:"+st.size());
        System.out.println("min:"+st.min());
        System.out.println("max:"+st.max());
        System.out.println("ceiling:"+st.ceiling("w"));
        System.out.println("floor:"+st.floor("d"));
    }
}
