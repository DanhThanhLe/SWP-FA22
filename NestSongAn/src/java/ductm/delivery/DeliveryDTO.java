/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ductm.delivery;

/**
 *
 * @author ACER
 */
public class DeliveryDTO {

    private int orderID;
    private String DeliveryName;
    private boolean status;

    public DeliveryDTO() {
    }

    public DeliveryDTO(int orderID, String DeliveryName, boolean status) {
        this.orderID = orderID;
        this.DeliveryName = DeliveryName;
        this.status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getDeliveryName() {
        return DeliveryName;
    }

    public void setDeliveryName(String DeliveryName) {
        this.DeliveryName = DeliveryName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
