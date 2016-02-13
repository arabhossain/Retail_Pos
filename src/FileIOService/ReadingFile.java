/*
    Software Engineer
    ---------------------------------------
    Md. Arab Hossain
    Email: arabhossain317@diu.edu.bd
           green.arab1995@gmail.com
    Mobile: +8801827-464330
            +8801737-331037
    Daffodil International University(Student)
 */
package FileIOService;

import AppConfig.vars;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Loser
 */
public class ReadingFile {
    ReadingFile(String FileName){
        vars.setFileName(FileName);
        read();
    }
    ReadingFile(String FileName, String FileUrl){
        vars.setDIR_URL(FileUrl);
        vars.setFileName(FileName);
        read();
    }
  private void read(){
    System.out.println("Reading File from"+vars.getDIR_URL()+vars.getFileName());
    //Name of the file
    String rt = null;
    try{
        //Create object of FileReader
        FileReader inputFile = new FileReader(vars.getDIR_URL()+vars.getFileName());
        BufferedReader bufferReader = new BufferedReader(inputFile);
        String line;
        // Read file line by line and print on the console
        while ((line = bufferReader.readLine()) != null)   {
                rt = line;
        }
        //Close the buffer reader
        bufferReader.close();
    }catch(IOException e){
            System.out.println("Error while reading file line by line:" 
            + e.getMessage());                      
    }
    vars.setContent(rt);
 }
   
}
