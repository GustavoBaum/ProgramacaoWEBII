package ProjetoREST.Application.Exceptions;

import java.util.Date;

public class ErrorResponse {

    private int statusCode;
    private Date timestamp;
    private String message;
    private String details;
    private String path;

    public ErrorResponse(int statusCode, Date timestamp, String message, String details, String path) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.path = path;
    }

    public int getStatusCode() { return statusCode; }

    public Date getTimestamp() { return timestamp; }

    public String getMessage() { return message; }

    public String getDetails() { return details; }

    public String getPath() { return path; }
}
