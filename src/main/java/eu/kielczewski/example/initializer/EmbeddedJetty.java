package eu.kielczewski.example.initializer;

import eu.kielczewski.example.config.MvcServletContainerInitializer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.listener.ContainerInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class EmbeddedJetty {

    private static final Logger logger = LoggerFactory.getLogger(EmbeddedJetty.class);

    public static void main(String[] args) throws Exception {
        new EmbeddedJetty().startJetty(80);
    }

    private void startJetty(int port) throws Exception {
        logger.debug("Starting server at port {}", port);
        Server server = new Server(port);
        server.setHandler(getServletContextHandler());
        server.start();
        server.join();
    }

    private static ServletContextHandler getServletContextHandler() throws IOException {
        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.addEventListener(ContainerInitializer.asContextListener(new MvcServletContainerInitializer()));
        contextHandler.setErrorHandler(null);
        return contextHandler;
    }
}
