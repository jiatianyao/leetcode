package 每日一题;

import java.util.*;
import java.util.stream.Collectors;

public class daily_0706_displayTable {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> result = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        Set<String> foodSet = new HashSet<>();
        for (List<String> order : orders) {
            String tableNumber = order.get(1);
            String foodItem = order.get(2);
            String key = tableNumber + "-"+foodItem;
            map.put(key,map.getOrDefault(key,0) + 1);
            foodSet.add(foodItem);
        }

        List<String> foodList = foodSet.stream().collect(Collectors.toList());
        Collections.sort(foodList);
        List<String> row1 = new ArrayList<>();
        row1.add("Table");

        for (int i = 0; i < foodList.size(); i++) {
            row1.add(foodList.get(i));
        }
        result.add(row1);
        Map<Integer,Map<String,Integer>> map2 = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            String[] split = key.split("-");
            String  tableNumber= split[0];
            int tableNumberI = Integer.parseInt(tableNumber);
            String  foodItem= split[1];
            Map<String,Integer> map3 = new HashMap<>();
            if(map2.get(tableNumberI)!=null){
                map3 = map2.get(tableNumberI);

            }
            map3.put(foodItem, value);
            map2.put(tableNumberI, map3);
        }

        for (Map.Entry<Integer, Map<String, Integer>> entry : map2.entrySet()) {
            Integer key = entry.getKey();
            List<String> rowN = new ArrayList<>();
            rowN.add(""+key);
            Map<String, Integer> mapR = entry.getValue();
            for (int i = 1; i < row1.size(); i++) {
                String foodName = row1.get(i);
                Integer foodItem = mapR.getOrDefault(foodName, 0);
                rowN.add(""+foodItem);
            }
            result.add(rowN);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>();
        List<String> foodList1 = new ArrayList<>();
        foodList1.add("David");
        foodList1.add("3");
        foodList1.add("Ceviche");
        List<String> foodList2 = new ArrayList<>();
        foodList2.add("Corina");
        foodList2.add("10");
        foodList2.add("Beef Burrito");
        List<String> foodList3 = new ArrayList<>();
        foodList3.add("David");
        foodList3.add("3");
        foodList3.add("Fried Chicken");
        List<String> foodList4 = new ArrayList<>();
        foodList4.add("Carla");
        foodList4.add("5");
        foodList4.add("Water");
        List<String> foodList5 = new ArrayList<>();
        foodList5.add("Carla");
        foodList5.add("5");
        foodList5.add("Ceviche");
        List<String> foodList6 = new ArrayList<>();
        foodList6.add("Rous");
        foodList6.add("3");
        foodList6.add("Ceviche");
        input.add(foodList1);
        input.add(foodList2);
        input.add(foodList3);
        input.add(foodList4);
        input.add(foodList5);
        input.add(foodList6);
        daily_0706_displayTable demo = new daily_0706_displayTable();
        demo.displayTable(input);
    }
}
