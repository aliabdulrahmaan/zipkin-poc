package com.aliassad.service1.filter;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import brave.Span;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import brave.Tracer;

@WebFilter()
@Slf4j
public class AddResponseHeaderFilter implements Filter {

    @Autowired
    Tracer tracer;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("tracer-id", tracer.currentSpan().context().traceIdString());
//        System.out.println(httpServletResponse.);
        chain.doFilter(request, response);
        Span currentSpan = tracer.currentSpan();
//        currentSpan.logEvent("ERROR: " + message);
//       HttpServletRequest req= (HttpServletRequest) request;
//       logPostOrPutRequestBody(req);
//        System.out.println(req);
//        currentSpan.tag("request", IOUtils.toString(request.getReader()));
//        currentSpan.tag("response",response.toString());

    }



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

//    private void logPostOrPutRequestBody(HttpServletRequest httpRequest) throws IOException {
//        if(Arrays.asList("POST", "PUT").contains(httpRequest.getMethod())) {
//            String characterEncoding = httpRequest.getCharacterEncoding();
//            Charset charset = Charset.forName(characterEncoding);
//            String bodyInStringFormat = readInputStreamInStringFormat(httpRequest.getInputStream(), charset);
//            log.info("Request body: {}", bodyInStringFormat);
//        }
//    }
//
//    private String readInputStreamInStringFormat(InputStream stream, Charset charset) throws IOException {
//        final int MAX_BODY_SIZE = 1024;
//        final StringBuilder bodyStringBuilder = new StringBuilder();
//        if (!stream.markSupported()) {
//            stream = new BufferedInputStream(stream);
//        }
//
//        stream.mark(MAX_BODY_SIZE + 1);
//        final byte[] entity = new byte[MAX_BODY_SIZE + 1];
//        final int bytesRead = stream.read(entity);
//
//        if (bytesRead != -1) {
//            bodyStringBuilder.append(new String(entity, 0, Math.min(bytesRead, MAX_BODY_SIZE), charset));
//            if (bytesRead > MAX_BODY_SIZE) {
//                bodyStringBuilder.append("...");
//            }
//        }
//        stream.reset();
//
//        return bodyStringBuilder.toString();
//    }
}