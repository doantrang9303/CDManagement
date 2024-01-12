
package view;

import controller.CDList;
import java.util.Scanner;
import model.CD;

/**
 *
 * @author lenovo
 */
public class CDManagement extends Menu{
    static String[] mc={"Add CD to the catalog", "Search CD by CD title", "Display the catalog", 
                        "Update CD", "Save the account to file", "Print list CDs from the file", "Quit"};

    private CDList cl=new CDList();
    private CD c=new CD();
    Scanner sc=new Scanner (System.in);
    public CDManagement() {
    super("CD House Management",mc); 
    
    
    }
    public static void main(String []args){
        CDManagement cm =new CDManagement();
         cm.run();
    }
    
    @Override
    public void execute(int n) {
        switch(n){
            case 1: cl.inputCD(); break;
            case 2:  cl.SearchByTitle();break;
            case 3:  cl.printCDList();break;
            case 4:  updating();break;
            case 5:  cl.save("CD.txt");break;
                    
            case 6: cl.printListFromFile();break;
            case 7:  System.exit(0);
        }        
  
    }
   private void updating(){
        String[] ms = {"Update CD information", "Delete CD information"};
        new Menu("Update CD",ms){
            @Override
            public void execute(int n) {
            switch(n){
                case 1: 
                    cl.inputToUpdate();
                    break;
                case 2:
                    cl.deleteCD();
                    break;
                
                }
            }
        }.run();
    }
    
}
