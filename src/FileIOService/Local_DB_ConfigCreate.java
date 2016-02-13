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
public class Local_DB_ConfigCreate {

    /**
     *
     */
    public Local_DB_ConfigCreate(){
       try{
            new Delete("./Configs/Localconfig.xml");
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
		Element rootElement = doc.createElement("Local_Database");
		doc.appendChild(rootElement);

		// staff elements
		Element staff = doc.createElement("Driver");
		rootElement.appendChild(staff);
		Attr attr = doc.createAttribute("Connection");
		attr.setValue(vars.getDRIVER_Type());
		staff.setAttributeNode(attr);
                    Element driveer = doc.createElement("JDBC_DRIVER");
                    driveer.appendChild(doc.createTextNode(Arab.Arab3SH.En_Code(vars.getJDBC_DRIVER())));
                    staff.appendChild(driveer);
                    Element dburl = doc.createElement("DB_URL");
                    dburl.appendChild(doc.createTextNode(Arab.Arab3SH.En_Code(vars.getDB_Url())));
                    staff.appendChild(dburl);
                    Element dbname = doc.createElement("DB_Name");
                    dbname.appendChild(doc.createTextNode(Arab.Arab3SH.En_Code(vars.getDbName())));
                    staff.appendChild(dbname);
                    Element user = doc.createElement("DB_User");
                    user.appendChild(doc.createTextNode(Arab.Arab3SH.En_Code(vars.getDbUser())));
                    staff.appendChild(user);
                    Element pass = doc.createElement("DB_Password");
                    pass.appendChild(doc.createTextNode(Arab.Arab3SH.En_Code(vars.getDbPass())));
                    staff.appendChild(pass);
                
                // staff elements
		Element a = doc.createElement("Branch");
		rootElement.appendChild(a);
		Attr b = doc.createAttribute("Area");
		b.setValue("Local");
		a.setAttributeNode(b);
                    Element c = doc.createElement("Shop_Name");
                    c.appendChild(doc.createTextNode(Arab.Arab3SH.En_Code(vars.getShopName())));
                    a.appendChild(c);
                    Element d = doc.createElement("BranchId");
                    d.appendChild(doc.createTextNode(Arab.Arab3SH.En_Code(String.valueOf(vars.getBranchID()))));
                    a.appendChild(d);
                    Element e = doc.createElement("MoneySymble");
                    e.appendChild(doc.createTextNode(Arab.Arab3SH.En_Code(vars.getMoneySymble())));
                    a.appendChild(e);
                    
                    

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("./Configs/Localconfig.xml"));

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

