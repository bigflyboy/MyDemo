package com.wangzhiyuan.mydemo.volleydemo;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

public class BitmapCache implements ImageLoader.ImageCache {

    private LruCache<String, Bitmap> cache;

    public BitmapCache(){
        cache = new LruCache<String, Bitmap>(8 * 1024* 1024) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };
    }

    @Override
    public Bitmap getBitmap(String url) {
        return cache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        cache.put(url, bitmap);
    }
}
