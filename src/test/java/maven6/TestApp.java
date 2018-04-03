package maven6;

import static org.junit.Assert.*;
import com.wordladder.Wordladder;
import org.junit.Before;
import org.junit.Test;

public class TestApp {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test1() {
		Wordladder wl=new Wordladder();
		wl.setDict("dictionary.txt");
		wl.setWord1("code");
		wl.setWord2("data");
		assertEquals("A ladder from data back to code:data date cate cade code \n",wl.getRes());
	}
	
	@Test
	public void test2() {
		Wordladder wl=new Wordladder();
		wl.setDict("dictionary.txt");
		wl.setWord1("kitty");
		wl.setWord2("kitty");
		assertEquals("The two words must be different.",wl.getRes());
	}
	
	@Test
	public void test3() {
		Wordladder wl=new Wordladder();
		wl.setDict("dictionary.txt");
		wl.setWord1("ghost");
		wl.setWord2("boo");
		assertEquals("The two words must be the same length.",wl.getRes());
	}

	@Test
	public void test4() {
		Wordladder wl=new Wordladder();
		wl.setDict("dictionary.txt");
		wl.setWord1("marty");
		wl.setWord2("keith");
		assertEquals("The two words must be found in the dictionary.",wl.getRes());
	}
}
