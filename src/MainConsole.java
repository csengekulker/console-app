import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MainConsole {
  ArrayList<Employee> empList;
  ArrayList<Employee> masikList;

  public MainConsole() throws FileNotFoundException, UnsupportedEncodingException {
    empList = new ArrayList<>();
    masikList = new ArrayList<>();

    readFile();
    feladat02();
    feladat03();
  }
  
  public void readFile() throws FileNotFoundException {
    System.out.println("Feladat 01");
    File file = new File("dolgozok.csv");
    Scanner sc = new Scanner(file, "UTF-8");

    while (sc.hasNext()) {
      String line = sc.nextLine();

      String[] lineArray = line.split(",");

      Employee emp = new Employee(
        Integer.parseInt(lineArray[0]), 
        lineArray[1], 
        lineArray[2], 
        Double.parseDouble(lineArray[3]), 
        LocalDate.parse(lineArray[4])
        );

        empList.add(emp);
    }

    sc.close();
  }

  public void feladat02() {
    System.out.println("Feladat 02");

    for ( Employee emp : empList) {
      if (emp.birth.getYear() < 2001) {
        masikList.add(emp);
      }
    }
  }

  public void feladat03() throws FileNotFoundException, UnsupportedEncodingException {
    System.out.println("Feladat 03");
    PrintWriter pw = new PrintWriter("koraiak.csv", "UTF-8");
    
    for ( Employee emp : masikList ) {
      pw.append(emp.id.toString());
      pw.append(',');
      pw.append(emp.name);
      pw.append(',');
      pw.append(emp.city);
      pw.append(',');
      pw.append(emp.salary.toString());
      pw.append(',');
      pw.append(emp.birth.toString());
      pw.println();
    }
    pw.close();
  }
} 
