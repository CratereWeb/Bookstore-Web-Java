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

import org.apache.tomcat.util.codec.binary.Base64;


@WebServlet(name = "BookstoreJSP", urlPatterns = {"/BookstoreJSP"})
@MultipartConfig(
			fileSizeThreshold = 1024 * 1024 * 1,
			maxFileSize = 1024 * 1024 * 10,
			maxRequestSize = 1024 * 1024 * 100
		)

public class BookServletJSP extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BookServletJSP() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Pour ajouter un livre à la base de données, aller à : ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}
}
