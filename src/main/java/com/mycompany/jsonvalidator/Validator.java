package com.mycompany.jsonvalidator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Provides validation of JSON strings through the "validate" method
 * 
 */

public class Validator {

    /**
     * Compiles the JSON string by params
     * 
     * @param errCode   error code
     * @param errMsg    error message
     * @param errPlace  error place
     * @param filename  name of the file received for validation
     * @param requestID request id
     * @return JSON string compiled from params
     */
    
    private static String jsonErr(int errCode, String errMsg, int errPlace,
            String filename, int requestID) {
        JSONObject obj = new JSONObject();
        obj.put("errorCode", Integer.toString(errCode));
        obj.put("errorMessage", errMsg);
        obj.put("errorPlace", Integer.toString(errPlace));
        obj.put("resource", filename);
        obj.put("request-id", requestID);
        return obj.toJSONString();
    }

    /**
     * 
     * @param jsonString    input JSON string to be validated
     * @param filename      name of file containing input JSON string
     * @param requestID     request id
     * @return input JSON string if it's valid or JSON string containing
     * information about error
     */
    
    public static String validate(String jsonString, String filename,
            int requestID) {
        JSONParser parser = new JSONParser();
        try {
            parser.parse(jsonString);
        } catch (ParseException  ex) {
            return jsonErr(ex.getErrorType(), ex.toString(), ex.getPosition(),
                    filename, requestID);
        }
        return jsonString;
    }
}
