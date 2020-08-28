package it.belstu.karpushevich.java_univer.main;

import it.belstu.karpushevich.java_univer.uni.dean.Dean;
import it.belstu.karpushevich.java_univer.uni.students.Student;
import java.io.*;

import java.text.Normalizer;

public class Main {

    public static void main(String[] args) {

        Student student = new Student(19, "Veronika", "Rogalevich", 2, "POIT", Form_of_Study.PAY_ON);
        Student stud1= new Student(19,"Oksana","Karpushevich",2,"POIT",Form_of_Study.PAY_ON);
        Student stud2=new Student(19,"Julia", "Nevar",2,"POIT", Form_of_Study.FREE);
        Student stud3= new Student(20,"Denis", "Kremen",2,"POIT",Form_of_Study.PAY_ON);
        Student stud4= new Student(20,"Egor","Horoshko",3,"POIT",Form_of_Study.PAY_ON);
        Student stud5= new Student(20,"Alina", "Black",3, "DEVI", Form_of_Study.FREE);
        Student stud6= new Student(19, "Danil","Selitsky",2, "POIT", Form_of_Study.FREE);
        Student stud7 = new Student(18, "Ekaterina", "Ratch",1,"ISIT",Form_of_Study.FREE);
        Student stud8= new Student(17, "Diana", "Miletskaya",1,"ISIT",Form_of_Study.FREE);
        Student stud9= new Student(21, "Nikita","Belma",4,"DEVI",Form_of_Study.PAY_ON);
        Student stud10= new Student(22, "Viktoria", "Remak", 4, "DEVI", Form_of_Study.FREE);
        Student stud11= new Student(16, "Viktoria", "Remak", 4, "DEVI", Form_of_Study.FREE);

        Dean dean= new Dean();
        dean.Add(stud1);
        dean.Add(stud5);
        dean.Add(stud3);
        dean.Add(stud10);
        dean.Add(stud2);
        dean.Add(stud4);
        dean.Add(stud9);
        dean.Add(stud7);
        dean.Add(stud6);
        dean.Add(stud8);
        dean.Add(student);

        dean.Show();

        dean.Count_course(3);
        dean.Surch_by(3, "POIT",Form_of_Study.PAY_ON);
        dean.Sort_by_course();
        dean.Show();

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Veron.dat")))
        {
            oos.writeObject(student);
            System.out.println("File has been written");
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serial/Veron.dat")))
        {
            Student p=(Student)ois.readObject();
            System.out.println("In File:");
            System.out.printf(p.toString());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
