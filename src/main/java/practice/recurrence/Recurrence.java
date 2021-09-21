package practice.recurrence;

/**
 * Created by dell on 2021/9/21.
 */
public class Recurrence {

    /**
     * 假设1个细胞的生命周期是3小时，1小时分裂一次。求n小时后，容器内有多少个细胞
     * f(n) = 2(f(n-1))-f(n-4)988
     */
    public void cell(int n){
        // 当前
        int count = n;
        //1小时后
        count = n + 2 * n;
        //2小时后
        count = (n + 2 * n) + 2 * (n + 2 * n);


    }

}
