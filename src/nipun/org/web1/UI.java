package nipun.org.web1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UI extends HttpServlet {

	private String message;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body bgcolor=\"lightblue\">");
		out.println("<form action=\"/Web/Logic\" method=\"POST\" >");
		out.println("<b><h1 align=center>LOGIC</h1></b><br/>");
		out.println("<form action=\"http://www.html.am/html-codes/textboxes/submitted.cfm\"><textarea name=\"myTextBox\" cols=\"190\" rows=\"30\">");
		out.println("import java.util.*;");
		out.println("import java.lang.*;");
		out.println("import java.io.*;");
		out.println("public class New");
		out.println("{");
		out.println("public static void main(String args[]) {");
		out.println("}");
		out.println("}");
		out.println("</textarea>");
		out.println("<h5 align=center><input type=\"submit\" value=\"Submit\"/></h5> ");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

}
