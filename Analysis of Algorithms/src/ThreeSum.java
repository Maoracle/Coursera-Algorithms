import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ThreeSum {
    public static void main(String[] args){
        ArrayList<Integer> data = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            data.add(sc.nextInt());
        }

        Collections.sort(data);

        for (int i = 0; i + 2 < data.size(); i++){
            if (i > 0 && data.get(i) == data.get(i-1)){
                continue;
            }
            int j = i + 1, k = data.size() - 1;
            int target = -data.get(i);
            while (j < k){
                if (data.get(j) + data.get(k) == target){
                    System.out.println(i+":"+data.get(i)+", "+j+":"+data.get(j)+", "+k+":"+data.get(k));
                    j++;
                    k--;
                    while (j < k && data.get(j) == data.get(j - 1)) j++;
                    while (j < k && data.get(k) == data.get(k + 1)) k++;
                }
                if (data.get(j) + data.get(k) > target){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
    }

}
