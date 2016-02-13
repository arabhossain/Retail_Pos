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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author Loser
 */
public class WriteFile {

    /**
     *
     * @param FileName
     * @param Content
     */
    public WriteFile(String FileName,String Content){
       vars.setContent(Content);
       vars.setFileName(FileName);
       writefile();
}

    /**
     *
     * @param FileName
     * @param Content
     * @param FileUrl
     */
    public WriteFile(String FileName,String Content, String FileUrl){
        vars.setContent(Content);
        vars.setFileName(FileName);
        vars.setDIR_URL(FileUrl);
        writefile();
}
    private void writefile(){
   try {
 
			File file = new File(vars.getDIR_URL()+vars.getFileName());

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(vars.getContent());
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}
