package furama.resort.converters;

import org.springframework.core.convert.converter.Converter;

import java.sql.Date;
import java.time.LocalDate;

public class DateConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(String source) {
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        if(source.equals("") || !source.matches(regex))
            return null;
        try {
            return LocalDate.parse(source);
        } catch (IllegalArgumentException e) {
            return  null;
        }
    }
}
