package it.belstu.karpushevich.java_univer.uni.dean;

import it.belstu.karpushevich.java_univer.main.Form_of_Study;
import it.belstu.karpushevich.java_univer.uni.students.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Dean {
    List<Student> students= new LinkedList<Student>();

    public void Add(Student student)
    {
        students.add(student);
    }

    public void Count_course(int course)
    {   int count=0;
        for (Student stu:students)
        {
            if(stu.course==course)
                count++;
        }
        if(count!=0)
            System.out.println("Count of students from "+ course+ " course is "+ count);
        else
            System.out.println("No students on this course");

    }

    public void Surch_by(int course, String specialize, Form_of_Study form)
    {
        int k=0;
        for (Student stu:students)
        {
            if(stu.course==course  && stu.specialize==specialize && stu.form_of_study==form)
            {
                System.out.println(stu);
                k++;
            }
        }
        if(k==0)
            System.out.println("No students with such parameters");
    }

    public void Sort_by_course()
    {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.course<o2.course? -1: (o1.course>o2.course?1:0);
            }
        });
    }


    public void Show()
    {
        for (Student stu: students) {
            System.out.println(stu);
        }
    }



}
