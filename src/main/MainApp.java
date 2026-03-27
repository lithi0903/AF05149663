package main;

import dao.HotelDAO;
import model.Hotel;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelDAO dao = new HotelDAO();

        while (true) {
            System.out.println("\n--- HOTEL MANAGEMENT ---");
            System.out.println("1. Add Hotel");
            System.out.println("2. View Hotels");
            System.out.println("3. Update Hotel");
            System.out.println("4. Delete Hotel");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Location: ");
                    String location = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    dao.addHotel(new Hotel(name, location, price));
                    break;

                case 2:
                    List<Hotel> list = dao.getAllHotels();
                    for (Hotel h : list) {
                        System.out.println(h.getId() + " | " +
                                h.getName() + " | " +
                                h.getLocation() + " | " +
                                h.getPrice());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("New Location: ");
                    String newLoc = sc.nextLine();

                    System.out.print("New Price: ");
                    double newPrice = sc.nextDouble();

                    dao.updateHotel(new Hotel(uid, newName, newLoc, newPrice));
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    dao.deleteHotel(did);
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}