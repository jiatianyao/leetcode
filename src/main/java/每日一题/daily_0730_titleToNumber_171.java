package 每日一题;

/**
 * 171. Excel 表列序号
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 * 例如，
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 * 输入: columnTitle = "A"
 * 输出: 1
 * 示例 2:
 * 输入: columnTitle = "AB"
 * 输出: 28
 * 示例 3:
 * 输入: columnTitle = "ZY"
 * 输出: 701
 * 示例 4:
 * 输入: columnTitle = "FXSHRXW"
 * 输出: 2147483647
 */
public class daily_0730_titleToNumber_171 {

    public int titleToNumber(String columnTitle) {
        int number = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            number += k * multiple;
            multiple *= 26;
        }
        return number;
    }

}
