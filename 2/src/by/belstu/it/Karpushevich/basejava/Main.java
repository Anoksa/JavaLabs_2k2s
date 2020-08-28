package by.belstu.it.Karpushevich.basejava;
import static java.lang.Math.*;
import java.util.Objects;

public class Main {
    //Задание 2
    final int er=89;
    public final int we=12;
    public static final int qw=123;
    //Для класса final означает, что класс не может наследоваться
    //Нельзя одновременно применять abstract и final
    //Для методов final означает, что метод не может быть переопределён в классах наследниках
    //Для переменных примитивов, что  означает,   что  изменить значение нельзя
    //Для ссылочных  типов означает, что нельзя изменнить ссылку на объект, но можно изменить состояние
    //конец задания 2

    public static void main(String[] args) {
        //Задание 1
        char ch='r';
        int in=4;
        short sh=23;
        byte by=4;
        long lo=243;
        boolean bo=false;
        double dou=23.4;
        String st="Hello";
        System.out.println(st+in);
        System.out.println(st+ch);
        System.out.println(st+dou);
        //byte by1 = by + in;
        long a=in+2147483647;
        System.out.println(a);
        //static int sint;
        boolean r = bo&&bo;
        System.out.println(r);
        boolean q = bo^bo;
        System.out.println(q);
        //boolean w = bo +bo;
        long x = 9223372036854775807L;
        System.out.println(x);
        long t=0x7fff_ffff_fffL;

        char y='a';
        char u='\u0061';
        char o=97;
        System.out.println(y+u+o);

        double e = 3.45%2.4;
        System.out.println(e);
        double p=1.0/0.0;
        System.out.println(p);
        double s = 0.0/0.0;
        System.out.println(s);
        double d=Math.log(-345);
        System.out.println(d);
        float f1=Float.intBitsToFloat(0x7F800000);
        float f2=Float.intBitsToFloat(0xFF800000);
        System.out.println(f1);
        System.out.println(f2);

        //Целочисленные константы можно записывать  в десятичной, восьмеричной и шестнадцатиричной форме

        //Конец задания 3

        System.out.println("Pi = " + PI);
        System.out.println("E = " + E);
        System.out.println("round Pi = " + Math.round( PI));
        System.out.println("round E = " + Math.round(E));
        System.out.println("min from Pi and E: " + min(PI, E));
        System.out.println(random());


        //
        Boolean er = false;
        System.out.println(er);
        Character cha = 'a';
        Integer oi = 234;
        Byte zx=8;
        Short as = 12;
        Long nj=123L;
        Double doub = 23.4;
        System.out.println(oi>>>2);
        System.out.println(~zx);
        System.out.println(er&true);
        System.out.println("Минимальное значение Long: " + Long.MIN_VALUE);
        System.out.println("Минимальное значение Double: " + Double.MIN_VALUE);
        System.out.println("Максимальное значение Long: " + Long.MAX_VALUE);
        System.out.println("Максимальное значение Double: " + Double.MAX_VALUE);

        Integer val = 5;
        Object obj = val;     // присваивание сопровождается упаковкой
        Integer valUnboxed = (Integer)obj; // приведение вызовет распаковку

        Integer obj1=10; //упакова
        int i1=obj1*2; //распаковка при вычислении выражения
        Byte some=1; //упаковка
        obj1=i1/10; //упаковка
        some=2; // упаковка

        Integer xn = Integer.parseInt("12");
        System.out.println(xn);
        Integer jt = 12;
        System.out.println(Integer.toHexString(jt));
        Integer jy = 11;
        if(Integer.compare(jt,jy)==0)
        {
            System.out.println("Равны");
        }
        else System.out.println("Не равны");
        Integer.toString(jy);
        //Этот метод возвращает целочисленное значение, которое соответствует количеству единиц в двоичном представлении числа-аргумента метода.
        Integer jkl = Integer.bitCount(jt);
        System.out.println(jkl);


        //

        String s34 = "2345";
        System.out.println(Integer.valueOf(s34));
        System.out.println(Integer.valueOf(s34) + 2);

        Integer djsl= new Integer(s34);
        System.out.println(djsl);
        System.out.println(Integer.parseInt(s34)-2);

        byte[] br = s34.getBytes();
        for (int i = 0; i <br.length ; i++) {
            System.out.print(br[i] + " ");
        }

        String str1 = new String(br);
        System.out.println(str1);


        boolean bool1, bool2;
        bool1 = Boolean.parseBoolean(s34);
        System.out.println(bool1);
        bool2 = Boolean.valueOf(s34);
        System.out.println(bool2);

        String str11="Koks";
        String str22="Koks";
        System.out.println(str11==str22);
        System.out.println(str11.equals(str22));
        System.out.println(str11.compareTo(str22));
        String str3 = null;

        System.out.println(str11==str3);
        System.out.println(str11.equals(str3));
        //System.out.println(str11.compareTo(str3));

        System.out.println("== null "+ (str1==str3));
        System.out.println("equals(null) "+str1.equals(str3));
        //System.out.println("compareTo "+str1.compareTo(nullstr));

        String hello="Hello my dear friend";
        for(String retval : hello.split(" ")){
            System.out.println(retval);
        }

        System.out.println(hello.contains("my"));
        System.out.println("HaashCode= "+hello.hashCode());
        System.out.println(hello.indexOf("d"));
        System.out.println(hello.length());
        System.out.println(hello.replace("l","k"));

        char[][]c1;
        char[] c2[];
        char c3[][];

        c1= new char[3][];
        c1[0]= new char[1];
        c1[1]= new char[2];
        c1[2]= new char[3];

        c2= new char[2][2];
        c3= new char[2][2];
        c2[1][1]='1';
        c2[0][1]='2';
        c2[0][0]='3';
        c2[1][0]='3';
        c3[1][1]='1';
        System.out.println( c2== c3);
        c3=c2;
        System.out.println( c2== c3);

        for(char[] j:c2){
            for(char c:j) {
                System.out.println(c);
            }
        }
        //c2[4][0];

        class WarpperStirng
        {
            private String pole;

            public WarpperStirng(String pole) {
                this.pole = pole;
            }

            public String getPole() {
                return pole;
            }

            public void setPole(String pole) {
                this.pole = pole;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                WarpperStirng that = (WarpperStirng) o;
                return Objects.equals(pole, that.pole);
            }

            @Override
            public int hashCode() {
                return Objects.hash(pole);
            }

            @Override
            public String toString() {
                return "WarpperStirng{" +
                        "pole='" + pole + '\'' +
                        '}';
            }

            public void replace (char oldchar, char newchar)
            {
                System.out.println(pole.replace(oldchar, newchar));
            }

        }
        var warpp= new WarpperStirng("Denis from Belarus") {
            @Override
            public void replace(char oldchar, char newchar) {
                System.out.println("override replace");
            }

            public void delete(char newchar) {
                System.out.println(getPole().replace(newchar, ' '));
            }
        };
        warpp.replace('g','h');
        warpp.delete('D');



    }


}

