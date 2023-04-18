import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        //int n = 7;
        int n = 9;
        //List<Integer> ar = List.of(1, 2, 1, 2, 1, 3, 2);
        List<Integer> ar = List.of(10, 20, 20, 10, 10, 30, 50, 10, 20);
        int res = sockMerchant(n, ar);
        System.out.printf(String.valueOf(res));
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        int res = 0;
        if (n != ar.size()) return 0;
        Map<Integer, Integer> mem = new HashMap<>();

        for (Integer num : ar) {
            if (mem.containsKey(num)) {
                int val = mem.get(num);

                if ((val + 1) == 2) {
                    res++;
                    mem.put(num, 0);
                } else {
                    mem.put(num, (mem.get(num) + 1));
                }
            } else {
                mem.put(num, 1);
            }
        }

        return res;
    }

    public static int sockMerchant2(int n, List<Integer> ar) {
        Collections.sort(ar);
        int res = 0;
        for(int i=0; i<ar.size()-1; i++){
            if(Objects.equals(ar.get(i), ar.get(i + 1))){
                res++;
                i++;
            }
        }
        return res;
    }
}