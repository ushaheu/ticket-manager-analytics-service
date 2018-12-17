package com.odilum.analytics.report.spark.processor.helpers;

import java.util.Date;

public class TicketLogs {

    private String id;
    private String ticketID;
    private Date ticketIssuedDateTime;
    private String consumerTitle;
    private String consumerName;
    private String consumerSurname;
    private String consumerPhoneNumber;
    private String consumerAlternatePhoneNumber;
    private String consumerCity;
    private String consumerLGA;
    private String consumerState;
    private String consumerZone;
    private String operatorAgentName;
    private String complaintCode;
    private String complaintDescription;
    private String complaintStatus;
    private String complaintSLA;
    private String resolutionDateTime;
    private String serviceProvider;
    private Date callInitiatedDateTime;
    private Date callTerminatedDateTime;
    private Double callQueueWaitTime;
    private Double callDuration;
    private Double ivrCallTime;

    public TicketLogs() {
    }

    public TicketLogs(String id, String ticketID, Date ticketIssuedDateTime, String consumerTitle, String consumerName,
                      String consumerSurname, String consumerPhoneNumber, String consumerAlternatePhoneNumber,
                      String consumerCity, String consumerLGA, String consumerState, String consumerZone,
                      String operatorAgentName, String complaintCode, String complaintDescription, String complaintStatus,
                      String complaintSLA, String resolutionDateTime, String serviceProvider, Date callInitiatedDateTime, Date callTerminatedDateTime,
                      Double callQueueWaitTime, Double callDuration, Double ivrCallTime) {
        this.id = id;
        this.ticketID = ticketID;
        this.ticketIssuedDateTime = ticketIssuedDateTime;
        this.consumerTitle = consumerTitle;
        this.consumerName = consumerName;
        this.consumerSurname = consumerSurname;
        this.consumerPhoneNumber = consumerPhoneNumber;
        this.consumerAlternatePhoneNumber = consumerAlternatePhoneNumber;
        this.consumerCity = consumerCity;
        this.consumerLGA = consumerLGA;
        this.consumerState = consumerState;
        this.consumerZone = consumerZone;
        this.operatorAgentName = operatorAgentName;
        this.complaintCode = complaintCode;
        this.complaintDescription = complaintDescription;
        this.complaintStatus = complaintStatus;
        this.complaintSLA = complaintSLA;
        this.resolutionDateTime = resolutionDateTime;
        this.serviceProvider = serviceProvider;
        this.callInitiatedDateTime = callInitiatedDateTime;
        this.callTerminatedDateTime = callTerminatedDateTime;
        this.callQueueWaitTime = callQueueWaitTime;
        this.callDuration = callDuration;
        this.ivrCallTime = ivrCallTime;
    }

