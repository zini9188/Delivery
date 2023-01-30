package app.shop;

import java.util.HashMap;
import java.util.Objects;

public class Shop {
    private String storeName;
    private HashMap<String, Integer> menus;

    public Shop(String storeName, HashMap<String, Integer> menus) {
        this.storeName = storeName;
        this.menus = menus;
    }

    public boolean isSameShop(String storeName) {
        return this.storeName.equals(storeName);
    }

    public void addMenu(String shopName, Menu menu) { // 음식 등록
        if (menus.containsKey(menu.getName())) {
            System.out.println("[안내] 이미 있는 메뉴 입니다.");
            return;
        }
        menus.put(menu.getName(), menu.getPrice());
        System.out.printf("[안내] %s에 음식(%s, %d) 추가되었습니다.\n", shopName, menu.getName(), menu.getPrice());
        System.out.println("[시스템] 가게 등록이 정상 처리되었습니다.");
    }

    public String getName() {
        return storeName;
    }

    public void showMenu() {
        System.out.printf("[안내] 현재 %s에 등록된 메뉴입니다.\n", getName());
        System.out.println("-".repeat(30));
        for (String name : menus.keySet()) {
            System.out.printf("[메뉴 이름: %10s, 가격: %6d]\n", name, menus.get(name));
        }
        System.out.println("-".repeat(30));
    }

    public Menu findByMenu(String menuName) {
        if (menus.containsKey(menuName)) {
            return new Menu(menuName, menus.get(menuName));
        }
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeName);
    }

    @Override
    public boolean equals(Object obj) {
        Shop shop = (Shop) obj;
        return shop.storeName.equals(this.storeName);
    }

}
