package org.example.framework.listener;

import com.google.gson.Gson;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.example.app.controller.UserController;
import org.example.framework.attribute.ContextAttributes;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@WebListener
public class ServletContextLoadDestroyListener implements ServletContextListener {

    @Override
    public void contextInitialized(final ServletContextEvent sce) {
        final ServletContext servletContext = sce.getServletContext();

        final var context = new AnnotationConfigApplicationContext("org.example.app");
        servletContext.setAttribute(ContextAttributes.SPRING_CONTEXT, context);
    }

    @Override
    public void contextDestroyed(final ServletContextEvent sce) {
        final var context =(ConfigurableApplicationContext) sce.getServletContext().getAttribute(ContextAttributes.SPRING_CONTEXT);
        context.close();
    }
    }
