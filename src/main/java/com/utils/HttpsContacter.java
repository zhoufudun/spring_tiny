package com.utils;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/**
 * Https协议请求
 * 
 * @author bailey
 * @version 1.0
 * @date 2016-12-16 14:09
 */
public class HttpsContacter extends HttpContactAble {
	private static CloseableHttpClient httpClient;
	@Override
	protected CloseableHttpClient buildHttpClient() throws Exception {
		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, new TrustManager[] { new TrustAnyTrustManager() }, null);
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.INSTANCE)
				.register("https", new SSLConnectionSocketFactory(sslContext)).build();
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		return HttpClients.custom().setConnectionManager(connManager).build();
	}

	public static CloseableHttpClient getHttpClient(){
		if(httpClient==null){
			HttpsContacter httpsContacter = new HttpsContacter();
			try {
				httpClient =httpsContacter.buildHttpClient();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return httpClient;
	}
}
