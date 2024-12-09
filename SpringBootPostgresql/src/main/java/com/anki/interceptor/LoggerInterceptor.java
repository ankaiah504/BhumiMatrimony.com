package com.anki.interceptor;



import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class LoggerInterceptor implements HandlerInterceptor{
	   // creating a logger
    Logger log
        = LoggerFactory.getLogger(LoggerInterceptor.class);
	  @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        log.info("LogHandlerInterceptor::preHandle()");
	//        logRequestDetails(request);
	        return true;
	    }

	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	        log.info("LogHandlerInterceptor::postHandle()");
	    }

	    @Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	        log.info("LogHandlerInterceptor::afterCompletion()");
	        logResponseDetails(response);
	    }


	    private void logRequestDetails(HttpServletRequest request) {
	    	log.info("Request: {}: {}", request.getMethod(), request.getRequestURL());
	    	System.out.println(" \n\n Headers");

	        Enumeration headerNames = request.getHeaderNames();
	        while(headerNames.hasMoreElements()) {
	            String headerName = (String)headerNames.nextElement();
	            System.out.println(headerName + " = " + request.getHeader(headerName));
	        }

	        System.out.println("\n\nParameters");

	        Enumeration params = request.getParameterNames();
	        while(params.hasMoreElements()){
	            String paramName = (String)params.nextElement();
	            System.out.println(paramName + " = " + request.getParameter(paramName));
	        }

	        System.out.println("\n\n Row data");
	        String data=extractPostRequestBody(request);
//	        System.out.println(extractPostRequestBody(request));
	        log.info("Request Details"+data);

	    }

	    private void logResponseDetails(HttpServletResponse response) {
	        log.info("Response: {}", HttpStatusCode.valueOf(response.getStatus()));
	        Map<String, String> headers = new HashMap<>();
	        for (String headerName : response.getHeaderNames()) {
	            headers.put(headerName, response.getHeader(headerName));
	        }
	        log.info("Response headers: {}", headers);
	    }
	

public  String extractPostRequestBody(HttpServletRequest request) {
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        Scanner s = null;
        try {
            s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s.hasNext() ? s.next() : "";
    }
    return "";     	    
}
}