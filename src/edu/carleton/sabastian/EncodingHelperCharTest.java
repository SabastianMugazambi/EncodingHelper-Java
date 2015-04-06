package edu.carleton.sabastian;

import com.sun.media.jfxmedia.track.Track;
import org.junit.Test;
import java.util.*;
import java.util.regex.Pattern;

import static org.junit.Assert.*;
//import static org.hamcrest.*;
//import static org.junit.*;
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
    public void encodingHelperCharConstructorWithHexadecimal() throws Exception{
        EncodingHelperChar T1 = new EncodingHelperChar(0x41);
        assertNotNull(T1);
    }

    /**
     * Tests to check if the passed in argument is a byte array
     * and additionally if
     * the constructor successfully constructed a non-null object.
     * @throws Exception
     */
    @Test
    public void encodingHelperCharConstructorWithByteArray() throws Exception{
        byte[] testarray = {0x41};
        EncodingHelperChar T1 = new EncodingHelperChar(testarray);
        assertNotNull(T1);
    }

    /**
     * Tests the constructor that takes in a character, and determines if the
     * constructor is null, and if so, will throw an Exception.
     * @throws Exception
     */

    @Test
    public void encodingHelperCharConstructorWithCharacter() throws Exception{
        EncodingHelperChar T1 = new EncodingHelperChar('A');
        assertNotNull(T1);
    }

    /**
     * Tests to see if the int returned by the getCodePoint method will match
     * the original int passed by the constructor. If the two ints are not
     * equal, then the assert statement throws an exception.
     * @throws Exception
     */

    @Test
    public void testGetCodePoint() throws Exception {
        EncodingHelperChar T1 = new EncodingHelperChar(0x41);
        assertEquals(T1.getCodePoint(),0x41);

    }

    /**
     * Tests to see if the set method correctly changes the code point to
     * some different code point. If the codepoint is different than what is
     * was set at, the method throws an exception.
     * @throws Exception
     */
    @Test
    public void testSetCodePoint() throws Exception {
        EncodingHelperChar T1 = new EncodingHelperChar(0x41);
        T1.setCodePoint(0x42);
        assertEquals(T1.getCodePoint(),0x42);
    }

    /**
     * Tests if the byte array that was passed to the constructor is actually
     * returned using the toUtf8Bytes method. If the two arrays are
     * different, then the method will throw an exception.
     * @throws Exception
     */
    @Test
    public void testToUtf8Bytes() throws Exception {
        byte[] testByte = {0x41};
        EncodingHelperChar T1 = new EncodingHelperChar(testByte);
        byte[] actual = T1.toUtf8Bytes();
        assertArrayEquals(testByte, actual);
    }

    /**
     * Tests if the CodePointString that the toCodePointString method returns
     * is equal to the original codepoint's CodePoint String. If the two are
     * not equal, the method will throw an exception
     * @throws Exception
     */

    @Test
    public void testToCodePointString() throws Exception {
        EncodingHelperChar T1 = new EncodingHelperChar(0x41);
        String testString =  T1.toCodePointString();
        assertEquals(testString,"U+0041");
    }

    /**
     * Tests if the toUtf8String method correctly returns a corresponding
     * UTF-8 string to the code point that was originally passed in the
     * constructor. If not, the method throws an exception.
     * @throws Exception
     */
    @Test

    public void testToUtf8String() throws Exception {
        EncodingHelperChar T1 = new EncodingHelperChar(0x41);
        String testString = T1.toUtf8String();
        assertEquals(testString, "\\x41");
    }

    /**
     * Tests if the getCharacterName method from EncodingHelperChar correctly
     * returns the name of the character that was passed as a codepoint in
     * the constructor. If not, the method throws an exception.
     * @throws Exception
     */
    @Test

    public void testGetCharacterName() throws Exception {
        EncodingHelperChar T1 = new EncodingHelperChar(0x41);
        String characterName = T1.getCharacterName();
        assertEquals("LATIN CAPITAL LETTER A", characterName);
    }

    /**
     * The main method simply calls each method with no parameters. This will
     * perform each test.
     * @param args
     */
    public void main(String[] args){
        try {
            encodingHelperCharConstructorWithByteArray();
            encodingHelperCharConstructorWithHexadecimal();
            encodingHelperCharConstructorWithCharacter();
            testGetCharacterName();
            testGetCodePoint();
            testToUtf8Bytes();
            testSetCodePoint();
            testToCodePointString();
        }

        catch (Exception e) {
            e.printStackTrace();
        }


    }
}