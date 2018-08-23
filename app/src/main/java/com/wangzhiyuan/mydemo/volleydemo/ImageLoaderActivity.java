package com.wangzhiyuan.mydemo.volleydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.wangzhiyuan.mydemo.R;

public class ImageLoaderActivity extends AppCompatActivity {

    private ImageView mImageView;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        mRequestQueue = Volley.newRequestQueue(this);
        mImageView = findViewById(R.id.image);
    }

    public void requestImage(View v){
        ImageLoader imageLoader = new ImageLoader(mRequestQueue, new BitmapCache());
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(mImageView,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground);
        imageLoader.get("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534571592092&di=33bda50fbfbb3be691c95435ddc918b8&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F21a4462309f79052782f28490ff3d7ca7bcbd591.jpg",
                listener);
    }
}
