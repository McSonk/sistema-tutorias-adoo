package test.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import util.pojo.POJO;
import util.pojo.POJOInstantiator;
import util.sql.ConnectionPool;
import util.sql.ResourceQuietCloser;

@WebServlet("/test/time")
public class TimeRetriever extends HttpServlet {

	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response)
			throws ServletException, IOException {
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(sdf.format(cal.getTime()));
		request.getSession()
			.setAttribute("server_time",
			              sdf.format(cal.getTime()));
		// Así es como se envía a un JSP dentro de WEB-INF
		request.getServletContext().getRequestDispatcher(
			"/WEB-INF/views/test/time-retriever.jsp")
			.forward(request, response);
	}

}

