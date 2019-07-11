package com.zh.code;

/**
 * create by zj on 2019/7/9
 */
public class CommonDivisor {

    public static void main(String[] args){
        System.out.println( getValues(2,3)+"--"+getValues2(2,3)+"--"+getValues3(5,10));
        System.out.println(getValues4(2,3)+"--"+getValues4(25,100)+"--"+getValues4(5,10));
    }

    /**
     * @param a
     * @param b
     * 暴力法：for循环
     * 如果是10000和10001时，需要循环4999次。太麻烦。
     */
    public static int getValues(int a,int b){
        int small=Math.min(a,b);
        int big=Math.max(a,b);

        if (big%small==0){
            return small;
        }

        for (int i=big/2;i>1;i--){
            if (small%i==0&&big%i==0){
                return i;
            }
        }

        return 1;
    }


    /**
     * @param a
     * @param b
     * @return
     * 辗转相除法（欧几里得算法）
     * a和b的最大公约数（a>b）等于a%b的余数与b的最大公约数
     * 问题：a和b的值过大时，取模运算性能太差
     */
    public static int getValues2(int a,int b){
        int small=Math.min(a,b);
        int big=Math.max(a,b);

        if (big%small==0){
            return small;
        }
       return getValues2(big%small,small);
    }


    /**
     * @param a
     * @param b
     * @return
     * 更相减损法
     *  a>b ,a-b=c和b的最大公约数等于a，b的最大公约数
     *
     *  问题：如果是10000和1的最大公约数，这时，递归的次数就有9999次，
     */
    public static int getValues3(int a,int b){
        int small=Math.min(a,b);
        int big=Math.max(a,b);

        if (small==big){
            return small;
        }
        return getValues3(big-small,small);
    }


    /**
     * @param a
     * @param b
     * @return
     * 优化方法：对更相减损法进行位移操作。
     * 如果：a，b均为偶数。则gcd代表方法名，gcd(a,b)=2*gcd(a/2,b/2)=2*gcd(a>>1,b>>1);
     * 若a为奇数，b为偶数，则：gcd(a,b)=gcd(a,b>>1)
     * 若b为奇数，a为偶数，则：gcd(a,b)=gcd(a>>1,b)
     */
    public static int getValues4(int a,int b){
        if (a==b){
            return a;
        }
        if ((a&1)==0&&(b&1)==0){
            return getValues4(a>>1,b>>1)<<1;
        }else if ((a&1)==0&&(b&1)!=0){
            return getValues4(a>>1,b);
        }else if ((a&1)!=0&&(b&1)==0){
            return getValues4(a,b>>1);
        }else{
            int big=Math.max(a,b);
            int small=Math.min(a,b);
            return getValues4(big-small,small);
        }

    }


}
