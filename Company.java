import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company {

    static int indexOfArray = 0;
   public static void main(String[] args){

        ArrayList<Employee> emp = new ArrayList<>();
        ArrayList<EducationDetails>[] educationDetails = new ArrayList[10];

        while(true){
            System.out.println("Menu:-");
            System.out.println("1. Add Employee");
            System.out.println("2. Print all Employees");
            System.out.println("3. Print all Developers");
            System.out.println("4. Print all freshers");
            System.out.println("5. Print all Developers of work ex > 2yrs");
            System.out.println("0. Exit\n");
            System.out.println("Enter choice (0-5):");
            int choice;
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch(choice){
                case 0 :    System.exit(0);
                        break;

                case 1 :    Scanner scanner = new Scanner(System.in);
                            System.out.println("Enter Name : ");
                            String name = scanner.nextLine();
                            System.out.println("Enter Age : ");
                            int age = sc.nextInt();
                            System.out.println("Enter Designation : ");
                            String desig = scanner.nextLine();
                            while(Employee.check_designation(desig))
                            {
                                System.out.println("Invalid Designation Entered");
                                System.out.println("Enter designation : ");
                                desig = scanner.nextLine();
                            }
                            EmploymentHistory employmentHistory = new EmploymentHistory();
                            System.out.println("Are you a fresher?(y/n) : ");
                            char choose = scanner.next().charAt(0);
                            //System.out.println(choose);
                            boolean ch;
                            if((choose=='y') || (choose=='Y'))
                            {
                                ch = true;
                                //System.out.println(ch);
                            }
                            else{
                                ch = false;
                                //System.out.println(ch);
                            }
                            employmentHistory.putdata(ch);

                            System.out.println("Enter you Education Details :-");
                            choose = 'y';
                            EducationDetails education;
                            List<EducationDetails> educationDetailsList = new ArrayList<>();

                            while(choose=='y' || choose=='Y'){
                                education = new EducationDetails();
                                education.putdata();
                                educationDetailsList.add(education);
                                //educationDetails[indexOfArray].add(education);
                                System.out.println("Want to add more?(y/n) : ");
                                choose = sc.next().charAt(0);
                            }

                            Employee employee = new Employee(name,age,desig,employmentHistory, (ArrayList<EducationDetails>) educationDetailsList);
                            emp.add(employee);
                            indexOfArray++;
                            System.out.println("Employee added successfully");
                        break;

                case 2 :    for(Employee e1 : emp) {

                                e1.getname();
                                e1.getage();
                                e1.getdesig();
                                e1.employmentHistory.printdetails();
                                e1.printEducationDetails();
                                System.out.println("\n");
                            }
                        break;

                case 3 :    for(Employee e2 : emp){
                                if(e2.designation.equals("Developer"))
                                    System.out.println(e2.name);
                            }


                        break;

                case 4 :    for(Employee e3 : emp){
                                if(e3.employmentHistory.fresher) {
                                    System.out.println(e3.name);

                                }
                            }
                        break;

                case 5 :    for(Employee e4 : emp){
                                if(e4.designation.equals("Developer") && e4.employmentHistory.duration>2) {

                                    System.out.println(e4.name);

                                }
                            }
                        break;

                default:    System.out.println("Wrong choice entered");
                        break;

            }
        }
    }
}
