/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered01.entity;

/**
 *
 * @author kasun
 */
public class ItemEntity {
    private String itemCode;
    private String description;
    private String packsize;
    private Double unitprice;
    private int qtyOnHand;

    public ItemEntity() {
    }

    public ItemEntity(String itemCode, String description, String packsize, Double unitprice, int qtyOnHand) {
        this.itemCode = itemCode;
        this.description = description;
        this.packsize = packsize;
        this.unitprice = unitprice;
        this.qtyOnHand = qtyOnHand;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the packsize
     */
    public String getPacksize() {
        return packsize;
    }

    /**
     * @param packsize the packsize to set
     */
    public void setPacksize(String packsize) {
        this.packsize = packsize;
    }

    /**
     * @return the unitprice
     */
    public Double getUnitprice() {
        return unitprice;
    }

    /**
     * @param unitprice the unitprice to set
     */
    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    /**
     * @return the qtyOnHand
     */
    public int getQtyOnHand() {
        return qtyOnHand;
    }

    /**
     * @param qtyOnHand the qtyOnHand to set
     */
    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public String toString() {
        return "ItemEntity{" + "itemCode=" + itemCode + ", description=" + description + ", packsize=" + packsize + ", unitprice=" + unitprice + ", qtyOnHand=" + qtyOnHand + '}';
    }
    
    
    
}
