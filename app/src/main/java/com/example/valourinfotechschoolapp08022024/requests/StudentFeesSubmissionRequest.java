package com.example.valourinfotechschoolapp08022024.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentFeesSubmissionRequest {
    @SerializedName("FinYear")
    @Expose
    private String finYear;
    @SerializedName("StudentId")
    @Expose
    private String studentId;
    @SerializedName("StudentName")
    @Expose
    private String studentName;
    @SerializedName("ClassName")
    @Expose
    private String className;
    @SerializedName("SectionName")
    @Expose
    private String sectionName;
    @SerializedName("FeeTypeName")
    @Expose
    private String feeTypeName;
    @SerializedName("FeeAmount")
    @Expose
    private String feeAmount;
    @SerializedName("LateFeePaid")
    @Expose
    private String lateFeePaid;
    @SerializedName("TotalPaid")
    @Expose
    private String totalPaid;
    @SerializedName("PaymentMode")
    @Expose
    private String paymentMode;
    @SerializedName("PaymentDate")
    @Expose
    private String paymentDate;
    @SerializedName("PaymentHead")
    @Expose
    private String paymentHead;
    @SerializedName("PayTransId")
    @Expose
    private String payTransId;
    @SerializedName("ApproveStatus")
    @Expose
    private String approveStatus;
    private final static long serialVersionUID = -2192708643078018027L;

    public String getFinYear() {
        return finYear;
    }

    public void setFinYear(String finYear) {
        this.finYear = finYear;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getFeeTypeName() {
        return feeTypeName;
    }

    public void setFeeTypeName(String feeTypeName) {
        this.feeTypeName = feeTypeName;
    }

    public String getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(String feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getLateFeePaid() {
        return lateFeePaid;
    }

    public void setLateFeePaid(String lateFeePaid) {
        this.lateFeePaid = lateFeePaid;
    }

    public String getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(String totalPaid) {
        this.totalPaid = totalPaid;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentHead() {
        return paymentHead;
    }

    public void setPaymentHead(String paymentHead) {
        this.paymentHead = paymentHead;
    }

    public String getPayTransId() {
        return payTransId;
    }

    public void setPayTransId(String payTransId) {
        this.payTransId = payTransId;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }
}
