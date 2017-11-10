
package com.mycompany.jsonvalidator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Validator {
    private static String jsonErr(int errCode, String errMsg, int errPlace) {
        JSONObject obj = new JSONObject();
        obj.put("errorCode", Integer.toString(errCode));
        obj.put("errorMessage", errMsg);
        obj.put("errorPlace", Integer.toString(errPlace));
        return obj.toJSONString();
    }
    
    public static String validate(String jsonString) {
        JSONParser parser = new JSONParser();
        try {
            parser.parse(jsonString);
        } catch (ParseException ex) {
            return jsonErr(ex.getErrorType(), ex.getMessage(), ex.getPosition());
        }
        return jsonString;
    }
}
