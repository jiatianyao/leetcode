package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 2021年4月24日 20:51:19
 */
public class HJ98 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            String[] split1 = str1.split(";");
            str1 = split1[0];
            String[] s = str1.split(" ");
            String productString = s[1];
            String[] split = productString.split("-");
            Product product1 = new Product("A1",2,Integer.parseInt(split[0]));
            Product product2 = new Product("A2",3,Integer.parseInt(split[1]));
            Product product3 = new Product("A3",4,Integer.parseInt(split[2]));
            Product product4 = new Product("A4",5,Integer.parseInt(split[3]));
            Product product5 = new Product("A5",8,Integer.parseInt(split[4]));
            Product product6 = new Product("A6",6,Integer.parseInt(split[5]));
            List<Product> list = new ArrayList<>();
            list.add(product1);
            list.add(product2);
            list.add(product3);
            list.add(product4);
            list.add(product5);
            list.add(product6);
            list.sort((o1, o2) -> {
                if(o1.getQuantity().equals(o2.getQuantity())){
                    return o2.getName().compareTo(o1.getName());
                }
                return o2.getQuantity().compareTo(o1.getQuantity());
            });

            String moneyboxString = s[1];
            String[] split2 = moneyboxString.split("-");
            Moneybox moneybox1 = new Moneybox("1",Integer.parseInt(split[0]));
            Moneybox moneybox2 = new Moneybox("2",Integer.parseInt(split[1]));
            Moneybox moneybox3 = new Moneybox("5",Integer.parseInt(split[2]));
            Moneybox moneybox4 = new Moneybox("10",Integer.parseInt(split[3]));
            List<Moneybox> moneyboxList = new ArrayList<>();
            moneyboxList.add(moneybox1);
            moneyboxList.add(moneybox2);
            moneyboxList.add(moneybox3);
            moneyboxList.add(moneybox4);

            System.out.println("S001:Initialization is successful");

            int p = 0;//投币
            List<Moneybox> moneyboxListP = new ArrayList<>();
            Moneybox moneyboxP1 = new Moneybox("1",0);
            Moneybox moneyboxP2 = new Moneybox("2",0);
            Moneybox moneyboxP3 = new Moneybox("5",0);
            Moneybox moneyboxP4 = new Moneybox("10",0);
            moneyboxListP.add(moneyboxP1);
            moneyboxListP.add(moneyboxP2);
            moneyboxListP.add(moneyboxP3);
            moneyboxListP.add(moneyboxP4);

            for (int i = 1; i < split1.length; i++) {
                int last = getProductSum(list);
                String command = split1[i];
//                System.out.println("==="+command);
                if(command.contains("c")){
                    if(p==0){
                        System.out.println("E009:Work failure");
                    }else{
                        printMoneyBox(moneyboxListP);
                        p = 0;
                        for (Moneybox moneybox : moneyboxListP) {
                            moneybox.setNum(0);
                        }
                    }



                }else if(command.contains("p")){
                    String[] s1 = command.split(" ");
                    int p2 = Integer.parseInt(s1[1]);
                    p+=p2;
                    if(p>0){
                        Moneybox moneybox1Yuan = moneyboxList.get(0);
                        Integer num1 = moneybox1Yuan.getNum();
                        Moneybox moneybox2Yuan = moneyboxList.get(1);
                        Integer num2 = moneybox2Yuan.getNum();
                        addP(moneyboxListP,p2);
                        if(num1+num2 < p){
                            System.out.println("E003:Change is not enough, pay fail");
                        }else{
                            System.out.println("S002:Pay success,balance="+p);
                        }
                    }else if(p==0){
                        System.out.println("E002:Denomination error");
                    }else if(last ==0){
                        System.out.println("E005:All the goods sold out");
                    }else{
                        System.out.println("S002:Pay success,balance="+p);
                    }
                }else if(command.contains("b")){
                    String[] s1 = command.split(" ");
                    String name = s1[1];
                    boolean isOk = isProductExist(list,name);
                    Product product = getProductNum(list,name);
                    if(!isOk){
                        System.out.println("E006:Goods does not exist");
                    }else if(product.getQuantity() ==0){
                        System.out.println("E007:The goods sold out");
                    }else if(product.getPrice() > p){
                        System.out.println("E008:Lack of balance");
                    }else{
                        Integer price = product.getPrice();
                        p-= price;
                        subProduct(list,name);
                        subMoneyBox(moneyboxListP,moneyboxList,price);
                        System.out.println("S003:Buy success,balance="+p);
                    }
                }else if(command.contains("q")){
                    if(command.equals("q1")){
                        printProduct(list);
                    }else if(command.equals("q2")){
                        printMoneyBox(moneyboxList);
                    }else{
                        System.out.println("E010:Parameter error");
                    }
                }
            }


        }
    }



    private static void addP(List<Moneybox> moneyboxListP, int c1) {
        for (Moneybox moneybox : moneyboxListP) {
            String name = moneybox.getName();
            Integer num = moneybox.getNum();
            if(name.equals(""+c1)){
                moneybox.setNum(++num);
            }
        }
    }

    private static void subMoneyBox(List<Moneybox> moneyboxListP, List<Moneybox> moneyboxList,int price) {
            Moneybox moneyboxP10 = moneyboxListP.get(3);
            Moneybox moneyboxP5 = moneyboxListP.get(2);
            Moneybox moneyboxP2 = moneyboxListP.get(1);
            Moneybox moneyboxP1 = moneyboxListP.get(0);

            if(moneyboxP1.getNum() >= price){
                Moneybox moneybox1 = moneyboxList.get(0);
                moneyboxP1.setNum(moneyboxP1.getNum()-price/1);
                moneybox1.setNum(moneybox1.getNum()+price/1);
            }else if(moneyboxP2.getNum() * 2 >= price - moneyboxP1.getNum()){
                price =  price - moneyboxP1.getNum();
                if(price%2 ==0){
                    Moneybox moneybox1 = moneyboxList.get(0);
                    Moneybox moneybox2 = moneyboxList.get(1);
                    moneyboxP1.setNum(0);
                    moneybox1.setNum(moneybox1.getNum()+moneyboxP1.getNum());
                    moneyboxP2.setNum(moneyboxP2.getNum()-price/2);
                    moneybox2.setNum(moneybox2.getNum()+price/2);
                }else{
                    moneyboxP1.setNum(1);
                    price =price+1;
                    moneyboxP2.setNum(moneyboxP2.getNum()-price/2);
                    Moneybox moneybox1 = moneyboxList.get(0);
                    Moneybox moneybox2 = moneyboxList.get(1);
                    moneybox1.setNum(moneybox1.getNum()+moneyboxP1.getNum()-1);
                    moneybox2.setNum(moneybox2.getNum()+price/2);

                }
            }else if(moneyboxP5.getNum() * 5 >= price - moneyboxP1.getNum()*1 -  moneyboxP2.getNum()*2){
                if(price ==5){
                    moneyboxP5.setNum(moneyboxP5.getNum()-1);
                    Moneybox moneybox5 = moneyboxList.get(3);
                    moneybox5.setNum(moneybox5.getNum()+1);
                }
                if(price ==8){
                    if(moneyboxP1.getNum() >=3){
                        moneyboxP5.setNum(moneyboxP5.getNum()-1);
                        Moneybox moneybox5 = moneyboxList.get(3);
                        moneybox5.setNum(moneybox5.getNum()+1);
                        Moneybox moneybox1 = moneyboxList.get(1);
                        moneybox1.setNum(moneybox1.getNum()+3);
                        moneyboxP1.setNum(moneyboxP1.getNum()-3);
                    }else if(moneyboxP2.getNum() >=1 && moneyboxP1.getNum() >=1 ){
                        moneyboxP5.setNum(moneyboxP5.getNum()-1);
                        Moneybox moneybox5 = moneyboxList.get(3);
                        moneybox5.setNum(moneybox5.getNum()+1);
                        Moneybox moneybox1 = moneyboxList.get(1);
                        moneybox1.setNum(moneybox1.getNum()+1);
                        moneyboxP1.setNum(moneyboxP1.getNum()-1);
                        Moneybox moneybox2 = moneyboxList.get(2);
                        moneybox2.setNum(moneybox2.getNum()+1);
                        moneyboxP2.setNum(moneyboxP2.getNum()-1);
                    }else if(moneyboxP2.getNum() >=2){

                    }
                }
            }



    }

    private static void subProduct(List<Product> list, String name) {
        for (Product product : list) {
            String name1 = product.getName();
            if(name1.equals(name)){
                Integer quantity = product.getQuantity();

                product.setQuantity(quantity-1);
            }
        }
    }

    private static Product getProductNum(List<Product> list, String name) {
        for (Product product : list) {
            String name1 = product.getName();
            if(name1.equals(name)){
                return product;
            }
        }
        return null;
    }

    private static boolean isProductExist(List<Product> list, String name) {
        for (Product product : list) {
            String name1 = product.getName();
            if(name1.equals(name)){
                return true;
            }
        }
        return false;
    }

    /**获取商品总额**/
    private static int getProductSum(List<Product> list) {
        int sumQuantity = 0;
        for (int i = 0; i < list.size(); i++) {
            Product product = list.get(i);
            Integer quantity = product.getQuantity();
            sumQuantity+=quantity;
        }
        return sumQuantity;
    }

    private static void printMoneyBox(List<Moneybox> moneyboxList) {
        for (int j = 0; j < moneyboxList.size(); j++) {
            Moneybox moneybox = moneyboxList.get(j);
            System.out.println(moneybox.getName()+" yuan coin number="+moneybox.getNum());

        }
    }

    private static void printProduct(List<Product> list) {
        for (int i = 0; i < list.size(); i++) {
            Product product = list.get(i);
            System.out.println(product.getName()+" "+product.getPrice()+" "+product.getQuantity());

        }
    }

}


class Product{
    private String name;
    private Integer price;
    private Integer quantity;

    public Product(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

class Moneybox{
    private String name;
    private Integer num;

    public Moneybox(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}