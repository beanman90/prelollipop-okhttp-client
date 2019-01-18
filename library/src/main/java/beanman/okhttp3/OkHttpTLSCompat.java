package beanman.okhttp3;

import android.os.Build;
import android.util.Log;
import okhttp3.*;

import javax.net.ssl.SSLContext;
import java.util.*;

/**
 * Created by Manh Do on 1/5/2019.
 */
public class OkHttpTLSCompat {

    public OkHttpTLSCompat() {
    }

    public OkHttpClient getClient() {
        return this.enableTls12OnPreLollipop(this.builder()).build();
    }

    protected OkHttpClient.Builder builder() {
        return new OkHttpClient.Builder()
                .followRedirects(true)
                .followSslRedirects(true)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1, Protocol.HTTP_2))
                .connectionPool(new ConnectionPool());
    }

    protected CipherSuite[] getCipherSuites() {
        return new CipherSuite[]{
                CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256,
                CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA,
                CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA,
                CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA,
                CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA,
                CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA,
                CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA,
                CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA
        };
    }

    private OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder client) {
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 22) {
            try {
                SSLContext socketContext = SSLContext.getInstance("TLSv1.2");
                socketContext.init(null, null, null);
                client.sslSocketFactory(new Tls12SocketFactory(socketContext.getSocketFactory()), new XX509TrustManager());

                List<ConnectionSpec> connectionSpecList = new ArrayList();
                connectionSpecList.add(ConnectionSpec.COMPATIBLE_TLS);
                connectionSpecList.add(ConnectionSpec.CLEARTEXT);
                connectionSpecList.add(new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                        .tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0)
                        .cipherSuites(this.getCipherSuites())
                        .build());
                client.connectionSpecs(connectionSpecList);
            } catch (Exception exc) {
                Log.e("OkHttpTLSCompat", "Error while setting TLS 1.2", exc);
            }
        }
        return client;
    }

}
