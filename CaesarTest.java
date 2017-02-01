package cipher;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaesarTest {
	Caesar cipher = new Caesar();

	@Test
	public void testEncipher() {
		//assertEquals("Fuuqj", cipher.encipher(5, "Apple"));
		//assertEquals("C'g siolm.", cipher.encipher(20, "I'm yours."));
		//assertEquals("'Slaaj Eslyvdrtgtyr!'", cipher.encipher(11, "'Happy Thanksgiving!'"));
	}
	
	@Test
	public void testDecipher() {
		assertEquals("'Happy Thanksgiving!'", cipher.decipher("'Slaaj Eslyvdrtgtyr!'"));
		assertEquals("Bramhs is my favorite composer.", cipher.decipher("Eudpkv lv pb idyrulwh frpsrvhu."));
		assertEquals("We love Beijing!", cipher.decipher("Xf mpwf Cfjkjoh!"));
	}

}
