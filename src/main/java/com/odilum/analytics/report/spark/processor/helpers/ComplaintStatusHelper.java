package com.odilum.analytics.report.spark.processor.helpers;

import java.io.Serializable;

public class ComplaintStatusHelper implements Serializable {

    String complaintStatus;

    public ComplaintStatusHelper() {
    }

    public ComplaintStatusHelper(String complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    public String getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(String complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    @Override
    public String toString() {
        return "ComplaintStatusHelper{" +
                "complaintStatus=" + complaintStatus +
                '}';
    }
}
