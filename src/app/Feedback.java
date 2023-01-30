package app;

import app.customer.Customer;
import app.customer.CustomerRepository;
import app.customer.Ordered;

import java.util.ArrayList;

public class Feedback {
    private CustomerRepository customerRepository;

    public Feedback(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void findFeedback() {
        System.out.println("[안내] 음식점 별점 조회하기 메뉴입니다.");
        System.out.println("[안내] 고객님의 이름을 알려주세요.");
        String name = Reader.readName();
        Customer customer = customerRepository.findByName(name);
        customer.printOrdered();
    }

    public void addFeedback() {
        System.out.println("[안내] 별점 등록하기 메뉴입니다.");
        System.out.println("[안내] 주문자 이름은 무엇인가요?");
        String name = Reader.readName();
        Customer customer = customerRepository.findByName(name);
        ArrayList<String> stores = customer.getOrderedStoreName();
        if (stores.toString().equals("[]")) {
            System.out.println("\n[안내] 리뷰를 남길 가게가 없어요.\n");
            return;
        }
        String storeName = getStoreName(name, stores);
        ArrayList<String> menus = customer.getOrderedMenuName(storeName);
        getMenuName(name, menus);
        int grade = getGrade();
        Ordered ordered = customer.findOrder(storeName);
        ordered.setGrade(grade);
        System.out.println("[안내] 리뷰 등록이 완료되었습니다.\n");
    }

    private int getGrade() {
        while (true) {
            System.out.println("[안내] 음식맛은 어떠셨나요? (1점 ~ 5점)");
            int grade = Reader.readPrice();
            if (grade > 0 && grade <= 5) {
                return grade;
            }
        }
    }

    private String getMenuName(String name, ArrayList<String> menus) {
        while (true) {
            System.out.printf("[안내] %s 님이 주문하셨던 메뉴 중 리뷰를 남기지 않은 메뉴에요.\n", name);
            System.out.println("-".repeat(30));
            System.out.println(menus.toString());
            System.out.println("-".repeat(30));
            System.out.println("[안내] 리뷰를 남길 음식 이름은 무엇인가요?");
            String menuName = Reader.readName();
            if (menus.contains(menuName)) {
                return menuName;
            }
        }
    }

    public String getStoreName(String name, ArrayList<String> stores) {
        while (true) {
            System.out.printf("[안내] %s 님이 리뷰를 남기지 않은 가게 이름이에요.\n", name);
            System.out.println("-".repeat(30));
            System.out.println(stores.toString());
            System.out.println("-".repeat(30));
            System.out.println("[안내] 리뷰를 남길 음식점 상호는 무엇인가요?");
            String storeName = Reader.readName();
            if (stores.contains(storeName)) {
                return storeName;
            }
        }
    }
}
