

        import java.util.Arrays;
        import java.util.Scanner;

public class ReportBuilder {
    static Scanner keyboard = new Scanner(System.in);
    static double highest = 0;
    static double lowest = 0;
    static double total = 0;
    static double average = 0;
    static int intEntry = 0;
    static double lastEntry;
    static double doubleEntry = 0;
    static double arrNumber[] = new double[7];
    static double arrHighest[] = new double[7];
    static double arrLowest[] = new double[7];
    static double arrAverage[] = new double[7];
    static double arrTotal[] = new double[7];
    static String reportTitle = "Report Title";
    static String heading[] = {"Input", "Lowest ", "Highest", "Average", "Total"};


    public static void main(String[] args) {

        //char wholeName[] = new char[];
        String fName;
        String lName = "";
        String lastName;
        String nameSwitch = null;


        String lastIn, lastOut = "";


        //FIRST NAME TIME!

        firstNameTime();

        //LAST NAME TIME

        lastNameTime();

        //now to get the numbers
        //first int is special because it sets all the beginning values
        firstIntTime();

        //getting numbers 2-6
        getInts();

        //getting the double at the end
        doubleTime();


       //printing the final report
        finalReport();





        }
    static void firstNameTime(){
        String firstIn, firstOut = "";
        System.out.println("Enter your first name: ");
        firstIn = keyboard.next();
        for (int i = 0; i < firstIn.length(); i++) {
            if (firstIn.charAt(i) >= 'A' && firstIn.charAt(i) <= 'Z')
                firstOut = firstOut + firstIn.charAt(i);
            if (firstIn.charAt(i) >= 'a' && firstIn.charAt(i) <= 'z')
                firstOut = firstOut + firstIn.charAt(i);
        }

        System.out.println("Your first name is ");
        System.out.println(firstOut);}



        static void lastNameTime(){
            String lastIn="";
            String lastOut = "";

            while (lastIn != "#") {
                System.out.println("Type your name letter by letter and type '#' to end");
                lastIn = keyboard.next();
                //for (int i=0; i<100; i++){
                if (lastIn.charAt(0) == '#')
                    break;
                if (lastIn.length() > 1)
                    System.out.println("Please type only one letter at a time.");

                if ((lastIn.charAt(0) >= 'A' && lastIn.charAt(0) <= 'Z') ||
                        (lastIn.charAt(0) >= 'a' && lastIn.charAt(0) <= 'z') && (lastIn.length()<=1)){
                    lastOut = lastOut + lastIn.charAt(0);
                }
                else
                    System.out.println("Please type letters, not other characters");
            }

            System.out.println("Your Last name is ");
            System.out.println(lastOut);

        }

    //first entry  has its own logic

    static void firstIntTime(){
        System.out.println();
    boolean valid = false;
        System.out.println("What is the first number (write an int)");
        while(!valid){


        if (!keyboard.hasNextInt()) {

            String wrongAnswer = keyboard.nextLine();//I had to put this in here otherwise it would keep repeating forever
            System.out.println("Please type an integer only");

        } else {
            intEntry = keyboard.nextInt();

            arrNumber[0] = intEntry;

            highest = intEntry;
            arrHighest[0] = highest;

            lowest = intEntry;
            arrLowest[0] = lowest;

            average = intEntry;
            arrAverage[0] = average;

            total = intEntry;
            arrTotal[0] = total;

            System.out.println("Highest: " + highest);
            System.out.println("Lowest: " + lowest);
            System.out.println("Running Average: " + average);
            System.out.println("Running Total: " + total);

            valid = true;
        }}}

     static void getInts(){

        for (int i = 1; i < 6; i++) {
          System.out.println("What is the next number (write an int)");

            if (!keyboard.hasNextInt()) {

                String wrongAnswer = keyboard.nextLine();//I had to put this in here otherwise it would keep repeating forever
                System.out.println("Please type an integer only");
                i--;

            } else {

                arrNumber[i] = keyboard.nextInt();
                total = total + arrNumber[i];
                //numbers[i] = intEntry;
                System.out.println("Running total: " + total);
                arrTotal[i] = total;

                average = total / (i + 1);
                System.out.println("Running average: " + average);
                arrAverage[i] = average;

                if (arrNumber[i] > highest) {
                    highest = arrNumber[i];
                }
                arrHighest[i] = highest;

                if (arrNumber[i] < lowest) {
                    lowest = arrNumber[i];
                }
                arrLowest[i] = lowest;

                System.out.println("Current Highest: " + highest);
                System.out.println("Current Lowest: " + lowest);
                System.out.println();

            }}
        }


static void doubleTime() {
    System.out.println("What is the last number (write a double this time)");
    arrNumber[6] = keyboard.nextDouble();
    total = total + arrNumber[6];
    // arrNumber[6] = lastEntry;
    System.out.println("Running total: " + total);
    arrTotal[6] = total;

    average = total / (6 + 1);
    System.out.println("Running average: " + average);
    arrAverage[6] = average;

    if (arrNumber[6] > highest) {
        highest = arrNumber[6];
    }
    arrHighest[6] = highest;

    if (arrNumber[6] < lowest) {
        lowest = arrNumber[6];
    }
    arrLowest[6] = lowest;

    System.out.println("Current highest: " + highest);
    System.out.println("Current lowest: " + lowest);


    System.out.println();

}
static void finalReport(){
 System.out.println(reportTitle);
        System.out.println(Arrays.toString(heading));

            for (int i = 0; i < 7; i++) {

        System.out.print("  " + arrNumber[i]);
        System.out.print("    " + arrLowest[i]);
        System.out.print("      " + arrHighest[i]);
        System.out.print("      " + arrAverage[i]);
        System.out.print("     " + arrTotal[i]);
        System.out.println();
    }}
}

