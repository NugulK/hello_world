package project;

import java.sql.Timestamp;

public class ProductManager {
    
    // 필드 
    private int product_id; // 상품코드
    private String product_name; // 상품이름
    private String category; // 카테고리
    private int price; // 가격
    private String description; // 상품설명
    private int stock_quantity; // 현재재고량
    private Timestamp created_at; // 상품등록일
    
    
    
    // 생성자
    public ProductManager() {
    }

    public ProductManager(int product_id, String product_name, String category, int price, String description, int stock_quantity, Timestamp created_at) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.stock_quantity = stock_quantity;
        this.created_at = created_at;
    }

    // Getter 및 Setter 메서드
    public int getProduct_id() {
        return product_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getStock_quantity() {
        return stock_quantity;
    }
    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }
    public Timestamp getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
    
    public String showList() {
    	return product_id + " " + product_name + " " + category + " " + price + " " + stock_quantity + " " + created_at + " ";
    }
 
}