    public TicketLogs(String ticketID, Date ticketIssuedDateTime, String consumerTitle, String consumerName,
                      String consumerSurname, String consumerPhoneNumber, String consumerAlternatePhoneNumber,
                      String consumerCity, String consumerLGA, String consumerState, String consumerZone,
                      String operatorAgentName, String complaintCode, String complaintDescription,
                      String complaintStatus, String complaintSLA, String resolutionDateTime, String serviceProvider, Date callInitiatedDateTime, Date callTerminatedDateTime,
                      Double callQueueWaitTime, Double callDuration, Double ivrCallTime) {
        this.ticketID = ticketID;
        this.ticketIssuedDateTime = ticketIssuedDateTime;
        this.consumerTitle = consumerTitle;
        this.consumerName = consumerName;
        this.consumerSurname = consumerSurname;
        this.consumerPhoneNumber = consumerPhoneNumber;
        this.consumerAlternatePhoneNumber = consumerAlternatePhoneNumber;
        this.consumerCity = consumerCity;
        this.consumerLGA = consumerLGA;
        this.consumerState = consumerState;
        this.consumerZone = consumerZone;
        this.operatorAgentName = operatorAgentName;
        this.complaintCode = complaintCode;
        this.complaintDescription = complaintDescription;
        this.complaintStatus = complaintStatus;
        this.complaintSLA = complaintSLA;
        this.resolutionDateTime = resolutionDateTime;
        this.serviceProvider = serviceProvider;
        this.callInitiatedDateTime = callInitiatedDateTime;
        this.callTerminatedDateTime = callTerminatedDateTime;
        this.callQueueWaitTime = callQueueWaitTime;
        this.callDuration = callDuration;
        this.ivrCallTime = ivrCallTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getConsumerTitle() {
        return consumerTitle;
    }

    public void setConsumerTitle(String consumerTitle) {
        this.consumerTitle = consumerTitle;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerSurname() {
        return consumerSurname;
    }

    public void setConsumerSurname(String consumerSurname) {
        this.consumerSurname = consumerSurname;
    }

    public String getConsumerPhoneNumber() {
        return consumerPhoneNumber;
    }

    public void setConsumerPhoneNumber(String consumerPhoneNumber) {
        this.consumerPhoneNumber = consumerPhoneNumber;
    }

    public String getConsumerAlternatePhoneNumber() {
        return consumerAlternatePhoneNumber;
    }

    public void setConsumerAlternatePhoneNumber(String consumerAlternatePhoneNumber) {
        this.consumerAlternatePhoneNumber = consumerAlternatePhoneNumber;
    }

    public String getConsumerCity() {
        return consumerCity;
    }

    public void setConsumerCity(String consumerCity) {
        this.consumerCity = consumerCity;
    }

    public String getConsumerLGA() {
        return consumerLGA;
    }

    public void setConsumerLGA(String consumerLGA) {
        this.consumerLGA = consumerLGA;
    }

    public String getConsumerState() {
        return consumerState;
    }

    public void setConsumerState(String consumerState) {
        this.consumerState = consumerState;
    }

    public String getConsumerZone() {
        return consumerZone;
    }

    public void setConsumerZone(String consumerZone) {
        this.consumerZone = consumerZone;
    }

    public String getOperatorAgentName() {
        return operatorAgentName;
    }

    public void setOperatorAgentName(String operatorAgentName) {
        this.operatorAgentName = operatorAgentName;
    }

    public String getComplaintCode() {
        return complaintCode;
    }

    public void setComplaintCode(String complaintCode) {
        this.complaintCode = complaintCode;
    }

    public String getComplaintDescription() {
        return complaintDescription;
    }

    public void setComplaintDescription(String complaintDescription) {
        this.complaintDescription = complaintDescription;
    }

    public String getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(String complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    public String getComplaintSLA() {
        return complaintSLA;
    }

    public void setComplaintSLA(String complaintSLA) {
        this.complaintSLA = complaintSLA;
    }

    public String getResolutionDateTime() {
        return resolutionDateTime;
    }

    public void setResolutionDateTime(String resolutionDateTime) {
        this.resolutionDateTime = resolutionDateTime;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public void setTicketIssuedDateTime(Date ticketIssuedDateTime) {
        this.ticketIssuedDateTime = ticketIssuedDateTime;
    }

    public Date getCallInitiatedDateTime() {
        return callInitiatedDateTime;
    }

    public void setCallInitiatedDateTime(Date callInitiatedDateTime) {
        this.callInitiatedDateTime = callInitiatedDateTime;
    }

    public Date getCallTerminatedDateTime() {
        return callTerminatedDateTime;
    }

    public void setCallTerminatedDateTime(Date callTerminatedDateTime) {
        this.callTerminatedDateTime = callTerminatedDateTime;
    }

    public Double getCallQueueWaitTime() {
        return callQueueWaitTime;
    }

    public void setCallQueueWaitTime(Double callQueueWaitTime) {
        this.callQueueWaitTime = callQueueWaitTime;
    }

    public Double getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(Double callDuration) {
        this.callDuration = callDuration;
    }

    public Date getTicketIssuedDateTime() {
        return ticketIssuedDateTime;
    }

    public Double getIvrCallTime() {
        return ivrCallTime;
    }

    public void setIvrCallTime(Double ivrCallTime) {
        this.ivrCallTime = ivrCallTime;
    }

    @Override
    public String toString() {
        return "TicketLogs{" +
                "id='" + id + '\'' +
                ", ticketID='" + ticketID + '\'' +
                ", ticketIssuedDateTime=" + ticketIssuedDateTime +
                ", consumerTitle='" + consumerTitle + '\'' +
                ", consumerName='" + consumerName + '\'' +
                ", consumerSurname='" + consumerSurname + '\'' +
                ", consumerPhoneNumber='" + consumerPhoneNumber + '\'' +
                ", consumerAlternatePhoneNumber='" + consumerAlternatePhoneNumber + '\'' +
                ", consumerCity='" + consumerCity + '\'' +
                ", consumerLGA='" + consumerLGA + '\'' +
                ", consumerState='" + consumerState + '\'' +
                ", consumerZone='" + consumerZone + '\'' +
                ", operatorAgentName='" + operatorAgentName + '\'' +
                ", complaintCode='" + complaintCode + '\'' +
                ", complaintDescription='" + complaintDescription + '\'' +
                ", complaintStatus='" + complaintStatus + '\'' +
                ", complaintSLA='" + complaintSLA + '\'' +
                ", resolutionDateTime='" + resolutionDateTime + '\'' +
                ", serviceProvider='" + serviceProvider + '\'' +
                ", callInitiatedDateTime=" + callInitiatedDateTime +
                ", callTerminatedDateTime=" + callTerminatedDateTime +
                ", callQueueWaitTime=" + callQueueWaitTime +
                ", callDuration=" + callDuration +
                ", ivrCallTime=" + ivrCallTime +
                '}';
    }
}
