package com.dandan.stream;

import com.dandan.stream.reference.Address;
import com.dandan.stream.reference.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @date：2020/11/18
 * @author：suchao
 */
public class StreamSorted {
    public static void main(String[] args) {
        List<Student> students = buildStudents();

        // id升序
        Comparator<Student> byIdASC = Comparator.comparing(Student::getId).reversed();

        // named不分区大小写降序
        Comparator<Student> byNameDESC = Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER)
                .reversed();

        // 联合排序
        Comparator<Student> finalComparator = byIdASC.thenComparing(byNameDESC);

        List<Student> result = students.stream().sorted(byIdASC).collect(Collectors.toList());
        System.out.println(result);
    }

    private static List<Student> buildStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(10, 20, "aty", new Address("d")));
        students.add(new Student(1, 22, "qun", new Address("c")));
        students.add(new Student(1, 26, "Zen", new Address("b")));
        students.add(new Student(5, 23, "aty", new Address("a")));
        return students;
    }
}
