package com.dians.museumapi.repositories;

import com.dians.museumapi.models.Museum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class XmlToDatabase {
    @Autowired
    private MuseumRepo museumRepo;

//    public boolean correctValue(String key){
//        return key.equals("name:en") || key.equals("addr:city:en") || key.equals("addr:street") || key.equals("email") || key.equals("opening_hours")
//                || key.equals("phone") || key.equals("website");
//    }
    public void parseFiles() {
        for (int j = 1; j <= 47; j++){
            try {
                File xmlFile = new File("Museum-API\\src\\main\\resources\\xmlfiles\\museum"+ j +".xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(xmlFile);
                doc.getDocumentElement().normalize();
                NodeList nodeList = doc.getElementsByTagName("tag");
                String museumName = null;
                String city = null;
                String address = null;
                String email = null;
                String workingHours = null;
                String phone = null;
                String website = null;
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        String key = element.getAttribute("k");
                        String value = element.getAttribute("v");

//                    if (correctValue(key)) {
//                        System.out.println(value);
//                    }

                        if (key.equals("name:en") || key.equals("name")){
                            museumName = value;
                        }
                        else if (key.equals("addr:city:en")){
                            city = value;
                        }
                        else if (key.equals("addr:street")){
                            address = value;
                        }
                        else if (key.equals("email")){
                            email = value;
                        }
                        else if (key.equals("opening_hours")){
                            workingHours = value;
                        }
                        else if (key.equals("phone")){
                            phone = value;
                        }
                        else if (key.equals("website")){
                            website = value;
                        }
                    }
                }
                Museum m = new Museum(museumName, city, address, email, workingHours, phone, website, "");
                if(museumRepo.findByMuseumName(m.getMuseumName()).isEmpty()){
                    museumRepo.save(m);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
