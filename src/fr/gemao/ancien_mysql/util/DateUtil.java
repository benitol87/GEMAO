package gemao.mysql.util;

public class DateUtil {

	private DateUtil(){}
	
	/**
	 * Classe qui converti une Date de java.util en Date java.sql.
	 * @param date
	 * 		Date de java.util
	 * @return Date java.sql ou null si la date en paramètre est null.
	 */
	public static java.sql.Date toSqlDate(java.util.Date date){
		java.sql.Date sqlDate = null;
		if(date != null){
			sqlDate = new java.sql.Date(date.getTime());
		}
		return sqlDate;
	}
}
