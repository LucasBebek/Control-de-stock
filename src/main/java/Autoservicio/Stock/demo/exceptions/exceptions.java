package Autoservicio.Stock.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class exceptions extends RuntimeException{
    public exceptions(String msg){
        super(msg);
    }
}
