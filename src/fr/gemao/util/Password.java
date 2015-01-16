package fr.gemao.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Classe s'occupant du cryptage des mots de passe
 * @author Benoît
 *
 */
public class Password {
	/**
	 * Méthode cryptant la chaîne passée en paramètre
	 * @param chaine : objet String non crypté, non nul
	 * @return un objet String contenant la chaîne cryptée (32 caractères)
	 */
	public static String encrypt(String chaine){
		if(chaine==null)
			throw new IllegalArgumentException("Can't encrypt a null string");
		
		MessageDigest m;
		String hashtext=null;
		try {
			m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(chaine.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			hashtext = bigInt.toString(16);
			// Now we need to zero pad it if you actually want the full 32 chars.
			while(hashtext.length() < 32 ){
			  hashtext = "0"+hashtext;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return hashtext;
	}
	
	/**
	 * Méthode comparant deux chaines
	 * @param chaineClair : une chaîne non codée, non nulle
	 * @param chaineCryptee : une chaîne codée
	 * @return true si les deux chaînes sont identiques une fois la
	 * deuxième décodée
	 */
	public static boolean compare(String chaineClair, String chaineCryptee){
		if(chaineClair==null && chaineCryptee==null){
			return true;
		}
		
		if(chaineClair==null)
			return false;
		
		String encryptedString = encrypt(chaineClair);
		
		return encryptedString.equals(chaineCryptee);
	}
}
