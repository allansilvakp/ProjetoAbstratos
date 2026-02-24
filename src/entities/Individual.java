package entities;

public class Individual extends TaxPayer {

    private Double healthExpenses;

    public Individual() {
        super();
    }

    public Individual(String name, Double annualIncome, Double healthExpenses) {
        super(name, annualIncome);
        this.healthExpenses = healthExpenses;
    }

    public Double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses(Double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }

    double tax = 0.0;

    @Override
    public double tax() {
        if (getAnnualIncome() < 20000.00) {
            tax = getAnnualIncome() * 0.15;
        }
        else if (getAnnualIncome() > 20000.00) {
            tax = getAnnualIncome() * 0.25;
        }

        if (healthExpenses > 0) {
            double desconto = tax - healthExpenses * 0.50;
            tax = desconto;
        }
        return tax;
    }
}
