package SomeTest.xml4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;

public class MyDom4jTest {
    private Document document;

    public  void  loadDocument(){
        SAXReader saxReader = new SAXReader();
        try {
          document = saxReader.read(new File("message.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void  showPhoneInfo(){
        Element rootElement = document.getRootElement();
        Iterator<Element> elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()){
            Element next = elementIterator.next();
            System.out.println(next.attributeValue("name"));
            Iterator<Element> elementIterator1 = next.elementIterator();
            while (elementIterator1.hasNext()){
                System.out.println(elementIterator1.next().attributeValue("name"));
            }
        }
    }

    public void addNewPhone() throws IOException {
        Element rootElement = document.getRootElement();
        Element brand = rootElement.addElement("Brand");
        brand.addAttribute("name","小米");
        Element type = brand.addElement("Type");
        type.addAttribute("name","redMi");
        saveXml("newInfo.xml");
    }

    public void saveXml(String path) throws IOException {
        OutputFormat prettyPrint = OutputFormat.createPrettyPrint();
        prettyPrint.setEncoding("UTF-8");
        XMLWriter xmlWriter = new XMLWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"));
        xmlWriter.write(document);
        xmlWriter.close();

    }

    public static void main(String[] args) throws IOException {
        MyDom4jTest myDom4jTest = new MyDom4jTest();
        myDom4jTest.loadDocument();
        myDom4jTest.addNewPhone();
        myDom4jTest.showPhoneInfo();
    }
}
