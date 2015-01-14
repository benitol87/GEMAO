package fr.gemao.sql.util;

import java.sql.Timestamp;

public class DateUtil {

	private DateUtil(){}
	
	/**
	 * Classe qui converti une Date de java.util en Date java.sql.
	 * @param date
	 * 		Date de java.util
	 * @return Date java.sql ou null si la date en paramètre est null.
	 */
	public static Timestamp toSqlDate(java.util.Date date){
		Timestamp sqlDate = null;
		if(date != null){
			sqlDate = new Timestamp(date.getTime());
		}
		return sqlDate;
	}
}
