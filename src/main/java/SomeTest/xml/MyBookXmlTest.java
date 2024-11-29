package SomeTest.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MyBookXmlTest {
    public static void main(String[] args) {
        //获得解析器工厂
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            //获取解析器实例
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //解析xml文件获得Document对象
            Document doc = dBuilder.parse("Phone.xml");
            doc.getDocumentElement().normalize(); // 规范化文档结构
            //添加元素
            Element brand = doc.createElement("Brand");
            brand.setAttribute("name", "三星");
            Element type = doc.createElement("Type");
            type.setAttribute("name", "Note2");
            brand.appendChild(type);
            doc.getElementsByTagName("PhoneInfo").item(0).appendChild(brand);

            //获取元素
            NodeList elementsByTagName = doc.getElementsByTagName("Brand");
            System.out.println(elementsByTagName.getLength());
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                Node node = elementsByTagName.item(i);
                Element element = (Element) node;
                String name = element.getAttribute("name");
                System.out.println(name);
                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node item = childNodes.item(j);
                    if (item.getNodeType() == Element.ELEMENT_NODE) {
                        Element element1 = (Element) item;
                        System.out.println(element1.getAttribute("name"));
                    }
                }
            }

            //修改元素
            NodeList nodeList = doc.getElementsByTagName("Brand");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node item = nodeList.item(i);
                Element element = (Element) item;
                element.setAttribute("id", i + "");
            }

            //保存
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            //设置缩进
            transformerFactory.setAttribute("indent-number", 4);
            try {
                //转换器
                Transformer transformer = transformerFactory.newTransformer();
                //指定转换格式
                transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
                transformer.setOutputProperty(OutputKeys.INDENT, "YES");
                DOMSource domSource = new DOMSource(doc);
                OutputStream outputStream = new FileOutputStream("message.xml");
                StreamResult result = new StreamResult(new OutputStreamWriter(outputStream, "utf-8"));
                transformer.transform(domSource, result);
            } catch (TransformerException e) {
                e.printStackTrace();
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        System.out.println(9500 * 6);
    }
}
