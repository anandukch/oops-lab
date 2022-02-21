
import java.io.*;

class FileClass {
  public void create(String filname) {
    try {
      File myObj = new File("filename.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
  }

  public void write(String filename,String content) {
    try {
      FileWriter fw = new FileWriter(filename);
      fw.write(content);
      fw.close();
    } catch (Exception e) {
      System.out.println("Error");
    }
  }

  public void read(String file) {
    try {
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
      br.close();

    } catch (IOException e) {
      System.out.println(e);
    }
  }
  public void copy(String file1,String file2) {
    try {
      FileReader fr = new FileReader(file1);
      FileWriter fw=new FileWriter(file2);
      int c;  
      while ((c = fr.read()) != -1) {  
       fw.write(c);  
      }  
      System.out.println("Copy finish...");
      fr.close();
      fw.close();
    } catch (IOException e) {
    }
  }

}

class FileDemo {
  public static void main(String[] args) {
    FileClass fc = new FileClass();
    fc.create("filename.txt");
    fc.write("filename.txt","This is second test");
    fc.copy("filename.txt", "filename2.txt");
    fc.read("filename2.txt");

  }
}