# Pre-Lollipop OkHttpClient [![](https://jitpack.io/v/beanman90/prelollipop-okhttp-client.svg)](https://jitpack.io/#beanman90/prelollipop-okhttp-client) [![downloads](https://jitpack.io/v/beanman90/prelollipop-okhttp-client/month.svg)](https://jitpack.io/#beanman90/prelollipop-okhttp-client) [![](https://img.shields.io/badge/Recommend-%E2%AD%90%EF%B8%8F%E2%AD%90%EF%B8%8F%E2%AD%90%EF%B8%8F%E2%AD%90%EF%B8%8F%E2%AD%90%EF%B8%8F-green.svg)]

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
