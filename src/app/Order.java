package app;

import app.customer.Customer;
import app.customer.CustomerRepository;
import app.shop.Shop;
import app.shop.ShopRepository;

public class Order {
    private ShopRepository shopRepository;
    private CustomerRepository customerRepository;

    public Order(ShopRepository shopRepository, CustomerRepository customerRepository) {
        this.shopRepository = shopRepository;
        this.customerRepository = customerRepository;
    }

    public void makeOrder() {
        if (shopRepository.isEmpty()) {
            return;
        }
        System.out.println("[안내] 고객님! 메뉴 주문을 진행하겠습니다!");
        System.out.println("[안내] 주문자 이름을 알려주세요!");
        String userName = Reader.readName();
        String shopName = getShopName();
        if (shopName.isEmpty()) {
            return;
        }
        Shop findShop = shopRepository.findByShop(shopName);
        String menuName = getMenuName(findShop);
        if (menuName.isEmpty()) {
            return;
        }
        System.out.printf("\n[안내] %s님!\n", userName);
        System.out.printf("[안내] %s 매장에 %s 주문이 완료되었습니다.\n\n", shopName, menuName);
        Customer customer = customerRepository.findByName(userName);
        customer.addOrdered(shopName, menuName);
    }

    private String getMenuName(Shop shop) {
        while (true) {
            shop.showMenu();
            System.out.println("[안내] 주문할 메뉴 이름을 알려주세요!");
            String menuName = Reader.readName();
            if (shop.findByMenu(menuName) == null) {
                System.out.println("[안내] 없는 메뉴입니다! 다시 입력하시려면 엔터를, 주문을 종료하시려면 0을 입력해주세요.");
                String input = Reader.readName();
                if (input.equals("0")) {
                    return "";
                }
            } else {
                return menuName;
            }
        }
    }

    private String getShopName() {
        while (true) {
            shopRepository.printShop();
            System.out.println("[안내] 주문할 음식점 상호는 무엇인가요?");
            String shopName = Reader.readName();
            if (shopRepository.findByShop(shopName) == null) {
                System.out.println("[안내] 없는 음식점입니다! 다시 입력하시려면 엔터를, 주문을 종료하시려면 0을 입력해주세요.");
                String input = Reader.readName();
                if (input.equals("0")) {
                    return "";
                }
            } else {
                return shopName;
            }
        }
    }
}
