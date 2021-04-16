package com.BE.RedLine.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//@Entity
@MappedSuperclass
public class NineLine {
//    @Id
//    @GeneratedValue
//    private Long id;
    private String location;
    private String callSign;
    private String patientUrgency;
    private String specialEquipment;
    private String patientType;
    private String security;
    private String hlzMarking;
    private String nationality;
    private String nbc; //line9; //special

    @JsonCreator
    public NineLine(String location, String callSign, String patientUrgency, String specialEquipment, String patientType, String security, String hlzMarking, String nationality, String nbc) {
        this.location = location;
        this.callSign = callSign;
        this.patientUrgency = patientUrgency;
        this.specialEquipment = specialEquipment;
        this.patientType = patientType;
        this.security = security;
        this.hlzMarking = hlzMarking;
        this.nationality = nationality;
        this.nbc = nbc;
    }

    //@JsonCreator
    public NineLine(String location, String callSign, String patientUrgency, String specialEquipment, String patientType) {
        this.location = location;
        this.callSign = callSign;
        this.patientUrgency = patientUrgency;
        this.specialEquipment = specialEquipment;
        this.patientType = patientType;
    }

    public NineLine(){
        this.location = "";
        this.callSign = "";
        this.patientUrgency = "";
        this.specialEquipment = "";
        this.patientType = "";
        this.security = "";
        this.hlzMarking = "";
        this.nationality = "";
        this.nbc = "";

    }

    @JsonGetter
    public String getLocation() {
        return location;
    }
    @JsonSetter
    public void setLocation(String location) {
        this.location = location;
    }
    @JsonGetter
    public String getCallSign() {
        return callSign;
    }
    @JsonSetter
    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }
    @JsonGetter
    public String getPatientUrgency() {
        return patientUrgency;
    }
    @JsonSetter
    public void setPatientUrgency(String patientUrgency) {
        this.patientUrgency = patientUrgency;
    }
    @JsonGetter
    public String getSpecialEquipment() {
        return specialEquipment;
    }
    @JsonSetter
    public void setSpecialEquipment(String specialEquipment) {
        this.specialEquipment = specialEquipment;
    }
    @JsonGetter
    public String getPatientType() {
        return patientType;
    }
    @JsonSetter
    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }
    @JsonGetter
    public String getSecurity() {
        return security;
    }
    @JsonSetter
    public void setSecurity(String security) {
        this.security = security;
    }
    @JsonGetter
    public String getHlzMarking() {
        return hlzMarking;
    }
    @JsonSetter
    public void setHlzMarking(String hlzMarking) {
        this.hlzMarking = hlzMarking;
    }
    @JsonGetter
    public String getNationality() {
        return nationality;
    }
    @JsonSetter
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    @JsonGetter
    public String getNbc() {
        return nbc;
    }
    @JsonSetter
    public void setNbc(String nbc) {
        this.nbc = nbc;
    }


}
