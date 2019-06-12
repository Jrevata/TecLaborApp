package com.jrevata.teclaborapp.models;

public class ResponseMessage {

    private String type;
    private String message;
    private String status;
    private String code;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "type='" + type + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

}
