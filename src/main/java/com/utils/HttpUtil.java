package com.utils;

import com.alibaba.fastjson.JSON;
import freemarker.template.utility.StringUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * @author 陈金虎 2017年1月16日 下午11:41:47
 * @类描述：http请求工具
 * @注意：本内容仅限于杭州霖梓网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@SuppressWarnings("deprecation")
public class HttpUtil {

    protected static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    public static final int cache = 10 * 1024;
    public static final int DEFULT_TIMEOUT = 10 * 1000;
    public static final int DEFULT_READ_TIMEOUT = 20 * 1000;

    private static URLConnection getConn(URL realUrl,int timeout){
        try {
            URLConnection conn = realUrl.openConnection();
            conn.setConnectTimeout(timeout);
            conn.setReadTimeout(DEFULT_READ_TIMEOUT);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            return conn;
        }catch (Exception e){
            logger.error("创建连接失败 url "+realUrl.getPath() , e);
            return null;
        }
    }
    /**
     * 执行GET请求
     *
     * @param url
     * @param timeout
     * @return
     */
    public static String doGet(String url, int timeout) {
        logger.info("doGet url = {}", url);
        BufferedReader in = null;
        OutputStreamWriter out = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = getConn(realUrl,timeout);
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.error("发送失败 url "+url , e);
            return "";
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        logger.info("doGet result = {}", result);
        return result;
    }

