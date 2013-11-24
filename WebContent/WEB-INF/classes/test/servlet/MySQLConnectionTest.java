package test.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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

@WebServlet("/test/mysql/connection")
public class MySQLConnectionTest extends HttpServlet {

	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession()
			.setAttribute("is_connected",
			              ConnectionPool.isConnected()?"si":"no");
		// Así es como se envía a un JSP dentro de WEB-INF
		request.getServletContext().getRequestDispatcher(
			"/WEB-INF/views/test/mysql-connection.jsp")
			.forward(request, response);
	}

}

