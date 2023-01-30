package app.customer;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private String name;
    private HashMap<String, ArrayList<Ordered>> ordered;

    public Customer(String name, HashMap<String, ArrayList<Ordered>> ordered) {
        this.name = name;
        this.ordered = ordered;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public Ordered findOrder(String storeName) {
        if (ordered.containsKey(storeName)) {
            for (Ordered order : ordered.get(storeName)) {
                if (!order.isFeedback()) {
                    return order;
                }
            }
        }
        return null;
    }

    public ArrayList<String> getOrderedStoreName() {
        ArrayList<String> stores = new ArrayList<>();
        for (String storeName : ordered.keySet()) {
            for (Ordered order : ordered.get(storeName)) {
                if (!order.isFeedback()) {
                    stores.add(storeName);
                    break;
                }
            }
        }
        return stores;
    }

    public ArrayList<String> getOrderedMenuName(String storeName) {
        ArrayList<String> menus = new ArrayList<>();
        if (ordered.containsKey(storeName)) {
            for (Ordered order : ordered.get(storeName)) {
                if (!order.isFeedback())
                    menus.add(order.toString());
            }
        }
        return menus;
    }

    public ArrayList<String> getReviewedMenuName(String storeName) {
        ArrayList<String> menus = new ArrayList<>();
        if (ordered.containsKey(storeName)) {
            for (Ordered order : ordered.get(storeName)) {
                if (order.isFeedback())
                    menus.add(order.toString());
            }
        }
        return menus;
    }

    public void printOrdered() {
        if (isOrdered()) {
            System.out.println("\n[안내] 아직 주문하신 음식이 없어요.\n");
            return;
        }
        if (!isFeedback()) {
            System.out.println("\n[안내] 아직 리뷰를 남긴 음식이 없어요.\n");
            return;
        }
        System.out.printf("\n[안내] %s 고객님이 현재까지 주문한 목록입니다.\n", name);
        for (String storeName : ordered.keySet()) {
            System.out.printf("%s\n주문 목록 %s\n", storeName, getReviewedMenuName(storeName));
        }
        System.out.println();
    }

    public boolean isFeedback() {
        for (String storeName : ordered.keySet()) {
            for (Ordered order : ordered.get(storeName)) {
                if (order.isFeedback()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addOrdered(String shopName, String menu) {
        if (ordered.containsKey(shopName)) {
            ordered.get(shopName).add(new Ordered(menu, 0));
        } else {
            ordered.put(shopName, new ArrayList<>() {{
                add(new Ordered(menu, 0));
            }});
        }
    }

    public boolean isOrdered() {
        return ordered.isEmpty();
    }
}
