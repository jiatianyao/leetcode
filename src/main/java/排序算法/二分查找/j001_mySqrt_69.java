package 排序算法.二分查找;

public class j001_mySqrt_69 {
    public int mySqrt(int x) {
        double head =0.0,tail=x,mid;
        tail +=1;
        for (int i = 0; i < 100; i++) {
            mid = head +((tail - head) /2);
            if(mid * mid <= x){
                head = mid;
            }else{
                tail = mid ;
            }
        }
        return (int)Math.floor(head);
    }

    public static void main(String[] args) {
        j001_mySqrt_69 demo = new j001_mySqrt_69();
        demo.mySqrt(4);
    }
}
