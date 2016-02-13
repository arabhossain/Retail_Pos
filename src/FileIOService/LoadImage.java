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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javafx.scene.image.Image;

/**
 *
 * @author Loser
 */
public class LoadImage {
    private static InputStream inStream=null;
    private static OutputStream outStram=null;

    /**
     *  Image will load from the system <code> src</code> dir . just put the image name with extension. No need to input dir name!
     * @param Image_Name
     * @return
     */
    public static Image from_images(String Image_Name) {
        return new Image("/images/" + Image_Name);
    }
    
    //File SourceFile;
    File DestinationFile = null;
    
    /**
     *
     * @param url
     * @return
     */
    public static Image getImage(String url){
        return new Image(new File(url).toURI().toString());
    }
    
    /**
     *
     * @param SourceImageURL
     * @param LocationURL
     * @return
     */
    public static boolean SavedImage(String SourceImageURL,String LocationURL){
         File SourceFile=new File(SourceImageURL);
         File DestationFile=new File(LocationURL);
        try{
        inStream=new FileInputStream(SourceFile);
               outStram=new FileOutputStream(DestationFile);
               byte[] buffer=new byte[3072];
               int lenth;
               while((lenth=inStream.read(buffer))>0){
                   outStram.write(buffer,0,lenth);
               }

               if(inStream!=null)inStream.close();
               if(outStram!=null)outStram.close();
               return true;
        }catch(Exception evt){
             evt.printStackTrace();
             return false;
        }
    }
}
