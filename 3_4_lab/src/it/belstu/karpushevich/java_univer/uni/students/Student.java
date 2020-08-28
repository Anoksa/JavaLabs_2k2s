package it.belstu.karpushevich.java_univer.uni.students;
import it.belstu.karpushevich.java_univer.main.Form_of_Study;
import it.belstu.karpushevich.java_univer.uni.Person;


public class Student extends Person
{
    public int course;
    public String specialize;
    public Form_of_Study form_of_study;


    public Student(int age, String name, String surname, int course, String specialize, Form_of_Study form_of_study ) {
        super(age, name, surname);
        try {
            if (age < 17) throw new Exception("value of age is less than 17");
            else {
                this.course = course;
                this.specialize = specialize;
                this.form_of_study = form_of_study;
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }

    }

    
    @Override
    public String toString() {
        return "Student: " +name+" "+ surname+
                " age: "+age+
                " course:" + course +
                ", specialize: " + specialize  +
                ", form_of_study: " + form_of_study;
    }
}
