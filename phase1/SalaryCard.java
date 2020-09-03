package phase1;

public class SalaryCard extends Card{
    private double salary;
    private double tax;

    public SalaryCard(double salary, double tax){
        super("Salary Card");
        this.salary = salary;
        this.tax =tax;
    }

    public double getSalary(){
        return this.salary;
    }

    public double getTax(){
        return this.tax;
    }

    public void raiseSalary(double raise){
        this.salary += raise;
        raiseTax();
    }

    private void raiseTax(){
        this.tax += 2000;
    }


}
