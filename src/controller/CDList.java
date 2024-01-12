/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import model.CD;

/**
 *
 * @author lenovo
 */
public class CDList {
    private ArrayList<CD> list;
    private  int maxList = 3;
    private int cdCounter = 0;


    public CDList() {
        list=new ArrayList();readFile("CD.txt");
        this.cdCounter = list.size();
    }
    Scanner sc=new Scanner(System.in);
    public ArrayList<CD> getList() {
        return list;
    }

    public void setList(ArrayList<CD> list) {
        this.list = list;
    }

    public int getCdCounter() {
        return cdCounter;
    }

    public void setCdCounter(int cdCounter) {
        this.cdCounter = cdCounter;
    }
    private String[] N = {"Game","Movie","Music"};
    private String[] T = {"Audio","Video"};    
// checkk
    public boolean checkList() {
        return cdCounter < maxList;
    }
    // ================================================================================================
    public boolean checkExist(String cId) {
        for (CD cd : list) {
            if (cd.getId().equalsIgnoreCase(cId))
                return true;
        }
        return false;
    }  
    // ================================================================================================
    public boolean checkInput(String s, String[] sList) {
        for (String string : sList) {
            if (string.equalsIgnoreCase(s.trim())) return true;
        }
        return false;
    }
   public CD returnCd(String cdID) {
        CD p = new CD();
        for (CD cd : list) {
            if (cd.getId().equalsIgnoreCase(cdID))
                p = cd;
        }
        return p;
    }
//add
    public void inputCD() {
        String id = "", name = "", type = "", title = "", uPrice = "", pYear = "";
        double price = 0;
        int year = 0;
        CD cd;
        
        if (!checkList()) {
            System.out.println("Unable to add CD");
            return;
        }
        
        do {
            try {
                System.out.println("Enter CD ID :");
                id = sc.nextLine();
                if (checkExist(id) || id.isEmpty() )
                    throw new Exception();
            } catch (Exception e) {
                System.out.println("Invalid! Enter ID again");
            }
        } while (checkExist(id) || id.isEmpty() );
        
        do {
            try {
                System.out.println("Enter CD collection name (game/movie/music):");
                name = sc.nextLine();
                if (!checkInput(name, N) || name.isEmpty()) 
                    throw new Exception();
            } catch (Exception ex) {
                System.out.println("Error");
            }
        } while (!checkInput(name, N) || name.isEmpty());
        
        do {
            try {
                System.out.println("Enter CD type (audio/video):");
                type = sc.nextLine();
                if (!checkInput(type, T) || type.isEmpty()) 
                    throw new Exception();
            } catch (Exception ex) {
                System.out.println("Error");
            }
        } while (!checkInput(type, T) || type.isEmpty());
        
        do {
            try {
                System.out.println("Enter CD title:");
                title = sc.nextLine();
                if ( title.isEmpty()) 
                    throw new Exception();
            } catch (Exception ex) {
                System.out.println("Error");
            }
        } while (title.isEmpty());
        
        do {
            try {
                System.out.println("Enter CD unit price :");
                uPrice = sc.nextLine();
                price = Double.parseDouble(uPrice);
                if (price < 0 )
                    throw new Exception();
            } catch (Exception ex) {
                System.out.println("Error");
            }
        } while (price < 0 || uPrice.isEmpty());
        
        do {
            try {
                System.out.println("Enter CD year publish :");
                pYear = sc.nextLine();
                year = Integer.parseInt(pYear);
                if (year < 1900||year>2023 )
                    throw new Exception();
            } catch (Exception ex) {
                System.out.println("Error,year should be run from 1990 to now(2023)");
            }
        } while (year <1990  || year>2023||pYear.isEmpty());
        
        
        cd = new CD(id, name, type, title, price, year);
        addCD(cd);
        
        System.out.println("Create Successfully !");
    }    
    public void addCD(CD cd) {
        list.add(cd);
        cdCounter++;
    }
//search
    public void SearchByTitle(){
        System.out.println("Enter CD title: ");
        String aN=sc.nextLine();
        this.list.stream().filter(a -> a.getTitle().contains(aN)).forEach(a ->System.out.println(a.toString()));
    }
//update
    public void inputToUpdate() {
        System.out.println("Enter CD ID to update");
        String id = sc.nextLine();
        CD cd;
        if (checkExist(id)==false) {
            System.out.println("CD does not exist !");
            System.out.println("Update failed !");
        } else {
            System.out.println(returnCd(id));
            
            String cName = "", nPrice = "", nYear = "", type = "", nTitle = "";
            double price = 0;
            int year = 0;
            do {
                try {
                    System.out.println("Enter CD collection name (game/movie/music):");
                    cName = sc.nextLine();
                    if ((!cName.isEmpty()) && !checkInput(cName, N)) 
                        throw new Exception();
                } catch (Exception ex) {
                    System.out.println("Error");
                }
            } while (!cName.isEmpty() && !checkInput(cName, N));
            
            do {
                try {
                    System.out.println("Enter CD type(audio/video):");
                    type = sc.nextLine();
                    if ((!type.isEmpty()) && !checkInput(type, T)) 
                        throw new Exception();
                } catch (Exception ex) {
                    System.out.println("Error");
                }
            } while (!type.isEmpty() && !checkInput(type, T));
            
            do {
                try {
                    System.out.println("Enter CD title:");
                    nTitle = sc.nextLine();
                    if (!nTitle.isEmpty()) 
                        throw new Exception();
                } catch (Exception ex) {
                    System.out.println("");
                }
            } while (nTitle.isEmpty());
            
            do {
                try {
                    System.out.println("Enter unit price:");
                    nPrice = sc.nextLine();
                    if (!nPrice.isEmpty()) {
                        price = Double.parseDouble(nPrice);}
                        if (price < 0 )
                            throw new Exception();
                    
                } catch (Exception ex) {
                    System.out.println("Error");
                }
            } while ((price < 0 ) && !nPrice.isEmpty());

            do {
                try {
                    System.out.println("Enter CD published year:");
                    nYear = sc.nextLine();
                    if (!nYear.isEmpty()) {
                        year = Integer.parseInt(nYear);
                        if (year<1990||year>2023)
                            throw new Exception();
                    }
                } catch (Exception ex) {
                    System.out.println("Error,year should be run from 1990 to now(2023)");
                }
            } while ((year < 1990||year>2023) && !nYear.isEmpty());

            updateCD(id, cName, type, nTitle, nPrice, nYear);
            System.out.println("Update successfully !");
        }
    }
    public void printCDList() {
        Collections.sort(getList(), (CD o1, CD o2) -> {
            if (o1.getCollectionName().equalsIgnoreCase(o2.getCollectionName())) {
                return o1.getTitle().compareTo(o2.getTitle());
            } else {
                return (o1.getCollectionName().compareTo(o2.getCollectionName()));
            }
        });
        for (CD cd : getList()) {
            System.out.println(cd);
        }
    }
    public void updateCD(String id, String cName, String nType, String nTitle, String nPrice, String nYear) {
        CD c = new CD();
        CD c1 = new CD();
        for (CD cd : list) {
            if (cd.getId().equalsIgnoreCase(id)){
                c.setId(id);
                
                if (cName.isEmpty()) {
                    c.setCollectionName(cd.getCollectionName());
                } else {
                    c.setCollectionName(cName);
                }
                
                if (nType.isEmpty()) {
                    c.setType(cd.getType());
                } else {
                    c.setType(nType);
                }
                
                if (nTitle.isEmpty()) {
                    c.setTitle(cd.getTitle());
                } else {
                    c.setTitle(nTitle);
                }
                
                if (nPrice.isEmpty()) {
                    c.setUnitPrice(cd.getUnitPrice());
                } else {
                    c.setUnitPrice(Double.parseDouble(nPrice));
                }
                
                if (nYear.isEmpty()) {
                    c.setPublishYear(cd.getPublishYear());
                } else {
                    c.setPublishYear(Integer.parseInt(nYear));
                }
                
                c1 = cd;
            }
        }
        list.add(c);
        list.remove(c1);
    }
//delete
    public void deleteCD() {
        System.out.println("Enter CD ID to delete");
        String id = sc.nextLine();
        if (checkExist(id)) {
            System.out.println("CD does not exist !");
            System.out.println("Delete failed !");
        } else {
            removeCd(id);
            System.out.println("Delete successfully !");
        }
    }
   public void removeCd(String cdID) {
        CD cd = this.returnCd(cdID);
        list.remove(cd);
        
        cdCounter--;
    }
//save to file
   public void save(String fName){
        
        try {
            PrintWriter pw=new PrintWriter(new FileWriter(fName));
            for( CD c:list)
                 pw.println(c.getId()+"_"+c.getCollectionName()+"_"+c.getType()+"_"+c.getTitle()+"_"+c.getUnitPrice()+"_"+c.getPublishYear());
            pw.close();
        System.out.println("Save to file successfully !");
        } catch (Exception e) {
            System.out.println("error");
        }
     }    
//print from file
     public ArrayList<CD> readFile(String fName) {
         
        ArrayList<CD> arr = new ArrayList<>();
        FileInputStream fileInputStream = null;
       try {
            fileInputStream = new FileInputStream(fName);
        } catch (FileNotFoundException ex) {  
        }
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] s = line.split("_");
            CD cd = new CD(s[0], s[1], s[2], s[3],Double.parseDouble(s[4]), Integer.parseInt(s[5]));
            arr.add(cd);
        }
        try {
            scanner.close();
            fileInputStream.close();
        } catch (Exception ex) {
        }
        return arr;
    }
   public void printListFromFile() {
        for (CD cd :readFile("CD.txt")) {
            System.out.println(cd);
        }
    }

}
