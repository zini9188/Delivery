package app;

import app.shop.Menu;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private String name;
    private HashMap<String, ArrayList<Menu>> ordered;

    public Customer(String name, HashMap<String, ArrayList<Menu>> ordered) {
        this.name = name;
        this.ordered = ordered;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public void printOrdered() {
        if (ordered.isEmpty()) {
            System.out.println("[안내] 아직 주문하신 음식이 없네요");
        }
        System.out.printf("[안내] %s 고객님이 현재까지 주문한 목록입니다.\n", name);
        for (String storeName : ordered.keySet()) {
            System.out.printf("%s", storeName);
            for (Menu menu : ordered.get(storeName)) {
                System.out.println(menu.getName());
            }
        }
    }

    public void addOrdered(String shopName, Menu menu) {
        if (ordered.containsKey(shopName)) {
            ordered.get(shopName).add(menu);
        } else {
            ordered.put(shopName, new ArrayList<>() {{
                add(menu);
            }});
        }
    }
}
