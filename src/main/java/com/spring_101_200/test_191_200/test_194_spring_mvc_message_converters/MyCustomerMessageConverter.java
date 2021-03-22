package com.spring_101_200.test_191_200.test_194_spring_mvc_message_converters;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class MyCustomerMessageConverter extends AbstractHttpMessageConverter<Object> {
    @Override
    protected boolean supports(Class<?> clazz) {
        if (clazz.equals(User.class)) {
            return true;
        }
        return false;
    }
 
    public MyCustomerMessageConverter() {
        super(new MediaType("text", "plain"));
    }
 
    @Override
    protected Object readInternal(Class<? extends Object> clazz,
            HttpInputMessage inputMessage) throws IOException,
            HttpMessageNotReadableException {
        Charset charset;
        MediaType contentType = inputMessage.getHeaders().getContentType();
        if (contentType != null && contentType.getCharSet() != null) {
            charset = contentType.getCharSet();
        } else {
            charset = Charset.forName("UTF-8");
        }
        String input = FileCopyUtils.copyToString(new InputStreamReader(
                inputMessage.getBody(), charset));
        logger.info(input);
        String[] s = input.split("\\|");
        User u = new User();
        u.setUsername(s[0]);
        u.setPassword(s[1]);
        u.setMobile(s[2]);
        return u;
    }
 
    @Override
    protected void writeInternal(Object t, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
 
    }
}