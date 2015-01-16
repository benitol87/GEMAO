package fr.gemao.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordTest {

	@Test(expected = IllegalArgumentException.class)
	public void testEncryptChaineNulle() {
		System.out.println("Test testEncryptChaineNulle");
		// Arrange
		String str = null;

		// Act
		Password.encrypt(str);

		// Assert
		fail();
	}

	@Test
	public void testCompare2ChainesNulles() {
		System.out.println("Test testCompare2ChainesNulles");
		// Arrange
		String str1 = null;
		String str2 = null;

		// Act
		boolean res = Password.compare(str1, str2);

		// Assert
		assertTrue(res);
	}
	
	@Test
	public void testCompareChaineClairNulle() {
		System.out.println("Test testCompareChaineClairNulle");
		// Arrange
		String str1 = null;
		String str2 = "dzeté't5374j";

		// Act
		boolean res = Password.compare(str1, str2);

		// Assert
		assertFalse(res);
	}
	
	@Test
	public void testCompareChaineCrypteeNulle() {
		System.out.println("Test testCompareChaineCrypteeNulle");
		// Arrange
		String str1 = "";
		String str2 = null;

		// Act
		boolean res = Password.compare(str1, str2);

		// Assert
		assertFalse(res);
	}
	
	@Test
	public void testCompareChainesDifferentes() {
		System.out.println("Test testCompareChainesDifferentes");
		// Arrange
		String str1 = "azerty87$";
		String str2 = "azerty87$";

		// Act
		boolean res = Password.compare(str1, str2);

		// Assert
		assertFalse(res);
	}
	
	@Test
	public void testCompareChainesEgales() {
		System.out.println("Test testCompareChainesEgales");
		// Arrange
		String str1 = "azerty87$";
		String str2 = Password.encrypt(str1);

		// Act
		boolean res = Password.compare(str1, str2);

		// Assert
		assertTrue(res);
	}
	
	@Test
	public void testCompareChaineLongue() {
		System.out.println("Test testCompareChaineLongue");
		// Arrange
		String str1 = "arge165g1t646re5r8e161fc65er16e1av6rv1e563z1e56z1g6zv3rqe1f56e1v6e1g6a8rf94g6er4g6eq16erg1er1e";
		String str2 = Password.encrypt(str1);

		// Act
		boolean res = Password.compare(str1, str2);

		// Assert
		assertTrue(res);
	}

}
