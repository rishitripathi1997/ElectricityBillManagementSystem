import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
public class ElectricityManagementSystem {
    public static void main(String[] args){
        // MAIN MENU
		System.out.println();	  
		System.out.println("\t\t\t    .-----------------------------------------------------------------------.");
		System.out.println("\t\t\t    | +    								  + |");
		System.out.println("\t\t\t    |      *****  E L E C T R I C   S U P P L Y   C O M P A N Y *****       |");
		System.out.println("\t\t\t    | +    							          + |");
		System.out.println("\t\t\t    '-----------------------------------------------------------------------'");
		System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to Access ADMIN MENU \nEnter 2 to Access CUSTOMER MENU\nEnter 0 to EXIT  ");
        int menu = input();
        if (menu == 1){
            AdminLogIn(args);
        }
        else if(menu == 2) {
			Customer(args);
		}
		else {
			System.out.println();
			System.out.println("\t\t\t\t\t:-------------------------------------------------------------------------:");
			System.out.println("\t\t\t\t\t:\t\tT H A N K   Y O U   F O R   V I S I T I N G !\t \t  :");
			System.out.println("\t\t\t\t\t:-------------------------------------------------------------------------:");
			System.exit(0);
		}
    }
    public static void AdminLogIn(String args[]) {
		System.out.println();	  
		System.out.println("\t\t\t\t\t\t     .-----------------------------------------------.");
		System.out.println("\t\t\t\t\t\t     |             A D M I N   L O G I N             |");
		System.out.println("\t\t\t\t\t\t     '-----------------------------------------------'");
		System.out.println();
		
		
		Scanner input = new Scanner (System.in);
		String username; String password;
		System.out.println("Enter Username");
		username = input.nextLine();
		
		System.out.println("Enter Password");
		password = input.nextLine();
		if ((username.equals("A") && password.equals("A"))) {
			System.out.println();
			System.out.println("\t\tA C C E S S   G R A N T E D !");
			System.out.println();
			System.out.println();
			Admin(args);
			
		}
		else {
			System.out.println();
			System.out.println("\t\t\t\t\t\tA C C E S S   D E N I E D");
			System.out.println();
			System.out.println("Enter 1 to LOG IN Again\n Enter 2 to go back to MAIN MENU\n Enter 0 to exit");
            int option = input();
			if (option == 1) {
				AdminLogIn(args);
			}
			else if (option == 9) {
				main(args);
			}
			else if (option == 0) {	
				System.out.println();
				System.out.println("\t\t\t\t\t:-------------------------------------------------------------------------:");
				System.out.println("\t\t\t\t\t:\t\tT H A N K   Y O U   F O R   V I S I T I N G !\t \t  :");
				System.out.println("\t\t\t\t\t:-------------------------------------------------------------------------:");
				System.exit(option);
			}	
		}
	}
    public static void CustomerLogIn(String args[]) {
        System.out.println();	  
        System.out.println("\t\t\t\t\t\t     .-----------------------------------------------.");
        System.out.println("\t\t\t\t\t\t     |        C U S T O M E R   L O G I N            |");
        System.out.println("\t\t\t\t\t\t     '-----------------------------------------------'");
        System.out.println();
        Scanner input=new Scanner (System.in);
        String username; String password;
        System.out.println("Enter Username");
        username = input.nextLine();
        System.out.println("Enter Password");
        password=input.nextLine();
        if (username.equals("C") && password.equals("C")) {
            System.out.println();
            System.out.println("\t\tA C C E S S   G R A N T E D !");
            System.out.println();
            System.out.println();
            try {
                search_bill_record(args);
            } 
            catch (FileNotFoundException e) {
                System.out.println("Customer REC Not Found");
                e.printStackTrace();
            }
        }
        else {
            System.out.println();
            System.out.println("\t\t\t\t\t\tA C C E S S   D E N I E D");
            System.out.println();
            System.out.println("Enter 1 to LOG IN Again\nEnter 9 to go back to MAIN MENU\nEnter 0 to exit");
            int option = input();
            if(option == 1) {
                CustomerLogIn(args);
            }
            else if (option == 9) {
                main(args);
            }
            else if (option == 0) {
                System.out.println();
                System.out.println("\t\t\t\t\t:-------------------------------------------------------------------------:");
                System.out.println("\t\t\t\t\t:\t\tT H A N K   Y O U   F O R   V I S I T I N G !\t \t  :");
                System.out.println("\t\t\t\t\t:-------------------------------------------------------------------------:");
                System.exit(option);
            }  
        }
    }
    public static void Admin(String args[]) {
        System.out.println();
        System.out.println("\t\t\t:-------------------------------------------------------------------------:");
        System.out.println("\t\t\t:\t\t\t   A D M I N   M E N U\t\t\t\t  :");
        System.out.println("\t\t\t:-------------------------------------------------------------------------:");
    System.out.println("o Enter 1 to Add Record\no Enter 2 to View Record\no Enter 3 to Delete Record\n" +
    "o Enter 4 to Edit Record\no Enter 5 to Seacrch from Record\no Enter 6 to calculate bill\n" +
    "o Enter 9 to go back to MAIN MENU\no Enter 0 to EXIT ");
    Scanner input =new Scanner (System.in);
    int select = input();
    if(select == 1) {
        add_record(args); 
        }
    else if(select == 2) {
        view_record(args);
    }
    else if(select == 3) {
        delete_record(args);
    }
    else if(select == 4) {
        editrecord(args);
    }
    else if (select == 6){
        try {
            BillCalculation(args);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    else if(select == 5) {
        try {
            search_record(args);
        } 
        catch (FileNotFoundException e) {
            System.out.println("Customer REC Not Found");
            e.printStackTrace();
        }
    }
    else if(select == 9) {
            main(args);
    }
    else if(select == 0) {
        System.out.println();
        System.out.println("\t\t\t\t\t:-------------------------------------------------------------------------:");
        System.out.println("\t\t\t\t\t:\t\tT H A N K   Y O U   F O R   V I S I T I N G !\t \t  :");
        System.out.println("\t\t\t\t\t:-------------------------------------------------------------------------:");
        System.exit(select);
    }
}
public static void add_record(String[]args) {
	
	System.out.println("\t\t\t\t     .-----------------------------------------------.");
	System.out.println("\t\t\t\t     |         A D D   R E C O R D   M E N U         |");
	System.out.println("\t\t\t\t     '-----------------------------------------------'");
	System.out.println();
	Scanner input = new Scanner(System.in);
	//NAME OF CUSTOMER
	 
	 // VARIABLE to be used in FILE = Name
	System.out.print("Enter name of Consumer: ");
	String Name = input.nextLine();	
	// Generating ID of customer
	String characters ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	String Id = "";// For storing ID of customer
	char [] chars = new char[5];
	for(int i = 0; i < 5; i++) {
		int index = (int)(Math.random()*36);	// Picking random values for ID;
		chars[i] = characters.charAt(index);
	}
	for(int i = 0; i<5; i++) {
		Id += chars[i];
	}
	//System.out.println(Id);
	String Customer_Id = Id;
	System.out.println("Consumer ID : "+Customer_Id);
		// CNIC of Customer
	System.out.println("Enter CNIC(DDDDD-DDDDDDD-D): ");
    String CNIC;
    CNIC = input.next();
	try {
	    boolean validation = validCNICOrNot(CNIC);
	    if ((CNIC.charAt(5) == '-') && (CNIC.charAt(13) == '-') && (validation == true))
	        System.out.println("Entered CNIC is valid");
	    else if (validation == true)
	        System.out.println("Entered CNIC is valid");
	    else if(validation != true) {
	        int c = 0;
	        for(int i = 2; i >= c; i--) {
	        	System.out.println("Invalid CNIC");
	        	System.out.println("Enter CNIC(DDDDD-DDDDDDD-D): ");
	        	CNIC = input.next();
	        	validation = validCNICOrNot(CNIC);
	        	if ((CNIC.charAt(5) == '-') && (CNIC.charAt(13) == '-') && (validation == true))
			        System.out.println("Entered CNIC is valid");
			    if (validation == true) {  
			      	break;
			    }
			    else{
			        System.out.println();
	        	  	System.out.println("\t\t"+i+" Tries Left!");
	        	  	System.out.println();
                }
	        	if (i == 0) {
	        		System.out.println(" o Enter 1 to go back to ADD RECORD MENU\n o Enter 2 to go back to ADMIN MENU\n o Enter 9 to go back to MAIN MENU\n o Enter 0 to EXIT");
	        	}
            }
        }
	}  	
	catch(Exception e) {
	    System.out.println("String Index Out of Bounds");
	    System.out.println("o Enter 1 to go back to ADD RECORD MENU\no Enter 2 to go back to ADMIN MENU\no Enter 9 to go back to MAIN MENU\no Enter 0 to EXIT");
        int option = input();
	    if(option==1) {
	        add_record(args);
	    }
        else if (option == 2 ) {
	        Admin(args);  		
	    }
	    else if (option == 9 ) {	
	        main(args);
	    }
	    else 
	        System.exit(0);		  
	}
	// Address of customer	
	// VARIABLE to be used in FILE =Address
		Scanner a = new Scanner(System.in);
		System.out.println("Enter Address of Consumer : ");
		String Adr = a.nextLine();
	
		// Mobile.No of customer
		// VARIABLE to be used in FILE = Mobile_Number.
		System.out.print("Enter Mobile No. of Customer(11 Digit number)r: ");
		String Mobile_Number;
		Mobile_Number = input.next();
		while (Mobile_Number.length() < 11 || Mobile_Number.length() > 11 || Mobile_Number == null || Mobile_Number.isBlank()) {
			System.out.println("INVALID Number!");
			System.out.print("Enter Mobile No. of Comsumer (11 Digit number): ");
			Mobile_Number = input.next();		
		}
		System.out.println();

// Entering Connection Type of Customer	
// Variable to be use is-------> connection
				String connection = "";
				System.out.println();
				System.out.println("\t\t\t\t\t\tTypes of Electricity Connections");
				System.out.println();
				System.out.println("1- RESIDENTIAL\n2- COMMERCIAL\n3- INDUSTRIAL\n4- AGRICULTURAL");
				System.out.println();
				System.out.println("Enter connection Number: ");
				String type = input.next();
				if(type.equals("1")) {
					connection = "RESIDENTIAL";
				}
				else if(type.equals("2")) {
					connection = "COMMERCIAL";
					
				}
				else if(type.equals("3")) {
					connection = "INDUSTRIAL";
					
				}
				else if(type.equals("4")) {
					connection = "AGRICULTURAL";
					
				}	
				// Generating meter Number of Customer
				// Variable to be used ------> MeterNumber	
			    String MeterNumber = "";
			    Random random = new Random();
				String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //alphabets stored 
				int count = 4; //numbers of times loop will execute 
				//loop to generate random string
				for (int i = 1; i < count - 1; i++) {
					//generating random index of variable alphabets
					int index = random.nextInt(alphabets.length());
					//using that index to print character
					char ch = alphabets.charAt(index);
			        MeterNumber += ch;
					//System.out.print(ch);
				}
			    MeterNumber = MeterNumber + "-";
				//System.out.print("-");
				//loop to generate random number
				for (int j = 0; j <= count; j++) {
					int num = (int)(Math.random() * 10);
			        MeterNumber += num;
					
				}
				System.out.println("Meter Number is : "+MeterNumber);
				System.out.println("   C O N S U M E R    R E C O R D    A D D E D !");
				System.out.println("o Enter 1 to go back to ADD RECORD MENU\no Enter 2 to go back to ADMIN MENU\no Enter 9 to go back to MAIN MENU\no Enter 0 to EXIT");
                int option = input();
        		if(option == 1) {
        		  	add_record(args);
        		}
        		else if (option == 2 ) {
        		  	Admin(args);	
        		}
        		else if (option == 9 ) {
        		  	main(args);
        		}
        		else 
        		  	System.exit(0);		
 //Creating a file path variable to reference the file :
	String filepath="CustomerData.txt";
/**********************************************************************************************/
	// Calling The Method to write on the file
	
	//Sequence of Variables
	// --> Customer_ID
	// --> Name
	// --> CNIC
	// --> Address
	// --> Mobile Number
	// --> MeterNumber
	// --> Connection type
	
	writing_record(Customer_Id,Name,CNIC,Adr,Mobile_Number,MeterNumber,connection,filepath);	
}
/**********************************************************************************************/

public static void writing_record(String Consumer_Id, String Name,String CNIC,String Address,String Mobile_Number,String MeterNumber, String connection,String filepath) 
{
	try 
	{
		FileWriter fw = new FileWriter(filepath,true);// Appending on the file
		BufferedWriter bw =new BufferedWriter(fw);// Efficiently writing on file
		PrintWriter pw = new PrintWriter(bw);//
		System.out.println("");
		pw.println(Consumer_Id+" "+Name+" "+CNIC+" "+Address+" "+Mobile_Number+" "+MeterNumber+" "+connection);
		pw.flush();//It will make sure that All data is written on the file.
		pw.close();// It Closes the file
		JOptionPane.showMessageDialog(null,"Record Updated");
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,"Error in updating Record");
	}
	

}
//****************************************************************************************//

//Method For Viewing the Record

public static void view_record(String []args) {
	Scanner input = new Scanner (System.in);
    // Passing The path of the file which is to be read
	//System.out.println("-------------------------[   Customer Record List   ]-------------------------");
	//System.out.println(" ");
	System.out.println("\t\t\t\t     .-----------------------------------------------.");
	System.out.println("\t\t\t\t     |         C U S T O M E R    R E C O R D        |");
	System.out.println("\t\t\t\t     '-----------------------------------------------'");
	System.out.println();
	String file_path = "CustomerData.txt";
	String read_each_line = "";// Storing each line of the File\ 
	try {
		BufferedReader br = new BufferedReader(new FileReader(file_path));// Reading the File
		System.out.println("Customer-Id,Name,CNIC,Address,Mobile Number,Meter Number,Connection Type");
		while((read_each_line = br.readLine()) != null) {
			System.out.println(read_each_line);
		}
		System.out.println();
		System.out.println();
		System.out.println("o Enter 1 to go back to ADMIN MENU\no Enter 9 to go back to MAIN MENU\no Enter 0 to EXIT");
        int option = input();
		if (option == 1) {
		  	Admin(args);
		}
		else if (option == 9 ) {
		  	main(args);
		}
        else {
			System.out.println();
			System.out.println("\t\t\t\t\t:-------------------------------------------------------------------------:");
			System.out.println("\t\t\t\t\t:\t\tT H A N K   Y O U   F O R   V I S I T I N G !\t \t  :");
			System.out.println("\t\t\t\t\t:-------------------------------------------------------------------------:");
			System.exit(0);
		}
	} 
	catch (FileNotFoundException e) {
			e.printStackTrace();
    }
	catch (IOException e) {
			e.printStackTrace();
    }
}

// public static void ask_to_delete_record(String args[]){
//-----> 1- First View Record
	 public static void delete_record(String args[]){
		 	System.out.println("\t\t\t\t     .-----------------------------------------------.");
			System.out.println("\t\t\t\t     |          D E L E T E    R E C O R D           |");
			System.out.println("\t\t\t\t     '-----------------------------------------------'");
			System.out.println();
			Scanner input = new Scanner (System.in);
			System.out.println("Enter Customer_ID to Delete the Customer's Record");
		    String Id = input.next();
			clearing_record("CustomerData.txt",Id,1,",");
			System.out.println();
			System.out.println("   C O N S U M E R    R E C O R D    D E L E T E D !");
			System.out.println();
			System.out.println("\t\t\t\t\t\t  ( If Consumer Record is not Deleted then ID is INVALID )");
			System.out.println();
			view_record(args);
			System.out.println();
			System.out.println();
			System.out.println("o Enter 1 to go back to DELETE RECORD MENU\n o Enter 2 to go back to ADMIN MENU\n o Enter 9 to go back to MAIN MENU\n o Enter 0 to EXIT");
            int option = input();
			if (option == 1) {	
			    delete_record(args);		
			}
			else if (option == 2 ) {
			    Admin(args);
			}
			else if (option == 9 ) {
			  	main(args);
			}
			else 
			    System.exit(0);		
			}
		
			// Method For Clearing Customer's Record
			public static void clearing_record(String filepath,String Id,int  selecting_position, String separator) {
				 //-----> 2- Write Code to Delete the Record
				 int position = selecting_position-1;// For managing the index in array
				 /*
				  Creating a temporary File and writing the 
				  data we want to keep in the file  and then updating the File.
				  (Deleting and Renaming the file)
				 */
				 String tempFile = "temp.txt";
				 File original_File = new File(filepath);
				 File updated_File = new File(tempFile);
				 String current_field;// Reading the Line in data
				 String data[]; // Analyzing the record
				 try 
				 {
					 // Writing on File
					// true shows that we are not overwriting on the file but adding to the file
					 FileWriter fw = new FileWriter(tempFile, true); 
					 BufferedWriter bw = new BufferedWriter(fw);
					 PrintWriter pw = new PrintWriter(bw);
					 // Reading File
					 FileReader fr = new FileReader(filepath);
					 BufferedReader br = new BufferedReader(fr);
					 // While Loop for looking into the record i:e each line ,if it contains data or not
					 while((current_field = br.readLine()) != null) {
						 data = current_field.split(",");// It will store each field of data into array
					 if(!(data[position].equalsIgnoreCase(Id))) {
						/* If the record is not present in the current position
						   we will simply save and keep the old file 
						 */
						 pw.println(current_field);
						 
					 }
					 }
					 // Closing the files to clear the memory
					 pw.flush();
					 pw.close();
					 fw.close();
					 bw.close();
					 fr.close();
					 br.close();
					 // Deleting the original File
					 original_File.delete();
					 //Renaming the temporary file  to the actual name of the file:
					 File newFile= new File(filepath);
					 updated_File.renameTo(newFile);// Renamed	 
				 }
				 catch(Exception e) {
					 
				 }
				  }
//********************************************************************************************************//
			 //    > SEARCHING A RECORD

			 public static void search_record(String[] args) throws FileNotFoundException {
					
					System.out.println();
				 	System.out.println("\t\t\t\t     .-----------------------------------------------.");
					System.out.println("\t\t\t\t     |          S E A R C H    R E C O R D           |");
					System.out.println("\t\t\t\t     '-----------------------------------------------'");
			        System.out.println();   
			        Scanner input = new Scanner(System.in);//standard input
			        File filepath = new File("CustomerData.txt");      
			        FileReader fr = null;       
			        String customer_id,searched_line = "";
			        
			        System.out.print("Enter Consumer-ID :");
			        customer_id = input.nextLine();       
			        
			        try{
			           fr = new FileReader(filepath);
			           BufferedReader br = new BufferedReader(fr);           
			           
			            // Main logic
						// Reads each line in the file and checks for consumer id then prints the searched record
						// Will read until last line(!=null)
			           System.out.println();
			           System.out.println("IF Consumer's Data is not printed then Id is INVALID!");
			           System.out.println();
			           while((searched_line = br.readLine()) != null) {
			           if(searched_line.contains(customer_id)) {
			        	   System.out.println("   C O N S U M E R    R E C O R D    F O U N D !");
			        	   System.out.println();
			               System.out.print(searched_line);
			           }
			           }
			           System.out.println();
						System.out.println();
						 System.out.println("o Enter 1 to go back to SEARCH RECORD MENU\no Enter 2 to go back to CUSTOMER MENU\no Enter 9 to go back to MAIN MENU\no Enter 0 to EXIT");
                          int option = input();
						  	 if (option == 1) {
						  		search_record(args);
						  	}
						  	 else if (option == 2 ) {
						  		Customer(args);
						  	 }
						  	else if (option == 9 ) {
						  		main(args);
						  	}
						  	else 
						  	    System.exit(0);	
				}
			        catch (IOException ex) {            
			            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
			            
			        }            
			        finally{            
			                try {
			                    fr.close();
			                } catch (IOException ex) {
			                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
			                    
			                }
			               
			            }
			       
			        }

			 


			

//********************************************************************************************************************//		 

			 // EDITING A RECORD
			 
				//Sequence of Variables:
			 
				// --> Customer_ID
				// --> Name
				// --> CNIC
				// --> Address
				// --> Mobile Number
			 	// --> Meter Number
				// --> Connection type
				private static Scanner x;
                private static String[] args;
				  public static void editrecord(String[] args) {
			          Scanner input = new Scanner(System.in);
			          String filepath="CustomerData.txt";
			          System.out.println("Enter Consumer ID to search record:");
			          String search = input.next();
			          System.out.println("Enter new Name of Consumer: ");
			          String newName = input.next();
			          // Generating new ID for Consumer:
			          String characters ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			          String new_Id = "";// For storing ID of customer
			          char [] chars=new char[5];
			  
			          for(int i = 0; i < 5; i++) {
			              int index = (int)(Math.random()*36);	// Picking random values for ID;
			              chars[i] = characters.charAt(index);
			          }
			          for(int i = 0; i < 5; i++) {
			              new_Id += chars[i];
			          }
			          System.out.println("New Consumer ID : "+new_Id);
/*************************************************************************************************/		          
			          
			       // ---> Enter new CNIC	          
			          System.out.println("Enter CNIC(DDDDD-DDDDDDD-D): ");
			          String newCNIC ;
			          newCNIC= input.next();
			          boolean validation = validCNICOrNot(newCNIC);
			          if ((newCNIC.charAt(5) == '-') && (newCNIC.charAt(13) == '-') && (validation == true))
			              System.out.print("Entered CNIC is valid");
			          else if (validation == true)
			              System.out.print("Entered CNIC is valid");
			          else if(validation != true) { 
			              int c = 0;
			              for(int i=  2; i >= c; i--) {
			            	  System.out.println("Invalid CNIC");
			            	  System.out.println("Enter CNIC(DDDDD-DDDDDDD-D): ");
			            	  newCNIC= input.next();
			            	  System.err.println(i+" Tries Left!");
			            	  if (i == 0) {
			            		  System.out.println("o Enter 1 to go back to ADD RECORD MENU\no Enter 2 to go back to ADMIN MENU\no Enter 9 to go back to MAIN MENU\no Enter 0 to EXIT");
                                  int option = input();
			            		  	if(option==1) {
			            		  		add_record(args);
			            		  	}
			            		  	else if (option == 2 ) {
			            		  		Admin(args);
			            		  	}
			            		  	else if (option == 9 ) {
			            		  		main(args);
			            		  	}
			            		  	else 
			            		  	System.exit(0);		 	
			            	  }
			              }
			          
			          }
			          
			          
/*************************************************************************************************/		                   
	// ---> Enter new Connection Type
			          
			       // Entering Connection Type of Customer
						
			       // Variable to be use is-------> newConnection
			       				String newConnection = null;
			       				System.out.println();
			       				System.out.println("\t\t\t\t\t\tTypes of Electricity Connections");
			       				System.out.println();
			       				System.out.println("1- RESIDENTIAL\n 2- COMMERCIAL\n 3- INDUSTRIAL\n 4- AGRICULTURAL");
			       				System.out.println();
			       				System.out.println("Enter connection Number: ");
			       				String type=input.next();
			       				if(type.equals(1)) {
			       					newConnection = "RESIDENTIAL";
			       				}
			       				else if(type.equals(2)) {
			       					newConnection = "COMMERCIAL";
			       					
			       				}
			       				else if(type.equals(3)) {
			       					newConnection = "INDUSTRIAL";
			       					
			       				}
			       				else if(type.equals(4)) {
			       					newConnection = "AGRICULTURAL";
			       					
			       				}
/*************************************************************************************************/		          
			          
			          
	// ---> New Meter number    				
			    				// Generating meter Number of Customer
			    				// Variable to be used ------> MeterNumber	
			    			    String newMeterNumber = "";
			    			    Random random = new Random();
			    				String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //alphabets stored 
			    				int count = 4; //numbers of times loop will execute 
			    				//loop to generate random string
			    				for (int i = 1; i < count - 1; i++) {
			    					//generating random index of variable alphabets
			    					int index = random.nextInt(alphabets.length());
			    					//using that index to print character
			    					char ch = alphabets.charAt(index);
			    			        newMeterNumber += ch;
			    					//System.out.print(ch);
			    				}
			    			    newMeterNumber = newMeterNumber + "-";
			    				//System.out.print("-");
			    				//loop to generate random number
			    				for (int j = 0; j <= count; j++) {
			    					int num = (int)(Math.random() * 10);
			    			        newMeterNumber += num;
			    					
			    				}
			    				System.out.println("Meter Number is : "+newMeterNumber);
/*************************************************************************************************/			          
			          System.out.println("Enter new Address of Consumer: ");
			          String newAddress = input.next();
			          System.out.println("Enter new Mobile Number of Consumer: ");
			          String newMobileNumber = input.next();
			          while(newMobileNumber.length() < 11 || newMobileNumber.length() > 11 ) {
			              System.out.println("INVALID Number!");
			              System.out.print("Enter Mobile No. of Comsumer (11 Digit number): ");
			              newMobileNumber = input.next();
			          
			          }
			          updatedRecord(filepath,search,new_Id,newName,newCNIC,newAddress,newMobileNumber,newMeterNumber,newConnection);
			          System.out.println();
						System.out.println();
						 System.out.println("o Enter 1 to go back to EDIT RECORD MENU\no Enter 2 to go back to ADMIN MENU\no Enter 9 to go back to MAIN MENU\no Enter 0 to EXIT");
						  int option= input();
						  	 if (option == 1) {
						  		editrecord(args);
						  	}
						  	 else if (option == 2 ) {
						  		Admin(args);
						  	 }
						  	else if (option == 9 ) {
						  		main(args);
						  	}
						  	else 
						  	System.exit(0);	   
				  }
			  
				public static void updatedRecord(String filepath, String search, String new_Id,String newName,String newCNIC, String newAddress, String newMobileNumber,String newMeterNumber, String newConnection) {
					String tempFile = "temp.txt";
					File oldFile = new File(filepath);
					File newFile = new File(tempFile);
					String Id = "";String Name = "";String CNIC = ""; String Address = "";String MobileNumber = "";String MeterNumber = "";String connection = "";
					try {	
						FileWriter fw = new FileWriter(tempFile,true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw);
						x = new Scanner(new File (filepath));
						x.useDelimiter("[,\n]");
						while(x.hasNext()) {
							Id = x.next();
							Name = x.next();
							CNIC = x.next();
							Address = x.next();
							MobileNumber = x.next();
							MeterNumber = x.next();
							connection = x.next();
							if(Id.equals(search))
							{
								pw.println(new_Id+","+newName+","+newCNIC+","+newAddress+","+newMobileNumber+","+newMeterNumber+","+newConnection);
								
							}
							else
							{
								
								pw.println(Id+","+Name+","+CNIC+","+Address+","+MobileNumber+","+MeterNumber+","+connection);
							}						
						}
						x.close();
						pw.flush();
						pw.close();
						oldFile.delete();
						File dump=new File(filepath);
						newFile.renameTo(dump);
						System.out.println(" R E C O R D   E D I T E D  S U C C E S S F U L L Y!");
						System.out.println();
						System.out.println();
						 System.out.println("o Enter 1 to go back to DELETE RECORD MENU\no Enter 2 to go back to ADMIN MENU\no Enter 9 to go back to MAIN MENU\no Enter 0 to EXIT");
					}
					catch(Exception e) {
						System.out.println(" R E C O R D   N O T   F O U N D");	
					}
				}
                public static void Customer(String args[]) {
                    // Code For Customer Entity
                    System.out.println();
                    System.out.println("\t\t\t:-------------------------------------------------------------------------:");
                    System.out.println("\t\t\t:\t\t     C U S T O M E R   M E N U\t\t\t\t  :");
                    System.out.println("\t\t\t:-------------------------------------------------------------------------:");
                    Scanner input = new Scanner(System.in);
                    System.out.println("o Enter 1 to LOG IN\no Enter 2 to SIGN UP\no Enter 3 to pay Bill\n"
                    + "o Enter 9 to go back to MAIN MENU\no Enter 0 to EXIT");
                    int option = input();
                    if (option == 1) {
                        CustomerLogIn(args);
                    }
                    else if (option == 2) {
                        try {
                            Application(args);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else if (option == 3){
                        try {
                            PayingBill();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else if (option == 9) {
                        main(args);
                    }
                    else {
                        System.exit(0);
                    }
                }
    public static void BillCalculation(String[] args)throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ID of customer: ");
        String ID = input.next();
        String Id = "", Name = "", CNIC = "", Address = "", contact = "", connectionType = "", meterNo = "";
        try {
            File Customerfile = new File("CustomerData.txt");
            Scanner fileInput = new Scanner(Customerfile);
            while (fileInput.hasNextLine()){
                if (!fileInput.hasNextLine()){
                    System.exit(1);
                }
                Id = fileInput.next();
                Name = fileInput.next();
                CNIC = fileInput.next();
                Address = fileInput.next();
                contact = fileInput.next();
                meterNo = fileInput.next();
                connectionType = fileInput.next();
                
                if (ID.contains(Id)){
                    break;
                }
                else continue;
            }
            fileInput.close();
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch (NoSuchElementException ex){
            ex.printStackTrace();
        }
        System.out.println("Enter Bill Month (e.g Feb-20): ");
        String billMonth = input.next();
        System.out.println("Enter Issue Date of bill(DD-MM-YYYY): ");
        String issueDate = input.next();
        System.out.println("Enter Due Date of bill: ");
        String dueDate = input.next();
        double bill = 0;
        double taxes = 0;
        double BillOnTime = 0;
        double AfterTimeBill = 0;
        
        System.out.print("Enter 1 for Residential connection bill or\n"
                        + "Enter 2 for Commercial connection bill or\n"
                        + "Enter 3 for Industrial connection bill or\n"
                        + "Enter 4 for Agricultural connection bill. ");
        int choice = input();
        //Residential
        if (choice == 1){
            System.out.print("Your connection is Single or Three phase?\n"
                        + "Enter 1 for Single Phase or\n"
                        + "Enter 2 for three phase connection. ");
            int des = input();
            boolean singlePhase = false, threePhase = false;
            if (des == 1){
                singlePhase = true;
            }
            else{
                threePhase = true;
            }
            System.out.print("You are using load less than 5KW?\n"
                            + "Enter 1 for less than 5KW or\n"
                            + "Enter 2 for more than 5KW. ");
            int num = input();
            if (num == 1){
                int load = 4;
                int peak = 0;
                int off_peak = 0;
                System.out.print("Enter number of units consumed. ");
                int units = input();
                bill = (int) Residential(units, load, peak, off_peak, singlePhase, threePhase);
                taxes = (int) ((bill / 100) * 17) + 35;
                BillOnTime = taxes + bill;
                AfterTimeBill = (taxes + bill) + 150;
                try {
                    WritingInFile_1(ID, Name, contact, billMonth, units, BillOnTime);
                    WritingInFile_2(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                    dueDate, meterNo, units, bill, taxes, BillOnTime, AfterTimeBill);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                printingBill(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                dueDate, meterNo, units, bill, taxes, BillOnTime, AfterTimeBill);
            }
            else if (num == 2){
                int load = 6;
                int units = 0;
                System.out.print("Enter no of units used during peak time. ");
                int peak = input();
                System.out.print("Enter no of units used during off_peak time. ");
                int off_peak = input();
                bill = (int) Residential(units, load, peak, off_peak, singlePhase, threePhase);
                int TotalUnits = peak + off_peak;
                taxes = (int)((bill / 100) * 17) + 35;
                BillOnTime = taxes + bill;
                AfterTimeBill = (taxes + bill) + 150;
                try{
                    WritingInFile_1(ID, Name, contact, billMonth, TotalUnits, BillOnTime);
                    WritingInFile_2(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                    dueDate, meterNo, TotalUnits, bill, taxes, BillOnTime, AfterTimeBill);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                printingBill(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                dueDate, meterNo, TotalUnits, bill, taxes, BillOnTime, AfterTimeBill);
                } 
            }
        //Commercial
        else if (choice == 2){
            System.out.print("Your connection is Single or Three phase?\n"
                        + "Enter 1 for Single Phase or\n"
                        + "Enter 2 for three phase connection. ");
            int des = input();
            boolean singlePhase = false, threePhase = false, TOU = false;
            if (des == 1){
                singlePhase = true;
            }
            else {
                threePhase = true;
            }
            System.out.print("You are using load less than 5KW?\n"
                            + "Enter 1 for less than 5KW or\n"
                            + "Enter 2 for more than 5KW or\n"
                            + "Enter 3 for Time Of Use connection. ");
            int num = input();
            if (num == 1){
                int load = 4;
                int peak = 0;
                int off_peak = 0;
                System.out.print("Enter no of units consumed. ");
                int units = input();
                bill = (int) Commercial(units, load, peak, off_peak, TOU, singlePhase, threePhase);
                taxes = (int) ((bill / 100) * 17) + 35;
                BillOnTime = taxes + bill;
                AfterTimeBill = (taxes + bill) + 200;
                try {
                    WritingInFile_1(ID, Name, contact, billMonth, units, BillOnTime);
                    WritingInFile_2(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                    dueDate, meterNo, units, bill, taxes, BillOnTime, AfterTimeBill);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                printingBill(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                dueDate, meterNo, units, bill, taxes, BillOnTime, AfterTimeBill);
            }
            else if (num == 2){
                int load = 6;
                int peak = 0;
                int off_peak = 0;
                System.out.print("Enter no of units consumed ");
                int units = input();
                bill = (int) Commercial(units, load, peak, off_peak, TOU, singlePhase, threePhase);
                taxes = (int) ((bill / 100) * 17) + 35;
                BillOnTime = taxes + bill;
                AfterTimeBill = (taxes + bill) + 200;
                try {
                    WritingInFile_1(ID, Name, contact, billMonth, units, BillOnTime);
                    WritingInFile_2(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                    dueDate, meterNo, units, bill, taxes, BillOnTime, AfterTimeBill);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                printingBill(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                dueDate, meterNo, units, bill, taxes, BillOnTime, AfterTimeBill);
            }
            else if (num == 3){
                int load = 0, units = 0;
                TOU = true;
                System.out.print("Enter peak time units. ");
                int peak = input();
                System.out.print("Enter off_peak time units. ");
                int off_peak = input();
                bill = (int) Commercial(units, load, peak, off_peak, TOU, singlePhase, threePhase);
                int TotalUnits = peak + off_peak;
                taxes = (int) ((bill / 100) * 17) + 35;
                BillOnTime = taxes + bill;
                AfterTimeBill = (taxes + bill) + 150;
                try {
                    WritingInFile_1(ID, Name, contact, billMonth, TotalUnits, BillOnTime);
                    WritingInFile_2(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                    dueDate, meterNo, TotalUnits, bill, taxes, BillOnTime, AfterTimeBill);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                printingBill(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                dueDate, meterNo, TotalUnits, bill, taxes, BillOnTime, AfterTimeBill);
            }
        }
        //Industrial
        else if (choice == 3){
            System.out.print("Enter 1 for B1 connection (Connection having load upto 25KW) or\n"
                        + "Enter 2 for B2 connection (Connection having load 25KW to 500KW) or\n"
                        + "Enter 3 for B3 connection (Connection with load upto 5000KW) or\n"
                        + "Enter 4 for B4 connection (For all loads upto 66132KW). ");
            int number = input();
            boolean B1 = false, B2 = false, B3 = false, B4 = false, Tou = false;
            if (number == 1){
                B1 = true;
                System.out.print("Enter 1 for normal connection or\n"
                + "Enter 2 for TOU connection. ");
                int num1 = input();
                if (num1 == 1){
                    int load = 24;
                    int peak = 0;
                    int off_peak = 0;
                    System.out.print("Enter no of units consumed. ");
                    int units = input();
                    bill = (int) Industrial(units, load, peak, off_peak, Tou, B1, B2, B3, B4);
                    taxes = (int) ((bill / 100) * 17) + 35;
                    BillOnTime = taxes + bill;
                    AfterTimeBill = (taxes + bill) + 150;
                    try{
                        WritingInFile_1(ID, Name, contact, billMonth, units, BillOnTime);
                        WritingInFile_2(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                        dueDate, meterNo, units, bill, taxes, BillOnTime, AfterTimeBill);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    printingBill(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                    dueDate, meterNo, units, bill, taxes, BillOnTime, AfterTimeBill);
                }
                else if (num1 == 2){
                    int load = 24, units = 0;
                    Tou = true;
                    System.out.print("Enter peak time units. ");
                    int peak = input();
                    System.out.print("Enter off_peak time units. ");
                    int off_peak = input();
                    bill = (int) Industrial(units, load, peak, off_peak, Tou, B1, B2, B3, B4);
                    int TotalUnits = peak + off_peak;
                    taxes = (int) ((bill / 100) * 17) + 35;
                    BillOnTime = taxes + bill;
                    AfterTimeBill = (taxes + bill) + 150;
                    try{
                        WritingInFile_1(ID, Name, contact, billMonth, TotalUnits, BillOnTime);
                        WritingInFile_2(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                        dueDate, meterNo, TotalUnits, bill, taxes, BillOnTime, AfterTimeBill);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    printingBill(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                    dueDate, meterNo, TotalUnits, bill, taxes, BillOnTime, AfterTimeBill);
                }
            }
            else if (number == 2){
                B2 = true;
                System.out.print("Enter 1 for normal connection or\n"
                + "Enter 2 for TOU connection. ");
                int num2 = input();
                if (num2 == 1){
                    int load = 50;
                    int peak = 0;
                    int off_peak = 0;
                    System.out.print("Enter no of units consumed. ");
                    int units = input();
                    bill = (int) Industrial(units, load, peak, off_peak, Tou, B1, B2, B3, B4);
                    taxes = (int) ((bill / 100) * 17) + 35;
                    BillOnTime = taxes + bill;
                    AfterTimeBill = (taxes + bill) + 150;
                    try{
                        WritingInFile_1(ID, Name, contact, billMonth, units, BillOnTime);
                        WritingInFile_2(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                        dueDate, meterNo, units, bill, taxes, BillOnTime, AfterTimeBill);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    printingBill(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                    dueDate, meterNo, units, bill, taxes, BillOnTime, AfterTimeBill);
                }
                if (num2 == 2){
                    int load = 50, units = 0;
                    Tou = true;
                    System.out.print("Enter peak time units. ");
                    int peak = input();
                    System.out.print("Enter off_peak time units. ");
                    int off_peak = input();
                    bill = (int) Industrial(units, load, peak, off_peak, Tou, B1, B2, B3, B4);
                    int totalUnits = peak + off_peak;
                    taxes = (int) ((bill / 100) * 17) + 35;
                    BillOnTime = taxes + bill;
                    AfterTimeBill = (taxes + bill) + 150;
                    try{
                        WritingInFile_1(ID, Name, contact, billMonth, totalUnits, BillOnTime);
                        WritingInFile_2(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                        dueDate, meterNo, totalUnits, bill, taxes, BillOnTime, AfterTimeBill);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    printingBill(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                    dueDate, meterNo, totalUnits, bill, taxes, BillOnTime, AfterTimeBill);
            }
        }
            if (number == 3){
                B3 = true;
                int load = 1000, units = 0;
                Tou = true;
                System.out.print("Enter peak time units. ");
                int peak = input();
                System.out.print("Enter off_peak time units. ");
                int off_peak = input();
                bill = (int) Industrial(units, load, peak, off_peak, Tou, B1, B2, B3, B4);
                int totalUnits = peak + off_peak;
                taxes = (int) ((bill / 100) * 17) + 35;
                BillOnTime = taxes + bill;
                AfterTimeBill = (taxes + bill) + 150;
                try{
                    WritingInFile_1(ID, Name, contact, billMonth, totalUnits, BillOnTime);
                    WritingInFile_2(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                    dueDate, meterNo, totalUnits, bill, taxes, BillOnTime, AfterTimeBill);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                printingBill(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                dueDate, meterNo, totalUnits, bill, taxes, BillOnTime, AfterTimeBill);
            }
            if (number == 4){
                B4 = true;
                int load = 6000, units = 0;
                Tou = true;
                System.out.print("Enter peak time units. ");
                int peak = input();
                System.out.print("Enter off_peak time units. ");
                int off_peak = input();
                bill = (int) Industrial(units, load, peak, off_peak, Tou, B1, B2, B3, B4);
                int totalUnits = peak + off_peak;
                taxes = (int) ((bill / 100) * 17) + 35;
                BillOnTime = taxes + bill;
                AfterTimeBill = (taxes + bill) + 150;
                try{
                    WritingInFile_1(ID, Name, contact, billMonth, totalUnits, BillOnTime);
                    WritingInFile_2(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                    dueDate, meterNo, totalUnits, bill, taxes, BillOnTime, AfterTimeBill);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                printingBill(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                dueDate, meterNo, totalUnits, bill, taxes, BillOnTime, AfterTimeBill);
            }
        }
        //Agricultural
        else if (choice == 4){
            System.out.print("Which connection you are using? TOU or normal?\n"
                            + "Enter 1 for TOU or\n Enter 2 for normal. ");
            int num1  = input();
            boolean ToU = false, SCARP = false, ATB = false;
            if (num1 == 1){
                int load = 6;
                ToU = true;
                int units = 0;
                System.out.print("You want to calculate bill for SCARP or ATB?\n"
                                + "Enter 1 for SCARP or\n Enter 2 for ATB. ");
                int num2 = input();
                if (num2 == 1){
                    SCARP = true;
                    System.out.print("Enter units consumed in peak time. ");
                    int peak = input();
                    System.out.print("Enter units consumed in off_peak time. ");
                    int off_peak = input();
                    bill = (int) Agricultural(units, load, peak, off_peak, ToU, SCARP, ATB);
                    int totalUnits = peak + off_peak;
                    taxes = (int) ((bill / 100) * 17) + 35;
                    BillOnTime = taxes + bill;
                    AfterTimeBill = (taxes + bill) + 150;
                    try{
                        WritingInFile_1(ID, Name, contact, billMonth, totalUnits, BillOnTime);
                        WritingInFile_2(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                        dueDate, meterNo, totalUnits, bill, taxes, BillOnTime, AfterTimeBill);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    printingBill(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                    dueDate, meterNo, totalUnits, bill, taxes, BillOnTime, AfterTimeBill);
                }
                else if (num2 == 2){
                    ATB = true;
                    System.out.print("Enter units consumed in peak time. ");
                    int peak = input();
                    System.out.print("Enter units consumed in off_peak time. ");
                    int off_peak = input();
                    bill = (int) Agricultural(units, load, peak, off_peak, ToU, SCARP, ATB);
                    int totalUnits = peak + off_peak;
                    taxes = (int) ((bill / 100) * 17) + 35;
                    BillOnTime = taxes + bill;
                    AfterTimeBill = (taxes + bill) + 150;
                    try{
                        WritingInFile_1(ID, Name, contact, billMonth, totalUnits, BillOnTime);
                        WritingInFile_2(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                        dueDate, meterNo, totalUnits, bill, taxes, BillOnTime, AfterTimeBill);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    printingBill(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                    dueDate, meterNo, totalUnits, bill, taxes, BillOnTime, AfterTimeBill);
                }
            }
            else if (num1 == 2){
                System.out.print("You want to calculate bill for SCARP or ATB?\n"
                                + "Enter 1 for SCARP or\n Enter 2 for ATB. ");
                int num3 = input();
                if (num3 == 1){
                    int load = 4;
                    int peak = 0;
                    int off_peak = 0; 
                    SCARP = true;
                    System.out.print("Enter no of units consumed. ");
                    int units = input();
                    bill = (int) Agricultural(units, load, peak, off_peak, ToU, SCARP, ATB);
                    taxes = (int) ((bill / 100) * 17) + 35;
                    BillOnTime = taxes + bill;
                    AfterTimeBill = (taxes + bill) + 150;
                    try{
                        WritingInFile_1(ID, Name, contact, billMonth, units, BillOnTime);
                        WritingInFile_2(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                        dueDate, meterNo, units, bill, taxes, BillOnTime, AfterTimeBill);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    printingBill(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                    dueDate, meterNo, units, bill, taxes, BillOnTime, AfterTimeBill);
                }
                else if (num3 == 2){
                    int load = 4;
                    int peak = 0;
                    int off_peak = 0;
                    ATB = true;
                    System.out.print("Enter no of units consumed. ");
                    int units = input();
                    bill = (int) Agricultural(units, load, peak, off_peak, ToU, SCARP, ATB);
                    taxes = (int) ((bill / 100) * 17) + 35;
                    BillOnTime = taxes + bill;
                    AfterTimeBill = (taxes + bill) + 150;
                    try{
                        WritingInFile_1(ID, Name, contact, billMonth, units, BillOnTime);
                        WritingInFile_2(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                        dueDate, meterNo, units, bill, taxes, BillOnTime, AfterTimeBill);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    printingBill(ID, Name, Address, contact, connectionType, billMonth, issueDate,
                    dueDate, meterNo, units, bill, taxes, BillOnTime, AfterTimeBill);
                }
            }
        }
    }
   //Bill amount
        // 1) Residential
        public static double Residential(int units, int load, int peak, int off_peak,
        boolean SinglePhase, boolean ThreePhase){
            double bill = 0;    //variable to store bill amount
            //conditions when power is used
            // for load of upto 5KW
            if ((load < 5) && (units != 0)){
                if (units < 50)
                    bill = units * 3.95;
                else if (units > 50 && units <= 100)
                    bill = units * 7.74;
                else if(units > 100 && units <= 200){
                    int Units = units - 100;
                    bill = (Units * 10.06) + (100 * 7.74);
                }
                else if (units > 200 && units <= 300){
                    int Units = units - 200;
                    bill = (Units * 12.15) + (100 * 10.06) + (100 * 7.74);
                }
                else if (units > 300 && units <= 700){
                    int Units = units - 300;
                    bill = (Units * 19.55) + (100 * 7.74) + (100 * 10.06) + (100 * 12.15);
                }
                else if (units > 700){
                    int Units = units - 700;
                    bill = (Units * 22.65) + (100 * 7.74) + (100 * 10.06) + (100 * 12.15) + (400 * 19.55);
                }
            }
            // for load of 5KW or more
            // for this "Time Of Use" connection is used i.e. Peak and off-peak time
            else if ((load >= 5) && (peak != 0) && (off_peak != 0) && (units == 0)){
                bill = (peak * 22.65) + (off_peak * 16.33);
            }
            //Two type of connection exists:
            //1) Single Phase Connection
            //2) Three Phase Connection
            //Conditions to charge bill if electricity isn't used in month
            else if ((SinglePhase == true) && (units == 0)){
                bill = 75;
            }
            else if ((ThreePhase == true) && (units == 0)){
                bill = 150;
            }
            else if ((SinglePhase == true) && (peak == 0) && (off_peak == 0) && (units == 0)){
                bill = 75;
            }
            else if ((ThreePhase == true) && (peak == 0) && (off_peak == 0) && (units == 0)){
                bill = 150;
            }
            return bill;
    }
    // 2) Commercial
    public static double Commercial(int units, int load, int peak, int off_peak,boolean TOU,
    boolean SinglePhase, boolean ThreePhase){
        double bill = 0;
        //conditions if power is used
        // for load upto 5KW
        if ((load < 5) && (units != 0)){
            bill = units * 19.95;
        }
        //for load of 5KW or more
        else if ((load >= 5) && (units != 0)){
            bill = units * 21.63;
        }
        //If "Time Of Use" connection is used
        else if ((TOU == true) && (peak != 0) && (off_peak != 0) && (units == 0)){
            bill = (peak * 23.55) + (off_peak * 17.58);
        }
        //Conditions if power isn't used
        else if ((SinglePhase == true) && (units == 0)){
            bill = 175;
        }
        else if ((ThreePhase == true) && (units == 0)){
            bill = 300;
        }
        else if ((SinglePhase == true) && (peak == 0) && (off_peak == 0) && (units == 0)){
            bill = 175;
        }
        else if ((ThreePhase == true) && (peak == 0) && (off_peak == 0) && (units == 0)){
            bill = 300;
        }
        return bill;
    }
    // 3) Industrial
    public static double Industrial(int units, int load, int peak, int off_peak,boolean TOU,
    boolean B1, boolean B2, boolean B3, boolean B4) {
        double bill = 0;
        //conditions if power isn't used.
        //4 industrial connections are below with their description
        //B1 connection (Connection having load upto 25KW)
        if ((B1 == true) && (units == 0)){
            bill = 350;
        }
        else if ((B1 == true) && (peak == 0) && (off_peak == 0) && (units == 0)){
            bill = 350;
        }
        //B2 connection (Connection having load 25KW to 500KW)
        else if ((B2 == true) && (units == 0)){
            bill = 2000;
        }
        else if ((B2 == true) && (peak == 0) && (off_peak == 0) && (units == 0)){
            bill = 2000;
        }
        //B3 connection (Connection with load upto 5000KW)
        else if ((B3 == true) && (peak == 0) && (off_peak == 0) && (units == 0)){
            bill = 50000;
        }
        //B4 connection (For all loads upto 66132KW)
        else if ((B4 == true) && (peak == 0) && (off_peak == 0) && (units == 0)){
            bill = 500000;
        }
        //when power is used and "Time Of Use" connection is used
        if ((TOU == true) && (peak != 0) && (off_peak != 0) && (units == 0)){
            //B1(a) connection
            if (load < 25){
                bill = (peak * 20.79) + (off_peak * 15.23);
            }
            //B2(a) connection
            else if ((load >= 25) && (load <= 500)){
                bill = (peak * 20.73) + (off_peak * 15.02);
            }
            //B3 connection
            else if ((load > 500) && (load <= 5000)){
                bill = (peak * 20.73) + (off_peak * 14.93);
            }
            //B4 connection
            else if ((load > 5000) && (load <= 66132)){
                bill = (peak * 20.73) + (off_peak * 14.83);
            }
        }
        //B1 connection
        else if ((load < 25) && (units != 0)){
            bill = units * 17.23;
        }
        //B2 connection
        else if ((load >= 25) && (load <= 2500) && (units != 0)){
            bill = units * 16.73;
        }
        return bill;
    }
    // 4) Agricultural 
    public static double Agricultural(int units, int load, int peak, int off_peak,
    boolean TOU,boolean SCARP,boolean ATB){
        double bill = 2000;
        // when power is used having "Time Of Use" connection and load greater than 5KW
        //SCARP (Salinity Control And Reclamation Project), it is a type of connection.
        //ATB means Agricultural Tube Wells
        if ((TOU == true) && (SCARP == true) && (load >= 5) && (units == 0) && (peak != 0) && (off_peak != 0)){
            bill = 0;
            bill = (peak * 20.55) + (off_peak * 13.30);
        }
        else if ((TOU == true) && (ATB == true) && (load >= 5) && (units == 0) && (peak != 0) && (off_peak != 0)){
            bill = 0;
            bill = (peak * 7.30) + (off_peak * 7.30);
        }
        // Connection with less than 5KW load
        else if ((SCARP == true) && (load < 5) && (units != 0)){
             bill = 0;
            bill = units * 17.63;
        }
        else if ((ATB == true) && (load < 5) && (units != 0)){
            bill = 0;
            bill = units * 7.30;
        }
        return bill;
    }
    public static void printingBill(String ID, String name, String address, String contact,
     String connectionType, String billMonth, String issueDate, String dueDate, String meterNo,
    int units, double bill, double taxes,double billOnTime, double billAfterTime) 
    throws IOException{
        System.out.println();
        System.out.print("\t\t\t\t ** ELECTRIC SUPPLY COMPANY **");
        System.out.println();
        System.out.print("\t\t\t\t** ELECTRICITY CONSUMER BILL **");
        System.out.println();
        System.out.println();
        System.out.println("\t\t****************************************************************");
        System.out.println();
        System.out.println("\t\t\t\t\t < Information >");
        System.out.println();
        System.out.print("Consumer ID\t\tName\t\t\tAddress\t\t\t\tPhone Number");
        System.out.println();
        System.out.print(ID+"\t\t\t"+name+"\t\t\t"+address+"\t\t\t\t"+contact);
        System.out.println();
        System.out.print("Connection Type\t\tBill Month\t\tIssue Date\t\t\tDue Date");
        System.out.println();
        System.out.print(connectionType+"\t\t"+billMonth+"\t\t\t"+issueDate+"\t\t\t"+dueDate);
        System.out.println();
        System.out.print("Meter No\t\tUnits Consumed");
        System.out.println();
        System.out.print(meterNo+"\t\t\t"+units);
        System.out.println();
        System.out.print("Cost of Electricity\tTaxes\t\t\tBill payable in time\t\tBill after due date");
        System.out.println();
        System.out.print(bill+"\t\t\t"+taxes+"\t\t\t"+billOnTime+"\t\t\t\t"+billAfterTime);
        System.out.println();
        System.out.println("\t\t\t\t\t< Previous Record >");
        System.out.println();
        System.out.println("Month\t\tUnits\t\tBill\t\tPrevious Reading\tCurrent Reading");
        try {
            long current = 0, previous = 0;
            File myfile = new File("billRecord.txt");
            Scanner input = new Scanner(myfile);
            while (input.hasNextLine()){
                if (!input.hasNext())
                    System.exit(1);
                String id = input.next();
                String NAME = input.next();
                String CONTACT = input.next();
                String month = input.next();
                int unitsConsumed = input.nextInt();
                double BILL = input.nextDouble();
                if (ID.contains(id)){
                    current += unitsConsumed;
                    previous = current - unitsConsumed;
                    System.out.println(month + "\t\t" + unitsConsumed + "\t\t" + BILL + "\t\t" + previous + "\t\t\t" + current);
                }
                else continue;
            }
            input.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (NoSuchElementException ex){
            ex.printStackTrace();
        }
    }
    public static void WritingInFile_1(String id, String Name, String contact, String billMonth,
    int units, double billOnTime)throws Exception{
        try{
            File file = new File("billRecord.txt");
            if (!file.exists()){
                file.createNewFile();
            }
            PrintWriter output = new PrintWriter(new FileWriter(file,true));
            output.print(id + " ");
            output.print(Name + " ");
            output.print(contact + " ");
            output.print(billMonth + " ");
            output.print(units + " ");
            output.println(billOnTime);
            output.close();
            System.out.println("Successfully wrote to the file.");
    }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (NoSuchElementException ex){
            ex.printStackTrace();
    }
}
    public static void WritingInFile_2(String ID, String name, String address, String contact,
    String connectionType, String billMonth, String issueDate, String dueDate, String meterNo,
   int units, double bill, double taxes,double billOnTime, double billAfterTime)throws Exception{
        File file = new File("Record.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        try {
            PrintWriter Output = new PrintWriter(new FileWriter(file, true));
            Output.print(ID + "  ");
            Output.print(name + "  ");
            Output.print(address + "  ");
            Output.print(contact + "  ");
            Output.print(connectionType + "  ");
            Output.print(billMonth + "  ");
            Output.print(issueDate + "  ");
            Output.print(dueDate + "  ");
            Output.print(meterNo + "  ");
            Output.print(units + "  ");
            Output.print(bill + "  ");
            Output.print(taxes + "  ");
            Output.print(billOnTime + "  ");
            Output.println(billAfterTime);
            Output.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }  
    }
    public static int input(){
        Scanner input = new Scanner(System.in);
        int number = 0;
        boolean continueInput = true;
        do {
            try {
                number = input.nextInt();
                continueInput = false;
            }
            catch (InputMismatchException ex) {
                System.out.println("Try again. Incorrect Input: an integer is required");
                input.nextLine();
            }
        } while (continueInput);
        return number;
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void search_bill_record(String[] args) throws FileNotFoundException {				
        System.out.println();
        System.out.println("\t\t\t\t     .-----------------------------------------------.");
        System.out.println("\t\t\t\t     |          S E A R C H    R E C O R D           |");
        System.out.println("\t\t\t\t     '-----------------------------------------------'");
        System.out.println();   
        Scanner input = new Scanner(System.in);//standard input
        File filepath = new File("CustomerData.txt");      
        FileReader fr = null;       
        String customer_id,searched_line = "";
        
        System.out.print("Enter Consumer-ID :");
        customer_id = input.nextLine();      
        try {
           fr = new FileReader(filepath);
           BufferedReader br = new BufferedReader(fr);
            // Main logic
            // Reads each line in the file and checks for consumer id then prints the searched record
            // Will read until last line(!=null)
           System.out.println();
           //System.out.println("IF Consumer's Data is not printed then Id is INVALID!");
           System.out.println();
           while((searched_line = br.readLine()) != null) {
                if (searched_line.contains(customer_id)) {
                    System.out.println("   C O N S U M E R    R E C O R D    F O U N D !");
                    System.out.println();
                    System.out.println(searched_line);
                    System.out.print("Press 1 If you want to see your Bill record: ");
                    int choice = input.nextInt();
                    if (choice == 1){
                        Billrecord(args);
                    }
                    else
                        System.exit(1);
                }
            }
            input.close();
            br.close();
        }        
        catch (IOException ex) {            
            ex.printStackTrace();;   
        }            
        finally{            
                try {
                    fr.close();
                } 
                catch (IOException ex) {
                    ex.printStackTrace();;  
                }      
            }   
        }
    public static void Billrecord(String[] args) throws FileNotFoundException{
        //scanner class to get input from user
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your ID: ");
        String identification = in.next();
        try {
            //getting file in which info is stored
            File FILE = new File("Record.txt");
            //using scanner to read the file
            Scanner input = new Scanner(FILE);
            //using loop to get info
            while (input.hasNextLine()){
                if (!input.hasNextLine()){
                    System.exit(1);
                }
                //storing all the values in variables
                String ID = input.next();
                String Name = input.next();
                String address = input.next();
                String contact = input.next();
                String connectionType  = input.next();
                String billMonth = input.next();
                String issueDate = input.next();
                String dueDate = input.next();
                String MeterNo = input.next();
                int units = input.nextInt();
                double bill = input.nextDouble();
                double taxes = input.nextDouble();
                double billOnTime = input.nextDouble();
                double billAfterTime = input.nextDouble();
                
                //if found
                if (ID.contains(identification)) {
                    try {
                        PrintingBillRecord(ID, Name, address, contact, connectionType, billMonth,
                        issueDate, dueDate, MeterNo, units, bill, taxes, billOnTime, billAfterTime);
                    } 
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else continue;
                in.close();
                input.close();
        }
    }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
}
    public static void PaymentMethod(){
        Scanner input = new Scanner(System.in);
        System.out.println("How do you want to pay the bill?\n1) Online Payment\n2) Cash ");
        int choice = input();
        if (choice == 1){
            System.out.print("Enter your Credit Card Number: ");
            String CreditCard = input.next();
            System.out.print(CreditCard);
		    System.out.print(isCCValid(CreditCard)? " is valid." : " is invalid. Try Again!");
            System.out.println();
            if (isCCValid(CreditCard) != true){
                PaymentMethod();
            }
            else{
                System.out.print("Payment Successful. Thank you!");
            }     
        }
        else if (choice == 2){
            System.out.print("Thank you for visiting!");
        }
        input.close();
    }
    //method to check conditions that will determine weather CC is valid or not
	public static boolean isCCValid(String number) {
		boolean valid = false;
		//summing the sum of even and odd places in CC
		int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
		//condition of validation
		if ((sum % 10 == 0) && (prefixMatched(number) == true) && (getSize(number)) == true) 
			valid = true;
		else
			valid = false;
		return valid;		
	}
	//method to get sum of even places
	public static int sumOfDoubleEvenPlace(String number) {
		int sum = 0;
		//loop is getting sum of even places
		 for (int i = number.length() - 2; i >= 0; i -= 2) {
		      int digit = Character.digit(number.charAt(i),10);
		      //getDigit method is invoked to break two digit number to single
		      sum += getDigit(digit * 2);
		    }
		return sum;
	}
	//method for getting single digit number
	public static int getDigit(int number) {
		int digit = (number / 10) + (number % 10);
		return digit;
	}
	//method to get sum of odd places in CC
	public static int sumOfOddPlace(String number) {
		int sum = 0;
	    for (int i = number.length() - 1; i >= 0; i -= 2) {
	      int digit = Character.digit(number.charAt(i), 10);
	      sum += digit;
	    }
	    return sum;
	}
	//method to check if the prefix of CC match the prefix of CC worldwide
	public static boolean prefixMatched(String number) {
		    if (number.startsWith("4") || number.startsWith("5") ||
		        number.startsWith("37") || number.startsWith("6")) {
		    	return true;
		    }
		    return false;
	}
	//method to check the length of CC
	public static boolean getSize(String number) {
		int length = number.length();
		if (length >= 13 && length <= 16)
			return true;
		return false;
	}
    public static void PayingBill() throws Exception{
        Scanner Input = new Scanner(System.in);
        System.out.print("Enter your ID: ");
        String Id = Input.next();
        System.out.print("Enter Bill Month: ");
        String billmonth = Input.next();
        try {
            File myfile = new File("Record.txt");
            Scanner input = new Scanner(myfile);
            while (input.hasNextLine()){
                if (!input.hasNext())
                    System.exit(1);
                String id = input.next();
                String NAME = input.next();
                String ADDRESS = input.next();
                String CONTACT = input.next();
                String CONNECTIONTYPE = input.next();
                String month = input.next();
                String ISSUEDATE = input.next();
                String DUEDATE = input.next();
                String METERNO = input.next();
                int unitsConsumed = input.nextInt();
                double BILL = input.nextDouble();
                double TAXES = input.nextDouble();
                double BILLonTIME = input.nextDouble();
                double BILLafterTIME = input.nextDouble();
                if ((Id.contains(id)) && (billmonth.contains(month))){
                    PaymentMethod();
                    printingBill(id, NAME, ADDRESS, CONTACT, CONNECTIONTYPE, month, ISSUEDATE, DUEDATE, METERNO,
                    unitsConsumed, BILL, TAXES, BILLonTIME, BILLafterTIME);    
                }
            }
            input.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void PrintingBillRecord(String ID, String name, String address, String contact,
    String connectionType, String billMonth, String issueDate, String dueDate, String meterNo,
    int units, double bill, double taxes, double billOnTime, double billAfterTime) 
    throws IOException{
        try {
            long current = 0, previous = 0;
            File myfile = new File("Record.txt");
            Scanner input = new Scanner(myfile);
            while (input.hasNextLine()){
                if (!input.hasNext())
                    System.exit(1);
                String id = input.next();
                String NAME = input.next();
                String ADDRESS = input.next();
                String CONTACT = input.next();
                String CONNECTIONTYPE = input.next();
                String month = input.next();
                String ISSUEDATE = input.next();
                String DUEDATE = input.next();
                String METERNO = input.next();
                int unitsConsumed = input.nextInt();
                double BILL = input.nextDouble();
                double TAXES = input.nextDouble();
                double BILLonTIME = input.nextDouble();
                double BILLafterTIME = input.nextDouble();
                if (ID.contains(id)){
                    System.out.println();
                    System.out.print("\t\t\t\t ** ELECTRIC SUPPLY COMPANY **");
                    System.out.println();
                    System.out.print("\t\t\t\t** ELECTRICITY CONSUMER BILL **");
                    System.out.println();
                    System.out.println();
                    System.out.println("\t\t****************************************************************");
                    System.out.println();
                    System.out.println("\t\t\t\t\t < Information >");
                    System.out.println();
                    System.out.print("Consumer ID\t\tName\t\t\tAddress\t\t\t\tPhone Number");
                    System.out.println();
                    System.out.print(ID+"\t\t\t"+NAME+"\t\t\t"+ADDRESS+"\t\t\t\t"+CONTACT);
                    System.out.println();
                    System.out.print("Connection Type\t\tBill Month\t\tIssue Date\t\t\tDue Date");
                    System.out.println();
                    System.out.print(CONNECTIONTYPE+"\t\t"+month+"\t\t\t"+ISSUEDATE+"\t\t\t"+DUEDATE);
                    System.out.println();
                    System.out.print("Meter No\t\tUnits Consumed");
                    System.out.println();
                    System.out.print(METERNO+"\t\t\t"+unitsConsumed);
                    System.out.println();
                    System.out.print("Cost of Electricity\tTaxes\t\t\tBill payable in time\t\tBill after due date");
                    System.out.println();
                    System.out.print(BILL+"\t\t\t"+TAXES+"\t\t\t"+BILLonTIME+"\t\t\t\t"+BILLafterTIME);
                    System.out.println();
                    System.out.println("\t\t\t\t\t< Previous Record >");
                    System.out.println();
                    System.out.println("Month\t\tUnits\t\tBill\t\tPrevious Reading\tCurrent Reading");
                    current += unitsConsumed;
                    previous = current - unitsConsumed;
                    System.out.println(month + "\t\t" + unitsConsumed + "\t\t" + BILL + "\t\t" + previous + "\t\t\t" + current);
                }
                else continue;
            }
            input.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (NoSuchElementException ex){
            ex.printStackTrace();
        }
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void Application(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        String name = input.next();
        System.out.print("Enter your Contact No: ");
        String contact = input.next();
        System.out.print("Enter CNIC NO: ");
        String CNIC = input.next();
        System.out.print("Enter your Address: ");
        String address = input.next();
        System.out.print("Residential \nCommercial \nIndustrial \nAgricultural\n");
        System.out.print("Choose a connection from above given connection: ");
        String connectionType = input.next();
        connectionType = connectionType.toUpperCase();
        String connections = "RESIDENTIAL, COMMERCIAL, INDUSTRIAL, AGRICULTURAL";
        String characters ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String Id = "";// For storing ID of customer
        char [] chars = new char[5];
        for(int i = 0; i < 5; i++) {
            int index = (int)(Math.random()*36);	// Picking random values for ID;
            chars[i] = characters.charAt(index);
        }
        for(int i = 0; i < 5; i++) {
            Id += chars[i];
        }
        if ((CNICVALID(CNIC) == true) && (MobileNumValidation(contact) == true) && (connections.contains(connectionType))){
            System.out.println("Application accepted.");
            System.out.print("Your Consumer ID is " + Id + " and your Meter No is " + MeterNo());   
            PrintWriter output = new PrintWriter(new FileWriter("CustomerData.txt",true));
            output.print(Id + " ");
            output.print(name + " " );
            output.print(CNIC + " " );
            output.print(address + " ");
            output.print(contact + " ");
            output.print(MeterNo() + " ");
            output.println(connectionType);
            output.close();
            System.out.println();
            System.out.println("Successfully wrote to the file");
        }
        else {
            System.out.println("Application Not Accepted. You entered wrong information");
        }
    }
    public static String MeterNo(){
        String MeterNumber = "";
        Random random = new Random();
		String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //alphabets stored 
		int count = 4; //numbers of times loop will execute 
		//loop to generate random string
		for (int i = 1; i < count - 1; i++) {
			//generating random index of variable alphabets
			int index = random.nextInt(alphabets.length());
			//using that index to print character
			char ch = alphabets.charAt(index);
            MeterNumber += ch;
			//System.out.print(ch);
		}
        MeterNumber = MeterNumber + "-";
		//System.out.print("-");
		//loop to generate random number
		for (int j = 0; j <= count; j++) {
			int num = (int)(Math.random() * 10);
            MeterNumber += num;
			//System.out.print(num);
		}
        return MeterNumber;
    }
    public static boolean CNICVALID(String s){
        boolean validation = validCNICOrNot(s);
        if ((s.charAt(5) == '-') && (s.charAt(13) == '-') && (validation == true))
            return true;
        else if (validation == true)
            return true;
        else 
            return false;
    }
    //method for checking validation
    public static boolean validCNICOrNot(String S){
        boolean validOrNot = CNICLength(S) && OnlyDigits(S);
        return validOrNot;
    }
    //method to check the length of CNIC
	public static boolean CNICLength(String S) {
		if ((S.length() == 15) || (S.length() == 13))
			return true;
		return false;			
	}
    //method to check that CNIC only contains digits
    public static boolean OnlyDigits(String S){
        int totalDigits = 0;
        for (int i = 0; i < S.length(); i++){
            if (Character.isDigit(S.charAt(i)))
                totalDigits++;
        }
        if (totalDigits == 13)
            return true;
        return false;
    }
    public static boolean MobileNumValidation(String S){
        if ((MobNoLength(S) == true) && (OnlyDigitsInNo(S) == true))
            return true;
        else return false;
    }
    //method to check the length of CNIC
	public static boolean MobNoLength(String S) {
		if ((S.length() == 11) || (S.length() == 12))
			return true;
		return false;			
	}
    //method to check that CNIC only contains digits
    public static boolean OnlyDigitsInNo(String S){
        int totalDigits = 0;
        for (int i = 0; i < S.length(); i++){
            if (Character.isDigit(S.charAt(i)))
                totalDigits++;
        }
        if (totalDigits == 11)
            return true;
        return false;
    }
}
