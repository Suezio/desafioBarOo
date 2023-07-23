package application;
import entities.Bill;

import java.util.Locale;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sexo: ");
        char gender = scanner.next().charAt(0);

        System.out.print("Quantidade de cervejas: ");
        int beer = scanner.nextInt();

        System.out.print("Quantidade de refrigerantes: ");
        int softDrink = scanner.nextInt();

        System.out.print("Quantidade de espetinhos: ");
        int barbecue = scanner.nextInt();


        scanner.close();

        Bill bill = new Bill(gender, beer, barbecue, softDrink);
        System.out.println(bill.toString());
    }
}