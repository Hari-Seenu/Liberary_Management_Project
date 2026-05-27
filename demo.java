import java.util.*;
public class demo { 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);  
        System.out.println("Enter id: ");
        int i= in.nextInt();
        List<demos> dvo = new ArrayList<>();
        for(demos d : dvo){
            if(d.id==4){
                d.id--;
            }
        }
        

    } 
}
