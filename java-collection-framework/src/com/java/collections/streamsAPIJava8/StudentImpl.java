package com.java.collections.streamsAPIJava8;

import java.util.*;
import java.util.stream.Collectors;

public class StudentImpl {

    static List<Student> students = new ArrayList<>();
    static Map<String,Integer> map = new HashMap<>();
    static Map<String,Integer> map1 = new HashMap<>();
    static Map<String,Integer> map2 = new HashMap<>();
    static Map<String,Integer> map3 = new HashMap<>();

    static{
        for(int i=1;i<5;i++){
            map.put("Sub-"+i , 90+i);
        }
        for(int j=1;j<5;j++){
            map1.put("Sub-"+j , 80+j);
        }
        for(int z=1;z<5;z++){
            map2.put("Sub-"+z , 85+z);
        }
        for(int x=1;x<5;x++){
            map3.put("Sub-"+x , 95+x);
        }
        students.add(new Student("Ram","Charan",map,
                List.of("A","A","A","A++"),List.of(1000.0,1200.50,2101.21,3542.21))
        );
        students.add(new Student("Swami","Nathan",map1,
                List.of("A","B","B","C"),List.of(1200.0,1780.50,2301.12,3427.76))
        );
        students.add(new Student("Ashish","Mitra",map2,
                List.of("B","B","A","A"),List.of(1000.0,2621.50,900.45,1427.76))
        );
        students.add(new Student("Chandan","Prajapati",map3,
                List.of("A","C","A+","A+"),List.of(1500.0,2631.50,800.45,3427.43))
        );

    }

    public static void main(String[] args) {

        System.out.println(students);
        System.out.println("-------------------------------------");

        //print each element of students list using streams
        students.stream()
                .forEach(student -> System.out.println(student));

        //compare by first Name
        System.out.println("----------------------");
        Collection<Student> sortedByFirstName = students.stream()
                .sorted((o1, o2) -> o1.getFirstName().compareToIgnoreCase(o2.getFirstName()))
                .collect(Collectors.toList());
        System.out.println(sortedByFirstName);

        System.out.println("--------sorted first name-----------");
        students.stream()
                .sorted((o1, o2) -> o1.getFirstName().compareToIgnoreCase(o2.getFirstName()))
                .forEach(student -> System.out.println(student.getFirstName()));

        System.out.println("-----map------");
        Collection<Student> mapStudents= students.stream()
                .map(student -> new Student(student.getFirstName(),
                        student.getLastName(),
                        student.getMarks().entrySet().stream().
                                filter(m->m.getKey().equals("Sub1")).
                                collect(Collectors.toMap(k->k.getKey(),k->k.getValue())),
                        student.getGrades().stream().filter(l->l.equals("A")).toList(),
                        student.getFees()
                ))
                .collect(Collectors.toList());

          Map<String,Integer> trial = map2.entrySet().stream()
                .filter(m->m.getValue()>85 && m.getValue()<88)
                .collect(Collectors.toMap(k->k.getKey(),k->k.getValue()));
        System.out.println(trial);

        System.out.println("-------Mapping using filter on each attribute---");

        Collection<Student> mapStudents1 = students.stream()
                .map(student -> new Student(student.getFirstName(),
                        student.getLastName(),
                        student.getMarks().entrySet().stream().filter(m->m.getValue()>80 && m.getValue()<90)
                                .collect(Collectors.toMap(k->k.getKey(),k->k.getValue())),
                        student.getGrades().stream().filter(l->l.equals("A")).collect(Collectors.toList()),
                        student.getFees().stream().filter(f->f<1500 && f>1000).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
        System.out.println(mapStudents1);

        System.out.println("--------returning new altered objects--------");

        Collection<Student> mapStudents2 = students.stream()
                .map(student -> new Student(student.getFirstName(),
                        student.getLastName(),
                        student.getMarks().entrySet().stream().filter(m->m.getValue()>80 && m.getValue()<90 && m.getKey().equalsIgnoreCase("Sub-2"))
                                .collect(Collectors.toMap(k->k.getKey()+"N",k->k.getValue()+2)),
                        student.getGrades().stream().filter(l->l.equals("A")).collect(Collectors.toList()),
                        student.getFees().stream().filter(f->f<1500 && f>1000)
                                .map(l->l*20).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
        System.out.println(mapStudents2);

        System.out.println("-------SortedByFees-----------");
        //using sorted and reduce together to return sorted objects with sum of fees
        Collection<Student> sortedByFees = students.stream()
                .sorted(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        if(o1.getFees().stream().reduce(0.0d,Double::sum) >
                                o2.getFees().stream().reduce(0.0d,Double::sum))
                            return 1;
                        else
                            return -1;
                    }
                })
                .collect(Collectors.toList());

        //we can also use this to return the first element which will bring the lowest fee object
        System.out.println("-----Least Fee----------");
        Student leastFee = students.stream()
                .sorted(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        if(o1.getFees().stream().reduce(0.0d,Double::sum) >
                                o2.getFees().stream().reduce(0.0d,Double::sum))
                            return 1;
                        else
                            return -1;
                    }
                })
                .findFirst().orElseThrow(null);

        System.out.println(sortedByFees);
        System.out.println(leastFee);

        System.out.println("------------FlatMap----------------------------");

        List<Integer> marks = students.stream().map(s->s.getMarks())
                .flatMap(e->e.values().stream())
                .collect(Collectors.toList());

        System.out.println(marks);

        System.out.println("------max----------");

        students.stream()
                .max(Comparator.comparing(student -> student.getFees().stream()
                        .reduce(0.0d,Double::sum)))
                .orElseThrow(NoSuchElementException::new);
    }

}
