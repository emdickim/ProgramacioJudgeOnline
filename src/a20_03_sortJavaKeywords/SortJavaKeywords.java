package a20_03_sortJavaKeywords;

import java.util.*;
import java.util.stream.Collectors;

public class SortJavaKeywords {
        //Retorna una llista ordenada ascendentment. Utilitza ArrayList i Collections per ordenar la llista.

        public List<String> listSortedAsc(Set<String> words) {
            List<String> wordsList = new ArrayList<>(words);
            Collections.sort(wordsList);
            return wordsList;
        }
        
        //Retorna una llista ordenada descendement. Utilitza ArrayList i Collections per ordenar la llista.

        public List<String> listSortedDesc(Set<String> words) {
            List<String> wordsList = new ArrayList<>(words);
            Collections.sort(wordsList, Collections.reverseOrder());
            return wordsList;
        }

        //Retorna un conjunt ordenat ascendentment. Utilitza TreeSet per ordenar el conjunt.

        public Set<String> setSortedAsc(Set<String> words) {
            return new TreeSet<>(words);
        }

        //Retorn un conjunt ordenat descendentment. Utilitza ArrayList, Collections i LinkedHashSet per ordenar el conjunt.

        public Set<String> setSortedDesc(Set<String> words) {
            ArrayList llistaDesc = new ArrayList<>(words);
            Collections.sort(llistaDesc, Collections.reverseOrder());

            Set<String> setLinkedHash = new LinkedHashSet<>(llistaDesc);

            return words.stream()
                        .sorted(Collections.reverseOrder())
                        .collect(Collectors.toCollection(LinkedHashSet::new));


        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SortJavaKeywords p = new SortJavaKeywords();

        Set<String> keywords = new HashSet<>(Arrays.asList("abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "if", "implements", "import", "instanceof", "int", "interface", "long", "new", "package", "private", "protected", "public", "return", "short", "static", "super", "switch", "synchronized", "this", "throw", "throws", "try", "void", "while"));
        System.out.println(keywords);


        while (true) {
            System.out.println("1. Show keywords\r\n" + //
                                "2. Show sorted list asc\r\n" + //
                                "3. Show sorted list desc\r\n" + //
                                "4. Show sorted set asc\r\n" + //
                                "5. Show sorted set desc\r\n" + //
                                "0. Exit\r\n" + //
                                "Choose option:");

            int opcio = sc.nextInt();
            sc.nextLine();
            switch (opcio) {
                case 0 -> System.exit(0);
                case 1 -> System.out.println(keywords);
                case 2 -> System.out.println(p.listSortedAsc(keywords));
                case 3 -> System.out.println(p.listSortedDesc(keywords));
                case 4 -> System.out.println(p.setSortedAsc(keywords));
                case 5 -> System.out.println(p.setSortedDesc(keywords));
                default -> System.out.println("Opció no vàlida");
            }
        }
    


    }
}
