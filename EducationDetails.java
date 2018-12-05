import java.util.Scanner;

public class EducationDetails {
    String education;
    float percentage;
    String date;

    public static boolean check_qualification(String designation) {

        String[] validDesignation = {"SSC","HSC","Diploma","Degree","Masters","Doctorate"};
        boolean flag =false;
        for(String element:validDesignation){
            if(element.equals(designation))
                flag = true;

        }
        return !flag;
    }
    public void putdata(){

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Qualification(SSC/HSC/Diploma/Degree/Masters/Doctorate) : ");
            this.education = sc.nextLine();
            while(check_qualification(this.education))
            {
                System.out.println("Invalid Designation Entered");
                System.out.println("Enter designation : ");
                this.education = sc.nextLine();
            }
            System.out.println("Enter Percentage : ");
            this.percentage = sc.nextFloat();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Date : ");
            this.date = scanner.nextLine();
    }

    public void printdata(){
        System.out.println("Qualification : " + this.education);
        System.out.println("Percentage : " + this.percentage);
        System.out.println("Date : " + this.date);

    }
}
