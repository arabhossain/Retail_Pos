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

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Loser
 */
public class CreateFile {
    File file;
    
    CreateFile(String DestinationURLwithName){
        file=new File(DestinationURLwithName);
        create();
    }
    CreateFile(String DestinationFolderURL, String FileName){
        file=new File(DestinationFolderURL+"/"+FileName);
        create();
    }
    private boolean create(){
       
        if(!file.exists()){
            try {
                file.createNewFile();
                System.out.println("File created. Location: "+file.getAbsolutePath());
                return true;
            } catch (IOException ex) {
                Logger.getLogger(CreateFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println(file.getName()+" already exists"); 
        }
        return false;
    }
}
