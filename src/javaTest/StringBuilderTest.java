//package javaTest;
//
//import org.apache.hc.client5.http.classic.methods.HttpPost;
//import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
//import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
//import org.apache.hc.core5.http.HttpRequestInterceptor;
//import org.apache.hc.core5.http.HttpResponseInterceptor;
//
//import java.io.IOException;
//import java.net.URI;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class StringBuilderTest {
//    public static void main(String[] args) {
//        StringBuilder stringBuilder = new StringBuilder();
////        stringBuilder
//
//    }
//
//    void httpTest(){
//
//        AtomicInteger requestCounter = new AtomicInteger();
//        CloseableHttpClient client = HttpClientBuilder
//                .create()
//                .addExecInterceptorFirst("123",(HttpRequestInterceptor) (request, context) -> requestCounter.getAndIncrement())
//                .addInterceptorLast((HttpResponseInterceptor) (response, context) -> { throw new IOException(); })
//                .build();
//        HttpPost request = new HttpPost(URI.create("https://httpstat.us/200"));
//
//        try {
//            client.execute(request);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
