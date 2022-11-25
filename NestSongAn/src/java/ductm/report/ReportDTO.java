/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ductm.report;

import java.sql.Date;

/**
 *
 * @author minhd
 */
public class ReportDTO {
    private String ID;
    private String Date;
    private float Total;
    private String Quantity;
    private String ProductID;

    public ReportDTO() {
    }

    public ReportDTO(String ID, String Date, float Total, String Quantity, String ProductID) {
        this.ID = ID;
        this.Date = Date;
        this.Total = Total;
        this.Quantity = Quantity;
        this.ProductID = ProductID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    
}
