# prelollipop-okhttp-client
OkHttpClient Compat (Fix OpenSSL Handshake on PreLollipop OS)

Jitpack URL:
https://jitpack.io/#beanman90/prelollipop-okhttp-client

Usage:

AndroidNetworking.initialize(this, new OkHttpTLSCompat().getClient());

new Picasso.Builder(this)
                .downloader(new OkHttp3Downloader(new OkHttpTLSCompat().getClient()))
                .listener((picasso, uri, exception) -> exception.printStackTrace()).build();
