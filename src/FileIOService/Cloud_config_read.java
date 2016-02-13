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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Loser
 */
public class Cloud_config_read {

    /**
     *
     */
    public Cloud_config_read(){
          try {

	File fXmlFile = new File("./Configs/Cloudconfig.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	      org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);
			
	doc.getDocumentElement().normalize();

	//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
	NodeList nList = doc.getElementsByTagName("Driver");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
				
	//	System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			vars.setCloudIP(Arab.Arab3SH.De_Code(eElement.getElementsByTagName("CloudIP").item(0).getTextContent()));
			vars.setCloudPort(Arab.Arab3SH.De_Code(eElement.getElementsByTagName("CloudPort").item(0).getTextContent()));
			vars.setCloudDatabaseName(Arab.Arab3SH.De_Code(eElement.getElementsByTagName("DB_Name").item(0).getTextContent()));
                        vars.setCloudUser(Arab.Arab3SH.De_Code(eElement.getElementsByTagName("DB_User").item(0).getTextContent()));
                        vars.setCloudPass(Arab.Arab3SH.De_Code(eElement.getElementsByTagName("DB_Password").item(0).getTextContent()));

		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
    
}
