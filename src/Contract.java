// Contract interface
public interface Contract {
    public double getSalary();

}

// Permanent Contract
class PermanentContract implements Contract {
    private int daysWorked;
    private boolean married;
    private int numChildren;
    private double monthlySalary;
    private double childAllowance;
    static final int MONTHLY_DAYS = 20;

    public PermanentContract(int numChildren, boolean married,double monthlySalary,double childAllowance,int daysWorked) {

        this.daysWorked = daysWorked;
        this.married = married;
        this.numChildren = numChildren;
        this.monthlySalary = monthlySalary;
        this.childAllowance = childAllowance;
    }

    public int getDaysWorked() {
        return daysWorked;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public int getNumChildren() {
        return numChildren;
    }

    public double getSalary() {
        double totalAllowance = 0;
        if (married) {
            totalAllowance = numChildren * childAllowance;
        }

        return (daysWorked/MONTHLY_DAYS) * (monthlySalary + totalAllowance);
    }

    public boolean isMarried(){
        return married;
    }

    public String toString() {
        return " is a " + this.getClass().getSimpleName() + ". he is " +
                (this.isMarried() ? "" : "not") + " married and has " + this.getNumChildren() +
                " children.\nHe/She has worked for " + this.getDaysWorked() +
                " days and upon contract his/her monthly salary is " + this.getMonthlySalary() + "\n";
    }

}
// Temporary Contract
class TemporaryContract implements Contract {
    private double hourlyWage;
    private int hoursWorked;

    public TemporaryContract(double hourlyWage, int hoursWorked) {
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }
    public double getSalary() {
        return hourlyWage * hoursWorked;
    }

    public String toString() {
        return " is a " + this.getClass().getSimpleName() +
                ". he is a temporary employee with " +
                this.getHourlyWage() +
                " hourly wage and he has worked for " +
                this.getHoursWorked() + " hours" + "\n";
    }

}
