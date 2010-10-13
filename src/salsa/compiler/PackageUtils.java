package salsa.compiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;


public class PackageUtils {

 private static boolean debug = true;

 public static List getClasseNamesInPackage
     (String jarName, String packageName){
   ArrayList classes = new ArrayList ();

   packageName = packageName.replaceAll("\\." , "/");
   if (debug) System.out.println
        ("Jar " + jarName + " looking for " + packageName);
   try{
     JarInputStream jarFile = new JarInputStream
        (new FileInputStream (jarName));
     JarEntry jarEntry;

     while(true) {
       jarEntry=jarFile.getNextJarEntry ();
       if(jarEntry == null){
         break;
       }
       if((jarEntry.getName ().startsWith (packageName)) &&
            (jarEntry.getName ().endsWith (".class")) ) {
         if (debug) System.out.println 
           ("Found " + jarEntry.getName().replaceAll("/", "\\."));
         classes.add (jarEntry.getName().replaceAll("/", "\\."));
       }
     }
   }
   catch( Exception e){
     e.printStackTrace ();
   }
   return classes;
}

/**
 * @throws IOException 
*
*/
  public static void main (String[] args) throws IOException{
      System.out.println(System.getProperty("java.class.path"));
      
      JarFile jarFile = new JarFile("/media/DEVELOP/java/antlr/antlrworks-1.4.jar");
      JarEntry jarEntry = jarFile.getJarEntry("org/antlr/Tool.class");
      System.err.println(jarEntry);
//   List list =  PackageUtils.getClasseNamesInPackage
//        ("C:/j2sdk1.4.1_02/lib/mail.jar", "com.sun.mail.handlers");
//   System.out.println(list);
   /*
   output :
   
    Jar C:/j2sdk1.4.1_02/lib/mail.jar looking for com/sun/mail/handlers
    Found com.sun.mail.handlers.text_html.class
    Found com.sun.mail.handlers.text_plain.class
    Found com.sun.mail.handlers.text_xml.class
    Found com.sun.mail.handlers.image_gif.class
    Found com.sun.mail.handlers.image_jpeg.class
    Found com.sun.mail.handlers.multipart_mixed.class
    Found com.sun.mail.handlers.message_rfc822.class
    [com.sun.mail.handlers.text_html.class, 
    com.sun.mail.handlers.text_xml.class,  com
    .sun.mail.handlers.image_jpeg.class, 
    , com.sun.mail.handlers.message_rfc822.class]
    
   */
  }
  
  
  /**
   * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
   *
   * @param packageName The base package
   * @return The classes
   * @throws ClassNotFoundException
   * @throws IOException
   */
  private static Class[] getClasses(String packageName)
          throws ClassNotFoundException, IOException {
      ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
      assert classLoader != null;
      String path = packageName.replace('.', '/');
      Enumeration<URL> resources = classLoader.getResources(path);
      List<File> dirs = new ArrayList<File>();
      while (resources.hasMoreElements()) {
          URL resource = resources.nextElement();
          dirs.add(new File(resource.getFile()));
      }
      ArrayList<Class> classes = new ArrayList<Class>();
      for (File directory : dirs) {
          classes.addAll(findClasses(directory, packageName));
      }
      return classes.toArray(new Class[classes.size()]);
  }

  /**
   * Recursive method used to find all classes in a given directory and subdirs.
   *
   * @param directory   The base directory
   * @param packageName The package name for classes found inside the base directory
   * @return The classes
   * @throws ClassNotFoundException
   */
  private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
      List<Class> classes = new ArrayList<Class>();
      if (!directory.exists()) {
          return classes;
      }
      File[] files = directory.listFiles();
      for (File file : files) {
          if (file.isDirectory()) {
              assert !file.getName().contains(".");
              classes.addAll(findClasses(file, packageName + "." + file.getName()));
          } else if (file.getName().endsWith(".class")) {
              classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
          }
      }
      return classes;
  }
}


