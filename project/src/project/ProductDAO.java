package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDAO {
    // 스캐너 객체선언
    static Scanner scn = new Scanner(System.in);
    
    Connection getConnect() {
        String url = "jdbc:oracle:thin:@192.168.0.17:1521:xe";
        String userId = "scott";
        String userPw = "tiger";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(url, userId, userPw);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } // end of getConnect()
    
    // 상품등록
    public boolean insert(ProductManager product) {
        String sql = "INSERT INTO products (product_name, category, price, description, stock_quantity, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnect();
        	PreparedStatement psmt = conn.prepareStatement(sql)) {
        	psmt.setString(1, product.getProduct_name());
        	psmt.setString(2, product.getCategory());
        	psmt.setInt(3, product.getPrice());
        	psmt.setString(4, product.getDescription());
        	psmt.setInt(5, product.getStock_quantity()); // 재고 수량 저장
        	psmt.setTimestamp(6, product.getCreated_at());
        	psmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 상품 목록
    public List<ProductManager> selcetAll() {
        List<ProductManager> list = new ArrayList<>();
        String sql = "SELECT * FROM products ORDER BY product_id ASC"; // 상품 번호로 오름차순 정렬
        try (Connection conn = getConnect(); 
             PreparedStatement psmt = conn.prepareStatement(sql); 
             ResultSet rs = psmt.executeQuery()) {

            while (rs.next()) {
                ProductManager product = new ProductManager(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getString("category"),
                    rs.getInt("price"),
                    rs.getString("description"),
                    rs.getInt("stock_quantity"),
                    rs.getTimestamp("created_at")
                );
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    // 상품 상세보기
    public ProductManager selectById(int productId) {
        ProductManager product = null;
        Connection conn = getConnect();
        PreparedStatement psmt = null;
        ResultSet rs = null;

        String sql = "SELECT product_id, product_name, category, price, stock_quantity, created_at, description FROM products WHERE product_id = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, productId);
            rs = psmt.executeQuery();
            
            if (rs.next()) {
                product = new ProductManager();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getInt("price"));
                product.setStock_quantity(rs.getInt("stock_quantity"));
                product.setCreated_at(rs.getTimestamp("created_at"));
                product.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (psmt != null) psmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product; // 상품 정보 반환
    }
    
    //상품 수정
    public boolean update(ProductManager productmanager) {
        Connection conn = null;
        PreparedStatement psmt = null;
        String sql = "UPDATE products SET product_name = ?, category = ?, price = ?, description = ? WHERE product_id = ?";
        try {
            conn = getConnect();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, productmanager.getProduct_name());
            psmt.setString(2, productmanager.getCategory());
            psmt.setInt(3, productmanager.getPrice());
            psmt.setString(4, productmanager.getDescription());
            psmt.setInt(5, productmanager.getProduct_id());
            
            int r = psmt.executeUpdate();
            return r > 0; // 수정 성공 여부 반환
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (psmt != null) psmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false; // 수정 실패
    }
    //상품 삭제
    public boolean delete(int product_id) {
    	Connection conn = getConnect();
    	String sql = "delete from products where product_id = ?";
    	try {
	        PreparedStatement psmt = conn.prepareStatement(sql);
	        psmt.setInt(1, product_id);
	        
	        int r = psmt.executeUpdate();
	        if (r > 0) {
	            return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
    }

    // 카테고리에 해당하는 상품 목록 조회
    public List<ProductManager> selectByCategory(String category) {
        List<ProductManager> products = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM products WHERE category = ?";
        
        try {
            conn = getConnect();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, category);
            rs = psmt.executeQuery();
            
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                String categoryName = rs.getString("category");
                int price = rs.getInt("price");
                int stockQuantity = rs.getInt("stock_quantity");
                Timestamp createdAt = rs.getTimestamp("created_at");
                String description = rs.getString("description");

                ProductManager product = new ProductManager(productId, productName, categoryName, price, description, stockQuantity, createdAt);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (psmt != null) psmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return products; // 조회된 상품 목록 반환
    }
    
    // 재고 기록 추가 메서드
    public boolean insertStockRecord(StockRecord stockRecord) {
        String sql = "INSERT INTO stock_records (product_id, change_quantity, change_date, note) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = getConnect();
             PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setInt(1, stockRecord.getProduct_id());
            psmt.setInt(2, stockRecord.getChange_quantity());
            psmt.setTimestamp(3, new Timestamp(System.currentTimeMillis())); // 현재 시간
            psmt.setString(4, stockRecord.getNote());
            psmt.executeUpdate();
            return true; // 성공적으로 추가되면 true 반환
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // 오류 발생 시 false 반환
        }
    }
    // 상품 재고 업데이트 메서드
    public boolean updateProductStock(int productId, int newStockQuantity) {
        String sql = "UPDATE products SET stock_quantity = ? WHERE product_id = ?";
        try (Connection conn = getConnect();
        	PreparedStatement psmt = conn.prepareStatement(sql)) {
        	psmt.setInt(1, newStockQuantity);
        	psmt.setInt(2, productId);
        	psmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // 재고 삭제 메서드
    public boolean stockUpdate(ProductManager productmanager) {
        Connection conn = null;
        PreparedStatement psmt = null;
        String sql = "UPDATE products SET stock_quantity = ? WHERE product_id = ?";
        try {
            conn = getConnect();
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, productmanager.getStock_quantity()); // 재고 수량 설정
            psmt.setInt(2, productmanager.getProduct_id());
            
            int r = psmt.executeUpdate();
            return r > 0; // 수정 성공 여부 반환
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (psmt != null) psmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false; // 수정 실패
    }
    //재고 이력 조회
    public List<StockRecord> selectStockHistory(int productId) {
        List<StockRecord> stockHistory = new ArrayList<>();
        String sql = "SELECT * FROM stock_records WHERE product_id = ? ORDER BY change_date DESC";
        
        try (Connection conn = getConnect();
             PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setInt(1, productId);
            ResultSet rs = psmt.executeQuery();
            
            while (rs.next()) {
                StockRecord record = new StockRecord();
                record.setRecord_id(rs.getInt("record_id"));
                record.setProduct_id(rs.getInt("product_id"));
                record.setChange_quantity(rs.getInt("change_quantity"));
                record.setChange_date(rs.getTimestamp("change_date"));
                record.setNote(rs.getString("note"));
                stockHistory.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stockHistory;
    }
    
} // end of ProductDAO