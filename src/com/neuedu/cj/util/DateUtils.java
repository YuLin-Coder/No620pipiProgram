package com.neuedu.cj.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateUtils {
/**
 * 时间字符串转换为Date类型
 * @param dateStr
 * @return
 */
	public static  Date stringConvertToDate(String source){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date dateTarget=null;
		try {
			dateTarget=simpleDateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateTarget;
	}
}
