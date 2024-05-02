package io.zipcoder.tc_spring_poll_application.dto.error;

public class CustomErrorResponses {

    private String title;
    private int status;
    private String detail;
    private Long timestamp;
    private String developerMessage;

    public CustomErrorResponses() {
    }

    public CustomErrorResponses(String title, int status, String detail, Long timestamp, String developerMessage) {
        this.title = title;
        this.status = status;
        this.detail = detail;
        this.timestamp = timestamp;
        this.developerMessage = developerMessage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
}
