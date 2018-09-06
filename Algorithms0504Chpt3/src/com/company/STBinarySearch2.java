package com.company;

/**
 * Created by mileygao on 5/9/17.
 */
public class STBinarySearch2<Key extends Comparable, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;
    public STBinarySearch2(int Max){
        keys = (Key[])new Comparable[Max];
        values = (Value[])new Comparable[Max];
    }

    public void put(Key key, Value value){
        int i = rank(key,0,N-1);
        if (i<N && key.compareTo(keys[i]) == 0){
            values[i] = value;
            return;
        }
        for (int j = N; j>i; j--){
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
        System.out.println(N);
    }

    public Value get(Key key){
        if (isEmpty()){       //------------------------------must?
            return null;
        }
        int i = rank(key,0,N-1);
        if (i<N && key.compareTo(keys[i])==0){
            return values[i];
        }
        return null;
    }

    public int rank(Key key, int lo, int hi){
        if (lo>hi){
            return lo;
        }
        int mid = lo + (hi - lo)/2;
        if (key.compareTo(keys[mid])>0){
            return rank(key,mid+1,hi);
        }else if (key.compareTo(keys[mid])<0){
            return rank(key,lo, mid-1);
        }else{
            return mid;
        }

    }

    public boolean contains(Key key){
        if (isEmpty()){
            return false;
        }
        int i = rank(key,0,N-1);
        if (i<N&& key.compareTo(keys[i])==0){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public Key min(){
        return keys[0];
    }

    public Key max(){
        return keys[N-1];
    }

    public void delete(Key key){
        if (isEmpty()){
            return;
        }
        int i = rank(key, 0, N-1);
        System.out.println(N);
        if (i<N && key.compareTo(keys[i])==0){
            for (int j = i; j<N; j++){
                keys[j] = keys[j+1];
                values[j] = values[j+1];
            }
            N--;
        }
    }

    public Key ceiling(Key key){
        int i = rank(key,0, N-1);
        return keys[i];
    }

    public Key floor(Key key){
        int i = rank(key, 0, N-1);
        if (i<N && key.compareTo(keys[i])==0){
            return key;
        }
        if (i>0){
            return keys[i-1];
        }
        return null;
    }

    public int size(){
        return N;
    }

    public void show(){
        for (Key key: keys){
            System.out.println(key);
        }
        for (Value value: values){
            System.out.println(value);
        }
    }
    public static void main(String[] args){
        String[] s = {"c","a","v","b","c","b","b","b","e","s","x","o"};
        STBinarySearch2<String,Integer> st = new STBinarySearch2(100);
        for (String s1: s) {
            if (st.contains(s1)) {
                st.put(s1,st.get(s1)+1);
            }else{
                st.put(s1,1);
            }
        }
        st.show();
        String max = "min";
        st.put(max,0);
        for (String s1: s){
            if (st.get(s1)>(st.get(max))){
                st.put(max,st.get(s1));
            }
        }
        System.out.println("max:"+st.get(max));
        st.delete("a");
        System.out.println("size:"+st.size()+"min:"+st.min()+"max:"+st.max()+st.ceiling("a")+st.floor("e"));
    }
}
