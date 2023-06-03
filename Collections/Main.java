package Collections;

import java.security.cert.CollectionCertStoreParameters;
import java.util.*;


public class Main {
    public static void main(String[] args){
        ArrayList<Integer> pooja = new ArrayList<>();
        pooja.add(1);
        pooja.add(3);
        pooja.add(-1);
        pooja.add(0);
        for (Integer i:pooja) {
            System.out.println(i);
        }
        Collections.sort(pooja);
        for (Integer i:pooja) {
            System.out.print(i);
        }
    }
}
