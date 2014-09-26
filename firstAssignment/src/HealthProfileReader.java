import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;


public class HealthProfileReader {

    ArrayList<Person> _people;
    Document _doc;
    XPath _xpath;

    public HealthProfileReader()
    {
        _people = new ArrayList<Person>();
    }
    public HealthProfileReader(String dbUrl) {

        _people = new ArrayList<Person>();
        initializeDatabase(dbUrl);

    }
    public void initializeDatabase(String dbUrl){

        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            _doc = builder.parse(dbUrl);
            XPathFactory xPathfactory = XPathFactory.newInstance();
            _xpath = xPathfactory.newXPath();
        }
        catch (ParserConfigurationException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());

        }
        catch (SAXException ex)
        {
            System.out.println(ex.getMessage());

        }
    }
    public void loadDB() throws NullPointerException{

        if(_xpath == null)
            throw new NullPointerException("XPath still need to be instanciated.");

        try
        {
            XPathExpression expr = _xpath.compile("//person/child::firstname/text()");

            String fName = (String) expr.evaluate(_doc, XPathConstants.STRING);


            System.out.println("Db loaded successfully");

        }
        catch (XPathExpressionException ex)
        {
            System.out.println(ex.getMessage());

        }
    }
    private HealthProfile createHealthProfile(NodeList elements){
        return null;
    }
    public void addPerson(Person p){
        this._people.add(p);
        System.out.println(p.toString());
    }

	


}