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
public class Local_config_read {

    /**
     *
     */
    public Local_config_read(){
          try {

	File fXmlFile = new File("./Configs/Localconfig.xml");
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

			vars.setDRIVER_Type(eElement.getAttribute("Connection"));
			vars.setJDBC_DRIVER(Arab.Arab3SH.De_Code(eElement.getElementsByTagName("JDBC_DRIVER").item(0).getTextContent()));
			vars.setDB_Url(Arab.Arab3SH.De_Code(eElement.getElementsByTagName("DB_URL").item(0).getTextContent()));
			vars.setDbName(Arab.Arab3SH.De_Code(eElement.getElementsByTagName("DB_Name").item(0).getTextContent()));
			vars.setDbUser(Arab.Arab3SH.De_Code(eElement.getElementsByTagName("DB_User").item(0).getTextContent()));
                        vars.setDbPass(Arab.Arab3SH.De_Code(eElement.getElementsByTagName("DB_Password").item(0).getTextContent()));

		}
	}
        //Read 
        nList = doc.getElementsByTagName("Branch");

	for (int temp = 0; temp < nList.getLength(); temp++) {
		Node nNode = nList.item(temp);		
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			vars.setShopName(Arab.Arab3SH.De_Code(eElement.getElementsByTagName("Shop_Name").item(0).getTextContent()));
			vars.setBranchID(Integer.parseInt(Arab.Arab3SH.De_Code(eElement.getElementsByTagName("BranchId").item(0).getTextContent())));
			vars.setMoneySymble(Arab.Arab3SH.De_Code(eElement.getElementsByTagName("MoneySymble").item(0).getTextContent()));
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
    
}
