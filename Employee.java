import java.util.*;

public class Employee {
    String name;
    int age;
    String designation;
    EmploymentHistory employmentHistory;
    public ArrayList<EducationDetails> educationDetailsList;



    Employee(String name, int age, String designation,EmploymentHistory emp,ArrayList<EducationDetails> edu)
    {
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.employmentHistory = emp;
        this.educationDetailsList = edu;
    }

    void getname() {
        System.out.println("Name : " + name);
    }
    void getage() {
        System.out.println("Age : " + age);
    }
    void getdesig() {
        System.out.println("Designation : " + designation);
    }

    void printEducationDetails(){
        for(EducationDetails edu : educationDetailsList)
        {
            edu.printdata();
        }
    }


    public static boolean check_designation(String designation) {

        String[] validDesignation = {"Developer","Manager","Admin","Tester"};
        boolean flag =false;
        for(String element:validDesignation){
            if(element.equals(designation))
                flag = true;

        }
        return !flag;
    }

}
