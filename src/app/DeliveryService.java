package app;
import app.customer.CustomerRepository;
import app.shop.ShopRepository;

import java.util.ArrayList;
import java.util.HashSet;

public class DeliveryService {
    public void run() {
        ShopRepository shopRepository = new ShopRepository(new HashSet<>(){});
        CustomerRepository customerRepository = new CustomerRepository(new ArrayList<>());
        Order order = new Order(shopRepository, customerRepository);
        Feedback feedback = new Feedback(customerRepository);
        while (true) {
            printOption();
            int menuId = Reader.readMenu();
            if (menuId == 5) {
                System.out.println("[안내] 이용해주셔서 감사합니다.");
                break;
            }
            switch (menuId) {
                case 1:
                    shopRepository.addShop();
                    break;
                case 2:
                    feedback.findFeedback();
                    break;
                case 3:
                    order.makeOrder();
                    break;
                case 4:
                    feedback.addFeedback();
                    break;
            }
        }
    }

    public void printOption() {
        System.out.println("[치킨의 민족 프로그램 V1]");
        System.out.println("-".repeat(30));
        System.out.println("1) [사장님용] 음식점 등록하기");
        System.out.println("2) [고객님과 사장님용] 음식점 별점 조회하기");
        System.out.println("3) [고객님용] 음식 주문하기");
        System.out.println("4) [고객님용] 별점 등록하기");
        System.out.println("5) 프로그램 종료하기");
        System.out.println("-".repeat(30));
        System.out.println("[시스템] 무엇을 도와드릴까요? ");
    }
}
