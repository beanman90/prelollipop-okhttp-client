# prelollipop-okhttp-client [![](https://jitpack.io/v/beanman90/prelollipop-okhttp-client.svg)](https://jitpack.io/#beanman90/prelollipop-okhttp-client) [![downloads](https://jitpack.io/v/beanman90/prelollipop-okhttp-client/month.svg)](https://jitpack.io/#beanman90/prelollipop-okhttp-client)

OkHttpClient Compat (Fix OpenSSL Handshake on PreLollipop OS)

Jitpack URL:
https://jitpack.io/#beanman90/prelollipop-okhttp-client

Usage:
```java
AndroidNetworking.initialize(this, new OkHttpTLSCompat().getClient());
```
```java
new Picasso.Builder(this)
                .downloader(new OkHttp3Downloader(new OkHttpTLSCompat().getClient()))
                .listener((picasso, uri, exception) -> exception.printStackTrace()).build();
```
