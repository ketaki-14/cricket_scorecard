import java.io.IOException;
import java.io.InputStream; 
import java.net.URL; 
import net.sf.json.JSON; 
import net.sf.json.xml.XMLSerializer; 
import org.apache.commons.io.IOUtils; 
import org.json.XML;

public class XMLtoJsonConvertor 
{ 
    private URL url = null; 
    private InputStream inputStream = null;     
    public void getXMLfromJson() 
    { 
        try
        { 
            url = XMLtoJsonConvertor.class.getClassLoader().getResource("cricket_scorecard.xml"); 
         
            InputStream inputStream = url.openStream(); 
            String xml = IOUtils.toString(inputStream); 
            org.json.JSONObject objJson = XML.toJSONObject(xml);
            System.out.println("JSON data : " + objJson);
            
        }
        catch(Exception e)
        { 
            e.printStackTrace(); 
        }
        finally
        { 
        	try 
        	{ 
                if (inputStream != null) 
                { 
                    inputStream.close(); 
                } 
                url = null; 
            } 
        	catch (IOException ex) {} 
        } 
    } 
    
    public static void main(String[] args) 
    { 
        new XMLtoJsonConvertor().getXMLfromJson(); 
    } 
    
}