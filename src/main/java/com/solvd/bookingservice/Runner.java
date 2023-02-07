package com.solvd.bookingservice;


import com.solvd.bookingservice.bookingservices.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Runner {
    private static Logger logger = LogManager.getLogger(Runner.class.getName());
    public static void main(String[] args) throws FileNotFoundException, JAXBException {
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
            logger.error("Exception caught");
        }

        Account account = new Account();
        account.setAccountID(1);
        account.setUsername("eric_liu");
        account.setPassword("liu123");
        account.setOrganisationID(123);
        account.setRegistrationDate(new Date());

        try {
            JAXBContext context = JAXBContext.newInstance(Account.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(account, new File("Account.xml"));

            Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
            Account accounts = (Account) jaxbUnmarshaller.unmarshal(new File("Account.xml"));

            System.out.println("Account ID: " + accounts.getAccountID());
            System.out.println("Username: " + accounts.getUsername());
            System.out.println("Password: " + accounts.getPassword());
            System.out.println("Organisation ID: " + accounts.getOrganisationID());
        } catch (JAXBException e) {
            logger.error("JAXB Exception");
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            Account accountJackson = mapper.readValue(new File("Account.json"), Account.class);
            logger.info(String.valueOf(accountJackson.getAccountID()));
        } catch (IOException e) {
            logger.error("Exception caught");
        }
    }
}