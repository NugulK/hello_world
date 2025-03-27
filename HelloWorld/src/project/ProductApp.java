package project;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductApp {
    // 스캐너 객체선언
    static Scanner scn = new Scanner(System.in);
    // 데이터 베이스 처리하는 기능작성
    static ProductDAO dao = new ProductDAO();

    public static void main(String[] args) {
        // 앱을 실행 하는 클래스.
        boolean run = true;
        while (run) {
        	displayMainmenu();
        	int	menu = getIntInput("메뉴 선택: ");
        	switch (menu) {
            case 1: // 상품관리기능
                run = prodmg(); // prodmg()의 반환값에 따라 run 변수 제어
                break;
            case 2: // 재고관리기능
            	// 재고 관리 기능 구현
            	run = stockmg();
                break;
            case 3: // 프로그램 종료
                System.out.println("====================================");
                System.out.println("");
                System.out.println("             프로그램 종료             ");
                System.out.println("");
                System.out.println("====================================");
                run = false; // 프로그램 종료
                break;
        	} // end of switch()
        } // end of while()
    } // end of main()
    // 메뉴 화면
    private static void displayMainmenu() {
    	System.out.println("====================================");
    	System.out.println("");
        System.out.println("           OO마트 프로그램            ");
        System.out.println("");
        System.out.println("====================================");
        System.out.println("1.상품관리  2.재고관리  3.프로그램 종료");
        System.out.println("------------------------------------");
    }
    // 메뉴선택
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scn.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("정수값을 입력하세요.");
            }
        }
    }
    // 상품관리기능 화면
    private static void displayProductMenu() {
    	System.out.println("====================================");
        System.out.println("");
        System.out.println("              상품 관리              ");
        System.out.println("");
        System.out.println("====================================");
        System.out.println("");
        System.out.println(" 1.상품등록 2.상품목록조회 3.상품상세보기   ");
        System.out.println(" 4.상품수정 5.상품 삭제   6.상품 검색     ");
        System.out.println(" 7.메인메뉴 8.프로그램종료     ");
        System.out.println("");
        System.out.println("------------------------------------");
    }
    // 상품관리기능
    private static boolean prodmg() {
        boolean run = true;
        while (run) {
        	displayProductMenu();
        	int menu = getIntInput("선택 : ");
            switch (menu) {
                case 1: // 등록
                    add();
                    break;
                case 2: // 목록
                     list();
                    break;
                case 3: // 상세보기
                     detail();
                    break;
                case 4: // 수정
                     update();
                    break;
                case 5: // 삭제
                     delete();
                    break;
                case 6: // 검색
                     search();
                    break;
                case 7: // 메인메뉴로
                	return true; // 메인 메뉴로 돌아가기
                case 8: // 종료
                    System.out.println("====================================");
                    System.out.println("");
                    System.out.println("             프로그램 종료             ");
                    System.out.println("");
                    System.out.println("====================================");
                    return false; // 프로그램 종료
            }//end of switch()
        } //end of while()
        return run;
    } // end of prodmg()
    // 상품 등록
    private static void add() {
        System.out.println("====================================");
        System.out.println("            📦 상품 등록              ");
        System.out.println("====================================");

        System.out.println("상품명을 입력하세요:");
        String product_name = scn.nextLine();
        System.out.println("카테고리를 입력하세요:");
        String category = scn.nextLine();
        System.out.println("가격을 입력하세요(0이상):");
        int price = Integer.parseInt(scn.nextLine());
        System.out.println("상품 설명을 입력하세요:");
        String description = scn.nextLine();
        System.out.println("재고량을 입력하세요 (0 이상):");
        int stock_quantity = Integer.parseInt(scn.nextLine());

        // 현재 날짜를 문자열로 포맷
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());

        // product_id는 자동 증가되므로 제외
        ProductManager productmanager = new ProductManager(0, product_name, category, price, description, stock_quantity, createdAt);
        
        if (dao.insert(productmanager)) {
            System.out.println("상품이 성공적으로 등록되었습니다!");
        } else {
            System.out.println("상품 등록에 실패하였습니다.");
        }
    }
    
    // 상품목록
    private static void list() {
    	System.out.println("====================================");
    	System.out.println("           📦 상품 목록 조회           ");
    	System.out.println("====================================");
    	List<ProductManager> list = dao.selcetAll();
    	if(list.isEmpty()) {
    		System.out.println("등록된 상품이 없습니다.");
    		return;
    	}
    	for (ProductManager pmg : list) {
    		System.out.println(pmg.showList());
    	}
    } // end of list()
    // 상품 상세보기
    private static void detail() {
    	System.out.println("====================================");
        System.out.println("           📄 상품 상세 정보           ");
        System.out.println("====================================");
        
        // 상품 번호 입력 받기
        System.out.println("상세 정보를 조회할 상품 번호를 입력하세요:");
        int product_id = Integer.parseInt(scn.nextLine()); // 상품 번호 입력 받기

        // 상품 정보 조회
        System.out.println("------------------------------------");
        ProductManager product = dao.selectById(product_id);
        
        if (product != null) {
            printProductInfo(product);
        } else {
            System.out.println("해당 상품 번호의 상품이 존재하지 않습니다.");
        }
    } // end of detail()
    // 현재상품정보
    private static void printProductInfo(ProductManager product) {
    	System.out.println("상품번호 : " + product.getProduct_id());
        System.out.println("상품명  : " + product.getProduct_name());
        System.out.println("카테고리 : " + product.getCategory());
        System.out.println("가격    : " + product.getPrice() + "원");
        System.out.println("현재재고량: " + product.getStock_quantity() + "개");
        System.out.println("등록일   : " + product.getCreated_at());
        System.out.println("설명    : " + product.getDescription());
    }
    //상품 수정
    private static void update() {
        System.out.println("====================================");
        System.out.println("            ✏️ 상품 수정              ");
        System.out.println("====================================");
        
        // 수정할 상품 번호 입력 받기
        System.out.println("수정할 상품 번호를 입력하세요:");
        int product_id = Integer.parseInt(scn.nextLine());

        // 상품 정보 조회
        ProductManager product = dao.selectById(product_id);
        
        if (product == null) {
            System.out.println("해당 상품 번호의 상품이 존재하지 않습니다.");
            return;
        }

        // 현재 상품 정보 표시
        System.out.println("------------------------------------");
        System.out.println("현재 상품 정보");
        printProductInfo(product);
        System.out.println("------------------------------------");
        System.out.println("수정할 내용을 입력해주세요 (그대로 두려면 Enter)");
        System.out.println("------------------------------------");

        // 수정할 정보 입력 받기
        System.out.print("상품명 [" + product.getProduct_name() + "] : ");
        String productName = scn.nextLine();
        if (productName.isEmpty()) productName = product.getProduct_name(); // 그대로 두기

        System.out.print("카테고리 [" + product.getCategory() + "] : ");
        String category = scn.nextLine();
        if (category.isEmpty()) category = product.getCategory(); // 그대로 두기

        System.out.print("가격 [" + product.getPrice() + "] : ");
        String priceInput = scn.nextLine();
        int price = product.getPrice(); // 기본값
        if (!priceInput.isEmpty()) price = Integer.parseInt(priceInput); // 새 가격 입력

        System.out.print("설명 [" + product.getDescription() + "] : ");
        String description = scn.nextLine();
        if (description.isEmpty()) description = product.getDescription(); // 그대로 두기

        // 수정된 상품 정보로 ProductManager 객체 생성
        ProductManager updatedProduct = new ProductManager(product_id, productName, category, price, description, product.getStock_quantity(), product.getCreated_at());

        // 데이터베이스에 수정된 정보 업데이트
        if (dao.update(updatedProduct)) {
            System.out.println("상품 정보가 성공적으로 수정되었습니다!");
        } else {
            System.out.println("상품 수정에 실패하였습니다.");
        }
    } //end of update()
    
    // 상품 삭제
    private static void delete() {
        System.out.println("====================================");
        System.out.println("            🗑️ 상품 삭제              ");
        System.out.println("====================================");
        
        // 삭제할 상품 번호 입력 받기
        System.out.println("삭제할 상품 번호를 입력하세요:");
        int product_id = Integer.parseInt(scn.nextLine());

        // 상품 정보 조회
        ProductManager product = dao.selectById(product_id);
        
        if (product == null) {
            System.out.println("해당 상품 번호의 상품이 존재하지 않습니다.");
            return;
        }

        // 현재 상품 정보 표시
        System.out.println("삭제할 상품 정보");
        System.out.println("------------------------------------");
        printProductInfo(product);
     
        // 삭제 여부 확인
        System.out.print("정말 이 상품을 삭제하시겠습니까? (Y/N) : ");
        String confirmation = scn.nextLine().trim().toUpperCase();
        
        if (confirmation.equals("Y")) {
            // 데이터베이스에서 삭제
            if (dao.delete(product_id)) {
                System.out.println("상품이 성공적으로 삭제되었습니다!");
            } else {
                System.out.println("상품 삭제에 실패하였습니다.");
            }
        } else {
            System.out.println("상품 삭제가 취소되었습니다.");
        }
    } // end of delete()

    // 상품 검색
    private static void search() {
        System.out.println("====================================");
        System.out.println("            🔍 상품 검색              ");
        System.out.println("====================================");
        
        // 검색할 카테고리 입력 받기
        System.out.print("검색할 카테고리를 입력하세요: ");
        String categoryInput = scn.nextLine().trim();

        // 카테고리에 해당하는 상품 목록 조회
        List<ProductManager> products = dao.selectByCategory(categoryInput);
        
        if (products.isEmpty()) {
            System.out.println("해당 카테고리에 상품이 없습니다.");
            return;
        }

        // 검색 결과 표시
        System.out.println("------------------------------------");
        System.out.println("              검색 결과               ");
        System.out.println("------------------------------------");

        for (ProductManager product : products) {
            printProductInfo(product);
            System.out.println("------------------------------------");
        }

        System.out.println("------------------------------------");
        System.out.print("메인 메뉴로 돌아가려면 '0' 입력: ");
        int productId = Integer.parseInt(scn.nextLine());
    }

    //재고관리기능
    private static boolean stockmg() {
        boolean run = true;
        while (run) {
            displayStockMenu(); 
            int menu = getIntInput("선택: ");
            switch (menu) {
                case 1: // 재고 추가
                    stockadd();
                    break;
                case 2: // 재고 수정
                     stockmodify();
                    break;
                case 3: // 재고 조회
                     stocklist();
                    break;
                case 4: // 재고 삭제
                     stockdelete();
                    break;
                case 5: // 재고 이력 조회
                    viewStockHistory();
                    break;
                case 6: // 메인메뉴로
                    return true; // 메인 메뉴로 돌아가기
                case 7: // 종료
                    System.out.println("====================================");
                    System.out.println("");
                    System.out.println("             프로그램 종료             ");
                    System.out.println("");
                    System.out.println("====================================");
                    return false; // 프로그램 종료
                default: System.out.println("잘못된 메뉴 선택입니다.");
            }
        }
        return run; // 기본적으로 true 반환
    } // end of stockmg()
    // 재고관리 메뉴 화면
    private static void displayStockMenu() {
        System.out.println("====================================");
        System.out.println("");
        System.out.println("              재고 관리              ");
        System.out.println("");
        System.out.println("====================================");
        System.out.println("1. 재고 추가 2. 재고 수정 3. 재고 조회");
        System.out.println("4. 재고 삭제 5. 재고 이력 조회 ");
        System.out.println("6. 메인 메뉴 7. 프로그램 종료");
        System.out.println("------------------------------------");
    }// end of displayStockMenu()
    // 재고 추가
    
    //재고 추가
    private static void stockadd() {
        System.out.println("====================================");
        System.out.println("             📦 재고 추가             ");
        System.out.println("====================================");
        System.out.print("재고를 추가할 상품 번호를 입력해주세요: ");
        int productId = Integer.parseInt(scn.nextLine());
        
        // 상품 정보 조회
        ProductManager product = dao.selectById(productId);
        
        if (product == null) {
            System.out.println("해당 상품 번호의 상품이 존재하지 않습니다.");
            return;
        }

        // 현재 상품 정보 출력
        System.out.println("------------------------------------");
        System.out.println("현재 상품 정보");
        printProductInfo(product);
        System.out.println("------------------------------------");
        
        // 추가할 재고 수량 입력 받기
        System.out.print("추가할 재고 수량을 입력하세요: ");
        int additionalQuantity = Integer.parseInt(scn.nextLine());

        // 재고 수량 업데이트
        if (additionalQuantity <= 0) {
            System.out.println("추가할 수량은 0보다 커야 합니다.");
            return;
        }

        // 새로운 재고 수량 계산
        int newStockQuantity = product.getStock_quantity() + additionalQuantity;

        // 데이터베이스에 재고 변경 기록 추가
        StockRecord stockRecord = new StockRecord(productId, additionalQuantity, "재고 추가");

        // 재고 기록 추가
        if (dao.insertStockRecord(stockRecord)) { // insertStockRecord 메서드가 성공적으로 실행되면
            // 상품 테이블의 재고 수량 업데이트
            if (dao.updateProductStock(productId, newStockQuantity)) {
                System.out.println("재고가 성공적으로 추가되었습니다!");
                System.out.printf("현재 재고량: %d개%n", newStockQuantity);
            } else {
                System.out.println("재고 업데이트에 실패하였습니다.");
            }
        } else {
            System.out.println("재고 기록 추가에 실패하였습니다.");
        }
    }
    //재고 수정
    private static void stockmodify() {
    	System.out.println("====================================");
        System.out.println("            ✏️ 재고 수정              ");
        System.out.println("====================================");
        System.out.println("재고를 수정할 상품 번호를 입력하세요.");
        int productId = Integer.parseInt(scn.nextLine());
        
        // 상품 정보 조회
        ProductManager product = dao.selectById(productId);
        
        if (product == null) {
            System.out.println("해당 상품 번호의 상품이 존재하지 않습니다.");
            return;
        }
        // 현재 상품 정보 출력
        System.out.println("------------------------------------");
        System.out.println("현재 상품 정보");
        printProductInfo(product);
        System.out.println("------------------------------------");
        
        // 수정할 재고 수량 업데이트
        System.out.print("수정할 재고 수량을 입력하세요:(양수만 입력가능) ");
        int modifyQuantity = Integer.parseInt(scn.nextLine());
        
        // 양수인지 확인
        if (modifyQuantity < 0) {
            System.out.println("수정할 수량은 양수여야 합니다.");
            return;
        }
        
        // 재고 수량 업데이트 로직
        // 새로운 재고 수량을 입력된 수량으로 설정
        int newStockQuantity = modifyQuantity;

        // 데이터베이스에 재고 변경 기록 추가
        StockRecord stockRecord = new StockRecord(productId, newStockQuantity, "재고 수정");
        
        // 상품 테이블의 재고 수량 업데이트
        if (dao.updateProductStock(productId, newStockQuantity)) {
            System.out.println("재고가 성공적으로 수정되었습니다.");
        } else {
            System.out.println("재고 수정에 실패했습니다.");
        }
    }
    // 재고 목록
    //재고 조회
    private static void stocklist() {
    	  System.out.println("====================================");
          System.out.println("             📊 재고 조회             ");
          System.out.println("====================================");
          System.out.print("상품 번호를 입력하세요 (모든 상품 조회는 0 입력): ");
          int productId = Integer.parseInt(scn.nextLine());
          
          List<ProductManager> products;
          
          if (productId == 0) {
              // 모든 상품 조회
              products = dao.selcetAll();
          } else {
              // 특정 상품 조회
              ProductManager product = dao.selectById(productId);
              if (product == null) {
                  System.out.println("해당 상품 번호의 상품이 존재하지 않습니다.");
                  return;
              }
              products = new ArrayList<>();
              products.add(product);
          }
          // 재고 목록 출력
          System.out.println("------------------------------------");
          System.out.println("              재고 목록               ");
          System.out.println("------------------------------------");
          System.out.println("번호   상품명            현재재고     등록일  ");
          
          for (ProductManager product : products) {
        	  System.out.printf("%d | %-14s|  %d | %s%n",
                      product.getProduct_id(),
                      product.getProduct_name(),
                      product.getStock_quantity(),
                      product.getCreated_at());
          }

          System.out.println("메인 메뉴로 돌아가려면 5를 입력하세요");
          System.out.println("------------------------------------");
          
    }
    // 재고 삭제
    private static void stockdelete() {
    	System.out.println("====================================");
        System.out.println("            🗑️ 재고 삭제              ");
        System.out.println("====================================");
        System.out.print("삭제할 상품 번호를 입력하세요: ");
        int productId = Integer.parseInt(scn.nextLine());
        
        // 상품 정보 조회
        ProductManager product = dao.selectById(productId);
        
        if (product == null) {
            System.out.println("해당 상품 번호의 상품이 존재하지 않습니다.");
            return;
        }
        // 삭제할 상품 정보 출력
        System.out.println("------------------------------------");
        System.out.println("삭제할 상품 정보");
        printProductInfo(product);
        System.out.println("------------------------------------");
        
        System.out.print("정말 이 상품을 삭제하시겠습니까? (Y/N) : ");
        String confirmation = scn.nextLine().trim().toUpperCase();
        
        if (confirmation.equals("Y")) {
                if (dao.delete(productId)) { 
                    System.out.println("상품이 성공적으로 삭제되었습니다!");
                } else {
                    System.out.println("상품 삭제에 실패했습니다.");
                }
            
        }
    }
    // 재고 이력조회
    private static void viewStockHistory() {
        System.out.println("====================================");
        System.out.println("          📜 재고 이력 조회          ");
        System.out.println("====================================");
        
        System.out.print("조회할 상품 번호를 입력하세요: ");
        int productId = Integer.parseInt(scn.nextLine());
        
        List<StockRecord> stockHistory = dao.selectStockHistory(productId);
        
        if (stockHistory.isEmpty()) {
            System.out.println("해당 상품의 재고 이력이 없습니다.");
        } else {
            System.out.println("재고 이력:");
            for (StockRecord record : stockHistory) {
                System.out.printf("변경 수량: %d, 변경 날짜: %s, 비고: %s%n",
                        record.getChange_quantity(),
                        record.getChange_date(),
                        record.getNote());
            }
        }
    }
} // end of ProductApp