package com.springsource.tcruntime.embeddedexample.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import com.springsource.tcserver.serviceability.rmi.JmxSocketListener;
import com.springsource.tcserver.serviceability.deploy.TcContainerDeployer;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

public class App {

  public static void main(String[] args)
  throws LifecycleException, InterruptedException, ServletException {
    Tomcat tomcat = new Tomcat();
    tomcat.setPort(8080);

    Context ctx = tomcat.addContext("", new File(".").getAbsolutePath());

    // JMX
    JmxSocketListener jmxListener = new JmxSocketListener();
    jmxListener.setPort(1099);
    tomcat.getService().addLifecycleListener(jmxListener);

    // Some mbeans for fun
    TcContainerDeployer deployer = new TcContainerDeployer();
    tomcat.getServer().addLifecycleListener(deployer);
    
    // This should be a separate class but for demo purposes this is sufficient.
    Tomcat.addServlet(ctx, "hello", new HttpServlet() {
      protected void service(HttpServletRequest req, HttpServletResponse resp) 
      throws ServletException, IOException {
        Writer w = resp.getWriter();
        w.write("Hello, World!\n");
        w.flush();
      }
    });
    ctx.addServletMapping("/*", "hello");

    tomcat.start();
    //without this the process exits
    tomcat.getServer().await();
  }

}
