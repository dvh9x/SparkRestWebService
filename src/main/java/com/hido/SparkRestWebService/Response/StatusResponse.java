package com.hido.SparkRestWebService.Response;

public enum StatusResponse {
    SUCCESS("Success"), ERROR("Error");
    final private String Status;

    StatusResponse(String status) {
        Status = status;
    }

    public String getStatus() {
        return Status;
    }
}
