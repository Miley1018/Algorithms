package com.company;

/**
 * Created by mileygao on 5/2/17.
 */
public class MSTIndexPQ<Key extends Comparable<Key>> {
    private Key[] keys;
    private int[] pq;
    private int[] qp;
    private int N;
    public MSTIndexPQ(int N){
        pq = new int[N+1];
        keys = (Key[])new Comparable[N+1];
        qp = new int[N+1];
        for (int i = 0; i <=N; i++){
            qp[i] = -1;
        }

    }

    public void merge(Key[][] streams) {                //------cant Key[][]?
        int n = streams.length;
        int[] A = {0, 0, 0, 0};
        MSTIndexPQ<Key> pq = new MSTIndexPQ<Key>(n);
        for (int i = 0; i < n; i ++){
            pq.insert(i,streams[i][A[i]]);
            A[i] = A[i]+1;
        }
        while (!pq.isEmpty()){
            System.out.println(pq.min());
            int i =  pq.delMin();
            if (A[i]<4){
                pq.insert(i,streams[i][A[i]]);
                A[i] = A[i]+1;
            }
        }
    }
    public void insert(int k, Key key){   //
        N++;
        keys[k] = key;
        pq[N] = k;
        qp[k] = N;
        swim(N);
    }
    public Key min(){
        return keys[pq[1]];
    }
    public int delMin(){
        int index = pq[1];
        exch(1,N--);
        sink(1);
        keys[index] = null;
        qp[index] = -1;
        return index;
    }
    public int minIndex(){
        return pq[1];
    }
    public void change(int k,Key key){
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }
    public void exch(int i, int j){            //?
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        int ki = pq[i];
        int kj = pq[j];
        int n = qp[ki];
        qp[ki] = qp[kj];
        qp[kj] = n;
    }
    public void delete(int k){           //?
        int n = qp[k];
        exch(k,N--);           //? exch(n,N--);
        swim(n);
        sink(n);
        qp[k] = -1;                   //?
        keys[k] = null;                   //?
    }
    public boolean less(int i, int j){
        return keys[pq[i]].compareTo(keys[pq[j]])<0;
    }
    public void sink(int k){
        while (k<=N/2){
            int j = 2*k;
            if (j<N && less(2*k+1,2*k)){
                j = j+1;
            }
            if (less(j,k)){
                exch(j,k);
            }else{
                break;
            }
            k = 2*k;
        }
    }
    public void swim(int k){
        while (k>1&&less(k,k/2)){
            exch(k,k/2);
            k = k/2;
        }
    }

    public boolean isEmpty(){
        return N==0;
    }
    public boolean contains(int k){
        return qp[k] != -1;
    }
    public static void main(String[] args){
        Integer[][] streams ={{1,2,10,12},{0,2,3,4},{0,5,7,10},{1,6,8,11}};
        MSTIndexPQ indexMinQueue = new MSTIndexPQ(4);
        indexMinQueue.merge(streams);
    }
}
