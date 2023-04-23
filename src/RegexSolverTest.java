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
}