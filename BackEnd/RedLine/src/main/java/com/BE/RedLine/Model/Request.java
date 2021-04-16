package com.BE.RedLine.Model;


import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;

@Entity
@Table(name="Request")
public class Request extends NineLine{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean completed = false;
    private String responder = "";

    @JsonCreator
    public Request(String location, String callSign, String patientUrgency, String specialEquipment, String patientType, String security, String hlzMarking, String nationality, String nbc, long id, boolean completed, String responder) {
        super(location, callSign, patientUrgency, specialEquipment, patientType, security, hlzMarking, nationality, nbc);
        this.id = id;
        this.completed = completed;
        this.responder = responder;
    }

    public Request(String location, String callSign, String patientUrgency, String specialEquipment, String patientType) {
        super(location, callSign, patientUrgency, specialEquipment, patientType);
    }

    public Request( NineLine nineLine){
        super(nineLine.getLocation(), nineLine.getCallSign(), nineLine.getPatientUrgency(),nineLine.getSpecialEquipment(), nineLine.getPatientType(), nineLine.getSecurity(), nineLine.getHlzMarking(), nineLine.getNationality(), nineLine.getNbc());
    }

    public Request(){
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getResponder() {
        return responder;
    }

    public void setResponder(String responder) {
        this.responder = responder;
    }
}
