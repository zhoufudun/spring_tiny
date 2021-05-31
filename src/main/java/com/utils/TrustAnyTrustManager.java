package com.utils;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;

/**
 * 信任的SERVER 证书
 * 
 * @author bailey
 * @version 1.0
 * @date 2016-12-16 11:49
 */
public class TrustAnyTrustManager implements X509TrustManager {
	@Override
	public void checkClientTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate, String paramString)
			throws CertificateException {
	}

	@Override
	public void checkServerTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate, String paramString)
			throws CertificateException {
	}

	@Override
	public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}