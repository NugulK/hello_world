package project;

import java.sql.Timestamp;

public class StockRecord {
    private int record_id;         // 기록 ID
    private int product_id;        // 상품 ID
    private int change_quantity;    // 변경 수량
    private Timestamp change_date;  // 변경 날짜
    private String note;           // 비고

    // 생성자
    public StockRecord(int product_id, int change_quantity, String note) {
        this.product_id = product_id;
        this.change_quantity = change_quantity;
        this.note = note;
        this.change_date = new Timestamp(System.currentTimeMillis()); // 현재 시간으로 설정
    }

    // 기본 생성자
    public StockRecord() {
        this.change_date = new Timestamp(System.currentTimeMillis()); // 기본값으로 현재 시간 설정
    }

    // Getter 및 Setter 메서드
    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getChange_quantity() {
        return change_quantity;
    }

    public void setChange_quantity(int change_quantity) {
        this.change_quantity = change_quantity;
    }

    public Timestamp getChange_date() {
        return change_date;
    }

    public void setChange_date(Timestamp change_date) {  // setter 메서드 추가
        this.change_date = change_date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}