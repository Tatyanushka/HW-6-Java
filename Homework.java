import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

public class Homework {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            int r = new Random().nextInt(50);
            int r2 = new Random().nextInt(50);
            int r3 = new Random().nextInt(50);

            hs.add(r);
            lhs.add(r2);
            ts.add(r3);
        }
        System.out.println("hs: " + hs);
        System.out.println("lhs: " +lhs);
        System.out.println("ts: " +ts);


        ArrayList<Integer> list = new ArrayList<>();
        Iterator<Integer> it = hs.iterator();
        while(it.hasNext()) {
            int i = it.next(); 
            if(lhs.contains(i)) {
                list.add(i); 
                it.remove();
            }
        }
        System.out.println();
        System.out.println("hs, в котором удалены повторяющееся ключи из lhs, если такие имеются: " + hs);
        

        ArrayList<Integer> list2 = new ArrayList<>();
        Iterator<Integer> it2 = lhs.iterator();
        while(it2.hasNext()) {
            int i = it2.next(); 
            if(ts.contains(i)) {
                break;
            }
            else {
                list2.add(i);
                ts.add(i);
            }
        }   
        System.out.println();
        System.out.println("ts, в который добавлен ключ отсутствующий в lhs: " +ts);
        System.out.println();

    //5.Объявить и инициализировать множество TreeSet ts1 с компаратором Integer (-1 при значении %2==0 ;0 при ==;1 при значении %2!=0). Заполнить ts1 15 случайными числами и вывести на печать.

        Comparator<Integer> comparator = new Comparator<Integer>() { 
            public int compare(Integer t0, Integer t1) {
                return ((t0 - t1)%2==0)?-1:((t0 - t1%2)!=0)?1:0;
            }
        };

        TreeSet<Integer> ts1 = new TreeSet<>(comparator);
        for (int i = 0; i < 15; i++) {
            int r4 = new Random().nextInt(30);
            ts1.add(r4);
        }
        System.out.println("ts1: ");
        ts1.forEach(n -> System.out.println(n));
        System.out.println();


    //6.*Объявить и инициализировать множество TreeMap tm с компаратором Integer (-1 при значении %2==0 ;0 при ==;1 при значении %2!=0). Заполнить tm 15 случайными числами и вывести на печать.

        TreeMap<Integer, Integer> tm = new TreeMap<>(comparator);
        for (int i = 0; i < 15; i++) {
            int k = new Random().nextInt(30);
            int v = new Random().nextInt(30);
            tm.put(k, v);  
        }
        System.out.println(tm);    
               
    }        
}
   
