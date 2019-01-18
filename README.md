# prelollipop-okhttp-client [![](https://jitpack.io/v/beanman90/prelollipop-okhttp-client.svg)](https://jitpack.io/#beanman90/prelollipop-okhttp-client) [![downloads](https://jitpack.io/v/beanman90/prelollipop-okhttp-client/month.svg)](https://jitpack.io/#beanman90/prelollipop-okhttp-client)

OkHttpClient Compat (Fix OpenSSL Handshake on PreLollipop OS)

Jitpack URL:
https://jitpack.io/#beanman90/prelollipop-okhttp-client

Usage:

AndroidNetworking.initialize(this, new OkHttpTLSCompat().getClient());

new Picasso.Builder(this)
                .downloader(new OkHttp3Downloader(new OkHttpTLSCompat().getClient()))
                .listener((picasso, uri, exception) -> exception.printStackTrace()).build();
[![Build Status](https://travis-ci.org/yeriomin/play-store-api.svg?branch=master)](https://travis-ci.org/yeriomin/play-store-api) [![Release](https://jitpack.io/v/yeriomin/play-store-api.svg)](https://jitpack.io/#yeriomin/play-store-api) [![downloads](https://jitpack.io/v/yeriomin/play-store-api/month.svg)](https://jitpack.io/#yeriomin/play-store-api)
