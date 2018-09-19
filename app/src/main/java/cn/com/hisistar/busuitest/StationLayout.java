package cn.com.hisistar.busuitest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

/**
 * @author lxj
 * @date 2018/9/10
 */
public class StationLayout extends ViewGroup {
    private static final String TAG = "StationLayout";

    private Paint mPaint;

    private int marginLeft;
    private int marginTop;
    private int marginRight;
    private int marginBottom;

    public StationLayout(Context context) {
        super(context);
    }

    public StationLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        setWillNotDraw(false);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e(TAG, "onLayout: "+"l="+l+" ");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(500,500,100,mPaint);
    }
}
