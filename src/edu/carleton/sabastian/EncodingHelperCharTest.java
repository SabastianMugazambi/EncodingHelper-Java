package edu.carleton.sabastian;

import org.junit.Test;
import java.util.*;
import java.util.regex.Pattern;

import static org.junit.Assert.*;
import static org.hamcrest.*;
import static org.junit.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * @Created by Sabastian Mugazambi (mugazambis) & Charlie Enriquez-Sarano
 * (enriquezc)
 * @Date 4/5/15.
 * @Purpose Test the EncodingHelperChar class
 *
 */
public class EncodingHelperCharTest {

    /**
     * Trying to check if the passed in argument is an int and additionally if
     * the constructor successfully constructed a non-null object.
     */
    @Test
    public void encodingHelperCharConstructorHexadecimal() throws Exception{
        EncodingHelperChar T1 = new EncodingHelperChar(0x41);
        assertNotNull(T1);
    }

    /**
     * Trying to check if the passed in argument is an  and additionally if
     * the constructor successfully constructed a non-null object.
     */
    public void encodingHelperCharConstructorByteArray() throws Exception{
        byte[] testarray = {0x41};
        EncodingHelperChar T1 = new EncodingHelperChar(testarray);
        assertNotNull(T1);
    }

    public void encodingHelperCharConstructorWithCharacter() throws Exception{
        EncodingHelperChar T1 = new EncodingHelperChar('A');
        assertNotNull(T1);
    }

    //Testing if the argument passed in are bytes
    @Test
    public void utf8BytesShouldBeBytes(byte[] T1) throws Exception {
        for (int i=0; i < T1.length ; i++){
            assertThat(T1[i], instanceOf(Byte.class));
        }
    }

    @Test
    public void testGetCodePoint() throws Exception {
        EncodingHelperChar T1 = new EncodingHelperChar(0x41);
        assertEquals(T1.getCodePoint(),0x41);

    }

    @Test
    public void testSetCodePoint() throws Exception {
        EncodingHelperChar T1 = new EncodingHelperChar(0x41);
        T1.setCodePoint(0x42);
        assertEquals(T1.getCodePoint(),0x42);
    }

    @Test
    public void testToUtf8Bytes() throws Exception {
        byte[] testByte = {0x41};
        EncodingHelperChar T1 = new EncodingHelperChar(testByte);
        byte[] actual = T1.toUtf8Bytes();
        assertArrayEquals(testByte, actual);
    }

    @Test
    public void testToCodePointString() throws Exception {
        EncodingHelperChar T1 = new EncodingHelperChar(0x41);
        String testString =  T1.toCodePointString();
        assertEquals(testString,"U+0041");
    }

    @Test
    public void testToUtf8String() throws Exception {
        EncodingHelperChar T1 = new EncodingHelperChar(0x41);
        String testString = T1.toUtf8String();
        assertEquals(testString, "\\x41");
    }

    @Test
    public void testGetCharacterName() throws Exception {
        EncodingHelperChar T1 = new EncodingHelperChar(0x41);
        String characterName = T1.getCharacterName();
        assertEquals("LATIN CAPITAL LETTER A", characterName);
    }

    public void main(String[] args){
        EncodingHelperChar Test1 = new EncodingHelperChar(0x41);
        EncodingHelperChar Test2 = new EncodingHelperChar([);
        encodingHelperCharConstructorShouldReturnTrue(Test1);
        utf8BytesShouldBeBytes(Test2);

    }
}