package com.company;

import java.util.ArrayList;

import java.util.Scanner;

class GarageAccount {
    int balance;
    int amount;

    int deposit() {
        balance = balance + amount;
        return balance;
    }

    void showBalance() {
        System.out.println(balance);
    }
}
class Vehicle{
    int amount;
    String name;
    Vehicle(int amount,String name){
        this.amount=amount;
        this.name=name;
    }
}
class Bike extends Vehicle{


    Bike() {

        super(200, "Bike");
    }
}

class Car extends Vehicle{
    Car(){
        super(500,"Car");
    }
}


public class Main {

    public static void main(String[] args) {
        // write your code here
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        boolean notCheckingBalance = true;
        GarageAccount g = new GarageAccount();
        g.balance=0;
        int siz = 2;


        System.out.println("Initial account balance is:"+g.balance);

       while (notCheckingBalance) {



            while (vehicleList.size()<siz){
               System.out.println("Enter the vehicle type which you want to repair(Type Car or Bike ):");
               Scanner sc = new Scanner(System.in);
               String vehicle = sc.nextLine();



               switch (vehicle ) {
                   case "Car":
                       vehicleList.add(new Car());
                       System.out.println("Car is being repaired");
                       break;
                   case "Bike":
                       vehicleList.add(new Bike());
                       System.out.println("Bike is being repaired");
                       break;

                   default:
                       System.out.println("Services not available for this vehicle.Only for Cars and Bikes");
               }}



           System.out.println("Do you want to check account balance,type yes or no:");
           Scanner s2 = new Scanner(System.in);
           String check = s2.nextLine();
           switch (check) {
               case "yes":
                   notCheckingBalance = false;
                   break;
               case "no":
                   notCheckingBalance = true;
                   siz +=  2;
                   break;


               default:
                   System.out.println("Enter a valid input!!");

           }

       }


        int AccountBalance = 0;
        for (Vehicle i : vehicleList) {
            AccountBalance = AccountBalance + i.amount;
        }
        g.balance=AccountBalance ;
        System.out.println("The account balance is:"+g.balance);

    }
}


