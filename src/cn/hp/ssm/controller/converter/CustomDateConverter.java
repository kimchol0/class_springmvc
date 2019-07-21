package cn.hp.ssm.controller.converter;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.core.convert.converter.Converter;

public class CustomDateConverter implements Converter<String,Date> {

	@Override
	public Date convert(String paramS) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			return sdf.parse(paramS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
