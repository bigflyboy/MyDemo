package com.wangzhiyuan.ui.recyclerview;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.wangzhiyuan.mydemo.R;

/**
 * Created by zybag on 2018/2/5.
 */

public class PandaRefreshHeader extends RelativeLayout implements RefreshHeader {

    private ImageView mRefreshImage;
    private RelativeLayout mRelativeLayout;
    private ImageView mRefreshBallImage;

    private AnimationDrawable mRefreshDrawable;

    private boolean isRefreshingFlag = false;

    private static final String TAG = "PandaRefreshHeader";

    public PandaRefreshHeader(Context context) {
        this(context, null);
    }

    public PandaRefreshHeader(Context context, AttributeSet attrs) {
        super(context, attrs);

        inflate(context, R.layout.header_panda, this);

        mRefreshImage = (ImageView) findViewById(R.id.refresh_drawable);
        mRefreshBallImage = (ImageView) findViewById(R.id.refresh_ball);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.panda_header);
        mRefreshImage.setBackgroundResource(R.drawable.frame_anim);
        mRefreshDrawable = (AnimationDrawable) mRefreshImage.getBackground();
        mRefreshDrawable.start();
        mRefreshBallImage.setVisibility(VISIBLE);
    }

    @Override
    public void reset() {

    }

    @Override
    public void pull() {
        mRefreshImage.setBackgroundResource(R.drawable.frame_anim);
        mRefreshDrawable = (AnimationDrawable) mRefreshImage.getBackground();
        mRefreshDrawable.start();
        mRefreshBallImage.setImageResource(R.drawable.common_listview_pull_down_ball);
        mRefreshBallImage.setBackgroundDrawable(null);
//        mRefreshBallImage.setVisibility(VISIBLE);
        mRefreshImage.setVisibility(VISIBLE);
    }

    @Override
    public void refreshing() {
        isRefreshingFlag = true;
        mRefreshImage.setVisibility(INVISIBLE);
        mRefreshBallImage.setImageDrawable(null);
        mRefreshBallImage.setBackgroundResource(R.drawable.frame_animing);
        mRefreshDrawable = (AnimationDrawable) mRefreshBallImage.getBackground();
        if(!mRefreshDrawable.isRunning()){
            mRefreshDrawable.start();
        }
//        mRefreshBallImage.setVisibility(INVISIBLE);
    }

    @Override
    public void onPositionChange(float currentPos, float lastPos, float refreshPos, boolean isTouch, State state) {
    // 往上拉
        if (currentPos < refreshPos && lastPos >= refreshPos) {
            if (isTouch && state == State.PULL) {

            }
            // 往下拉
        } else if (currentPos > refreshPos && lastPos <= refreshPos) {
            if (isTouch && state == State.PULL) {

            }
        }
        if(currentPos >= 210){
            RelativeLayout.LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                    (int)currentPos);
            mRelativeLayout.setLayoutParams(params);
        }

    }

    @Override
    public void complete() {
        isRefreshingFlag = false;
        RelativeLayout.LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                mRefreshImage.getHeight());
        mRelativeLayout.setLayoutParams(params);
    }

    @Override
    public boolean isRefreshing() {
        return isRefreshingFlag;
    }
    public static float px2dp(Context context, float pxVal) {

        final float scale = context.getResources().getDisplayMetrics().density;
        return (pxVal / scale);

    }
}
