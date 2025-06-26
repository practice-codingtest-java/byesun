import java.util.Arrays;

public class 이모티콘할인행사 {
    public static void main(String[] args) {
        int[][] users = new int[][]{{40,10000},{25,10000}};
        int[] emoticons = new int[]{7000,9000};
        int[] result = solution(users,emoticons);
        System.out.println(Arrays.toString(result));
    }

    static int[] discount = {10,20,30,40};
    static int maxPlus = 0;
    static int maxSales = 0;

    public static int[] solution(int[][] users, int[] emoticons) {
        dfs(0,new int[emoticons.length],users,emoticons);
        return new int[]{maxPlus,maxSales};
    }
    private static void dfs(int depth, int[] discount_percent, int[][] users, int[] emoticons) {
        if(depth == users.length) {
            valuate(discount_percent,users,emoticons);
            return;
        }

        for(int d : discount) {
            discount_percent[depth] = d;
            dfs(depth+1,discount_percent,users,emoticons);
        }
    }
    private static void valuate(int[] discount_percent, int[][] users, int[] emoticons) {
        int plusCount = 0;
        int totalSales = 0;

        for(int[] user : users) {
            int minDiscount = user[0];
            int maxPrice = user[1];

            int userTotal = 0;

            for(int i=0; i<emoticons.length; i++) {
                if(discount_percent[i] >= minDiscount) {
                    int discountPirce = emoticons[i] * (100 - discount_percent[i]) / 100;
                    userTotal += discountPirce;
                }
            }
            if(userTotal >= maxPrice) {
                plusCount++;
            } else {
                totalSales += userTotal;
            }
        }
        if(plusCount > maxPlus) {
            maxPlus = plusCount;
            maxSales = totalSales;
        } else if(plusCount == maxPlus && totalSales > maxSales) {
            maxSales = totalSales;
        }
    }
}
