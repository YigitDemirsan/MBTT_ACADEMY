import java.util.ArrayList;
import java.util.Scanner;

class BasePayError extends Exception{
    private final String message;
    public BasePayError(){
        this.message = "Base payment must be higher than 100.00 TL";
    }
    @Override
    public String getMessage(){
        return this.message;
    }
}
class MaximumHoursError extends Exception{
    private final String message;

    public MaximumHoursError (){
        this.message = "You exceed the working hour limit.";
    }
    @Override
    public String getMessage(){
        return this.message;
    }
}
public class Main {
    public static void main(String[] args){
        ArrayList<Double> basePaymentList = new ArrayList<Double>();
        ArrayList<Integer> workingHoursList = new ArrayList<Integer>();
        double basePayment = 0;
        int workingHours = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of the employee: ");
        int numberOfEmployees = scanner.nextInt();
        for (int i = 0 ; i<numberOfEmployees ; i++){
            System.out.println("Enter the base payment of the Employee: ");
            basePayment = scanner.nextDouble();
            if (basePayment<100.00){
                try {
                    throw new BasePayError();
                } catch (BasePayError e) {
                    throw new RuntimeException(e);
                }
            }else{
                basePaymentList.add(basePayment);
            }
        }
        for (int i = 0 ; i < numberOfEmployees ; i++){
            System.out.println("Enter the working hour of the Employee: ");
            workingHours = scanner.nextInt();
            if (workingHours>60){
                try {
                    throw new MaximumHoursError();
                } catch (MaximumHoursError e) {
                    throw new RuntimeException(e);
                }
            }else{
                workingHoursList.add(workingHours);
            }
        }
        System.out.println(calculateTheSalary(numberOfEmployees,basePaymentList,workingHoursList));
        for (int i = 0; i<numberOfEmployees; i++){
            System.out.println("-------------------------");
            System.out.println("Employee:---Total salary:");
            System.out.println("Employee "+(i+1)+"--------"+calculateTheSalary(numberOfEmployees,basePaymentList,workingHoursList).get(i));
        }
    }
    public static ArrayList<Double>  calculateTheSalary(int numberOfEmployee,ArrayList<Double> basePayment,ArrayList<Integer> workingHours){
        ArrayList<Double> totalSalary = new ArrayList<>();
        double salary = 0;
        for(int i = 0; i<numberOfEmployee; i++){
            if (workingHours.get(i)>40){
                salary = (basePayment.get(i)*40)+((workingHours.get(i)-40)*(basePayment.get(i)*1.5));
                totalSalary.add(salary);
            }else{
                salary = basePayment.get(i)*workingHours.get(i);
                totalSalary.add(salary);
            }
        }
        return totalSalary;
    }
}
