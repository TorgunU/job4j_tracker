package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Торгун Иван Викторович");
        student.setGroup("Стажер");
        student.setAdmissionDate(LocalDate.of(2023, 9, 27));
        System.out.println(student.getFullName());
        System.out.println(student.getGroup());
        System.out.println(student.getAdmissionDate());
    }
}
