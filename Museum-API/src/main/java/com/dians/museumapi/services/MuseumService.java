package com.dians.museumapi.services;

import com.dians.museumapi.models.Museum;
import com.dians.museumapi.repositories.MuseumRepo;
import com.dians.museumapi.services.XMLparsing.ParsingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MuseumService {
    @Autowired
    private MuseumRepo museumRepo;

    public void parseFiles() {
        File folder = new File("Museum-API\\src\\main\\resources\\xmlfiles");
        int countMuseums = folder.list().length;
        if (museumRepo.findAll().size() < countMuseums){
        for (int j = 1; j <= 47; j++){
            try {
                File xmlFile = new File("Museum-API\\src\\main\\resources\\xmlfiles\\museum"+ j +".xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(xmlFile);
                doc.getDocumentElement().normalize();
                NodeList nodeList = doc.getElementsByTagName("tag");
                Museum m = new Museum();
                ParsingContext parsingContext = new ParsingContext();
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        String key = element.getAttribute("k");
                        String value = element.getAttribute("v");
                        //
                        parsingContext.parse(key,value,m);
                    }
                }
                if(museumRepo.findByMuseumName(m.getMuseumName()).isEmpty()){
                    museumRepo.save(m);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        }
    }

    public List<Museum> searchMuseumsByName(String searchTerm) {
        Optional<List<Museum>> optionalMuseums = museumRepo.findByMuseumNameContainingIgnoreCase(searchTerm);
        return optionalMuseums.orElse(Collections.emptyList());
    }

    public Museum findMuseumById(Long museumId) {
        return museumRepo.findById(museumId).orElseThrow();
    }

    public List<Museum> findAll(){
        return museumRepo.findAll();
    }

}
