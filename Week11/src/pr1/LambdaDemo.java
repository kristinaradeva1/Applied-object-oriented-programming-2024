package pr1;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

class LambdaDemo
{
    public static void main(String[] args)
    {
        Predicate<Salesperson> predicate1 = salesperson -> salesperson.getNumSales() > 1200;
//       = new Predicate<Salesperson>() {
//
//        public boolean test(Salesperson salesperson) {
//            return salesperson.getNumSales() > 1200;
//        }
//    }
        Predicate<Salesperson> predicate2 = salesperson -> salesperson.getNumSales() < 900; // да се инициализира
        Predicate<Salesperson> predicate = predicate1.or(predicate2); // да се инициализира
        Consumer<Salesperson> consumer1 = salesperson ->
        {
            salesperson.addBonus(salesperson.getSalary() * 0.05);
            System.out.println(salesperson.toString());
        }; // да се инициализира
        Consumer<Salesperson> consumer2 = salesperson ->
         {
             if(predicate.test(salesperson)) {
                 salesperson.addBonus(
                         salesperson.getSalary() * 0.02);

             }     else {
                 salesperson.addBonus(salesperson.getSalary() * -0.02);
             }
             System.out.println(salesperson.toString());
         }; ; // да се инициализира
            Comparator<Salesperson> comparator1 = (salesperson1, salesperson2) -> {
            return Double.compare(salesperson2.getSalary(),salesperson1.getSalary());
        };
             //   new Comparator<Salesperson>() {
            //@Override
            //public int compare(Salesperson o1, Salesperson o2) {
              //  return 0;
            //}
        //}; // да се инициализира
        Comparator<Salesperson> comparator2 = (salesperson1, salesperson2) -> {
            int salary = Double.compare(salesperson2.getSalary(), salesperson1.getSalary());
            if(salary == 0) {
                return salesperson1.getNumSales() - salesperson2.getNumSales();
            }
            return salary;
        };// да се инициализира
        Random rand = new Random();
        Salesperson[] salespersons =
                {
                        new Salesperson("John Doe", 2000, 949),
                        new Salesperson("Jane Doe", 3900, 1500),
                        new Salesperson("Alex Doe", rand.nextDouble(1500, 5000), rand.nextInt(500, 2000)),
                        new Salesperson("Mike Doe", rand.nextDouble(1500, 5000), rand.nextInt(500, 2000)),
                        new Salesperson("Peter Doe", rand.nextDouble(1500, 5000), rand.nextInt(500, 2000)),
                        new Salesperson("Jane Doe",rand.nextDouble(1500, 5000), rand.nextInt(500, 2000)),
                        new Salesperson("John Doe", rand.nextDouble(1500, 5000), rand.nextInt(500, 2000)),
                        new Salesperson("Jane Doe",rand.nextDouble(1500, 5000), rand.nextInt(500, 2000)),
                        new Salesperson("John Doe",rand.nextDouble(1500, 5000), rand.nextInt(500, 2000)),
                        new Salesperson("Jane Doe", rand.nextDouble(1500, 5000), rand.nextInt(500, 2000)),
                        new Salesperson("John Doe", rand.nextDouble(1500, 5000), rand.nextInt(500, 2000)),
                        new Salesperson("Person Doe", rand.nextDouble(1500, 5000), rand.nextInt(500, 2000)),
                        // да се добавят още 10 обекти от тип Salesperson
                        // или да се инициализират с Random стойности
                };
        List<Salesperson> listOfSalespersons = new ArrayList<>(Arrays.asList(salespersons));
        // обектите на salespersons да се запишат в
        //  listOfSalespersons
        for (Salesperson salesperson: salespersons)
        {
            applyBonus(salesperson, predicate1, consumer1);
            System.out.println(salesperson);
            salesperson.printNumSales(salesperson);

        }
        for (Salesperson salesperson: salespersons)
        {
            applyBonus(salesperson, predicate2, consumer2);
            System.out.println(salesperson);}
        sort(listOfSalespersons, comparator1);
        System.out.println(listOfSalespersons);
        sort(listOfSalespersons, comparator2);
        System.out.println(listOfSalespersons);

        group(listOfSalespersons);
       // applyBonus();

    }

    public static void applyBonus(Salesperson salesperson,
                                  Predicate<Salesperson>
                                          predicate,
                                  Consumer<Salesperson> consumer)
    {
        // Напишете if команда, където използвайте predicate
        // за да определите дали да изпълните consumer
        // Изпълнете consumer, когато условието на if командата е
       // изпълнено
        if(salesperson == null || predicate == null || consumer == null) {
            return;
        }
        if(predicate.test(salesperson)) {
            consumer.accept(salesperson);
        }
    }
    public static void applyBonus(List<Salesperson> salespersons,
                                  Predicate<Salesperson>
                                          predicate,
                                  Consumer<Salesperson> consumer)
    {
        // Напишете if команда, където използвайте predicate
        // за да определите дали да изпълните consumer
        // Изпълнете consumer, когато условието на if командата е
        //изпълнено
        if(salespersons == null || predicate == null || consumer == null) {
            return;
        }

        for(Salesperson salesperson: salespersons) {
            if(salesperson != null && predicate.test(salesperson)) {
                consumer.accept(salesperson);
            }
        }
    }
    public static void sort(List<Salesperson> salespersons,
                            Comparator<Salesperson>
                                    comparator)
    {
        // Сортирайте salespersons като използвате comparator
        if(salespersons == null || comparator == null || salespersons.isEmpty()) {
            return;
        }
        salespersons.sort(comparator);
    }
    public static void group(List<Salesperson> salespersons)
    {
        // Групирайте имената на salespersons по първата буква в
        //името изведете отделните групи на стандартен изход
        if(salespersons == null || salespersons.isEmpty()) {
            return;
        }
        HashMap<Character, List<String>> group = new HashMap<>();
        for(Salesperson salesperson : salespersons) {
            Character letter = salesperson.getName().charAt(0);
            if(!group.containsKey(letter)) {
                group.put(letter, new ArrayList<>());
            }
            group.get(letter).add(salesperson.getName());
        }
        for(Map.Entry<Character, List<String>> entry: group.entrySet()) {
            System.out.printf("%s:\t%s\n", entry.getKey(), entry.getValue());
        }
    }
    public static Set<Salesperson> distinct (List< Salesperson > list) {
        if(list == null) {
            return null;
        }

        Set<Salesperson> set = new HashSet<>(list);
//        for(int i = 0; i < list.size(); i++) {
//
//        }
        return set;
        //to do:
    }
}
