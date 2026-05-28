import java.util.*;
public class Main {
    public static List<Books> books = new ArrayList<>();//this is access by members and librariens. common to both of them. 
    /*
    above line make,no need to send books on method argument like rent(List<Books> books,int id).inside the method,the changes in books is not affect the Main.book.
    but after making books as static,the changes in Main.books inside the method is reflect to Main.books.
    */
    static Scanner in = new Scanner(System.in);
    static public int dis(){//used for rent book (more then one book).
        while(true){
            System.out.println("IF YES THEN 1 ELSE 0: ");
            int o = in.nextInt();
            in.nextLine();  
            if(o==1 || o==0){
                return o;
            }
            System.out.println("IDHA KOODA PATHU PODAMUDIYANA....\nI REPEAT AGAIN");
        }
        

        
    }
    static public int cout(int qun){
            while(true){
                System.out.println("ENTER COUNT: ");
                int o = in.nextInt();
                in.nextLine();
                if(o<=qun){
                    return o;
                }
                System.out.println("IDHA KOODA PATHU PODAMUDIYANA....\nI REPEAT AGAIN");
            }
        
    }
   
    public static void main(String[] args) {
        //user object
        Mem um=null;
        Librarien ul =null;
        //members,Librarien and book list
        List<Mem> Members = new ArrayList<>();
        List<Librarien> Librians = new ArrayList<>();
        
        //Mwmbwers,Liberariens and books 
        Members.add(new Mem("hari","hari123"));
        Members.add(new Mem("Luffy","MDL123"));
        Librians.add(new Librarien("Salasar", "lord"));
        Librians.add(new Librarien("Sadler", "lord"));
        books.add(new Books("ONE PIECE","NETFLIX" , "ADVENTURE", 5, 10));
        books.add(new Books("HARRY POTTER", "WB STUDIOS", "MAGICAL FANTASY", 2, 12));
        
        
        //default yes or no method. this is used in someplaces
        
        
        System.out.println("HARI'S LIBRARY ");
        System.out.println("LOGIN NOW: \n1 FOR MEMBER\n2 for LIBRARIEN");
        int lc = in.nextInt();
        in.nextLine();
        System.out.println("Enter name: ");
        String uname = in.nextLine().replace(" ","");
        System.out.println("Enter Password: ");
        String upass = in.nextLine();
        switch (lc){
            case 1:
                um = Mem.mCheck(Members,uname,upass);
                if(um==null){
                    System.out.println("INVALID CARDINALS");
                    break;
                }
                else{
                    System.out.println("LOGIN SUCCESSFULLY");
                }
                
                ui:while(true){
                    int bn;//for store book id
                    System.out.println("1.BOOK LIST \n2.RENT BOOKS\n3.RETURN BOOK\n4.OWN SHELF\n5.EXIT");
                    System.out.println("ENTER SERVICE NUMBER: ");
                    int op = in.nextInt();
                    in.nextLine();
                    switch (op) {
                        case 1://book list
                            Librarien.libBook();
                            break;
                        case 2://book rent
                            System.out.println("ENTER BOOK ID: ");
                            bn = in.nextInt();
                            in.nextLine();
                            bn=um.rentBook(bn);
                            if(bn==1){
                                System.out.println("BOOK ADDED TO SHELF SUCCESSFULLY");
                            }
                            if(bn==0){
                                System.out.println("NOT ADDED SUCCESSFULLY");
                            }
                            else if(bn==-2){
                                System.out.println("BOOK IS OUT OF STOCK");
                            }
                            else if(bn==-1){
                                System.out.println("BOOK NOT FOUND");
                            }
                            break;
                        case 3:
                            System.out.println("ENTER BOOK ID: ");
                            bn = in.nextInt();
                            in.nextLine();
                            bn=um.returnBook(bn);
                            if(bn==1){
                                System.out.println("RETURNED BOOK SUCCESSFULLY");
                            }
                            else{
                                System.out.println("BOOK NOT FOUND IN YOUR SHELF");
                            }


                        case 4://own shelf
                            um.ownShelf(um.Mname);
                            break;

                        case 5:
                            System.out.println("OK BYE\nPOITU URUPUDRA VELAYA PARU.\nYOU CAN DO ALL ");
                            break ui;
                            
                    }
                   
                }
                break;
                
                
            case 2:
                ul=Librarien.lCheck(Librians, uname, upass);
                if(ul==null){
                    System.out.println("INVALID CARDINALS");
                    break;
                }
                else{
                    System.out.println("LOGIN SUCCESSFULLY");

                }
                ui:while(true){
                    System.out.println("1.BOOK LIST \n2.ADD BOOKS\n3.MEMBERS LIST");
                    System.out.println("ENTER SERVICE NUMBER: ");
                    int op = in.nextInt();
                    in.nextLine();
                    switch (op) {
                        case 1:
                            Librarien.libBook();
                            break;
                        case 2:

                            break;
                        case 3:
                            break ui;//it is stoping point of switch case
                            
                    }
                   
                }
                break;
            default:
                System.out.println("(*->) IDHAYE OLUNGA PATHA PODA MUDIYALANA, APURO....");
        }
        in.close();

        
    }

}
