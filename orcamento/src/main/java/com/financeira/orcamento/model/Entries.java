package com.financeira.orcamento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "User_Entries")
public class Entries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userID;
    private String labelEntrie;
    private Double entrie;
    
    public Long getUserID() {
        return userID;
    }
    public void setUserID(Long userID) {
        this.userID = userID;
    }
    public String getLabelEntrie() {
        return labelEntrie;
    }
    public void setLabelEntrie(String labelEntrie) {
        this.labelEntrie = labelEntrie;
    }
    public Double getEntrie() {
        return entrie;
    }
    public void setEntrie(Double entrie) {
        this.entrie = entrie;
    }

}
