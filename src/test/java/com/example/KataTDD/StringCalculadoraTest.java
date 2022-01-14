package com.example.KataTDD;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class StringCalculadoraTest {

    private StringCalculadora stringCalculadora = new StringCalculadora();

    @Test
    public void stringVacio() throws Exception{
        assertThat(stringCalculadora.add(""), is(0));
    }

    @Test
    public void stringOneNumber() throws Exception{
        assertThat(stringCalculadora.add("1"), is(1));
        assertThat(stringCalculadora.add("50"), is(50));
    }

    @Test
    public void stringSeparator() throws Exception {
        assertThat(stringCalculadora.add("10,11"), is(21));
        assertThat(stringCalculadora.add("1,50"), is(51));
    }

    @Test
    public void stringJumpLine() throws Exception {
        assertThat(stringCalculadora.add("20\n20"), is(40));
        assertThat(stringCalculadora.add("40\n12"), is(52));
    }

    @Test
    public void stringThreeNumbersDelimiter() throws Exception {
        assertThat(stringCalculadora.add("10 20|30"), is(60));
        assertThat(stringCalculadora.add("5,3 15"), is(23));
        assertThat(stringCalculadora.add("14,5\n7 10"), is(36));
    }

    /*@Tes0t
    public void stringNumberNegative() throws Exception {
        stringCalculadora.add("-1,-4");
    }*/

    @Test
    public void stringNumberIs100AreIgnored() throws Exception {
        assertThat(stringCalculadora.add("10,1000"), is(1010));
        assertThat(stringCalculadora.add("5,1010"), is(5));
    }

    @Test
    public void stringDelimitadorNumeral() throws Exception{
        assertThat(stringCalculadora.add("15#20"), is(35));
        assertThat(stringCalculadora.add("2#3#5"), is(10));
    }

}