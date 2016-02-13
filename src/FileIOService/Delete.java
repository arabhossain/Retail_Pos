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
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Loser
 */
public class Delete {

    /**
     *
     * @param File_Name
     */
    public Delete(String File_Name){
       try{
        File file = new File(vars.getDIR_URL()+File_Name);
        file.delete();
       }catch(Exception e){
           
       }
   } 

    /**
     *
     * @param File_URL
     * @param Null
     * @param Nulle
     */
    public Delete(String File_URL, String Null,String Nulle){
      try{
       File file = new File(File_URL);
       file.delete();
        }catch(Exception e){
           
       }
   }

    /**
     *
     * @param File_Name
     * @param File_URL
     */
    public Delete(String File_Name, String File_URL){
      try{
       File file = new File(File_URL+File_Name);
       file.delete();
        }catch(Exception e){
           
       }
   }
}
