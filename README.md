sistema-tutorias-adoo
=====================

Descargar
---------

Para configurarlo en su propia máquina necesitan cambiar
ya sea el web.xml o el build.properties pero para el último
hay que usar [Java Ant](http://ant.apache.org/bindownload.cgi).

Tomcat y OpenShift
------------------

El proceso para instalar tomcat en openshift, por si a alguien
le interesa, está [aquí](https://github.com/openshift-quickstart/openshift-tomcat-quickstart/blob/master/README.md)

pero solo se hace una vez y en el fuente pueden ver como se
configura para conectarse a MySQL:

* [Pool de conexiones](https://github.com/urbo-escom/sistema-tutorias-adoo/blob/master/WebContent/WEB-INF/classes/util/sql/ConnectionPool.java)

* [Listener](https://github.com/urbo-escom/sistema-tutorias-adoo/blob/master/WebContent/WEB-INF/classes/web/listener/DataSourceListener.java)

