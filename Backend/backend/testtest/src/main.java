import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        int[] dataOG = {1, 6, 6, 8, 4, 8, 8, 5, 8,0,3,0,0,41,7,9,9,8,74,0,0,6,96,78,0,6,59,5,0,56, 9, 6, 7, 3};
        int[] data = Arrays.stream(dataOG).sorted().toArray();
        int same = 0;
        int lastValue = data[data.length-1];

        // Imperative
        for(int i = 0;i<data.length; i++){
            if(lastValue==data[i]){
                continue;
            }
            lastValue = data[i];
            for(int j = 0;j<data.length; j++){
                if(data[i]==data[j]){
                    same++;
                }
            }
            System.out.println(data[i] + "--->" + same + "x");
            same = 0;
        }

        // Declarative
        System.out.println("DECLARATIVE");

        Arrays.stream(dataOG)
                .sorted()
                .mapToObj()


//        for(int d =0;d<data.length;d++){
//            System.out.println(data[d]);
//        }

//        for(int i = 0;i<data.length; i++){
//            for(int j = 0;j<data.length; j++){
//                if(data[i]==data[j]){
//                    same++;
//                }
//            }
//            System.out.println(data[i] + ":" + same);
//            same = 0;
//        }

    }
}
