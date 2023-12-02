import java.time.Year;

public class Employee {
    private String name;
    private int birthYear;
    private int age;
    private double monthlyIncome = 0;
    private double occupationRate;
    private Vehicle employeeVehicle;

    public Employee(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.age = calculateAge();
        this.occupationRate = 100; // default 100%
    }

    public Employee(String name, int birthYear, Vehicle employeeVehicle) {
        this.name = name;
        this.birthYear = birthYear;
        this.age = calculateAge();
        this.occupationRate = 100; // default 100%
        this.employeeVehicle = employeeVehicle;
    }

    public Employee(String name, int birthYear, double occupationRate) {
        this.name = name;
        this.birthYear = birthYear;
        this.age = calculateAge();
        setOccupationRate(occupationRate);
    }

    public Employee(String name, int birthYear, double occupationRate, Vehicle employeeVehicle) {
        this.name = name;
        this.birthYear = birthYear;
        this.age = calculateAge();
        setOccupationRate(occupationRate);
        this.employeeVehicle = employeeVehicle;
    }

    public String getName() {
        return name;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public double getOccupationRate() {
        return occupationRate;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setOccupationRate(double occupationRate) {
        if (occupationRate < 10) {
            this.occupationRate = 10;
        } else if (occupationRate > 100) {
            this.occupationRate = 100;
        } else {
            this.occupationRate = occupationRate;
        }
    }

    private int calculateAge() {
        return Year.now().getValue() - birthYear;
    }

    public double annualIncome() {
        double baseIncome = 12 * monthlyIncome * occupationRate;
        double bonuses = 0;
        return baseIncome + bonuses;
    }

    @Override
    public String toString() {
        if (employeeVehicle != null) {
            return "Name: " + name + ", a " + this.getClass().getSimpleName() +
                    "\nAge: " + age +
                    "\nEmployee has a " + employeeVehicle.getClass().getSimpleName() +
                    "\n"+employeeVehicle+
                    "\n" + name + " has a occupation rate: " + occupationRate + "%";
        } else {
            return "Name: " + name + ", a " + this.getClass().getSimpleName() +
                    "\nAge: " + age +
                    "\n" + name + " has a occupation rate: " + occupationRate + "%";
        }
    }
}

// Manager subclass
class Manager extends Employee {

    private int numOfClients;
    private int daysTravelled;

    static final int GAIN_FACTOR_CLIENT = 500;

    static final int GAIN_FACTOR_TRAVEL = 100;

    public Manager(String name, int birthYear, int numOfClients, int daysTravelled) {
        super(name, birthYear);
        this.numOfClients = numOfClients;
        this.daysTravelled = daysTravelled;

        System.out.println("We have a new employee: " + this.getName() + ", a manager.");
    }

    public Manager(String name, int birthYear, int numOfClients, int daysTravelled, Vehicle vehicle) {
        super(name, birthYear, vehicle);
        this.numOfClients = numOfClients;
        this.daysTravelled = daysTravelled;
        System.out.println("We have a new employee: " + this.getName() + ", a manager.");
    }

    public Manager(String name, int birthYear, int numOfClients, int daysTravelled,double occupationRate) {
        super(name, birthYear, occupationRate);
        this.numOfClients = numOfClients;
        this.daysTravelled = daysTravelled;

        System.out.println("We have a new employee: " + this.getName() + ", a manager.");
    }

    public Manager(String name, int birthYear, int numOfClients, int daysTravelled,double occupationRate, Vehicle vehicle) {
        super(name, birthYear, occupationRate, vehicle);
        this.numOfClients = numOfClients;
        this.daysTravelled = daysTravelled;

        System.out.println("We have a new employee: " + this.getName() + ", a manager.");
    }

    @Override
    public double annualIncome() {
        double baseIncome = 12 * this.getMonthlyIncome() * this.getOccupationRate();
        double bonuses = 0;
        double clientBonus = GAIN_FACTOR_CLIENT * this.numOfClients;
        double travelBonus = GAIN_FACTOR_TRAVEL * this.daysTravelled;
        bonuses = clientBonus + travelBonus;
        return baseIncome + bonuses;
    }
    @Override
    public String toString() {

        return super.toString() +
                " He/She travelled " + daysTravelled +" days and has brought " +
                numOfClients + " new clients."+
                "\nHis/Her estimated annual income is "+ annualIncome();
    }
}

class Tester extends Employee {
    private int bugsSolved;
    static final int GAIN_FACTOR_ERROR = 10;
    public Tester(String name, int birthYear, int bugsSolved) {
        super(name, birthYear);
        this.bugsSolved = bugsSolved;

        System.out.println("We have a new employee: " + this.getName() + ", a tester.");
    }
    public Tester(String name, int birthYear, int bugsSolved, Vehicle vehicle) {
        super(name, birthYear, vehicle);
        this.bugsSolved = bugsSolved;
        System.out.println("We have a new employee: " + this.getName() + ", a tester.");
    }
    public Tester(String name, int birthYear, int bugsSolved, double occupationRate) {
        super(name, birthYear,occupationRate);
        this.bugsSolved = bugsSolved;
        System.out.println("We have a new employee: " + this.getName() + ", a tester.");
    }

    public Tester(String name, int birthYear, int bugsSolved, double occupationRate, Vehicle vehicle) {
        super(name, birthYear,occupationRate, vehicle);
        this.bugsSolved = bugsSolved;
        System.out.println("We have a new employee: " + this.getName() + ", a tester.");
    }

    @Override
    public double annualIncome() {
        double baseIncome = 12 * this.getMonthlyIncome() * this.getOccupationRate();
        double bonuses = GAIN_FACTOR_ERROR * this.bugsSolved;
        return baseIncome + bonuses;
    }

    @Override
    public String toString() {
        return super.toString() +
                " and corrected " + bugsSolved + " bugs."+
                "\nHis/Her estimated annual income is "+ annualIncome();
    }

}

class Programmer extends Employee {

    private int projectsCompleted;
    static final int GAIN_FACTOR_PROJECTS = 200;

    public Programmer(String name, int birthYear, int projectsCompleted) {
        super(name, birthYear);
        this.projectsCompleted = projectsCompleted;

        System.out.println("We have a new employee: " + this.getName() + ", a programmer.");
    }

    public Programmer(String name, int birthYear, int projectsCompleted, Vehicle vehicle) {
        super(name, birthYear, vehicle);
        this.projectsCompleted = projectsCompleted;

        System.out.println("We have a new employee: " + this.getName() + ", a programmer.");
    }

    public Programmer(String name, int birthYear, int projectsCompleted,double occupationRate) {
        super(name, birthYear, occupationRate);
        this.projectsCompleted = projectsCompleted;

        System.out.println("We have a new employee: " + this.getName() + ", a programmer.");
    }

    public Programmer(String name, int birthYear, int projectsCompleted,double occupationRate, Vehicle vehicle) {
        super(name, birthYear, occupationRate, vehicle);
        this.projectsCompleted = projectsCompleted;

        System.out.println("We have a new employee: " + this.getName() + ", a programmer.");
    }

    @Override
    public double annualIncome() {
        double baseIncome = 12 * this.getMonthlyIncome() * this.getOccupationRate();
        double bonuses = GAIN_FACTOR_PROJECTS * this.projectsCompleted;
        return baseIncome + bonuses;
    }

    @Override
    public String toString() {
        return super.toString() +
                " and completed " + projectsCompleted + " projects." +
                "\nHis/Her estimated annual income is "+ annualIncome();
    }

}

