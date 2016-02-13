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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 *
 * @author Loser
 */
public class Cloud_DB_ConfigCreate {

    /**
     *
     */
    public Cloud_DB_ConfigCreate(){
       try{
         new Delete("./Configs/Cloudconfig.xml");
       }catch(Exception e){
           e.printStackTrace();
       }
   }

    /**
     *
     */
    public void db_data(){
        try {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("Cloud_Database");
		doc.appendChild(rootElement);

		// staff elements
		Element staff = doc.createElement("Driver");
		rootElement.appendChild(staff);

		// set attribute to staff element
		Attr attr = doc.createAttribute("Connection");
		attr.setValue("MySql");
		staff.setAttributeNode(attr);

		// shorten way
		// staff.setAttribute("id", "1");

		// elements
                   
                    
                    Element cloudIp = doc.createElement("CloudIP");
                    cloudIp.appendChild(doc.createTextNode(Arab.Arab3SH.En_Code(vars.getCloudIP())));
                    staff.appendChild(cloudIp);
                    
                     Element cloudport = doc.createElement("CloudPort");
                    cloudport.appendChild(doc.createTextNode(Arab.Arab3SH.En_Code(vars.getCloudPort())));
                    staff.appendChild(cloudport);
                    
                    // elements
                    Element dbname = doc.createElement("DB_Name");
                    dbname.appendChild(doc.createTextNode(Arab.Arab3SH.En_Code(vars.getCloudDatabaseName())));
                    staff.appendChild(dbname);

                    Element user = doc.createElement("DB_User");
                    user.appendChild(doc.createTextNode(Arab.Arab3SH.En_Code(vars.getCloudUser())));
                    staff.appendChild(user);

                    // elements
                    Element pass = doc.createElement("DB_Password");
                    pass.appendChild(doc.createTextNode(Arab.Arab3SH.En_Code(vars.getCloudPass())));
                    staff.appendChild(pass);

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("./Configs/Cloudconfig.xml"));

		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");

	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
    }
}

