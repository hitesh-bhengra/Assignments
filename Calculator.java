import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        double num1, num2;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 1st number : ");
            num1 = sc.nextFloat();
            System.out.println("Enter 2nd number : ");
            num2 = sc.nextFloat();
            NewCalculator calc = new NewCalculator();


            System.out.println("Addition : "+calc.add(num1, num2));

            System.out.println("Subtraction : "+calc.subtract(num1, num2));

            System.out.println("Multiplication : "+calc.multiply(num1, num2));

            System.out.println("Division : "+calc.divide(num1, num2));
        }
        catch(Exception e){
            System.out.println("Invalid Input "+e);

        }
    }
}
     abstract class GenericCalculator<E> {

        public abstract E add(E num1, E num2);
        public abstract E subtract(E num1, E num2);
        public abstract E multiply(E num1, E num2);
        public abstract E divide(E num1, E num2);
    }

      class NewCalculator extends GenericCalculator<Number>{

        @Override
        public Number add(Number num1, Number num2) {
            return (num1.doubleValue() + num2.doubleValue());
        }

        @Override
        public Number subtract(Number num1, Number num2) {
            return (num1.doubleValue() - num2.doubleValue());
        }

        @Override
        public Number multiply(Number num1, Number num2) {
            return (num1.doubleValue() * num2.doubleValue());
        }

          @Override
          public Number divide(Number num1, Number num2) {
              return (num1.doubleValue() / num2.doubleValue());
          }
    }

