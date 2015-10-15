package edu.upc.clase.demo.entity;

import java.io.Serializable;

/**
 *
 * @author gian.corzo
 */
public class JsonResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean success;
    private String message;
    private Object data;

    public JsonResponse(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public JsonResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
