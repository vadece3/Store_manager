/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abu_store_management;

/**
 *
 * @author KAMDEM VADECE
 */
public class table_product_details {
    
    String product_id,product_name,entry_date,entry_quantity,remaining_quantity,price_per_product;

    public table_product_details(String product_id,String product_name,String entry_date,String entry_quantity,String remaining_quantity,String price_per_product) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.entry_date = entry_date;
        this.entry_quantity = entry_quantity;
        this.remaining_quantity = remaining_quantity;
        this.price_per_product = price_per_product;
        
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }

    public String getEntry_quantity() {
        return entry_quantity;
    }

    public void setEntry_quantity(String entry_quantity) {
        this.entry_quantity = entry_quantity;
    }

    public String getRemaining_quantity() {
        return remaining_quantity;
    }

    public void setRemaining_quantity(String remaining_quantity) {
        this.remaining_quantity = remaining_quantity;
    }

    public String getPrice_per_product() {
        return price_per_product;
    }

    public void setPrice_per_product(String price_per_product) {
        this.price_per_product = price_per_product;
    }
    
}
