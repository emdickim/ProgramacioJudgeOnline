package listTest;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    static void main(String[] args) {


        ArrayList<Integer> numbers = new ArrayList<>();

        List<Integer> numbers2 = new ArrayList<>();

        List<String> names = new ArrayList<>();

        System.out.println(names.add("kim"));
        System.out.println(names.add("nena"));
        System.out.println(names.add("akasha"));

        System.out.println(names);
        names.add(0, "Marina");

        System.out.println(names);

        System.out.println("Size: " + names.size());

        System.out.println(names.get(3));

        System.out.println(names.get(names.size()-1));


        System.out.println(names.contains("marina".toLowerCase()));

        for (int i = 0; i < names.size(); i++) {
            System.out.printf("posicio %d = %s%n", i, names.get(i));
        }

        for (String str: names) {
            System.out.println(str);
        }

        System.out.println();
        names.stream().forEach(p -> System.out.println(p));

        names.stream().forEach(System.out::println);



    }

}
