package com.anki.config;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class BufferedRequestWrapper  extends HttpServletRequestWrapper{
	private final byte[] body;

	public BufferedRequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		// TODO Auto-generated constructor stub
		InputStream inputStream = request.getInputStream();
        this.body = inputStream.readAllBytes();
	}
	@Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(this.body)));
    }

    public byte[] getBody() {
        return body;
    }
}
