package co.bank.transaction.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> response(String message, boolean success, HttpStatus status, Object object){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("success", success);
        map.put("data", object);
        return ResponseEntity.status(status).body(map);
    }
}
