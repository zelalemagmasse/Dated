package com.company;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws ParseException {


        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");

        //Get the current time
        LocalDateTime rightNow= LocalDateTime.now();
        //Date from the user
       // rightNow.getT
        LocalDate userDate=null;

        //Set up formatters so that you can use them later
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter shortMonthFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        DateTimeFormatter longFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        //Time formatter (time only)
        DateTimeFormatter hr24 = DateTimeFormatter.ofPattern("kk:m");

        //Output today's date in formats that have been preset
        System.out.println("The current date is: "+rightNow.format(longFormat));
        System.out.println("This is the current date and time unformatted: "+rightNow);

        //Output the current time in formats that have been preset
        System.out.println("This is the current system time: "+ LocalTime.now());
        System.out.println("This is the current system time (24 h format): "+LocalTime.now().format(hr24));

        //This is how you parse a string with a date time formatter
        String aDate = "22/05/2010";
        userDate = LocalDate.parse(aDate,dTF);
        System.out.println(userDate.format(longFormat));



        //Display the date entered
        System.out.println(userDate.format(shortMonthFormat));

       /* SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy").parse(date33);
        Date date2=null;
        try {
            //Parsing the String
            date2 = dateFormat.parse(date33);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(date2);
       // now1.after;
       // long longTime = new Long((new Date().getTime()));

      // if(thisYear1.ge){}
       // System.out.println("This is the year entered:"+newYear);
       */
        prompter();

    }


    private static void dateDisplay(String date) {
        DateTimeFormatter shortMonthFormatOne = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        DateTimeFormatter shortMonthFormatTwo = DateTimeFormatter.ofPattern("MMM/dd/yyyy");
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate userDate=null;
        userDate = LocalDate.parse(date,dTF);
        System.out.println("The date you Entered in the dd/MMM/yyyy format will be " +userDate.format(shortMonthFormatOne));
        System.out.println("The date you Entered in the MMM/dd/yyyy format will be " +userDate.format(shortMonthFormatTwo));
        System.out.println("The date you Entered in the dd/MM/yyyy format will be " +userDate.format(dTF));

    }
    private static String validateUser(String date){
       String returnDate;
        if(isValidate(date)){
            returnDate= date;
        }else {
            Scanner input = new Scanner(System.in);
            String re_enteredDate="" ;
            boolean validityTester ;
            do {

                System.out.println(" You are Mistaken , please Now re-enter a Date in dd/mm/yyyy format");
                 re_enteredDate = input.nextLine();
                validityTester = isValidate(re_enteredDate);

            }while(isValidate(re_enteredDate)!=true);
          returnDate=re_enteredDate;
        }
     return returnDate;
    }
    private static boolean isValidate(String dateTime){
        SimpleDateFormat myDateFormat= new SimpleDateFormat("dd/MM/yyyy");
        try{
            myDateFormat.parse(dateTime);
            return true;

        }catch (ParseException ex){
            return false;
        }

    }
    private static void prompter()throws ParseException{
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Now enter a Date in dd/mm/yyyy format");
        String thisYear = keyboard.nextLine();
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        Date received = sdf.parse(validateUser(thisYear));

        Date todayDate = new Date();
        boolean after = received.after(todayDate);
        dateDisplay(validateUser(thisYear));
        while (after) {

            System.out.println("Now enter a Date in dd/mm/yyyy format");
            String thisYear2 = keyboard.nextLine();
            Date receivedAgain = sdf.parse(validateUser(thisYear2));
            dateDisplay(validateUser(thisYear2));
            after = receivedAgain.after(todayDate);

        }
    }

}
