package com.virtusa.xmlparser;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.stream.*;

public class XmlParser {

    public static void main(String argv[]) throws Exception {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        InputStream in = new FileInputStream("./src/cvsfile/person.xml");
        XMLStreamReader streamReader = inputFactory.createXMLStreamReader(in);
        int persons = 0;
        while (streamReader.hasNext()) {
            if (streamReader.isStartElement()) {
                switch (streamReader.getLocalName()) {
                case "first_name": {
                    System.out.print("First Name : ");
                    System.out.println(streamReader.getElementText());
                    break;
                }
                case "last_name": {
                    System.out.print("Last Name : ");
                    System.out.println(streamReader.getElementText());
                    break;
                }
                case "age": {
                    System.out.print("Age : ");
                    System.out.println(streamReader.getElementText());
                    break;
                }
                case "line_1": {
                    System.out.print("line_1 : ");
                    System.out.println(streamReader.getElementText());
                    break;
                }
                case "line_2": {
                    System.out.print("line_2 : ");
                    System.out.println(streamReader.getElementText());
                    break;
                }
                case "line_3": {
                    System.out.print("line_3 : ");
                    System.out.println(streamReader.getElementText());
                    break;
                }
                case "person" : {
                	try {
                	 System.out.println(streamReader.getElementText());
                	}catch(XMLStreamException e){
                		System.out.println("");
                	}
                    persons ++;
                }
                }
            }
            streamReader.next();
        }
        System.out.print(persons);
        System.out.println(" persons");
    }

}
