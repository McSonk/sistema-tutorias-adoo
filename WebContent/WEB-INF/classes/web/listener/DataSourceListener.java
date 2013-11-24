package web.listener;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import util.sql.ConnectionPool;
import util.sql.AccessProperties;

@WebListener
public class DataSourceListener implements ServletContextListener {

	private AccessProperties getAccessProperties(ServletContext context) {
		return new AccessProperties()
			.setUrl(context.getInitParameter(
				"database_url"))
			.setDriverClassName(context.getInitParameter(
				"database_driver_class_name"))
			.setUsername(context.getInitParameter(
				"database_username"))
			.setPassword(context.getInitParameter(
				"database_password"));
	}

	private AccessProperties getAccessPropertiesByOpenShift() {
		return new AccessProperties()
			.setUrl("jdbc:mysql://" +
			        System.getenv("OPENSHIFT_MYSQL_DB_HOST") +
			        ":" +
			        System.getenv("OPENSHIFT_MYSQL_DB_PORT") +
			        "/" +
			        "adootutorias")
			.setDriverClassName("com.mysql.jdbc.Driver")
			.setUsername(System.getenv(
				"OPENSHIFT_MYSQL_DB_USERNAME"))
			.setPassword(System.getenv(
				"OPENSHIFT_MYSQL_DB_PASSWORD"));
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("ServletContextListener started");

		ServletContext context = event.getServletContext();

		AccessProperties properties =
			getAccessPropertiesByOpenShift();

		System.out.println("Using database properties:" + properties);
		ConnectionPool.initDataSource(properties);
		if (!ConnectionPool.isConnected()) {
			properties = getAccessProperties(context);
			ConnectionPool.closeDataSource();

			System.out.println("No connection with:" +
			                   properties);
			System.out.println("Trying:" + properties);


			System.out.println("Using database properties:" +
			                   properties);
			ConnectionPool.initDataSource(properties);
			if (!ConnectionPool.isConnected())
				System.out.println(
				"No connection with:"+properties);
			else
				System.out.println("No Database connection");
		} else {
			System.out.println("Connected to Database");
		}

		context.setAttribute("root", context.getContextPath());
		System.out.println(
			"Setting root web path: " + context.getContextPath());
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("ServletContextListener destroyed");
		ConnectionPool.closeDataSource();
	}

}

