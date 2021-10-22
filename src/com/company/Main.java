package com.company;

import java.util.ArrayList;


import java.util.Scanner;


class Vehicle {
    int amount;
    String name;

    Vehicle(int amount, String name) {
        this.amount = amount;
        this.name = name;
    }
}

class Bike extends Vehicle {


    Bike() {

        super(200, "Bike");
    }
}

class Car extends Vehicle {
    Car() {
        super(500, "Car");
    }
}


public class Main {

    public static void main(String[] args) {
        // write your code here


        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        boolean notCheckingBalance = true;
        boolean checkingBalance = true;
        int accountBalance = 0;
        int siz = 2;
        boolean goingBack = true;
        boolean onlyOneVehicle = false;


        while (goingBack) {

            System.out.println("Initial account balance is:" + accountBalance);

            while (notCheckingBalance) {


                while (vehicleList.size() < siz) {
                    System.out.println("Enter the vehicle type which you want to repair(Type \"Car\" or \"Bike\" ):");
                    Scanner sc = new Scanner(System.in);
                    String vehicle = sc.nextLine();


                    switch (vehicle) {
                        case "Car":
                            vehicleList.add(new Car());
                            System.out.println("Car is being repaired");
                            break;
                        case "Bike":
                            vehicleList.add(new Bike());
                            System.out.println("Bike is being repaired");

                            break;
                        case "":

                            if (siz - vehicleList.size() == 2) {
                                System.out.println("Nothing to repair");
                            } else {
                                System.out.println("Repairing only 1 vehicle ");
                                siz--;
                                onlyOneVehicle = true;
                            }


                            break;

                        default:
                            System.out.println("Services not available for this vehicle.Only for Cars and Bikes");
                            break;

                    }
                }


                System.out.println("Do you want to check account balance,ongoing repairs and repaired vehicle summary?, type yes or no:");
                System.out.println("Type \"exit\" to exit from the loop");
                Scanner s2 = new Scanner(System.in);
                String check = s2.nextLine();
                switch (check) {
                    case "yes":

                        notCheckingBalance = false;
                        checkingBalance = true;
                        break;
                    case "no":

                        siz += 2;
                        break;
                    case "exit":
                        notCheckingBalance = false;
                        checkingBalance = false;
                        goingBack = false;
                        break;


                    default:
                        System.out.println("Enter a valid input!!");

                }

            }
            while (checkingBalance) {
                System.out.println("Press \"1\" for checking account balance");

                System.out.println("Press \"2\" for checking ongoing repairs");
                System.out.println("Press \"3\" for checking repaired vehicles summary:");
                System.out.println("Press \"0\" to exit ");
                System.out.println("Press \"5\" to go back and add more elements");


                Scanner se = new Scanner(System.in);
                int choices = se.nextInt();


                switch (choices) {

                    case 1:
                        int repairedVehicles1;
                        if (onlyOneVehicle) {

                            repairedVehicles1 = vehicleList.size() - 1;

                        } else {

                            repairedVehicles1 = vehicleList.size() - 2;


                        }
                        for (int k = 0; k < repairedVehicles1; k++) {


                            accountBalance = accountBalance + vehicleList.get(k).amount;


                        }


                        System.out.println("The account balance is:" + accountBalance);
                        break;


                    case 2:
                        try {

                            if (onlyOneVehicle) {
                                int firstOngoingRepairs = vehicleList.size() - 1;
                                System.out.println("The ongoing repairs are of : " + vehicleList.get(firstOngoingRepairs).name);
                            } else {
                                int firstOngoingRepairs = vehicleList.size() - 2;
                                int secondOngoingRepairs = vehicleList.size() - 1;
                                System.out.println("The ongoing repairs are of : " + vehicleList.get(firstOngoingRepairs).name + " and " + vehicleList.get(secondOngoingRepairs).name);
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("No vehicles to repair");
                        }
                        break;
                    case 3:
                        int repairedVehicles2;
                        if (onlyOneVehicle) {
                            repairedVehicles2 = vehicleList.size();
                        } else {
                            repairedVehicles2 = vehicleList.size() - 2;
                        }
                        int carCount = 0;
                        int bikeCount = 0;
                        for (int j = 0; j < repairedVehicles2; j++) {
                            if ((vehicleList.get(j).name).equals("Car")) {
                                carCount++;
                            } else if ((vehicleList.get(j).name).equals("Bike")) {
                                bikeCount++;
                            }
                        }
                        System.out.println("cars = " + carCount + ": cost = " + carCount * 500 + ", bikes = " + bikeCount + ": cost = " + bikeCount * 200);

                        break;

                    case 0:

                        checkingBalance = false;
                        goingBack = false;
                        break;

                    case 5:
                        notCheckingBalance = true;
                        checkingBalance = false;
                        siz += 2;
                        break;


                    default:
                        System.out.println("Enter a valid input");


                }
            }
        }

    }
}


