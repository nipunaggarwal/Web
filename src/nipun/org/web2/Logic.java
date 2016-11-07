package nipun.org.web2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logic extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String text = (String) request.getParameter("myTextBox");

		FileWriter fWriter = null;
		BufferedWriter writer = null;
		try {

			String contextPath = getServletContext().getRealPath("/");
			String xmlFilePath = contextPath + "\\New.java";

			fWriter = new FileWriter(contextPath + "\\New.java");

			System.out.println(xmlFilePath);
			File myfile = new File(xmlFilePath);
			myfile.createNewFile();
			writer = new BufferedWriter(fWriter);
			writer.write(text);
			writer.newLine();
			writer.close();
			out.println("Your input of " + text.length()
					+ " characters was saved in file New.java at location: "
					+ xmlFilePath);
		} catch (Exception e) {
			System.out.println("Error!");
		}
		String contextPath = getServletContext().getRealPath("/");
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd "
				+ contextPath + " && javac New.java && java New");
		builder.redirectErrorStream(true);
		Process p = builder.start();
		BufferedReader r = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		String line;
		while (true) {
			line = r.readLine();
			if (line == null) {
				break;
			}

			out.println("<html>");
			out.println("<body bgcolor=\"lightblue\">");
			out.println("<form action=\"/Web/Logic\" method=\"POST\" >");
			out.println("<b><h1 align=center>OUTPUT</h1></b><br/>");
			out.println("<form action=\"http://www.html.am/html-codes/textboxes/submitted.cfm\"><textarea name=\"myTextBox\" cols=\"100\" rows=\"20\">");
			out.println(line);
			out.println("</textarea>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");

		}
	}
}
