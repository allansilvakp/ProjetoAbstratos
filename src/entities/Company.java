package entities;

public class Company extends TaxPayer{

    private Integer numberEmplyoee;

    public Company() {
    }

    public Company(String name, Double annualIncome, Integer numberEmplyoee) {
        super(name, annualIncome);
        this.numberEmplyoee = numberEmplyoee;
    }

    public Integer getNumberEmplyoee() {
        return numberEmplyoee;
    }

    public void setNumberEmplyoee(Integer numberEmplyoee) {
        this.numberEmplyoee = numberEmplyoee;
    }

    double tax = 0.0;

    @Override
    public double tax() {
        if (numberEmplyoee <= 10) {
            tax = getAnnualIncome() * 0.16;
        }
        else if (numberEmplyoee > 10) {
            tax = getAnnualIncome() * 0.14;
        }

        return tax;
    }
}
