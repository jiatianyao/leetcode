package 牛客.中等;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
 * 链表的值不能重复。
 * 构造过程，例如
 * 1 <- 2       12
 * 3 <- 2       231
 * 5 <- 1       2315
 * 4 <- 5       23154
 * 7 <- 2       273154
 * 最后的链表的顺序为 2 7 3 1 5 4
 * 删除 结点 2
 * 则结果为 7 3 1 5 4
 * 链表长度不大于1000，每个节点的值不大于10000。
 * 本题含有多组样例。
 */
public class HJ48 {
    public static void main(String[] args) {

        Scanner sca = new Scanner(System.in);
        while (sca.hasNext()) {
            List<Integer> list = new LinkedList<>();
            int count = sca.nextInt();
            Integer head = sca.nextInt();
            list.add(head);
            for (int i = 0; i < count - 1; i++) {
                Integer src = sca.nextInt();
                Integer temp = sca.nextInt();
                if (list.contains(src)) {
                    continue;
                }
                int weizhi = list.indexOf(temp);
                if (weizhi == -1) {
                    continue;
                }
                list.add(weizhi + 1, src);
            }
            Integer delete = sca.nextInt();
            list.remove(delete);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i) + " ");
            }
            // sb = sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }
}
