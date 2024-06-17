package com.apple.user_check.Validation;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class ValidationController {

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/home")
    @ResponseBody
    public String home(HttpServletRequest request) {

        Map<String, Object> info = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            info.put(headerName, request.getHeader(headerName));
        }

        // Get parameter information
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            info.put(entry.getKey(), Arrays.toString(entry.getValue()));
        }

        // Get other request information
        info.put("Method", request.getMethod());
        info.put("Request URI", request.getRequestURI());
        info.put("Protocol", request.getProtocol());
        info.put("Path Info", request.getPathInfo());
        info.put("Remote Addr", request.getRemoteAddr());
        info.put("Remote Host", request.getRemoteHost());
        info.put("Server Name", request.getServerName());
        info.put("Server Port", request.getServerPort());
        info.put("Locale", request.getLocale().toString());
        info.put("Is Secure", request.isSecure());

        // Convert the info map to a JSON string and return it
        try {
            return objectMapper.writeValueAsString(info);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error processing request info.";
        }


    }

}
