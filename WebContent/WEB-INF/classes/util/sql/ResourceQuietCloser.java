package util.sql;

public class ResourceQuietCloser {

   public static void closeQuietly(AutoCloseable ... resources) {
      for(AutoCloseable resource : resources) {
         try {
            // System.out.println("Closing resource : " +
               // resource.getClass().getName());
            resource.close();
         } catch (Exception e) {
            // System.out.println(
               // "Exception while closing " +
               // resource + ":" + e.getMessage());
         }
      }
   }

}

