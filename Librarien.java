import java.util.*;
public class Librarien {
    String Lname,Lpass;
    public Librarien(String lname, String lpass) {
        Lname = lname;
        Lpass = lpass;
    }
    public static Librarien lCheck(List<Librarien> Librians, String uname,String upass){
        for(Librarien l  : Librians){
            if(uname.equals(l.Lname )&& upass.equals(l.Lpass)){
                return l;
            }
        }
        return null;
    }
    public static void libBook(){
        System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
        System.out.printf("| %-10s | %-20s | %-20s | %-20s | %-10s |\n","ID","NAME","SOURSE","GENURE","QUANTITY");
        System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
        for(Books book : Main.books){
            System.out.printf("| %-10d | %-20s | %-20s | %-20s | %-10d |\n",book.id,book.bna,book.aut,book.gnr,book.qun);
        }
        System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
    }
}
