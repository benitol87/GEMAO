package gemao.mysql.date;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import fr.gemao.sql.util.DateUtil;

public class TestDate {

	public static void main(String[] args) {
		Date dateU = Calendar.getInstance().getTime();
		
		System.out.println(dateU);
		System.out.println(DateUtil.toSqlDate(dateU));
		
		Time time  = new Time(dateU.getTime());
		System.out.println(time);
		
		Timestamp timestamp = new Timestamp(dateU.getTime());
		System.out.println(timestamp);
		
		Date d = timestamp;
		System.out.println(d);
	}
}
