package app.shop;

import app.Reader;

import java.util.HashMap;
import java.util.HashSet;

public class ShopRepository {
    private HashSet<Shop> shops;

    public ShopRepository(HashSet<Shop> shops) {
        this.shops = shops;
    }

    public Shop findByShop(String name) {
        for (Shop shop : shops) {
            if (shop.isSameShop(name)) {
                return shop;
            }
        }
        return null;
    }

    public void addShop() {
        System.out.println("[안내] 반갑습니다. 가맹주님!");
        printShop();
        System.out.println("[안내] 음식점 상호는 무엇인가요?");
        String shopName = Reader.readName();
        System.out.println("[안내] 대표 메뉴 이름은 무엇인가요?");
        String menuName = Reader.readName();
        System.out.println("[안내] 해당 메뉴 가격은 얼마인가요?");
        int menuPrice = Reader.readPrice();
        Shop shop = findByShop(shopName);
        if (shop == null) {
            shops.add(new Shop(shopName, new HashMap<>() {{
                put(menuName, menuPrice);
            }}));
        } else {
            shop.addMenu(shopName, new Menu(menuName, menuPrice));
        }
    }

    public void printShop() {
        if (!shops.isEmpty()) {
            System.out.println("[안내] 현재 등록된 음식점 상호입니다.");
            System.out.println("-".repeat(30));
            for (Shop shop : shops) {
                System.out.printf("%8s ", shop.getName());
            }
            System.out.println("\n" + "-".repeat(30));
        }
    }

    public boolean isEmpty() {
        if (shops.isEmpty()) {
            System.out.println("\n[안내] 현재 등록된 매장이 없습니다.\n");
            return true;
        }
        return false;
    }

}
