package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.tomcat.util.codec.binary.Base64;


@WebServlet(name = "CatalogJSP", urlPatterns = {"/CatalogJSP"})
@MultipartConfig(
			fileSizeThreshold = 1024 * 1024 * 1,
			maxFileSize = 1024 * 1024 * 10,
			maxRequestSize = 1024 * 1024 * 100
		)

public class CatalogJSP extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CatalogJSP() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Pour ajouter un livre à la base de données, aller à : ").append(request.getContextPath());
		
		System.out.println("test CatalogJSP");

		
		Catalog catalog = new Catalog();
		catalog.printAllBooks();

		response.setContentType("text/html;charset=UTF-8");
		

		request.getRequestDispatcher("catalog.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
	}
}
