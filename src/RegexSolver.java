import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSolver {
    /**
     * Validates correct format for a Social Security Number(SSN)
     * @param input
     * @return
     */
    public boolean validSSN (final String input) {
        /*
        Checks for an SSN with Spaces
         */
        String regexSSNSpace = "^" +//Makes Sure there is nothing in front of the SSN
                "[0-9]{3}" +//Checks for a block of three numbers
                "[ ]{1}" +//Checks for only one space
                "[0-9]{2}" +//Checks for a block of two numbers
                "[ ]{1}" +//Checks for only one space
                "[0-9]{4}" +//Checks for a block of four numbers
                "$";//Makes sure that is the end of the SSN

        /*
        Checks for an SSN with Dashes
         */
        String regexSSNDash = "^" +//Makes Sure there is nothing in front of the SSN
                "[0-9]{3}" +//Checks for a block of three numbers
                "[-]{1}" +//Checks for only one dash
                "[0-9]{2}" +//Checks for a block of two numbers
                "[-]{1}" +//Checks for only one dash
                "[0-9]{4}" +//Checks for a block of four numbers
                "$";//Makes sure that is the end of the SSN

        /*
        Checks for an SSN with no spaces
         */
        String regexSSNNoSpace = "^" +//Makes Sure there is nothing in front of the SSN
                "[0-9]{3}" +//Checks for a block of three numbers
                "[0-9]{2}" +//Checks for a block of two numbers
                "[0-9]{4}" +//Checks for a block of four numbers
                "$";//Makes sure that is the end of the SSN


        /*
        Checks that it only has either spaces, dashes, or no spaces
         */
        Pattern pattern = Pattern.compile(regexSSNSpace + "|" + regexSSNDash + "|" + regexSSNNoSpace);
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            return true;
        }

        return false;
    }

    /**
     * Validates correct phone number format
     * @param input
     * @return
     */
    public boolean validPhone (final String input) {
        String regexPhone = "^" +//Makes Sure there is nothing in front of the phone number
                "[(]?" +//Checks for a starting parenthesis or none
                "[0-9]{3}" +//Checks for a block of three numbers
                "[)]?" +//Checks for a ending parenthesis or none
                "[ ]?" +//Checks for a space or no space between the first and second sections
                "[0-9]{3}" +//Checks for a block of three numbers
                "[ -]?" +//Checks for a space, dash, or no space between the second and third sections
                "[0-9]{4}" +//Checks for a block of four numbers
                "$";//Makes sure that is the end of the phone number


        Pattern pattern = Pattern.compile(regexPhone);
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            return true;
        }

        return false;
    }

    /**
     * Validates an email is in the correct format
     * @param input
     * @return
     */
    public boolean validEmail (final String input) {
        String regexEmail = "^" +//Makes Sure there is nothing in front of the email
                "[^\\W]" +//Makes Sure there is no special character at the start
                "[\\w\\W]+" +//Makes sure the email name is one or more word or non-word char
                "@" +//Makes sure the email has an @ symbol
                "[a-zA-Z0-9-]+\\." +//Makes sure the domain name ends in a .
                "[\\w\\W]{2,}" +//Checks the domain name
                "[^\\W]" +//Makes Sure there is no special character at the end
                "$";//Makes sure that is the end of the email


        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            return true;
        }

        return false;
    }

    /**
     * Validates roster name is in correct format
     * @param input
     * @return
     */
    public boolean validName (final String input) {
        String regexName = "^" +//Makes sure that is the start of the name
                "[A-Z]{1}" +//Checks for first letter capital
                "[a-z]+" +//Checks for rest of name
                "(, )" +//Checks for comma-space separator
                "[A-Z]{1}" +//Checks for first letter capital
                "[a-z]+" +//Checks for rest of name
                "(, )" +//Checks for comma-space separator
                "([A-Z] )+" +//Checks for one or more MI with space
                "$";//Makes sure that is the end of the name

        Pattern pattern = Pattern.compile(regexName);
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            return true;
        }

        return false;
    }

    /**
     * Validates day is in correct format
     * @param input
     * @return
     */
    public boolean validDate (final String input) {
        int day = 0, month = 0, year = 0;

        String regexDate = "[-/]?([0-9]{2,4})[-/]?";

        Pattern pattern = Pattern.compile(regexDate);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            if(matcher.group().contains("-")){
                month = Integer.parseInt(matcher.group().split("-")[0]);
            } else if (matcher.group().contains("/")) {
                month = Integer.parseInt(matcher.group().split("/")[0]);
            }
        }

        if (matcher.find()) {
            if(matcher.group().contains("-")){
                day = Integer.parseInt(matcher.group().split("-")[0]);
            } else if (matcher.group().contains("/")) {
                day = Integer.parseInt(matcher.group().split("/")[0]);
            }
        }

        if (matcher.find()) {
            year = Integer.parseInt(matcher.group().split("-")[0]);
        }

        if (!isDay(day, month) || !isMonth(month) || !isYear(year)) {
            return false;
        }

        return true;
    }

    private boolean isDay (final int day, final int month) {
        System.out.println(day);

        if (month == 1 || month == 3 || month == 5 ||
                month == 7 || month == 8 || month == 10 || month == 12) {
            if (day < 1 || day > 31) {
                return false;
            }
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day < 1 || day > 30) {
                return false;
            }
        }

        if (month == 2) {
            if (day < 1 || day > 28) {
                return false;
            }
        }

        return true;
    }

    private boolean isMonth (final int month) {
        System.out.println(month);

        if (month < 1 || month > 12) {
            return false;
        }

        return true;
    }

    private boolean isYear (final int year) {
        System.out.println(year);

        if (year < 1) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        RegexSolver solver = new RegexSolver();

        System.out.println(solver.validDate("09/12/2032"));
    }
}
