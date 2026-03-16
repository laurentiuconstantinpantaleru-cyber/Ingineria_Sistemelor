package lab2;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;
import java.util.TreeSet;
import java.util.Set;
public class main {

    public static void main() {

        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusY = new ArrayList(); //a
        Set<Integer> zSet = new TreeSet(); //b
        List<Integer> xMinusY = new ArrayList();//c
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList(); //dn
        Random rand= new Random();

        for (int i = 0; i < 5; i++) {
            x.add(rand.nextInt(11));
        }
        for (int i = 0; i < 7; i++) {
            y.add(rand.nextInt(11));
        }


        Collections.sort(x);
        Collections.sort(y);

        System.out.println("Lista x: " + x);
        System.out.println("Lista y: " + y);

        xPlusY.addAll(y);
        xPlusY.addAll(x);
        Collections.sort(xPlusY);
        System.out.println("a) xPlusY (toate elementele): " + xPlusY);

        zSet.addAll(x);
        zSet.retainAll(y);
        System.out.println("b) zSet (valori comune): " + zSet);

        xMinusY.addAll(x);
        xMinusY.removeAll(y);
        System.out.println("c) xMinusY (doar in x): " + xMinusY);

        for (Integer val : x) {
            if (val <= p) xPlusYLimitedByP.add(val);
        }
        for (Integer val : y) {
            if (val <= p) xPlusYLimitedByP.add(val);
        }
        System.out.println("d) xPlusYLimitedByP (<= " + p + "): " + xPlusYLimitedByP);
    }
}