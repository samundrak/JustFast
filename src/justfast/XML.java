package justfast;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML {
    private String xml;
    private static String[] nodes;
    public HashMap<String, String> info;
    public XML() {
      String[] n = {"local-file","ftp-host","ftp-port","speed","ftp-dir","username","password"};
      nodes = n;
      info = new HashMap<>();
      xml = System.getProperty("java.io.tmpdir")+"info.xml";
      fileChecker();
     
     
     
    }
 
    private void fileChecker(){
               if(!new File(xml).exists()){
               write(new String[]{"c:/","192.168.1.1","8888","1024","mnt","username","password"});
               fileChecker(); 
              }
           
    }
     public void read(){
        try {
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = factory.newDocumentBuilder();
            Document doc = db.parse(new File(xml));
            
            NodeList nl = doc.getElementsByTagName("justfast");
            Node node = nl.item(0);
            
            Element justFast = (Element) nl.item(0);
            
            for(int i = 0; i < nodes.length; i++){
            NodeList tempLst = justFast.getElementsByTagName(nodes[i]);
            Node localfile = tempLst.item(0);
            NodeList nn = localfile.getChildNodes();
            String val = nn.item(0).getNodeValue();
            info.put(nodes[i], val);
            }
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
    public void write(String[] info){
        Transformer tf;
        tf = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            
            Element rootElement =doc.createElement("justfast");
            doc.appendChild(rootElement);
            
            for(int i =0; i < nodes.length; i++){
                Element el = doc.createElement(nodes[i]);
                rootElement.appendChild(el);
                if(info[i].isEmpty()){
                 info[i] = " ";
                }
                el.appendChild(doc.createTextNode(info[i]));
            }
            
            TransformerFactory tff = TransformerFactory.newInstance();
            tf = tff.newTransformer();
            DOMSource dom = new DOMSource(doc);
            StreamResult sr = new StreamResult(new File(xml));
            tf.transform(dom, sr);
            
        } catch (TransformerException | ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
