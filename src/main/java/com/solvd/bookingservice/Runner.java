package com.solvd.bookingservice;


import com.solvd.bookingservice.bookingservices.Account;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Runner {
    static Logger logger = Logger.getLogger(Runner.class.getName());
    public static void main(String[] args) throws FileNotFoundException {
        //Parse using DOM
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document d = builder.parse("Account.xml");
            Node node = d.getElementsByTagName("Account").item(0);
            logger.info("Account ID: " + node.getAttributes().getNamedItem("accountID").getTextContent());
            logger.info("Username: " + node.getAttributes().getNamedItem("username").getTextContent());
            logger.info("Password: " + node.getAttributes().getNamedItem("password").getTextContent());
            logger.info("Organisation ID: " + node.getAttributes().getNamedItem("organisationID").getTextContent());
        } catch (Exception e) {
            logger.info("Exception caught");
        }

        Account account = new Account();
        account.setAccountID(1);
        account.setUsername("eric_liu");
        account.setPassword("liu123");
        account.setOrganisationID(123);
        account.setRegistrationDate(new Date());

        JAXBContext context = JAXBContext.newInstance(Account.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(account, new File("Account.xml"));
        marshaller.unmarshal(new FileReader("Account.xml"));

        ObjectMapper mapper = new ObjectMapper();
        try {
            Account accountJackson = mapper.readValue(new File("Account.json"), Account.class);
            logger.info(accountJackson.getName());
        } catch (IOException e) {
            logger.info("Exception caught");
        }
    }
    }
}