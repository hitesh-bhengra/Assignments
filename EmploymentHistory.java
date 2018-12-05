import java.util.Scanner;

public class EmploymentHistory {

    boolean fresher;
    String organization;
    float duration;
    int project_worked;

    public void putdata(boolean fresh){
        fresher = fresh;
        Scanner sc = new Scanner(System.in);
        if(!fresh)
        {
            //this.fresher = !fresh;
            System.out.println("Enter Previous Company : ");
            this.organization = sc.nextLine();
            System.out.println("Enter duration in the company : ");
            this.duration = sc.nextFloat();
            System.out.println("Enter number of Projects completed : ");
            this.project_worked = sc.nextInt();
        }


    }

    public void printdetails() {
        System.out.println(fresher);
        System.out.println("Company : " + organization);
        System.out.println("Duration : " + duration + "yrs");
        System.out.println("Number of projects done : " + project_worked);
    }
}
