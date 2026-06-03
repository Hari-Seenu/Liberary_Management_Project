import java.util.*;
public class Main {
    public static List<Books> books = new ArrayList<>();//this is access by members and librariens. common to both of them.
    
    public static List<Mem> Members = new ArrayList<>();//this is assessed by all liberarians foradd and remove members.
    /*
    above line make,no need to send books on method argument like rent(List<Books> books,int id).inside the method,the changes in books is not affect the Main.book.
    but after making books as static,the changes in Main.books inside the method is reflect to Main.books.
    */
    static Scanner in = new Scanner(System.in);
    static public void searchBy(){
        int op;
        String names;
        ui:while(true){
            System.out.println("SELECT YOUR SEARCHING PARAMETER: ");
            System.out.println("1.ID\n2.BOOK NAME\n3.AUTHOR NAME\n4.GANURE\n5.EXIT");
            op=in.nextInt();
            in.nextLine();
            switch(op){
                case 1:
                    System.out.println("ENTER ID: ");
                    op=in.nextInt();
                    in.nextLine();
                    Books.getBook_id(op);
                break;
                case 2:
                    System.out.println("ENTER BOOK NAME: ");
                    names=in.nextLine().replace(" ", "").toLowerCase();
                    System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
                    System.out.printf("| %-10s | %-20s | %-20s | %-20s | %-10s |\n","ID","NAME","SOURSE","GENURE","QUANTITY");
                    System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
                    for(Books b: Main.books){
                        
                        if(b.bna.replace(" ", "").toLowerCase().equals(names)){
                            System.out.printf("| %-10d | %-20s | %-20s | %-20s | %-10d |\n",b.id,b.bna,b.aut,b.gnr,b.qun);
                            System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
                        }
                    }
                break;
                case 3:
                    System.out.println("ENTER AUTHOR NAME: ");
                    names=in.nextLine().replace(" ", "").toLowerCase();
                    System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
                    System.out.printf("| %-10s | %-20s | %-20s | %-20s | %-10s |\n","ID","NAME","SOURSE","GENURE","QUANTITY");
                    System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
                    for(Books b: Main.books){
                        if(b.aut.replace(" ", "").toLowerCase().equals(names)){
                            System.out.printf("| %-10d | %-20s | %-20s | %-20s | %-10d |\n",b.id,b.bna,b.aut,b.gnr,b.qun);
                            System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
                        }
                    }
                break;
                case 4:
                    System.out.println("ENTER GANURE NAME: ");
                    names=in.nextLine().replace(" ", "").toLowerCase();
                    System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
                    System.out.printf("| %-10s | %-20s | %-20s | %-20s | %-10s |\n","ID","NAME","SOURSE","GENURE","QUANTITY");
                    System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
                    for(Books b: Main.books){
                        if(b.gnr.replace(" ", "").toLowerCase().equals(names)){
                            System.out.printf("| %-10d | %-20s | %-20s | %-20s | %-10d |\n",b.id,b.bna,b.aut,b.gnr,b.qun);
                            System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
                        }
                    }
                break;
                case 5:
                    System.out.println("EXITED FROM SEARCH BAR ");
                    op=0;
                break ui;
            }

        }
        
    }
    static public int dis(){//used for rent book (more then one book) in member and add stocks in liberary(new stockor existing stock) 
        while(true){
            System.out.println("IF OPTION 1 THEN PRESS 1 ELSE PRESS 0: ");
            int o = in.nextInt();
            in.nextLine();  
            if(o==1 || o==0){
                return o;
            }
            System.out.println("IDHA KOODA PATHU PODAMUDIYANA....\nI REPEAT AGAIN");
        }
        

        
    }
    static public int cout(int qun){//used in return book
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
        //List<Mem> Members = new ArrayList<>(); it is static now.because it assesed by all liberarians.
        List<Librarien> Librians = new ArrayList<>();
        
        //Members,Liberariens and books 
        Members.add(new Mem("hari","hari123"));
        Members.add(new Mem("Luffy","MDL123"));
        Librians.add(new Librarien("Salasar", "lord"));
        Librians.add(new Librarien("Sadler", "lord"));
        books.add(new Books("ONE PIECE","NETFLIX" , "ADVENTURE", 5, 10));
        books.add(new Books("HARRY POTTER", "WB STUDIOS", "MAGICAL FANTASY", 2, 1));
        
        
        //default yes or no method. this is used in someplaces
        
        
        System.out.println("HARI'S LIBRARY ");
        String uname;
        String upass;
        
        uo:while(true){
            System.out.println("LOGIN NOW: \n1 FOR MEMBER\n2 for LIBRARIEN\n3 for EXIT");
            int lc = in.nextInt();
            in.nextLine();
            switch (lc){
            case 1://member
                System.out.println("Enter name: ");
                uname = in.nextLine().replace(" ","");
                System.out.println("Enter Password: ");
                upass = in.nextLine();
                um = Mem.mCheck(Members,uname,upass);
                if(um==null){
                    System.out.println("INVALID CARDINALS");
                    break;
                }
                else{
                    System.out.println("LOGIN SUCCESSFULLY");
                }
                
                ui:while(true){
                    
                    System.out.println("1.BOOK LIST \n2.FILTER SEARCH \n3.RENT BOOKS\n4.RETURN BOOK\n5.OWN SHELF\n6.LOGOUT\n7.EXIT");
                    System.out.println("ENTER SERVICE NUMBER: ");
                    int op = in.nextInt();//using this variable for store op code and  book id also
                    in.nextLine();
                    switch (op) {
                        case 1://book list
                            Librarien.libBook();
                            break;
                        case 2:
                            Main.searchBy();
                            break;
                        case 3://book rent
                            System.out.println("ENTER BOOK ID: ");
                            op = in.nextInt();//op is used here for store book id.
                            in.nextLine();
                            op=um.rentBook(op);
                            if(op==1){
                                System.out.println("BOOK ADDED TO SHELF SUCCESSFULLY");
                            }
                            if(op==0){
                                System.out.println("NOT ADDED SUCCESSFULLY");
                            }
                            else if(op==-2){
                                System.out.println("BOOK IS OUT OF STOCK");
                            }
                            else if(op==-1){
                                System.out.println("BOOK NOT FOUND");
                            }
                            break;
                        case 4:
                            System.out.println("ENTER BOOK ID: ");
                            op = in.nextInt();
                            in.nextLine();
                            op=um.returnBook(op);
                            if(op==1){
                                System.out.println("RETURNED BOOK SUCCESSFULLY");
                            }
                            else{
                                System.out.println("BOOK NOT FOUND IN YOUR SHELF");
                            }


                        case 5://own shelf
                            um.ownShelf(um.Mname);
                            break;

                        case 6:
                            System.out.println("LOGED OUT SUCCESSFULLY ");
                            break ui;
                        case 7:
                            System.out.println("BYE BYE....");
                            break uo;
                            
                    }
                   
                }
                break;
                
                
            case 2://liberarien
                System.out.println("Enter name: ");
                uname = in.nextLine().replace(" ","");
                System.out.println("Enter Password: ");
                upass = in.nextLine();
                ul=Librarien.lCheck(Librians, uname, upass);
                if(ul==null){
                    System.out.println("INVALID CARDINALS");
                    break;
                }
                else{
                    System.out.println("LOGIN SUCCESSFULLY");

                }
                ui:while(true){
                    System.out.println("1.BOOK LIST \n2.FILTER SEARCH \n3.ADD BOOKS\n4.MEMBERS LIST\n5.LOGOUT \n6.EXIT");
                    System.out.println("ENTER SERVICE NUMBER: ");
                    int op = in.nextInt();
                    in.nextLine();
                    switch (op) {
                        case 1:
                            Librarien.libBook();
                            break;
                        case 2:
                            Main.searchBy();
                            break;
                        case 3:
                            System.out.println("WANT TO ADD NEW STOCK OR UPDATE EXISTING STOCK");
                            op=Main.dis();
                            if(op==1){//new stock
                                op = ul.addStock();    
                                if( op==1){
                                    System.out.println("STOCK ADDED SUCCESSFULLY");
                                }
                                else{
                                    System.out.println("STOCK ADDING CANCELLED");
                                }
                                
                            }
                            else if(op==0){//update existing stock
                                op = ul.updateStocks();
                                if(op==1){
                                    System.out.println("BOOK UPDATED SUCCESSFULLY");
                                }
                                else if(op==0){
                                    System.out.println("FIND BOOKID BY SEARCH OR FILTER OPTION");
                                }
                            }
                            

                            break;
                        case 5:
                            System.out.println("LOG OUT SUCCESSFULLY");
                            break ui;//it is stoping point of switch case
                        case 6:
                            System.out.println("BYE BYE...");
                            break uo;
                            
                    }
                   
                }
                break;
            case 3:
                break uo;
            default:
                System.out.println("(*->) IDHAYE OLUNGA PATHA PODA MUDIYALANA, APURO....");
            }
        }
        
        in.close();

        
    }

}