    /**
     * 执行GET请求
     *
     * @param url
     * @param param
     * @return
     */
    public static String doPost(String url, String param) {
        BufferedReader in = null;
        OutputStreamWriter out = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = getConn(realUrl,DEFULT_TIMEOUT);
            out = new OutputStreamWriter(conn.getOutputStream());
            // 把数据写入请求的Body
            out.write(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.error("发送失败 url "+url , e);
            return "";
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    /**
     * 发送POST请求，将参数放置到BODY里边
     *
     * @param url
     * @param param
     * @return
     */
    public static String doHttpPost(String url, String param) {
        logger.info("doHttpPost begin url = {} param = {}", url, param);
        BufferedReader in = null;
        OutputStreamWriter out = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = getConn(realUrl,DEFULT_TIMEOUT);
            out = new OutputStreamWriter(conn.getOutputStream());
            // 把数据写入请求的Body
            out.write(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.error("发送失败 url "+url , e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        logger.info("doHttpPost result = {}", result);
        return result;
    }

    /**
     * <b>功能描述:</b>
     * @author : chenruhui
     * <b>创建日期 :</b>
     * @date 2018/10/30 10:42
     * @param reqUrl
     * @param parameters
     * @param recvEncoding
     * @return java.lang.String
     * <b>修改历史:</b>(修改人,修改时间,修改原因/内容)
     */
    public static String doHttpPost(String reqUrl, Map parameters, String recvEncoding) {
        java.net.HttpURLConnection urlCon = null;
        String responseContent = null;
        try {
            StringBuffer params = new StringBuffer();
            Iterator iter = parameters.entrySet().iterator();
            while (iter
                    .hasNext()) {
                Map.Entry element = (Map.Entry) iter.next();
                params.append(element.getKey().toString());
                params.append("=");
                params.append(URLEncoder.encode(element.getValue().toString(),
                        "UTF-8"));
                params.append("&");
            }
            if (params.length() > 0) {
                params = params.deleteCharAt(params.length() - 1);
            }
            URL url = new URL(reqUrl);
            urlCon = (java.net.HttpURLConnection) url.openConnection();
            urlCon.setRequestMethod("POST");
            System.setProperty("sun.net.client.defaultConnectTimeout",
                    String.valueOf(5000));
            System.setProperty("sun.net.client.defaultReadTimeout",
                    String.valueOf(10000));

            urlCon.setDoOutput(true);
            byte[] b = params.toString().getBytes();
            urlCon.getOutputStream().write(b, 0, b.length);
            urlCon.getOutputStream().flush();
            urlCon.getOutputStream().close();

            InputStream in = urlCon.getInputStream();
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(in,
                            recvEncoding));
            String tempLine = rd.readLine();
            StringBuilder tempStr = new StringBuilder();
            String crlf = System.getProperty("line.separator");
            while (tempLine != null) {
                tempStr.append(tempLine);
                tempStr.append(crlf);
                tempLine = rd.readLine();
            }
            responseContent = tempStr.toString();
            rd.close();
            in.close();
        } catch (IOException e) {
            logger.error("发送失败 url "+reqUrl , e);
        } finally {
            if (urlCon != null) {
                urlCon.disconnect();
            }
        }
        return responseContent;
    }

    /**
     * 发送POST请求，将参数放置到BODY里边
     *
     * @param url
     * @param param
     * @return
     */
    public static String doHttpPostJsonParam(String url, String param) {
        logger.info("post json 请求 Url =  {}",url);
        BufferedReader in = null;
        OutputStreamWriter out = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = getConn(realUrl,DEFULT_TIMEOUT);
            conn.setRequestProperty("content-type", "application/json");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("contentType", "utf-8");

            out = new OutputStreamWriter(conn.getOutputStream());
            // 把数据写入请求的Body
            out.write(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.error("发送失败 url "+url , e);
        } finally {
            logger.info(" url = " + url + " ,param = " + param + ", result =   " + result);
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    /**
     * 发送HTTPS的POST请求，并且忽略证书验证,将参数放置到BODY里边
     *
     * @param urlString
     * @param query
     * @return
     */
    public static String doHttpsPostIgnoreCert(String urlString, String query) {

        ByteArrayOutputStream buffer = new ByteArrayOutputStream(512);
        try {
            URL url = new URL(urlString);
            /*
             * use ignore host name verifier
             */
            HttpsURLConnection.setDefaultHostnameVerifier(ignoreHostnameVerifier);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            // Prepare SSL Context
            TrustManager[] tm = {ignoreCertificationTrustManger};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 设置doOutput属性为true表示将使用此urlConnection写入数据
            connection.setDoOutput(true);
            connection.setReadTimeout(DEFULT_READ_TIMEOUT);
            connection.setConnectTimeout(DEFULT_TIMEOUT);
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            connection.setSSLSocketFactory(ssf);

            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            // 把数据写入请求的Body
            out.write(query);
            out.flush();
            out.close();

            InputStream reader = connection.getInputStream();
            byte[] bytes = new byte[512];
            int length = reader.read(bytes);

            do {
                buffer.write(bytes, 0, length);
                length = reader.read(bytes);
            } while (length > 0);

            reader.close();
            connection.disconnect();
        } catch (Exception ex) {
            logger.error("发送失败 url "+urlString , ex);
        } finally {
        }
        String repString = new String(buffer.toByteArray());
        return repString;
    }

    /**
     * 忽视证书HostName
     */
    private static HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier() {

        @Override
		public boolean verify(String s, SSLSession sslsession) {
            logger.debug("WARNING: Hostname is not matched for cert.");
            return true;
        }
    };

    /**
     * Ignore Certification
     */
    private static TrustManager ignoreCertificationTrustManger = new X509TrustManager() {

        private X509Certificate[] certificates;

        @Override
		public void checkClientTrusted(X509Certificate[] certificates, String authType) throws CertificateException {
            if (this.certificates == null) {
                this.certificates = certificates;
                logger.debug("init at checkClientTrusted");
            }
        }

        @Override
		public void checkServerTrusted(X509Certificate[] ax509certificate, String s) throws CertificateException {
            if (this.certificates == null) {
                this.certificates = ax509certificate;
                logger.debug("init at checkServerTrusted");
            }
        }

        @Override
		public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    };

	public static String post(String url, Map<String, String> params) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
		String body = null;

		logger.info("create httppost:" + url + ",params=" + params);
		HttpPost post = postForm(url, params);

		body = invoke(httpclient, post);

//		httpclient.getConnectionManager().shutdown();

		return body;
	}
	public static String postIgnoreCert(String url, Map<String, String> params) {
        CloseableHttpClient httpclient = HttpsContacter.getHttpClient();
        String body = null;

		logger.info("create httppost:" + url + ",params=" + params);
		HttpPost post = postForm(url, params);

		body = invoke(httpclient, post);

//		httpclient.getConnectionManager().shutdown();

		return body;
	}

    private static String invoke(CloseableHttpClient httpclient, HttpUriRequest httpost) {

        HttpResponse response = sendRequest(httpclient, httpost);
        String body = paseResponse(response);
        return body;
    }

    private static String paseResponse(HttpResponse response) {
        logger.info("get response from http server..");
        HttpEntity entity = response.getEntity();

        logger.info("response status: " + response.getStatusLine());
        String charset = EntityUtils.getContentCharSet(entity);
        logger.info(charset);

        String body = null;
        try {
            body = EntityUtils.toString(entity);
            logger.info(body);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return body;
    }

    private static HttpResponse sendRequest(CloseableHttpClient httpclient, HttpUriRequest httpost) {
        logger.info("execute post...");
        HttpResponse response = null;
        try {
            response = httpclient.execute(httpost);
        } catch (ClientProtocolException e) {
            logger.error("连接超时 url:" +httpost.getURI(),e);
            throw new EbApiException(RespCode.CONNECTION_TIMEOUT);
        } catch (IOException e) {
            logger.error("连接超时 url:" +httpost.getURI(),e);
            throw new EbApiException(RespCode.CONNECTION_TIMEOUT);
        }
        return response;
    }

    private static HttpPost postForm(String url, Map<String, String> params) {

        HttpPost httpost = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        Set<String> keySet = params.keySet();
        for (String key : keySet) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }

        try {
            logger.info("set utf-8 form entity to httppost");
            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
            httpost.setConfig(RequestConfig.custom()
                    .setConnectTimeout(5000)
                    .setConnectionRequestTimeout(3000)
                    .setSocketTimeout(60000).build());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return httpost;
    }
    /**
     * 根据url下载文件，保存到流中
     *
     * @param url 文件路径
     * @return
     */
    public static String downloadWithStream(String url) {
        try {
            org.apache.http.client.HttpClient client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = client.execute(httpget);

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            ByteArrayOutputStream fileout = new ByteArrayOutputStream();
            // 根据实际运行效果 设置缓冲区大小
            byte[] buffer = new byte[cache];
            int ch = 0;
            while ((ch = is.read(buffer)) != -1) {
                fileout.write(buffer, 0, ch);
            }
            is.close();
            fileout.flush();
            fileout.close();
            //保存文件信息
            String result = new String(fileout.toByteArray(), "ISO-8859-1");
            result = URLEncoder.encode(result, "ISO-8859-1");
            return result;

        } catch (Exception e) {
            logger.error("发送失败 url "+url , e);
        }
        return null;
    }








    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back...
        }
        if (cl == null) {
            // No thread context class loader -> use class loader of this class.
            cl = HttpUtil.class.getClassLoader();
            if (cl == null) {
                // getClassLoader() returning null indicates the bootstrap ClassLoader
                try {
                    cl = ClassLoader.getSystemClassLoader();
                } catch (Throwable ex) {
                    // Cannot access system ClassLoader - oh well, maybe the caller can live with null...
                }
            }
        }
        return cl;
    }
}
