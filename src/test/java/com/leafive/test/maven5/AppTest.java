package com.leafive.test.maven5;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     * @throws IOException 
     */
	
    public AppTest( String testName )
    {
        super( testName );
    }

    
    public void test1() throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		ByteArrayInputStream in = new ByteArrayInputStream("src/res/smalldict1.txt\n\n".getBytes());
		System.setIn(in);
		App.main(null);
		assertEquals(
		"Dictionary file name? " + 
				"Word #1 (or Enter to quit): " + 
		"Have a nice day.\n",out.toString());
	}
    
    public void test2() throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		ByteArrayInputStream in = new ByteArrayInputStream("notfound.txt\nsrc/res/smalldict1.txt\n\n".getBytes());
		System.setIn(in);
		App.main(null);
		assertEquals(
		"Dictionary file name? " + "Dictionary file name? "+
				"Word #1 (or Enter to quit): " +  
		"Have a nice day.\n",out.toString());
	}
    
    public void test3() throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		ByteArrayInputStream in = new ByteArrayInputStream("src/res/dictionary.txt\nkitty\nkitty\n\n".getBytes());
		System.setIn(in);
		App.main(null);
		assertEquals(
		"Dictionary file name? " + 
				"Word #1 (or Enter to quit): " + 
				"Word #2 (or Enter to quit): " + 
				"The two words must be different.\n" + 
		"Word #1 (or Enter to quit): " + 
		"Have a nice day.\n",out.toString());
	}
    
    public void test4() throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		ByteArrayInputStream in = new ByteArrayInputStream("src/res/dictionary.txt\nghost\nboo\n\n".getBytes());
		System.setIn(in);
		App.main(null);
		assertEquals(
		"Dictionary file name? " + 
				"Word #1 (or Enter to quit): " + 
				"Word #2 (or Enter to quit): " + 
				"The two words must be the same length.\n" + 
		"Word #1 (or Enter to quit): " + 
		"Have a nice day.\n",out.toString());
	}
    
    public void test5() throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		ByteArrayInputStream in = new ByteArrayInputStream("src/res/dictionary.txt\nmarty\nkeith\n\n".getBytes());
		System.setIn(in);
		App.main(null);
		assertEquals(
		"Dictionary file name? " + 
				"Word #1 (or Enter to quit): " + 
				"Word #2 (or Enter to quit): " + 
				"The two words must be found in the dictionary.\n" + 
		"Word #1 (or Enter to quit): " + 
		"Have a nice day.\n",out.toString());
	}
    
    public void test6() throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		ByteArrayInputStream in = new ByteArrayInputStream("src/res/smalldict1.txt\nbled\nbarb\nbled\nblow\n\n".getBytes());
		System.setIn(in);
		App.main(null);
		assertEquals(
		"Dictionary file name? " + 
				"Word #1 (or Enter to quit): " + 
				"Word #2 (or Enter to quit): " + 
				"No word ladder found from barb back to bled.\n" + 
		"Word #1 (or Enter to quit): " + 
		"Word #2 (or Enter to quit): " +
		"A ladder from blow back to bled:\n"+
			"blow blew bled \n"+
			"Word #1 (or Enter to quit): " + 
		"Have a nice day.\n",out.toString());
	}
    
    public void test7() throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		ByteArrayInputStream in = new ByteArrayInputStream("src/res/dictionary.txt\ndog\ncat\n\n".getBytes());
		System.setIn(in);
		App.main(null);
		assertEquals(
		"Dictionary file name? " + 
				"Word #1 (or Enter to quit): " + 
				"Word #2 (or Enter to quit): " + 
			"A ladder from cat back to dog:\n" + 
			"cat cag cog dog \n" + 
		"Word #1 (or Enter to quit): " + 
		"Have a nice day.\n",out.toString());
	}
	public void test8() throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		ByteArrayInputStream in = new ByteArrayInputStream("src/res/dictionary.txt\ncode\ndata\n\n".getBytes());
		System.setIn(in);
		App.main(null);
		assertEquals(
		"Dictionary file name? " + 
				"Word #1 (or Enter to quit): " + 
				"Word #2 (or Enter to quit): " + 
		"A ladder from data back to code:\n" + 
		"data date cate cade code \n" + 
		"Word #1 (or Enter to quit): " + 
		"Have a nice day.\n",out.toString());
	}
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
    		TestSuite suite= new TestSuite(); 
        suite.addTest(new AppTest("test1")); 
        suite.addTest(new AppTest("test2"));
        suite.addTest(new AppTest("test3"));
        suite.addTest(new AppTest("test4")); 
        suite.addTest(new AppTest("test5"));
        suite.addTest(new AppTest("test6"));
        suite.addTest(new AppTest("test7")); 
        suite.addTest(new AppTest("test8"));
        
        return suite;
    }

    /**
     * Rigourous Test :-)
     */
    /*public void testApp()
    {
        assertTrue( true );
    }*/
}
