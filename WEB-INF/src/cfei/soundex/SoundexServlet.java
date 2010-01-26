/**
 * SoundexServlet.java
 * Description: This class is a Servlet to handle incoming HTTP requests.
 * @author Christopher Fei
 */

package cfei.soundex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SoundexServlet extends HttpServlet{
	
	/**
	 * Description: we override the doGet() method of the HttpServlet class to handle 
	 * GET requests by calling the Soundex algorithm implementation.
	 * @param request is an HttpServletRequest that represents the HTTP request from the client to the servlet
	 * @param response is an HttpServletResponse that represents the HTTP response from the servlet to the client
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String input = request.getParameter("input");
		String soundexResult = Soundex.soundex(input);
		out.write(soundexResult);
		
	}
	
}
