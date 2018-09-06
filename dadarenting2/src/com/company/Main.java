package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception{
        Cars[] a = {new Passenger("aodiA4",500,4), new Passenger("mazida",400,4), new Pickup("pikaxue",450,4,2), new Passenger("jinlong",800,20), new Truck("songhuajiang",400,4), new Truck("yiweike",1000,20)};
        List<Cars> chosen = new ArrayList<Cars>();
        int chosenPersons = 0;
        int chosenCargos = 0;
        int totalPrice = 0;
        int choice=2;
        int wrong = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎使用答答租车");
        System.out.println("您是否要租车 1是0否");
        while(wrong == 1) {
            try {
                choice = sc.nextInt();
                if (!(choice == 0 || choice == 1)) {
                    throw new IllegalArgumentException("输入错误");
                }
                else {
                    wrong = 0;
                }
            } catch (IllegalArgumentException e) {                   //自己定义的异常+其他不知名异常？
                System.out.println("换成0或1，谢谢");
            }
        }
        if (choice == 0){
            System.out.println("Thx");
        }else if (choice == 1){
            System.out.println("您可租车的类型和价目表");
            System.out.println("序号\t汽车类型\t租金\t容量");
            for (int i =0; i<a.length; i++){
                System.out.println(i+1+"\t"+a[i].getName()+"\t"+a[i].getPrice()+"元／天\t载人"+a[i].getPersons()+"\t载货"+a[i].getCargos());
            }
            System.out.println("请输入您要租的数量");
            int num = sc.nextInt();
            for (int i =1; i<=num;i++){
                System.out.println("请输入第"+i+"辆车的序号");
                int thisNum =sc.nextInt();
                chosen.add(a[thisNum-1]);
            }
            System.out.println("请输入您要租的天数");
            int days = sc.nextInt();
            System.out.println("您的账单如下");
            System.out.println("可载人的车有：");
            for (int i = 0; i <chosen.size();i++){
                if (chosen.get(i).check()==0){
                    continue;
                }else{
                    chosenPersons+=chosen.get(i).getPersons();
                    System.out.println(chosen.get(i).getName());
                }
            }
            System.out.println("可载人："+chosenPersons);
            System.out.println("可载货的车有：");
            for (int i = 0; i <chosen.size();i++){
                if (chosen.get(i).check()==2){
                    continue;
                }else{
                    chosenCargos+=chosen.get(i).getCargos();
                    System.out.println(chosen.get(i).getName());
                }
            }
            System.out.println("可载货："+chosenCargos);
            for (int i = 0; i <chosen.size();i++){
                totalPrice+=chosen.get(i).getPrice();
            }
            System.out.println("租车总价格："+totalPrice*days);
        }
        }
    }
