package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list= new ArrayList<>();

        IO.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            IO.println("Tax payer #" + i + "data: ");
            IO.print("Individual or company (i/c)? ");
            char ic = sc.next().charAt(0);
            IO.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            IO.print("Anual income: ");
            double annualIncome = sc.nextDouble();

            if (ic == 'i') {
                IO.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();

                list.add(new Individual(name, annualIncome, healthExpenditures));
            }
            else if (ic == 'c') {
                IO.print("Number of employees: ");
                int numberEmplyoee = sc.nextInt();

                list.add(new Company(name, annualIncome, numberEmplyoee));
            }
        }

        IO.println();
        IO.println("TAXES PAID: ");
        for (TaxPayer t : list) {
            IO.println(t.getName() + ": $ " + String.format("%.2f", t.tax()));
        }
        IO.println();

        double totalTaxes = 0.0;

        for (TaxPayer t : list) {
            totalTaxes = totalTaxes + t.tax();
        }

        IO.println("TOTAL TAXES: $ " + String.format("%.2f", totalTaxes));




    }
}
