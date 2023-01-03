package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.apache.tomcat.util.codec.binary.Base64;
import org.w3c.dom.NodeList;





@WebServlet(name = "NewBookInCatalogueServletJSP", urlPatterns = {"/NewBookInCatalogueServletJSP"})
@MultipartConfig(
			fileSizeThreshold = 1024 * 1024 * 1,
			maxFileSize = 1024 * 1024 * 10,
			maxRequestSize = 1024 * 1024 * 100
		)

public class NewBookInCatalogueServletJSP extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NewBookInCatalogueServletJSP() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Pour ajouter un livre à la base de données, aller à : ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<String, String> newBookData = new HashMap<String, String>();
		
		// IMAGE : PREMIERE DE COUVERTURE
		Part imageFilePart = request.getPart("imageFile");
	    InputStream imageFileContent = imageFilePart.getInputStream();
	    byte[] imageBytes = new byte[imageFileContent.available()];
	    imageFileContent.read(imageBytes, 0, imageBytes.length);
	    imageFileContent.close();
	    String imageString = Base64.encodeBase64String(imageBytes);
	    
	    //stores file src information in a new attribute that can be used in JSP file
	    request.setAttribute("cover", imageString);
	    
	    // TEXTAREA : DESCRIPTION
	    StringBuffer descriptionBuffer= new StringBuffer(request.getParameter("description"));
	    String descriptionString = descriptionBuffer.toString();
	    
	    request.setAttribute("description", descriptionString);
	    
	    
	    // DATE
	    StringBuffer dateBuffer = new StringBuffer(request.getParameter("publish_date"));
	    String dateString = dateBuffer.toString();
//	    System.out.println(dateString);
	    
	    request.setAttribute("publish_date", dateString);
	    
	    
	    newBookData.put("author", request.getParameter("author"));
	    newBookData.put("title", request.getParameter("title"));
	    newBookData.put("genre", request.getParameter("genre"));
	    newBookData.put("price", request.getParameter("price"));
	    newBookData.put("publish_date", dateString);
	    newBookData.put("coverBytesString", imageString);	    
	    newBookData.put("description", descriptionString);
	    
	    // Ajout au catalogue XML
	    this.addBookToXMLCatalogue(newBookData);
	    
		// Envoi du fichier JSP au client
		request.getRequestDispatcher("view-new-book-in-catalog.jsp").forward(request, response);
		
	}
	
	private void addBookToXMLCatalogue(HashMap<String, String> newBookData) {
		Catalog catalog = new Catalog();
		catalog.addBook(newBookData);
	}
}
