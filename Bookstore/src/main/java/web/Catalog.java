package web;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import jakarta.servlet.ServletContext;


public class Catalog {
	
	private SAXBuilder builder;
//	private String rootPath;
	private String xmlFilePath;
	private URL xmlURL;
	private File xmlFile;
	private Document jdomXMLDoc;
	private Element rootElement;
	private List<Element> listBooksElements;
	
	public Catalog() {
		
		this.builder = new SAXBuilder();
		
		this.xmlFilePath = "http://localhost:8080/Bookstore/catalog.xml";
		
		try {
			
			this.xmlURL = new URL(this.xmlFilePath);
			this.xmlFile = new File("catalog.xml");
			FileUtils.copyURLToFile(xmlURL, xmlFile);
			this.jdomXMLDoc = this.builder.build(xmlFile);
			this.rootElement = jdomXMLDoc.getRootElement();
			this.listBooksElements = rootElement.getChildren("book");	

		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void printAllBooks() {
		System.out.println(this.listBooksElements.toString());
	}
	public void printHowManyBooks() {
		System.out.println(this.listBooksElements.size() + " livres dans le catalogue");
	}
	
	public void addBook(HashMap<String, String> newBookData) {
		
		System.out.println("Avant l'ajout :");
		this.printHowManyBooks();
		
//		System.out.println("Nouveau livre ! : " + newBookData.toString() );
		
		
		
		Element newBook = new Element("book");
		newBook.setAttribute("author", newBookData.get("author"));
		newBook.setAttribute("title", newBookData.get("title"));
		newBook.setAttribute("genre", newBookData.get("genre"));
		newBook.setAttribute("price", newBookData.get("price"));
		newBook.setAttribute("publish_date", newBookData.get("publish_date"));
		newBook.setAttribute("cover", newBookData.get("coverBytesString"));
		newBook.setAttribute("description", newBookData.get("description"));
		
		this.rootElement.addContent(newBook);
		
		try {			
			this.saveCatalogXMLFile();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Après l'ajout :");
		this.printHowManyBooks();
	}
	
	public void saveCatalogXMLFile() {
		XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
//		try {
//			this.xmlURL = new URL(this.xmlFilePath);
//			
//		} catch (MalformedURLException e1) {
//			e1.printStackTrace();
//			
//		}
//		this.xmlFile = new File("catalog.xml");
//		try {
//			FileUtils.copyURLToFile(xmlURL, xmlFile);
//
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}

		try {
			String xmlFilePath = System.getProperty("catalina.base") + "/webapps/Bookstore/catalog.xml";
			System.out.println(xmlFilePath);
			outputter.output(this.jdomXMLDoc, new FileOutputStream(xmlFilePath));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	
	
	
	
	
	

	
}
