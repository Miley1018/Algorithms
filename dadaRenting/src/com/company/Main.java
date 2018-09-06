package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("欢迎使用答答租车：\n 您是否要租车：1是0否");
        Scanner scanner = new Scanner(System.in);
        String get = scanner.nextLine();
        if (get.equals("0")){
            System.out.println("Thx");
        }else if(get.equals("1")){
            System.out.println("您可租车的类型及其价目表");
            System.out.println("序号\t汽车类型\t租金\t容量");
            Cars[] cars={new Passengers("aodiA4",500,4), new Passengers("mazida",400,4), new Pickup("pikaxue6",450,2,4),new Passengers("jinlong",800,20),new Truck("songhuajiang",400,4),new Truck("yiweike",1000,20)};
            int n=cars.length;
            for (int i = 0; i <= n-1; i++){
                System.out.println((i+1)+"\t"+cars[i].get());
            }

            System.out.println("请输入您要租的数量：");
            int num = scanner.nextInt();
            Cars[] usecars = new Cars[num];
            for (int i = 1; i <= num; i++){
                System.out.println("请输入第"+i+"辆车的序号");
                int o = scanner.nextInt();
                usecars[i-1]=cars[o-1];
            }

            System.out.println("请输入租用的天数：");
            int days = scanner.nextInt();

            System.out.println("您的账单：");
            System.out.println("可载人的车有：");
            int tp=0;
            for (int i = 0;i <= usecars.length-1; i++){
                if ((usecars[i].check()==2)||(usecars[i].check()==0)){
                    System.out.print(usecars[i].getName()+"\t");
                    tp+=usecars[i].getPersons();
                }
            }
            System.out.println("可载人："+tp);


            System.out.println("可载货的车有：");
            int ta=0;
            for (int i = 0;i <= usecars.length-1; i++){
                if ((usecars[i].check()==1)||(usecars[i].check()==0)){
                    System.out.print(usecars[i].getName()+"\t");
                    ta+=usecars[i].getVolumn();
                }
            }
            System.out.println("可载货："+ta);

            System.out.print("租车总价格：");
            int tpr=0;
            for (int i = 0;i <= usecars.length-1; i++){
                    tpr+=usecars[i].getPrice();
            }
            tpr=tpr*days;
            System.out.println(tpr+"元");

        }else{
            System.out.print("please change your choice to 1 or 0");
        }}
}
