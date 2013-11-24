package util.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.apache.tomcat.jdbc.pool.DataSource;

public class ConnectionPool {

	private static DataSource dataSource = null;

	private static AccessProperties properties = null;

	public static Connection getConnection() {
		try {
			if (dataSource == null)
				throw new SQLException(
					"No hubo conexion " +
					"usando las credenciales:"+
					properties.toString());
			return dataSource.getConnection();
		} catch (SQLException e) {
			return null;
		}
	}

	public static boolean isConnected() {
		if (dataSource == null)
			return false;

		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch(SQLException e) {}

		if (connection == null) {
			return false;
		} else {
			ResourceQuietCloser.closeQuietly(connection);
			return true;
		}
	}

	public static void initDataSource(AccessProperties properties) {
		PoolProperties p = new PoolProperties();

		p.setUrl(properties.getUrl());
		p.setDriverClassName(properties.getDriverClassName());
		p.setUsername(properties.getUsername());
		p.setPassword(properties.getPassword());

		p.setJmxEnabled(true);
		p.setTestWhileIdle(false);
		p.setTestOnBorrow(true);
		p.setValidationQuery("SELECT 1");
		p.setTestOnReturn(false);
		p.setValidationInterval(30000);
		p.setTimeBetweenEvictionRunsMillis(30000);

		p.setMaxActive(75);
		p.setMaxIdle(75);
		p.setInitialSize(10);
		p.setMaxWait(10000);
		p.setRemoveAbandonedTimeout(60);
		p.setMinEvictableIdleTimeMillis(30000);
		p.setMinIdle(10);

		p.setLogAbandoned(true);
		p.setRemoveAbandoned(true);

		p.setJdbcInterceptors(
		"org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;" +
		"org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");

		dataSource = new DataSource();
		dataSource.setPoolProperties(p);
	}

	public static void closeDataSource() {
		if (dataSource != null)
			dataSource.close();
	}

}

