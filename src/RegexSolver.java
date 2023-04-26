import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSolver {
    /**
     * Validates correct format for a Social Security Number(SSN) detailed in regex comments
     * SHORTCOMINGS: Figuring out how to make sure the SSN only has spaces/dashes/no spaces
     * without there being any mixing.
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
     * Validates correct phone number format detailed in comments of regex
     * SHORTCOMINGS: No Shortcomings
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
     * Validates an email is in the correct format detailed in regex comments
     * SHORTCOMINGS: Knowing what and what not to allow being a part of the email,
     * the requirements were a little vague.
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
     * Validates roster name is in correct format detailed in regex comments
     * SHORTCOMINGS: No shortcomings
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
     * Validates day is in correct format detailed in regex comments
     * SHORTCOMINGS: Making sure that the input string had a valid date only using regex, then
     * figuring out if it was a leap year and validating the day based on the month which is
     * based on the year.
     * @param input
     * @return
     */
    public boolean validDate (final String input) {
        int day = 0, month = 0, year = 0;

        String regexDateSlash = "^" +//Checks there's nothing at the beginning
                "((1[0-2])|(0?[1-9]))" +//Checks to make sure that the months are between 1-12
                "[/]" +//Checks for slash separators
                "((3[01])|([12][0-9])|(0?[1-9]))" +//Checks to make sure that the days are between 1-31
                "[/]" +//Checks for slash separators
                "\\d{4}" +//Checks that the years are 4 digits long
                "$";//Checks there's nothing at the end

        String regexDateDash = "^" +//Checks there's nothing at the beginning
                "((1[0-2])|(0?[1-9]))" +//Checks to make sure that the months are between 1-12
                "[-]" +//Checks for dash separators
                "((3[01])|([12][0-9])|(0?[1-9]))" +//Checks to make sure that the days are between 1-31
                "[-]" +//Checks for dash separators
                "\\d{4}" +//Checks that the years are 4 digits long
                "$";//Checks there's nothing at the end

        Pattern pattern = Pattern.compile(regexDateSlash + "|" + regexDateDash);//Makes sure the date can only have slashes or dashes, no mixing
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String[] dateInfo = matcher.group().split("[-/]");

            //Parses info on the input date to validate
            day = Integer.parseInt(dateInfo[1]);
            month = Integer.parseInt(dateInfo[0]);
            year = Integer.parseInt(dateInfo[2]);

            //Checks to see if the year is a leap year or not
            boolean isLeapYear = (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));

            //Makes sure all days fall within the range on respective month
            if (isLeapYear && month == 2 && !(day > 0 && day < 30)) {//If leap year make sure the Feb can have 29 days
                return false;
            } else if (!isLeapYear && month == 2 && !(day > 0 && day < 29)) {//Else Feb can have 28 days
                return false;
            } else if (((month == 1) || (month == 3) || (month == 5) || (month == 7) ||
                    (month == 8) || (month == 10) || (month == 12)) && !(day > 0 && day < 32)) {
                return false;
            } else if (((month == 4) || (month == 6) || (month == 9) || (month == 11)) && !(day > 0 && day < 31)) {
                return false;
            }

            return true;
        }

        return false;
    }

    /**
     * Makes sure the input address follows the correct format detailed in regex comments
     * SHORTCOMINGS: Learning how to capture words on their own and not just matching single chars
     * on their own.
     * @param input
     * @return
     */
    public boolean validAdr (final String input) {
        String regexAdr = "(?i)^" +//Catches anything before address and forgets case-sensitivity
                "\\d{1,5}" +//Matches any Street number up to 5 digits
                "\\s" +//Space between Street number and Street name
                "((\\w+)\\s)+" +//Allows multiple words in Street name (i.e. 123 Martin Luther King Jr. Blvd.)
                "(Rd\\.?|Road|St\\.?|Street|Blvd\\.?|Boulevard|Ave\\.?|Avenue)" +//Matches any address type w/ abbreviations
                "$";//Catches anything after address

        Pattern pattern = Pattern.compile(regexAdr);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return true;
        }

        return false;
    }

    /**
     * Validates city, state and zip letter format detailed in regex comments
     * SHORTCOMINGS: Learning how to match a multitude of words by pairing up
     * common first letters.
     * Extra Credit: Matches states by their abbreviations
     * @param input
     * @return
     */
    public boolean validState (final String input) {
        String regexState = "(?i)^" +//Catches anything before city name and forgets case-sensitivity
                "(\\w+\\s)*" +//Allows multiple words in city name (i.e. Federal Way)
                "(\\w+),\\s" +//Catches last word in city name with comma and space
                "(a[klrz]|c[aot]|de|fl|ga|hi|i[adln]|k[sy]|la|m[adeinost]|n[cdehjmvy]|o[hkr]|" +
                "pa|ri|s[cd]|t[nx]|ut|v[at]|w[aivy])" +//catches all 50 state abbreviations
                "\\s" +//Space between State name and zip code
                "\\d{5}" +//Matches 5-digit zip code
                "$";//Catches anything after zip code

        Pattern pattern = Pattern.compile(regexState);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return true;
        }

        return false;
    }

    /**
     * Validates military times are in correct format without colon detailed in regex comments
     * SHORTCOMINGS: Figuring out how to validate times (i.e. last two numbers can't go above 59
     * and first two can't go above 23), and how to attach leading zero.
     * @param input
     * @return
     */
    public boolean validMilitary (final String input) {
        String regexMilitary = "^" +//Checks everything before time
                "([01][0-9][0-5][0-9]|2[0-3][0-5][0-9])" +//Allows any time from 0000-2359. (doesn't count 2400 since it's the same as 0000)
                "$";//Checks everything after time

        Pattern pattern = Pattern.compile(regexMilitary);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return true;
        }

        return false;
    }

    /**
     * Validates US Currency format down to pennies detailed in regex comments
     * SHORTCOMINGS: How to match it based on the correct format (i.e. how to match
     * $1,000,000.00 and not match $009,000.00).
     * @param input
     * @return
     */
    public boolean validCurrency (final String input) {
        String regexCurrency = "^" +//Checks for anything before the currency
                "\\$" +//Leading Dollar sign
                "(([1-9]\\d{0,2}(,\\d{3})*)|" +//Matches any amount greater than $999.99
                "(([1-9]\\d{0,1})?\\d))" +//Matches any amount less than or equal to $999.99 while watching for leading zero
                "\\.\\d{2}" +//Penny level
                "$";//Checks for anything after the currency

        Pattern pattern = Pattern.compile(regexCurrency);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return true;
        }

        return false;
    }

    /**
     * Validates that a URL is in the correct format detailed in regex comments
     * SHORTCOMINGS: No shortcomings
     * @param input
     * @return
     */
    public boolean validURL (final String input) {
        String regexURL = "^" +//Checks to make sure nothing before
                "(https://|http://)?" +//Optional https:// or http://
                "(\\w+\\.)?" +//Can have one subdomain
                "(\\w+\\.)" +//Must have second-level domain
                "(\\w+)" +//Must have top-level domain
                "((/[^/]+)+|/)" +//Must have at least empty subdirectory or can have multiple subdirectories
                "$";//Checks to make sure nothing after

        Pattern pattern = Pattern.compile(regexURL);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return true;
        }

        return false;
    }

    /**
     * Validates that a password follows the format detailed in regex comments
     * SHORTCOMINGS: Learning how to use lookaheads to verify certain conditions
     * (i.e. How to make sure that there is at least one capital letter).
     * @param input
     * @return
     */
    public boolean validPassword (final String input) {
        String regexPass = "^" +//Checks there is nothing at beginning of password
                "(?=.*[A-Z])" +//Makes sure there is at least 1 capital letter
                "(?=.*[a-z])" +//Makes sure there is at least 1 lower letter
                "(?=.*\\d)" +//Makes sure there is at least 1 number
                "(?=.*[!?@#])" +//Makes sure there is at least 1 punctuation mark
                "(?!.*([a-z])\\1{3,})" +//Makes sure there is no more than 3 repeating lower letters
                "[a-zA-Z\\d!@?#]{10,}" +//Makes sure there is at least 10 characters in the password
                "$";//Checks there is nothing after the password

        Pattern pattern = Pattern.compile(regexPass);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return true;
        }

        return false;
    }

    /**
     * Validates a word with odd letters has ion at end detailed in regex comments
     * SHORTCOMINGS: How to verify odd number of letters, and use lookbehinds to see
     * if the word ended in ion or not.
     * @param input
     * @return
     */
    public boolean validIonWord (final String input) {
        String regexIonWord = "(?i)^" +//Makes sure there is nothing before the word and doesn't worry about case-sensitivity
                "(([a-z][a-z])+[a-z])" +//Matches only odd numbers of letters
                "(?<=ion)" +//Lookbehind for the last letters being ion
                "$";//Makes sure there is nothing after the word

        Pattern pattern = Pattern.compile(regexIonWord);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return true;
        }

        return false;
    }


}
