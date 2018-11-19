/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.job.dynamicproviders;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Объект информационного сообщения.
 *
 * @author wasa
 */
@Getter
@Setter
public class Message {

    static private final Logger LOG = Logger.getLogger(Message.class.getName());
    private boolean success;
    private String message;
    private Integer code;
    private Object data;
    private String stackTrace;

    /**
     * Инициализирует поля {@link Message#message}, {@link Message#success}
     *
     * @param success статус
     * @param message текст сообщения
     */
    public Message(boolean success, String message)
    {
        this(success, message, null, null, null);
    }
    public Message(boolean success, String message, Integer code){
        this(success, message, code, null, null);
    }
    public Message(boolean success, String message, Integer code, Object data, String stackTrace){
        this.success = success;
        this.message = message;
        this.code = code;
        this.data = data;
        this.stackTrace = stackTrace;

        if (LOG.isLoggable(Level.FINE))
            LOG.fine(toString());
    }

    @Override
    public String toString() {
        try {
            JSONObject obj = new JSONObject();
            obj.put("success", success);
            obj.put("message", message);
            if (code != null) {
                obj.put("code", code);
            }
            if (data != null) {
                obj.put("data", data.toString());
            }
            if (stackTrace != null) {
                obj.put("stackTrace", stackTrace);
            }
            return obj.toString();
        } catch (JSONException ex) {
            throw new RuntimeException(ex);
        }
    }
}
