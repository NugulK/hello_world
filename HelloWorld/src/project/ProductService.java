package project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductService { // 비즈니스 로직 담당
    private ProductDAO productDAO; // ProductDAO 인스턴스 변수 추가

    // 생성자에서 ProductDAO 초기화
    public ProductService() {
        productDAO = new ProductDAO(); // ProductDAO 인스턴스 생성
    }

    // 상품 등록 메서드
    public boolean registerProduct(String productName, String category, int price, String description, int stockQuantity) {
        // 현재 날짜를 문자열로 포맷
        String createdAt = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        // ProductManager 객체 생성
        ProductManager product = new ProductManager(); // productId는 0으로 설정

        // insert 메서드 호출
        return productDAO.insert(product); // ProductDAO의 insert 메서드 호출
    }
}