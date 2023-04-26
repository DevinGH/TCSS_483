import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexSolverTest {
    private RegexSolver solver = new RegexSolver();

    @org.junit.jupiter.api.Test
    void validSSNNNoSpaces() {
        assertEquals(true, solver.validSSN("555555555"));
        assertEquals(true, solver.validSSN("123456789"));
    }
    @org.junit.jupiter.api.Test
    void validSSNNDashes() {
        assertEquals(true, solver.validSSN("555-55-5555"));
        assertEquals(true, solver.validSSN("123-45-6789"));
    }
    @org.junit.jupiter.api.Test
    void validSSNNSpace() {
        assertEquals(true, solver.validSSN("555 55 5555"));
        assertEquals(true, solver.validSSN("123 45 6789"));
    }
    @org.junit.jupiter.api.Test
    void invalidSSNNoSpaces() {
        assertEquals(false, solver.validSSN("5555555555"));
        assertEquals(false, solver.validSSN("1234567890"));
    }
    @org.junit.jupiter.api.Test
    void invalidSSNNOneDashOneSpace() {
        assertEquals(false, solver.validSSN("555-55 5555"));
        assertEquals(false, solver.validSSN("123 45-6789"));
    }
    @org.junit.jupiter.api.Test
    void invalidSSNNSpace() {
        assertEquals(false, solver.validSSN("55555555"));
        assertEquals(false, solver.validSSN("12345678"));
    }

    @Test
    void validPhonePara(){
        assertEquals(true, solver.validPhone("(111) 111-1111"));
    }

    @Test
    void validPhoneNoPara(){
        assertEquals(true, solver.validPhone("111 111-1111"));
    }

    @Test
    void validPhoneDash(){
        assertEquals(true, solver.validPhone("111 111-1111"));
    }

    @Test
    void validPhoneNoDash(){
        assertEquals(true, solver.validPhone("111 111 1111"));
    }

    @Test
    void validPhoneNoSpace(){
        assertEquals(true, solver.validPhone("1111111111"));
    }

    @Test
    void invalidPhonePara(){
        assertEquals(false, solver.validPhone("((111)) 111 1111"));
    }

    @Test
    void invalidPhoneNoPara(){
        assertEquals(false, solver.validPhone("1111 111-1111"));
    }

    @Test
    void invalidPhoneDash(){
        assertEquals(false, solver.validPhone("111 111 -1111"));
    }

    @Test
    void invalidPhoneNoDash(){
        assertEquals(false, solver.validPhone("111 111  1111"));
    }

    @Test
    void invalidPhoneNoSpace(){
        assertEquals(false, solver.validPhone("111111111111"));
    }

    @Test
    void validEmailNoSC(){
        assertEquals(true, solver.validEmail("Mister@mister.com"));
        assertEquals(true, solver.validEmail("absjdh@ashdbajsh.gov"));
    }

    @Test
    void validEmailSC(){
        assertEquals(true, solver.validEmail("M!st@r@gmail.com"));
    }

    @Test
    void validEmail() {
        assertEquals(true, solver.validEmail("google@google.co.nz"));
    }

    @Test
    void validEmailDigits(){
        assertEquals(true, solver.validEmail("077@gmail.com"));
    }

    @Test
    void invalidEmailSCAtEnd(){
        assertEquals(false, solver.validEmail("ashfjhhsdfbj@fnsjk.com."));
    }

    @Test
    void invalidEmailSCAtStart(){
        assertEquals(false, solver.validEmail("@ashdbjasd@gmail.com"));
    }

    @Test
    void invalidEmailEmpty(){
        assertEquals(false, solver.validEmail(""));
    }

    @Test
    void invalidEmailNoAtSign(){
        assertEquals(false, solver.validEmail("ahsjdbajshdbhjas"));
    }

    @Test
    void invalidEmailNoDomain(){
        assertEquals(false, solver.validEmail("ajsbdjhasd@ahjsbdas"));
    }

    @Test
    void validNameOneMI(){
        assertEquals(true, solver.validName("Josh, Man, M "));
        assertEquals(true, solver.validName("Mashasbasdhbjashd, Man, M "));
        assertEquals(true, solver.validName("Josh, Asjdbaskjdbjaks, M "));
        assertEquals(true, solver.validName("Josh, Man, V "));
    }

    @Test
    void validNameMultipleMI(){
        assertEquals(true, solver.validName("Josh, Man, M I K E "));
    }

    @Test
    void invalidNameNoComma(){
        assertEquals(false, solver.validName("Josh Man M "));
    }

    @Test
    void invalidNameEmpty(){
        assertEquals(false, solver.validName(""));
    }

    @Test
    void invalidNameMultipleComma(){
        assertEquals(false, solver.validName("Josh,, Man,, M"));
    }

    @Test
    void invalidNameMissingName(){
        assertEquals(false, solver.validName("Josh, , M"));
    }

    @Test
    void invalidNameDigits(){
        assertEquals(false, solver.validName("70sh, Man, M"));
    }

    @Test
    void invalidNameNoMIMiddle(){
        assertEquals(false, solver.validName("Asdbhjas, Ashdbjas, Asjkjksd"));
    }

    @Test
    void invalidNameNoCapital(){
        assertEquals(false, solver.validName("asjhdbjash, ahsdbjahs, A"));
    }

    @Test
    void validDateSlash() {
        assertEquals(true, solver.validDate("12/23/2023"));
        assertEquals(true, solver.validDate("02/20/1993"));
        assertEquals(true, solver.validDate("10/01/1986"));
        assertEquals(true, solver.validDate("1/9/2023"));
    }

    @Test
    void validDateDash() {
        assertEquals(true, solver.validDate("12-23-2023"));
        assertEquals(true, solver.validDate("02-03-2023"));
        assertEquals(true, solver.validDate("2-2-2023"));
    }

    @Test
    void validDateLeapYear(){
        assertEquals(true, solver.validDate("2-29-2800"));
        assertEquals(true, solver.validDate("2-29-2000"));
        assertEquals(true, solver.validDate("2-29-4000"));
    }

    @Test
    void invalidDateEmpty(){
        assertEquals(false, solver.validDate(""));
    }

    @Test
    void invalidDateWrongDay(){
        assertEquals(false, solver.validDate("12/44/2022"));
        assertEquals(false, solver.validDate("001-002-2222"));
    }

    @Test
    void invalidDateWrongYear(){
        assertEquals(false, solver.validDate("12/23/00000"));
        assertEquals(false, solver.validDate("2-29-200"));
    }

    @Test
    void invalidDateNotLeapYear(){
        assertEquals(false, solver.validDate("2-29-2100"));
        assertEquals(false, solver.validDate("2-29-1900"));
    }

    @Test
    void invalidDateWrongMonth(){
        assertEquals(false, solver.validDate("32/12/2223"));
    }

    @Test
    void invalidDateNoDigits(){
        assertEquals(false, solver.validDate("AA/AA/AAAA"));
    }

    @Test
    void invalidDateWrongFormat(){
        assertEquals(false, solver.validDate("09-12/2322"));
    }

    @Test
    void validStreetVaryingDigits(){
        assertEquals(true, solver.validAdr("12345 Yes Street"));
        assertEquals(true, solver.validAdr("1234 Yes Street"));
        assertEquals(true, solver.validAdr("123 Yes Street"));
        assertEquals(true, solver.validAdr("12 Yes Street"));
        assertEquals(true, solver.validAdr("1 Yes Street"));
    }

    @Test
    void validStreetMultiStName(){
        assertEquals(true, solver.validAdr("12345 Yes Yes Street"));
        assertEquals(true, solver.validAdr("12345 Yes Yes Yes Street"));
    }

    @Test
    void validStreetNoAbbr(){
        assertEquals(true, solver.validAdr("12345 Yes Road"));
        assertEquals(true, solver.validAdr("12345 Yes Street"));
        assertEquals(true, solver.validAdr("12345 Yes Boulevard"));
        assertEquals(true, solver.validAdr("12345 Yes Avenue"));
    }

    @Test
    void validStreetAbbr(){
        assertEquals(true, solver.validAdr("12345 Yes St"));
        assertEquals(true, solver.validAdr("12345 Yes Rd."));
        assertEquals(true, solver.validAdr("12345 Yes Ave"));
        assertEquals(true, solver.validAdr("12345 Yes Blvd."));
    }

    @Test
    void invalidEmpty(){
        assertEquals(false, solver.validAdr(""));
    }

    @Test
    void invalidNoNumber(){
        assertEquals(false, solver.validAdr("Yes Ave."));
    }

    @Test
    void invalidNoStreet(){
        assertEquals(false, solver.validAdr("1234 Ave."));
    }

    @Test
    void invalidNoTypeIncorrectType(){
        assertEquals(false, solver.validAdr("1243 Yes"));
        assertEquals(false, solver.validAdr("1243 Yes Aveee."));
        assertEquals(false, solver.validAdr("1243 Yes Rood."));
        assertEquals(false, solver.validAdr("1243 Yes 1234"));
    }

    @Test
    void validCityOneWord(){
        assertEquals(true, solver.validState("Tacoma, WA 98123"));
    }

    @Test
    void validCityMultiWord(){
        assertEquals(true, solver.validState("Federal Way, WA 98123"));
        assertEquals(true, solver.validState("Tacoma Federal City Name Here, WA 98123"));
    }

    @Test
    void validStateAbbr(){
        assertEquals(true, solver.validState("Tacoma, WA 98123"));
        assertEquals(true, solver.validState("Tacoma, LA 98123"));
        assertEquals(true, solver.validState("Tacoma, WI 98123"));
        assertEquals(true, solver.validState("Tacoma, MI 98123"));
        assertEquals(true, solver.validState("Tacoma, NY 98123"));
    }

    @Test
    void validZIP(){
        assertEquals(true, solver.validState("Tacoma, WA 98123"));
        assertEquals(true, solver.validState("Tacoma, WA 12345"));
        assertEquals(true, solver.validState("Tacoma, WA 54321"));
        assertEquals(true, solver.validState("Tacoma, WA 00001"));
    }

    @Test
    void invalidCityStEmpty(){
        assertEquals(false, solver.validState(""));
    }

    @Test
    void invalidLetterFormat(){
        assertEquals(false, solver.validState("Tacoma WA 98123"));
        assertEquals(false, solver.validState("Tacoma, WA98123"));
        assertEquals(false, solver.validState("Tacoma,WA 98123"));
        assertEquals(false, solver.validState("TacomaWA98123"));
    }

    @Test
    void invalidStateAbbr(){
        assertEquals(false, solver.validState("Tacoma, WP 98123"));
        assertEquals(false, solver.validState("Tacoma, I9 98123"));
        assertEquals(false, solver.validState("Tacoma, MV 98123"));
    }

    @Test
    void invalidZIPEmpty(){
        assertEquals(false, solver.validState("Tacoma, WA"));
    }

    @Test
    void invalidZIPLess(){
        assertEquals(false, solver.validState("Tacoma, WA 98"));
    }

    @Test
    void invalidZIPMore(){
        assertEquals(false, solver.validState("Tacoma, WA 98123123"));
    }

    @Test
    void validMilitaryTime(){
        assertEquals(true, solver.validMilitary("0000"));
        assertEquals(true, solver.validMilitary("0010"));
        assertEquals(true, solver.validMilitary("2300"));
        assertEquals(true, solver.validMilitary("1351"));
        assertEquals(true, solver.validMilitary("2359"));
    }

    @Test
    void invalidMilitaryTimeEmpty(){
        assertEquals(false, solver.validMilitary(""));
    }

    @Test
    void invalidMilitaryTime(){
        assertEquals(false, solver.validMilitary("9999"));
        assertEquals(false, solver.validMilitary("1399"));
        assertEquals(false, solver.validMilitary("1460"));
        assertEquals(false, solver.validMilitary("9000"));
        assertEquals(false, solver.validMilitary("2400"));
    }

    @Test
    void invalidMilitaryTimeLess(){
        assertEquals(false, solver.validMilitary("90"));
        assertEquals(false, solver.validMilitary("9"));
        assertEquals(false, solver.validMilitary("900"));
        assertEquals(false, solver.validMilitary("10"));
    }

    @Test
    void invalidMilitaryTimeMore(){
        assertEquals(false, solver.validMilitary("9000000"));
        assertEquals(false, solver.validMilitary("00100"));
        assertEquals(false, solver.validMilitary("02359"));
        assertEquals(false, solver.validMilitary("999999999999999"));
    }

    @Test
    void validCurrencySmall(){
        assertEquals(true, solver.validCurrency("$1.00"));
        assertEquals(true, solver.validCurrency("$0.22"));
        assertEquals(true, solver.validCurrency("$99.83"));
        assertEquals(true, solver.validCurrency("$100.10"));
        assertEquals(true, solver.validCurrency("$999.99"));
    }

    @Test
    void validCurrencyBig(){
        assertEquals(true, solver.validCurrency("$1,000,000.00"));
        assertEquals(true, solver.validCurrency("$10,000.00"));
        assertEquals(true, solver.validCurrency("$100,000.00"));
        assertEquals(true, solver.validCurrency("$999,999,999,999.99"));
        assertEquals(true, solver.validCurrency("$1,000,780,000,120,430,670,000,000.99"));
    }

    @Test
    void validCurrencyZero(){
        assertEquals(true, solver.validCurrency("$0.00"));
    }

    @Test
    void invalidCurrencyNoSign(){
        assertEquals(false, solver.validCurrency("1.00"));
    }

    @Test
    void invalidCurrencyEmpty(){
        assertEquals(false, solver.validCurrency(""));
    }

    @Test
    void invalidCurrencyNoDigits(){
        assertEquals(false, solver.validCurrency("$"));
    }

    @Test
    void invalidCurrencyNoSingleDigit(){
        assertEquals(false, solver.validCurrency("$.00"));
    }

    @Test
    void invalidCurrencyNoComma(){
        assertEquals(false, solver.validCurrency("$1000000.00"));
        assertEquals(false, solver.validCurrency("$10000.00"));
    }

    @Test
    void invalidCurrencyNoPennies(){
        assertEquals(false, solver.validCurrency("$11112323"));
        assertEquals(false, solver.validCurrency("$1"));
        assertEquals(false, solver.validCurrency("$0"));
    }

    @Test
    void invalidCurrencyLeadingZeros(){
        assertEquals(false, solver.validCurrency("$009.00"));
        assertEquals(false, solver.validCurrency("$00.00"));
        assertEquals(false, solver.validCurrency("$01.99"));
    }

    @Test
    void validURLNoHTTPOrHTTPS(){
        assertEquals(true, solver.validURL("www.google.com/"));
    }

    @Test
    void validURLHTTPSOrHTTP(){
        assertEquals(true, solver.validURL("https://www.google.com/"));
        assertEquals(true, solver.validURL("http://www.google.com/"));
    }

    @Test
    void validURLWithWithoutSubdomain(){
        assertEquals(true, solver.validURL("https://github.com/"));
    }

    @Test
    void validURLMultiSubDirectory(){
        assertEquals(true, solver.validURL("https://github.com/MyUserN@m3!?/MyFirstRepo"));
    }

    @Test
    void invalidURLEmpty(){
        assertEquals(false, solver.validURL(""));
    }

    @Test
    void invalidURLMissingSecondDomain(){
        assertEquals(false, solver.validURL("www..com"));
    }

    @Test
    void invalidURLMissingTopDomain(){
        assertEquals(false, solver.validURL("www.google"));
    }

    @Test
    void invalidURLNoDomains(){
        assertEquals(false, solver.validURL("https:///yes/waht"));
    }

    @Test
    void invalidURLWrongSubdirectory(){
        assertEquals(false, solver.validURL("www.google.com//"));
    }

    @Test
    void invalidURLMisspelledScheme(){
        assertEquals(false, solver.validURL("httsp//:www.google.com"));
    }
}