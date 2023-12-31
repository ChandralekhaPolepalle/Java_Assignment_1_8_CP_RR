import java.time.Year;

public class Employee {
    private String name;
    private int birthYear;
    private int age;
    private double monthlySalary = 0;
    private double rate;
    private Vehicle employeeVehicle;
    private Contract contract;

    public Employee(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.age = calculateAge();
        this.rate = 100; // default 100%
        System.out.println("We have a new employee: " + this.name +", " + this.getClass().getSimpleName().toLowerCase());
    }

    public Employee(String name, int birthYear, Vehicle employeeVehicle) {
        this.name = name;
        this.birthYear = birthYear;
        this.age = calculateAge();
        this.rate = 100; // default 100%
        this.employeeVehicle = employeeVehicle;
        System.out.println("We have a new employee: " + this.name +", " + this.getClass().getSimpleName().toLowerCase());
    }

    public Employee(String name, int birthYear, double rate) {
        this.name = name;
        this.birthYear = birthYear;
        this.age = calculateAge();
        setrate(rate);
        System.out.println("We have a new employee: " + this.name +", " + this.getClass().getSimpleName().toLowerCase());
    }

    public Employee(String name, int birthYear, double rate, Vehicle employeeVehicle) {
        this.name = name;
        this.birthYear = birthYear;
        this.age = calculateAge();
        setrate(rate);
        this.employeeVehicle = employeeVehicle;
        System.out.println("We have a new employee: " + this.name +", " + this.getClass().getSimpleName().toLowerCase());
    }

    public String getName() {
        return name;
    }

    public void setmonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getrate() {
        return rate;
    }

    public double getmonthlySalary() {
        return monthlySalary;
    }

    public void setrate(double rate) {
        if (rate < 10) {
            this.rate = 10;
        } else if (rate > 100) {
            this.rate = 100;
        } else {
            this.rate = rate;
        }
    }

    private int calculateAge() {
        return Year.now().getValue() - birthYear;
    }

    public double annualIncome() {
        double baseIncome = 12 * monthlySalary * rate;
        double bonuses = 0;
        return baseIncome + bonuses;
    }

    @Override
    public String toString() {
            return "Name: " + name + ", a " + this.getClass().getSimpleName() +
                    "\nAge: " + age +
                    ((employeeVehicle != null) ? "\nEmployee has a " + employeeVehicle.getClass().getSimpleName() +
                    "\n" + employeeVehicle : "" )+
                    "\n" + name + " has a occupation rate: " + (int)rate + "%";
    }

    public void signContract(Contract contract) {
        this.contract = contract;
    }

    public String contractInfo() {
        return name + contract;
    }
}


// Manager subclass
class Manager extends Employee {

    private int nbClients;
    private int nbTravelDays;

    static final int GAIN_FACTOR_CLIENT = 500;

    static final int GAIN_FACTOR_TRAVEL = 100;

    public Manager(String name, int birthYear, int nbClients, int nbTravelDays) {
        super(name, birthYear);
        this.nbClients = nbClients;
        this.nbTravelDays = nbTravelDays;
    }

    public Manager(String name, int birthYear, int nbClients, int nbTravelDays, Vehicle vehicle) {
        super(name, birthYear, vehicle);
        this.nbClients = nbClients;
        this.nbTravelDays = nbTravelDays;
    }

    public Manager(String name, int birthYear, int nbClients, int nbTravelDays,double rate) {
        super(name, birthYear, rate);
        this.nbClients = nbClients;
        this.nbTravelDays = nbTravelDays;
    }

    public Manager(String name, int birthYear, int nbClients, int nbTravelDays,double rate, Vehicle vehicle) {
        super(name, birthYear, rate, vehicle);
        this.nbClients = nbClients;
        this.nbTravelDays = nbTravelDays;
    }

    @Override
    public double annualIncome() {
        double baseIncome = 12 * this.getmonthlySalary() * this.getrate();
        double bonuses = 0;
        double clientBonus = GAIN_FACTOR_CLIENT * this.nbClients;
        double travelBonus = GAIN_FACTOR_TRAVEL * this.nbTravelDays;
        bonuses = clientBonus + travelBonus;
        return baseIncome + bonuses;
    }
    @Override
    public String toString() {

        return super.toString() +
                " He/She travelled " + nbTravelDays +" days and has brought " +
                nbClients + " new clients."+
                "\nHis/Her estimated annual income is "+ annualIncome();
    }
}

class Tester extends Employee {
    private int nbBugs;
    static final int GAIN_FACTOR_ERROR = 10;
    public Tester(String name, int birthYear, int nbBugs) {
        super(name, birthYear);
        this.nbBugs = nbBugs;
    }
    public Tester(String name, int birthYear, int nbBugs, Vehicle vehicle) {
        super(name, birthYear, vehicle);
        this.nbBugs = nbBugs;
    }
    public Tester(String name, int birthYear, int nbBugs, double rate) {
        super(name, birthYear,rate);
        this.nbBugs = nbBugs;
    }

    public Tester(String name, int birthYear, int nbBugs, double rate, Vehicle vehicle) {
        super(name, birthYear,rate, vehicle);
        this.nbBugs = nbBugs;
    }

    @Override
    public double annualIncome() {
        double baseIncome = 12 * this.getmonthlySalary() * this.getrate();
        double bonuses = GAIN_FACTOR_ERROR * this.nbBugs;
        return baseIncome + bonuses;
    }

    @Override
    public String toString() {
        return super.toString() +
                " and corrected " + nbBugs + " bugs."+
                "\nHis/Her estimated annual income is "+ annualIncome();
    }

}

class Programmer extends Employee {

    private int nbProjects;
    static final int GAIN_FACTOR_PROJECTS = 200;

    public Programmer(String name, int birthYear, int nbProjects) {
        super(name, birthYear);
        this.nbProjects = nbProjects;
    }

    public Programmer(String name, int birthYear, int nbProjects, Vehicle vehicle) {
        super(name, birthYear, vehicle);
        this.nbProjects = nbProjects;
    }

    public Programmer(String name, int birthYear, int nbProjects,double rate) {
        super(name, birthYear, rate);
        this.nbProjects = nbProjects;
    }

    public Programmer(String name, int birthYear, int nbProjects,double rate, Vehicle vehicle) {
        super(name, birthYear, rate, vehicle);
        this.nbProjects = nbProjects;
    }

    @Override
    public double annualIncome() {
        double baseIncome = 12 * this.getmonthlySalary() * this.getrate();
        double bonuses = GAIN_FACTOR_PROJECTS * this.nbProjects;
        return baseIncome + bonuses;
    }

    @Override
    public String toString() {
        return super.toString() +
                " and completed " + nbProjects + " projects." +
                "\nHis/Her estimated annual income is "+ annualIncome();
    }

}

