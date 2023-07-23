package entities;

import java.text.DecimalFormat;

public class Bill {
    public char gender;
    public int beer;
    public int barbecue;
    public int softDrink;
    private double beerPrice = 5.00;
    private double barbecuePrice = 7.00;
    private double softDrinkPrice = 3.00;
    private double maleTicketPrice = 10.00;
    private double femaleTicketPrice = 8.00;
    private double coverCharge = 4.00;

    public Bill(char gender, int beer, int barbecue, int softDrink) {
        this.gender = gender;
        this.beer = beer;
        this.barbecue = barbecue;
        this.softDrink = softDrink;
    }

    private double calculateConsumption() {
        double totalBeer = beer * beerPrice;
        double totalBarbecue = barbecue * barbecuePrice;
        double totalSoftDrink = softDrink * softDrinkPrice;

        return totalBeer + totalBarbecue + totalSoftDrink;
    }

    private double cover() {
        double consumption = calculateConsumption();
        return consumption > 30.00 ? 0.00 : coverCharge;
    }

    private double feeding() {
        return calculateConsumption() + cover();
    }

    private double ticket() {
        return gender == 'F' ? femaleTicketPrice : maleTicketPrice;
    }

    public double total() {
        return feeding() + ticket();
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");

        StringBuilder sb = new StringBuilder();
        sb.append("\nRELATÓRIO:");
        sb.append("\nConsumo = R$ ").append(df.format(calculateConsumption())).append("\n");
        if (cover() > 0) {
            sb.append("Couvert = R$ ").append(df.format(cover())).append("\n");
        } else {
            sb.append("Isento de Couvert\n");
        }
        sb.append("Ingresso = R$ ").append(df.format(ticket())).append("\n");
        sb.append("Valor a pagar = R$ ").append(df.format(total())).append("\n");

        return sb.toString();
    }
}