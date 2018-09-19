package cn.com.hisistar.busuitest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lxj
 * @date 2018/9/6
 */
public class BusStationView extends View {

    private static final String TAG = "BusStationView";

    private Paint mPaint;
    private Paint mLinePaint;
    private Paint mCirclePaint;
    private Paint mNumberPaint;
    private Paint mTextZhPaint;
    private Paint mTextEnPaint;


    private float mViewWidth;
    private float mViewHeight;
    private float middleHeight;
    private float paddingTop;
    private float paddingLeft;
    private float textSizeSingle;
    private float textSizeDouble;
    private float radiusSingle;
    private float radiusDouble;
    private float lineLength;
    private float lineWidth;

    private Path mLinePath;
    private Path mCirclePath1;
    private Path mCirclePath2;
    private Path mTextPath;

    private List<BusStation> mBusStationList;
    private List<Point> mPointList;
    private List<Point> mNumberPointList;
    private List<Point> mTextZhPointList;
    private List<Point> mTextEnPointList;

    private int curStation;

    private Bitmap subwayLogo;

    private Rect logoSrc;
    private Rect logoDst;


    private boolean isTest = false;

    public BusStationView(Context context) {
        super(context);
    }

    public BusStationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mLinePaint = new Paint();
        mCirclePaint = new Paint();
        mNumberPaint = new Paint();
        mTextZhPaint = new Paint();
        mTextEnPaint = new Paint();

        mPointList = new ArrayList<>();
        mNumberPointList = new ArrayList<>();
        mTextZhPointList = new ArrayList<>();
        mTextEnPointList = new ArrayList<>();


        mBusStationList = new ArrayList<>();


        mLinePath = new Path();
        mCirclePath1 = new Path();
        mCirclePath2 = new Path();
        mTextPath = new Path();

        paddingTop = 10f;
        paddingLeft = 15f;
        radiusSingle = 15f;
        radiusDouble = 15f;

        curStation = 0;

        subwayLogo = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.logometro);
        logoSrc = new Rect(0, 0, subwayLogo.getWidth(), subwayLogo.getHeight());
        logoDst = new Rect();


//        initStations();


    }

    /*
        private void initStations() {
            mBusStationList.clear();
            mBusStationList.add(new BusStation("时尚创意城总站", false));
            mBusStationList.add(new BusStation("时尚创意城西", false));
            mBusStationList.add(new BusStation("时尚创意城北", false));
            mBusStationList.add(new BusStation("", false));
            mBusStationList.add(new BusStation("石凹公园", false));
            mBusStationList.add(new BusStation("华荣综合市场", false));
            mBusStationList.add(new BusStation("桃园宾馆", false));
            mBusStationList.add(new BusStation("大浪行政中心", false));
            mBusStationList.add(new BusStation("大浪大浪大浪同富裕工业区", false));
            mBusStationList.add(new BusStation("龙华妇幼中心", false));
            mBusStationList.add(new BusStation("羊台山", false));
            mBusStationList.add(new BusStation("大浪石观工业区", false));
            mBusStationList.add(new BusStation("赤岭头村", false));
            mBusStationList.add(new BusStation("国泰家私城", true));
            mBusStationList.add(new BusStation("西头居委会", false));
            mBusStationList.add(new BusStation("上塘村口", false));
            mBusStationList.add(new BusStation("锦绣江南", false));
            mBusStationList.add(new BusStation("中诺工业区", false));
            mBusStationList.add(new BusStation("大发埔油站", true));
            mBusStationList.add(new BusStation("坂田医院", false));
            mBusStationList.add(new BusStation("坂田地铁站", true));
            mBusStationList.add(new BusStation("杨美地铁站", true));
            mBusStationList.add(new BusStation("宏扬学校", false));
            mBusStationList.add(new BusStation("丽湖花园", false));
            mBusStationList.add(new BusStation("中海怡翠", false));
            mBusStationList.add(new BusStation("三联桥头", false));
            mBusStationList.add(new BusStation("布吉汽车站", false));
            mBusStationList.add(new BusStation("东方半岛", false));
            mBusStationList.add(new BusStation("大芬油画村", false));
            mBusStationList.add(new BusStation("百门前工业区", false));
            mBusStationList.add(new BusStation("南湾人民医院", false));
            mBusStationList.add(new BusStation("南湾街道办", false));
            mBusStationList.add(new BusStation("南岭村", false));
            mBusStationList.add(new BusStation("樟树布社区", false));
            mBusStationList.add(new BusStation("沙湾路口", false));
            mBusStationList.add(new BusStation("沙湾天桥", false));
            mBusStationList.add(new BusStation("沙湾汽车站", false));
            mBusStationList.add(new BusStation("沙岭小区", false));
            mBusStationList.add(new BusStation("丹平社区", false));
            mBusStationList.add(new BusStation("丹平人行天桥", false));
            mBusStationList.add(new BusStation("丹平金鹏物流", false));
            mBusStationList.add(new BusStation("深圳法律创意园", false));
            mBusStationList.add(new BusStation("联创科技园", false));
            mBusStationList.add(new BusStation("第三人民医院", false));
            mBusStationList.add(new BusStation("李朗国际珠宝园", false));
            mBusStationList.add(new BusStation("粤信创意园", false));
            mBusStationList.add(new BusStation("左右家私", false));
            mBusStationList.add(new BusStation("万国食品城总站", false));
            mBusStationList.add(new BusStation("时尚创意城总站", false));
            mBusStationList.add(new BusStation("时尚创意城西", false));
            mBusStationList.add(new BusStation("时尚创意城北", false));
            mBusStationList.add(new BusStation("石龙仔路口", false));
            mBusStationList.add(new BusStation("石凹公园", false));
            mBusStationList.add(new BusStation("华荣综合市场", false));
            mBusStationList.add(new BusStation("桃园宾馆", false));
            mBusStationList.add(new BusStation("大浪行政中心", false));
            mBusStationList.add(new BusStation("大浪大浪同富裕工业区", false));
            mBusStationList.add(new BusStation("龙华妇幼中心", false));
            mBusStationList.add(new BusStation("羊台山", false));
            mBusStationList.add(new BusStation("大浪石观浪石观浪石观工业区", false));
            mBusStationList.add(new BusStation("赤岭头村", false));
            mBusStationList.add(new BusStation("国泰家私城", true));
            mBusStationList.add(new BusStation("西头居委会", false));
            mBusStationList.add(new BusStation("上塘村口", false));
        }

        private void initEnStations() {

            mBusStationList.clear();
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
            mBusStationList.add(new BusStation("", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
            mBusStationList.add(new BusStation("jumped up", false));
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
            mBusStationList.add(new BusStation("Easter Bunny came to back life", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
            mBusStationList.add(new BusStation("jumped up", false));
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
            mBusStationList.add(new BusStation("Easter Bunny came to back life", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
            mBusStationList.add(new BusStation("jumped up", false));
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
            mBusStationList.add(new BusStation("Easter Bunny came to back life", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
            mBusStationList.add(new BusStation("jumped up", false));
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
            mBusStationList.add(new BusStation("Easter Bunny came to back life", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
            mBusStationList.add(new BusStation("jumped up", false));
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
            mBusStationList.add(new BusStation("Easter Bunny came to back life", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
            mBusStationList.add(new BusStation("jumped up", false));
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
            mBusStationList.add(new BusStation("Easter Bunny came to back life", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
            mBusStationList.add(new BusStation("jumped up", false));
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
            mBusStationList.add(new BusStation("Easter Bunny came to back life", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
            mBusStationList.add(new BusStation("jumped up", false));
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bun", false));
            mBusStationList.add(new BusStation("Easter Bunny came to back life", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
        }

        private void initZhAndEnStations() {
            mBusStationList.clear();
            mBusStationList.add(new BusStation("时尚创意城总站A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("时尚创意城西A man was blissfullng along", false));
            mBusStationList.add(new BusStation("时尚创意城北A man was bly driving along", false));
            mBusStationList.add(new BusStation("A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("石凹公园A man was blissfuiving along", false));
            mBusStationList.add(new BusStation("华荣综合市场", false));
            mBusStationList.add(new BusStation("桃园宾馆A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("大浪行政中心A man wlly driving along", false));
            mBusStationList.add(new BusStation("大浪大浪大浪同富裕工业区A mablissfullymablissfully driving along", false));
            mBusStationList.add(new BusStation("龙华妇幼中心A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("羊台山A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("大浪石观工业区", false));
            mBusStationList.add(new BusStation("赤岭头村A man was  driving along", false));
            mBusStationList.add(new BusStation("国泰家私城A man was  along", true));
            mBusStationList.add(new BusStation("西头居委会A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("上塘村口 man was blissfully driving along", false));
            mBusStationList.add(new BusStation("锦绣江南A  blissfully driving along", false));
            mBusStationList.add(new BusStation("中诺工业区A along", false));
            mBusStationList.add(new BusStation("大发埔油站 was blissfully driving along", true));
            mBusStationList.add(new BusStation("坂田医院A man iving along", false));
            mBusStationList.add(new BusStation("时尚创意城总站A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("时尚创意城西A man was blissfullng along", false));
           BusStationList.add(new BusStation("时尚创意城北A man was bly driving along", false));
            mBusStationList.add(new BusStation("A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("石凹公园A man was blissfuiving along", false));
            mBusStationList.add(new BusStation("华荣综合市场", false));
            mBusStationList.add(new BusStation("桃园宾馆A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("大浪行政中心A man wlly driving along", false));
            mBusStationList.add(new BusStation("大浪大浪大浪同富裕工业区A mablissfullymablissfully driving along", false));
            mBusStationList.add(new BusStation("龙华妇幼中心A man was blissfully driving along", false));
        }
    /*
        private void initStations() {
            mBusStationList.clear();
            mBusStationList.add(new BusStation("时尚创意城总站", false));
            mBusStationList.add(new BusStation("时尚创意城西", false));
            mBusStationList.add(new BusStation("时尚创意城北", false));
            mBusStationList.add(new BusStation("", false));
            mBusStationList.add(new BusStation("石凹公园", false));
            mBusStationList.add(new BusStation("华荣综合市场", false));
            mBusStationList.add(new BusStation("桃园宾馆", false));
            mBusStationList.add(new BusStation("大浪行政中心", false));
            mBusStationList.add(new BusStation("大浪大浪大浪同富裕工业区", false));
            mBusStationList.add(new BusStation("龙华妇幼中心", false));
            mBusStationList.add(new BusStation("羊台山", false));
            mBusStationList.add(new BusStation("大浪石观工业区", false));
            mBusStationList.add(new BusStation("赤岭头村", false));
            mBusStationList.add(new BusStation("国泰家私城", true));
            mBusStationList.add(new BusStation("西头居委会", false));
            mBusStationList.add(new BusStation("上塘村口", false));
            mBusStationList.add(new BusStation("锦绣江南", false));
            mBusStationList.add(new BusStation("中诺工业区", false));
            mBusStationList.add(new BusStation("大发埔油站", true));
            mBusStationList.add(new BusStation("坂田医院", false));
            mBusStationList.add(new BusStation("坂田地铁站", true));
            mBusStationList.add(new BusStation("杨美地铁站", true));
            mBusStationList.add(new BusStation("宏扬学校", false));
            mBusStationList.add(new BusStation("丽湖花园", false));
            mBusStationList.add(new BusStation("中海怡翠", false));
            mBusStationList.add(new BusStation("三联桥头", false));
            mBusStationList.add(new BusStation("布吉汽车站", false));
            mBusStationList.add(new BusStation("东方半岛", false));
            mBusStationList.add(new BusStation("大芬油画村", false));
            mBusStationList.add(new BusStation("百门前工业区", false));
            mBusStationList.add(new BusStation("南湾人民医院", false));
            mBusStationList.add(new BusStation("南湾街道办", false));
            mBusStationList.add(new BusStation("南岭村", false));
            mBusStationList.add(new BusStation("樟树布社区", false));
            mBusStationList.add(new BusStation("沙湾路口", false));
            mBusStationList.add(new BusStation("沙湾天桥", false));
            mBusStationList.add(new BusStation("沙湾汽车站", false));
            mBusStationList.add(new BusStation("沙岭小区", false));
            mBusStationList.add(new BusStation("丹平社区", false));
            mBusStationList.add(new BusStation("丹平人行天桥", false));
            mBusStationList.add(new BusStation("丹平金鹏物流", false));
            mBusStationList.add(new BusStation("深圳法律创意园", false));
            mBusStationList.add(new BusStation("联创科技园", false));
            mBusStationList.add(new BusStation("第三人民医院", false));
            mBusStationList.add(new BusStation("李朗国际珠宝园", false));
            mBusStationList.add(new BusStation("粤信创意园", false));
            mBusStationList.add(new BusStation("左右家私", false));
            mBusStationList.add(new BusStation("万国食品城总站", false));
            mBusStationList.add(new BusStation("时尚创意城总站", false));
            mBusStationList.add(new BusStation("时尚创意城西", false));
            mBusStationList.add(new BusStation("时尚创意城北", false));
            mBusStationList.add(new BusStation("石龙仔路口", false));
            mBusStationList.add(new BusStation("石凹公园", false));
            mBusStationList.add(new BusStation("华荣综合市场", false));
            mBusStationList.add(new BusStation("桃园宾馆", false));
            mBusStationList.add(new BusStation("大浪行政中心", false));
            mBusStationList.add(new BusStation("大浪大浪同富裕工业区", false));
            mBusStationList.add(new BusStation("龙华妇幼中心", false));
            mBusStationList.add(new BusStation("羊台山", false));
            mBusStationList.add(new BusStation("大浪石观浪石观浪石观工业区", false));
            mBusStationList.add(new BusStation("赤岭头村", false));
            mBusStationList.add(new BusStation("国泰家私城", true));
            mBusStationList.add(new BusStation("西头居委会", false));
            mBusStationList.add(new BusStation("上塘村口", false));
            mBusStationList.add(new BusStation("锦绣江南", false));
            mBusStationList.add(new BusStation("中诺工业区", false));
            mBusStationList.add(new BusStation("大发埔油站", true));
            mBusStationList.add(new BusStation("坂田医院", false));
            mBusStationList.add(new BusStation("坂田地铁站", true));
            mBusStationList.add(new BusStation("杨美地铁站", true));
            mBusStationList.add(new BusStation("宏扬学校", false));
            mBusStationList.add(new BusStation("丽湖花园", false));
            mBusStationList.add(new BusStation("中海怡翠", false));
            mBusStationList.add(new BusStation("三联桥头", false));
            mBusStationList.add(new BusStation("布吉汽车站", false));
            mBusStationList.add(new BusStation("东方半岛", false));
            mBusStationList.add(new BusStation("大芬油画村", false));
            mBusStationList.add(new BusStation("百门前工业区", false));
            mBusStationList.add(new BusStation("南湾人民医院", false));
            mBusStationList.add(new BusStation("南湾街道办", false));
        }

        private void initEnStations() {

            mBusStationList.clear();
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
            mBusStationList.add(new BusStation("", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
            mBusStationList.add(new BusStation("jumped up", false));
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
            mBusStationList.add(new BusStation("Easter Bunny came to back life", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
            mBusStationList.add(new BusStation("jumped up", false));
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
            mBusStationList.add(new BusStation("Easter Bunny came to back life", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
            mBusStationList.add(new BusStation("jumped up", false));
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
            mBusStationList.add(new BusStation("Easter Bunny came to back life", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
            mBusStationList.add(new BusStation("jumped up", false));
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
            mBusStationList.add(new BusStation("Easter Bunny came to back life", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
            mBusStationList.add(new BusStation("jumped up", false));
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
            mBusStationList.add(new BusStation("Easter Bunny came to back life", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
            mBusStationList.add(new BusStation("jumped up", false));
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
            mBusStationList.add(new BusStation("Easter Bunny came to back life", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
            mBusStationList.add(new BusStation("jumped up", false));
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
            mBusStationList.add(new BusStation("Easter Bunny came to back life", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
            mBusStationList.add(new BusStation("jumped up", false));
            mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
            mBusStationList.add(new BusStation("the highway", false));
            mBusStationList.add(new BusStation("when he saw the Easter Bun", false));
            mBusStationList.add(new BusStation("Easter Bunny came to back life", false));
            mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
            mBusStationList.add(new BusStation(" candy", false));
            mBusStationList.add(new BusStation("waved its paw at the two humans", false));
            mBusStationList.add(new BusStation("told the man not to worry", false));
        }
    */
    private void initZhAndEnStations() {
        mBusStationList.clear();
        mBusStationList.add(new BusStation("时尚创意城总站A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("时尚创意城西A man was blissfullng along", false));
        mBusStationList.add(new BusStation("时尚创意城北A man was bly driving along", false));
        mBusStationList.add(new BusStation("A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("石凹公园A man was blissfuiving along", false));
        mBusStationList.add(new BusStation("华荣综合市场", false));
        mBusStationList.add(new BusStation("桃园宾馆A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("大浪行政中心A man wlly driving along", false));
        mBusStationList.add(new BusStation("大浪大浪大浪同富裕工业区A mablissfullymablissfully driving along", false));
        mBusStationList.add(new BusStation("龙华妇幼中心A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("羊台山A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("大浪石观工业区", false));
        mBusStationList.add(new BusStation("赤岭头村A man was  driving along", false));
        mBusStationList.add(new BusStation("国泰家私城A man was  drivingdrivingdriving", true));
        mBusStationList.add(new BusStation("西头居委会A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("上塘村口 man was blissfully driving along", false));
        mBusStationList.add(new BusStation("锦绣江南A  blissfully driving along", false));
        mBusStationList.add(new BusStation("中诺工业区A along", false));
        mBusStationList.add(new BusStation("大发埔油站 was blissfully driving along", true));
        mBusStationList.add(new BusStation("坂田医院A man iving along", false));
        mBusStationList.add(new BusStation("时尚创意城总站A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("时尚创意城西A man was blissfullng along", false));
        mBusStationList.add(new BusStation("时尚创意城北A man was bly driving along", false));
        mBusStationList.add(new BusStation("A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("石凹公园A man was blissfuiving along", false));
        mBusStationList.add(new BusStation("华荣综合市场", false));
        mBusStationList.add(new BusStation("桃园宾馆A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("大浪行政中心A man wlly driving along", false));
        mBusStationList.add(new BusStation("大浪大浪大浪同富裕工业区A mablissfullymablissfully driving along", false));
        mBusStationList.add(new BusStation("龙华妇幼中心A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("羊台山A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("大浪石观工业区", false));
        mBusStationList.add(new BusStation("赤岭头村A man was  driving along", false));
        mBusStationList.add(new BusStation("国泰家私城A man was  along", true));
        mBusStationList.add(new BusStation("西头居委会A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("上塘村口 man was blissfully driving along", false));
        mBusStationList.add(new BusStation("锦绣江南A  blissfully driving along", false));
        mBusStationList.add(new BusStation("中诺工业区A along", false));
        mBusStationList.add(new BusStation("大发埔油站 was blissfully driving along", true));
        mBusStationList.add(new BusStation("坂田医院A man iving along", false));
        mBusStationList.add(new BusStation("时尚创意城总站A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("时尚创意城西A man was blissfullng along", false));
        mBusStationList.add(new BusStation("时尚创意城北A man was bly driving along", false));
        mBusStationList.add(new BusStation("A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("石凹公园A man was blissfuiving along", false));
        mBusStationList.add(new BusStation("华荣综合市场", false));
        mBusStationList.add(new BusStation("桃园宾馆A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("大浪行政中心A man wlly driving along", false));
        mBusStationList.add(new BusStation("大浪大浪大浪同富裕工业区A mablissfullymablissfully driving along", false));
        mBusStationList.add(new BusStation("龙华妇幼中心A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("羊台山A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("大浪石观工业区", false));
        mBusStationList.add(new BusStation("赤岭头村A man was  driving along", false));
        mBusStationList.add(new BusStation("国泰家私城A man was  along", true));
        mBusStationList.add(new BusStation("西头居委会A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("上塘村口 man was blissfully driving along", false));
        mBusStationList.add(new BusStation("锦绣江南A  blissfully driving along", false));
        mBusStationList.add(new BusStation("中诺工业区A along", false));
        mBusStationList.add(new BusStation("大发埔油站 was blissfully driving along", true));
        mBusStationList.add(new BusStation("坂田医院A man iving along", false));
        mBusStationList.add(new BusStation("时尚创意城总站A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("时尚创意城西A man was blissfullng along", false));
        mBusStationList.add(new BusStation("时尚创意城北A man was bly driving along", false));
        mBusStationList.add(new BusStation("A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("石凹公园A man was blissfuiving along", false));
        mBusStationList.add(new BusStation("华荣综合市场", false));
        mBusStationList.add(new BusStation("桃园宾馆A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("大浪行政中心A man wlly driving along", false));
        mBusStationList.add(new BusStation("大浪大浪大浪同富裕工业区A mablissfullymablissfully driving along", false));
        mBusStationList.add(new BusStation("龙华妇幼中心A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("羊台山A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("大浪石观工业区", false));
        mBusStationList.add(new BusStation("赤岭头村A man was  driving along", false));
        mBusStationList.add(new BusStation("国泰家私城A man was  along", true));
        mBusStationList.add(new BusStation("西头居委会A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("上塘村口 man was blissfully driving along", false));
        mBusStationList.add(new BusStation("锦绣江南A  blissfully driving along", false));
        mBusStationList.add(new BusStation("中诺工业区A along", false));
        mBusStationList.add(new BusStation("大发埔油站 was blissfully driving along", true));
        mBusStationList.add(new BusStation("坂田医院A man iving along", false));
    }

    public List<BusStation> getBusStationList() {
        return mBusStationList;
    }

    public void setBusStationList(List<BusStation> busStationList) {
        mBusStationList = busStationList;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.restore();

        if ((mBusStationList == null) || mBusStationList.isEmpty()) {
//            initStations();
//            initEnStations();
            initZhAndEnStations();
//            return;
        }

//        drawCoordinate(canvas);

        if (curStation > mBusStationList.size()) {
            curStation = 0;
        }

        if (mBusStationList.size() > 30) {
            drawDouble(canvas, curStation, mBusStationList.size());
        } else {
            drawSingle(canvas, curStation, mBusStationList.size());
        }
        if (isTest) {
            curStation++;
            if (curStation == mBusStationList.size()) {
                curStation = 0;
            }
            postInvalidateDelayed(5000);

        }

    }


    private void drawSingle(Canvas canvas, int nowStation, int totalStation) {
        cleanAll();
        radiusSingle = 20f;
        lineWidth = radiusSingle / 2f;
        nowStation -= 1;

        mLinePaint.setColor(Color.GRAY);
        mLinePaint.setAntiAlias(true);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setStrokeWidth(lineWidth);

        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);
//        mCirclePaint.setColor(Color.GREEN);

        mNumberPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mNumberPaint.setStrokeWidth(0);
        mNumberPaint.setTextSize(20);
        mNumberPaint.setColor(Color.WHITE);
        mNumberPaint.setAntiAlias(true);
        mNumberPaint.setTextAlign(Paint.Align.CENTER);

//        mTextZhPaint.setStyle(Paint.Style.FILL_AND_STROKE);
//        mTextZhPaint.setStrokeWidth(0);
        mTextZhPaint.setTextSize(30);
        mTextZhPaint.setColor(Color.BLACK);
        mTextZhPaint.setAntiAlias(true);
        mTextZhPaint.setTypeface(Typeface.DEFAULT_BOLD);
        mTextZhPaint.setTextAlign(Paint.Align.CENTER);

//        mTextEnPaint.setStyle(Paint.Style.FILL);
//        mTextEnPaint.setStrokeWidth(0);
        mTextEnPaint.setTextSize(25);
        mTextEnPaint.setColor(Color.BLACK);
        mTextEnPaint.setAntiAlias(true);
        mTextEnPaint.setTypeface(Typeface.DEFAULT_BOLD);
//        mTextEnPaint.setTextAlign(Paint.Align.LEFT);

        float numberOffset = getFontHeight(mNumberPaint) / 4f;
        lineLength = (mViewWidth - radiusSingle * 2 * totalStation - paddingLeft * 2) / (totalStation - 1);

        float startX = paddingLeft + radiusSingle;
        float startY = paddingTop + middleHeight + radiusSingle;
        float stopX = mViewWidth - paddingLeft - radiusSingle;
        mLinePath.moveTo(startX, startY);
        mLinePath.lineTo(stopX, startY);
        canvas.drawPath(mLinePath, mLinePaint);

        float startCx = paddingLeft + radiusSingle;
        float startCy = paddingTop + middleHeight + radiusSingle;
        float translateX = lineLength + radiusSingle * 2;

        for (int i = 0; i < totalStation; i++) {
            if (i < nowStation) {
                mCirclePath1.addCircle(startCx + translateX * i, startCy, radiusSingle, Path.Direction.CCW);
            } else if (i > nowStation) {
                mCirclePath2.addCircle(startCx + translateX * i, startCy, radiusSingle, Path.Direction.CCW);
            }
            mPointList.add(new Point(startCx + translateX * i, startCy));
//            canvas.drawCircle(paddingLeft + radiusSingle + (lineLength + radiusSingle * 2) * i, paddingTop + middleHeight + radiusSingle, radiusSingle, mCirclePaint);
        }
        mCirclePaint.setColor(Color.GRAY);
        canvas.drawPath(mCirclePath1, mCirclePaint);

        mCirclePaint.setColor(Color.RED);

        canvas.drawCircle(paddingLeft + radiusSingle + (lineLength + radiusSingle * 2) * nowStation, paddingTop + middleHeight + radiusSingle, radiusSingle, mCirclePaint);

        mCirclePaint.setColor(Color.GREEN);
        canvas.drawPath(mCirclePath2, mCirclePaint);

        for (Point point : mPointList) {
            mNumberPointList.add(new Point(point.getX(), point.getY() + numberOffset));
        }

        for (int i = 0; i < totalStation; i++) {
            String num = i + 1 + "";
            canvas.drawText(num, mNumberPointList.get(i).getX(), mNumberPointList.get(i).getY(), mNumberPaint);
        }

        BusStation busStation = mBusStationList.get(0);
        float textHeightSpace = mViewHeight - paddingTop * 1.5f - radiusSingle * 2;


        for (int i = 0; i < totalStation; i++) {
            BusStation station = mBusStationList.get(i);
            if (station.isSubway()) {
                int left = (int) (mPointList.get(i).getX() - radiusSingle);
                int top = (int) (mPointList.get(i).getY() + radiusSingle + paddingTop / 4f);
                int right = (int) (mPointList.get(i).getX() + radiusSingle);
                int bottom = (int) (mPointList.get(i).getY() + radiusSingle * 3 + paddingTop / 4f);
                logoDst.set(left, top, right, bottom);
                canvas.drawBitmap(subwayLogo, logoSrc, logoDst, mPaint);
            }
        }


        if (busStation.getNameInfo() == BusStation.CHINESE) {

            for (Point point : mPointList) {
                mTextZhPointList.add(new Point(point.getX(), point.getY() + radiusSingle + paddingTop / 4f));
            }
            drawZhStationDouble(canvas, mTextZhPointList, 0, totalStation, nowStation, textHeightSpace, radiusSingle);

        } else if (busStation.getNameInfo() == BusStation.ENGLISH) {
            for (Point point : mPointList) {
                mTextEnPointList.add(new Point(point.getX(), point.getY() + radiusSingle + paddingTop / 4f));
            }

            drawEnStationDouble(canvas, mTextEnPointList, 0, totalStation, nowStation, textHeightSpace, radiusSingle);

        } else {
            mTextZhPaint.setTextSize(22);
            mTextEnPaint.setTextSize(22);

            for (Point point : mPointList) {
                mTextZhPointList.add(new Point(point.getX() - radiusSingle / 5f * 3f, point.getY() + radiusSingle + paddingTop / 4f));
                mTextEnPointList.add(new Point(point.getX() + radiusSingle / 5f * 3f, point.getY() + radiusSingle + paddingTop / 4f));
            }

            drawZhStationDouble(canvas, mTextZhPointList, 0, totalStation, nowStation, textHeightSpace, radiusSingle);
            drawEnStationDouble(canvas, mTextEnPointList, 0, totalStation, nowStation, textHeightSpace, radiusSingle);


        }


    }

    private void drawZhStationSingle(Canvas canvas, List<Point> textZhPointList, int singleStation1, int totalStation, int nowStation, float textHeightSpace) {

    }

    private void drawEnStationSingle(Canvas canvas, List<Point> textZhPointList, int singleStation1, int totalStation, int nowStation, float textHeightSpace) {

    }

    private void drawDouble(Canvas canvas, int nowStation, int totalStation) {
        cleanAll();
        radiusDouble = 15f;
        lineWidth = radiusDouble / 2f;
        nowStation -= 1;

        mLinePaint.setColor(Color.GRAY);
        mLinePaint.setAntiAlias(true);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setStrokeWidth(lineWidth);

        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);
//        mCirclePaint.setColor(Color.GREEN);

        mNumberPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mNumberPaint.setStrokeWidth(0);
        mNumberPaint.setTextSize(15);
        mNumberPaint.setColor(Color.WHITE);
        mNumberPaint.setAntiAlias(true);
        mNumberPaint.setTextAlign(Paint.Align.CENTER);

//        mTextZhPaint.setStyle(Paint.Style.FILL_AND_STROKE);
//        mTextZhPaint.setStrokeWidth(0);
        mTextZhPaint.setTextSize(16);
        mTextZhPaint.setColor(Color.BLACK);
        mTextZhPaint.setAntiAlias(true);
        mTextZhPaint.setTypeface(Typeface.DEFAULT_BOLD);
        mTextZhPaint.setTextAlign(Paint.Align.CENTER);

//        mTextEnPaint.setStyle(Paint.Style.FILL);
//        mTextEnPaint.setStrokeWidth(0);
        mTextEnPaint.setTextSize(16);
        mTextEnPaint.setColor(Color.BLACK);
        mTextEnPaint.setAntiAlias(true);
        mTextEnPaint.setTypeface(Typeface.DEFAULT_BOLD);
//        mTextEnPaint.setTextAlign(Paint.Align.LEFT);

        float numberOffset = getFontHeight(mNumberPaint) / 4f;

        int singleStation1;
        if (totalStation % 2 == 0) {
            singleStation1 = totalStation / 2;
        } else {
            singleStation1 = (totalStation + 1) / 2;
        }

        int singleStation2 = totalStation - singleStation1;

        lineLength = (mViewWidth - radiusDouble * 2 * singleStation1 - paddingLeft * 2) / (singleStation1 - 1);

//        Log.e(TAG, "drawCircleDouble: - middleHeight / 2 =" + -middleHeight);
        float startX1 = paddingLeft + radiusDouble;
        float startY1 = mViewHeight / 2f + (-paddingTop / 2f) + (-middleHeight / 2f) + (-radiusDouble);
        float stopX1 = mViewWidth + (-paddingLeft) + (-radiusDouble);
        float stopY2 = mViewHeight / 2f + (+paddingTop / 2f) + (+middleHeight / 2f) + (+radiusDouble);
        mLinePath.moveTo(startX1, startY1);
        mLinePath.lineTo(stopX1, startY1);
        mLinePath.lineTo(stopX1, stopY2);
        mLinePath.lineTo(startX1, stopY2);
        canvas.drawPath(mLinePath, mLinePaint);

        float startCx1 = paddingLeft + radiusDouble;
        float startCy1 = mViewHeight / 2f + (-middleHeight / 2f) + (-paddingTop / 2f) + (-radiusDouble);
        float translateX1 = lineLength + radiusDouble * 2;
        for (int i = 0; i < singleStation1; i++) {
            if (i < nowStation) {
                mCirclePath1.addCircle(startCx1 + translateX1 * i, startCy1, radiusDouble, Path.Direction.CCW);
            } else if (i > nowStation) {
                mCirclePath2.addCircle(startCx1 + translateX1 * i, startCy1, radiusDouble, Path.Direction.CCW);
            }
            mPointList.add(new Point(startCx1 + translateX1 * i, startCy1));
        }

        lineLength = (mViewWidth - radiusDouble * 2 * singleStation2 - paddingLeft * 2) / (singleStation2 - 1);
        float startCx2 = mViewWidth - paddingLeft - radiusDouble;
        float startCy2 = mViewHeight / 2f + (middleHeight / 2f) + (paddingTop / 2f) + (radiusDouble);
        float translateX2 = lineLength + radiusDouble * 2;
        for (int i = singleStation1; i < totalStation; i++) {
            if (i < nowStation) {
                mCirclePath1.addCircle(startCx2 - translateX2 * (i - singleStation1), startCy2, radiusDouble, Path.Direction.CCW);
            } else if (i > nowStation) {
                mCirclePath2.addCircle(startCx2 - translateX2 * (i - singleStation1), startCy2, radiusDouble, Path.Direction.CCW);
            }
            mPointList.add(new Point(startCx2 - translateX2 * (i - singleStation1), startCy2));
        }
        mCirclePaint.setColor(Color.GRAY);
        canvas.drawPath(mCirclePath1, mCirclePaint);
        mCirclePaint.setColor(Color.RED);
        if (nowStation < singleStation1) {
            canvas.drawCircle(startCx1 + translateX1 * nowStation, startCy1, radiusDouble, mCirclePaint);
        } else {
            canvas.drawCircle(startCx2 - translateX2 * (nowStation - singleStation1), startCy2, radiusDouble, mCirclePaint);
        }
        mCirclePaint.setColor(Color.GREEN);
        canvas.drawPath(mCirclePath2, mCirclePaint);

        for (Point point : mPointList) {
            mNumberPointList.add(new Point(point.getX(), point.getY() + numberOffset));
        }

        for (int i = 0; i < totalStation; i++) {
            String num = i + 1 + "";
            canvas.drawText(num, mNumberPointList.get(i).getX(), mNumberPointList.get(i).getY(), mNumberPaint);
        }

        BusStation busStation = mBusStationList.get(0);
        float textHeightSpace = mViewHeight / 2f - (paddingTop / 4f) * 3f - radiusDouble * 2;


        for (int i = 0; i < totalStation; i++) {
            BusStation station = mBusStationList.get(i);
            if ((i < singleStation1) && station.isSubway()) {

                int left = (int) (mPointList.get(i).getX() - radiusDouble);
                int top = (int) (mPointList.get(i).getY() - radiusDouble * 3 - paddingTop / 4f);
                int right = (int) (mPointList.get(i).getX() + radiusDouble);
                int bottom = (int) (mPointList.get(i).getY() - radiusDouble - paddingTop / 4f);
                logoDst.set(left, top, right, bottom);
                canvas.drawBitmap(subwayLogo, logoSrc, logoDst, mPaint);

            } else if ((i >= singleStation1) && station.isSubway()) {
                int left = (int) (mPointList.get(i).getX() - radiusDouble);
                int top = (int) (mPointList.get(i).getY() + radiusDouble + paddingTop / 4f);
                int right = (int) (mPointList.get(i).getX() + radiusDouble);
                int bottom = (int) (mPointList.get(i).getY() + radiusDouble * 3 + paddingTop / 4f);
                logoDst.set(left, top, right, bottom);
                canvas.drawBitmap(subwayLogo, logoSrc, logoDst, mPaint);
            }
        }


        if (busStation.getNameInfo() == BusStation.CHINESE) {
            for (int i = 0; i < singleStation1; i++) {
                mTextZhPointList.add(new Point(mPointList.get(i).getX(), paddingTop / 4f));
            }
            for (int i = singleStation1; i < totalStation; i++) {
                mTextZhPointList.add(new Point(mPointList.get(i).getX(), mPointList.get(i).getY() + radiusDouble + paddingTop / 4f));
            }
            drawZhStationDouble(canvas, mTextZhPointList, singleStation1, totalStation, nowStation, textHeightSpace, radiusDouble);

        } else if (busStation.getNameInfo() == BusStation.ENGLISH) {
            for (int i = 0; i < singleStation1; i++) {
                mTextEnPointList.add(new Point(mPointList.get(i).getX(), paddingTop / 4f));
            }
            for (int i = singleStation1; i < totalStation; i++) {
                mTextEnPointList.add(new Point(mPointList.get(i).getX(), mPointList.get(i).getY() + radiusDouble + paddingTop / 4f));
            }
            drawEnStationDouble(canvas, mTextEnPointList, singleStation1, totalStation, nowStation, textHeightSpace, radiusDouble);

        } else {
//            mTextZhPaint.setTextSize(14);
//            mTextEnPaint.setTextSize(14);
            for (int i = 0; i < singleStation1; i++) {
                mTextZhPointList.add(new Point(mPointList.get(i).getX() - radiusDouble / 5f * 3f, paddingTop / 4f));
                mTextEnPointList.add(new Point(mPointList.get(i).getX() + radiusDouble / 5f * 3f, paddingTop / 4f));
            }
            for (int i = singleStation1; i < totalStation; i++) {
                mTextZhPointList.add(new Point(mPointList.get(i).getX() - radiusDouble / 5f * 3f, mPointList.get(i).getY() + radiusDouble + paddingTop / 4f));
                mTextEnPointList.add(new Point(mPointList.get(i).getX() + radiusDouble / 5f * 3f, mPointList.get(i).getY() + radiusDouble + paddingTop / 4f));
            }

            drawZhStationDouble(canvas, mTextZhPointList, singleStation1, totalStation, nowStation, textHeightSpace, radiusDouble);
            drawEnStationDouble(canvas, mTextEnPointList, singleStation1, totalStation, nowStation, textHeightSpace, radiusDouble);


        }


    }


    private void drawZhStationDouble(Canvas canvas, List<Point> textZhPointList, int singleStation1, int totalStation, int nowStation, float textHeightSpace, float radius) {
        float textZhHeight = getFontHeight(mTextZhPaint);

        for (int i = 0; i < totalStation; i++) {
            BusStation busStation = mBusStationList.get(i);
            String station = busStation.getStationName();

            int index = busStation.getLastZhIndex(station);
            station = station.substring(0, index);

            float zhX = textZhPointList.get(i).getX();
            float zhY = textZhPointList.get(i).getY();
            float textSpace = textHeightSpace;

            if (busStation.isSubway()) {
//                canvas.drawBitmap(subwayLogo, zhX, zhY, mPaint);
                textSpace = textHeightSpace - radius * 2 - paddingTop / 4f;
            }

            float textTotalHeight = textZhHeight * station.length();


            int maxJ = station.length();

            if ((textTotalHeight < textSpace + paddingTop / 2f) && (i < singleStation1)) {
                zhY += textSpace - textTotalHeight - paddingTop / 2f;
            }

            if ((i >= singleStation1) && busStation.isSubway()) {
                zhY += radius * 2 + paddingTop / 4f;
            }

            if (textTotalHeight > textSpace) {
                maxJ -= (textTotalHeight - textSpace) / textZhHeight;
            }

            if (i == nowStation) {
                mPaint.setColor(Color.RED);
                canvas.drawRect(zhX - textZhHeight / 2f, zhY, zhX - textZhHeight / 2f + textZhHeight, zhY + (maxJ) * textZhHeight + 4f, mPaint);
//                    if (i < singleStation1) {
//                        canvas.drawRect(x - textZhHeight / 2f, y, x - textZhHeight / 2f + textZhHeight, mViewHeight / 2 - radiusDouble * 2 - paddingTop, mPaint);
//                    } else {
//                        canvas.drawRect(x - textZhHeight / 2f, y, x - textZhHeight / 2f + textZhHeight, mViewHeight - paddingTop / 2f, mPaint);
//                    }
                mTextZhPaint.setColor(Color.WHITE);
            } else if (i < nowStation) {
                mTextZhPaint.setColor(Color.GRAY);
            } else {
                mTextZhPaint.setColor(Color.BLACK);
            }
            for (int j = 0; j < maxJ; j++) {
                canvas.drawText(station.substring(j, j + 1), zhX, zhY + textZhHeight * (j + 1), mTextZhPaint);
            }
        }
    }

    private void drawEnStationDouble(Canvas canvas, List<Point> textEnPointList, int singleStation1, int totalStation, int nowStation, float textHeightSpace, float radius) {

        float textEnHeight = getFontHeight(mTextEnPaint);

        for (int i = 0; i < totalStation; i++) {

            BusStation busStation = mBusStationList.get(i);
            String station = busStation.getStationName();

            int index = busStation.getLastZhIndex(station);
            station = station.substring(index);

            float textWidth = mTextEnPaint.measureText(station);
            float enX = textEnPointList.get(i).getX();
            float enY = textEnPointList.get(i).getY();
            float textSpace = textHeightSpace;

            if (busStation.isSubway()) {
//                canvas.drawBitmap(subwayLogo, zhX, zhY, mPaint);
                textSpace = textHeightSpace - radius * 2 - paddingTop / 4f;
            }

            if ((textWidth < textSpace) && (i < singleStation1)) {
                enY += textSpace - textWidth;
            }
            if ((i >= singleStation1) && busStation.isSubway()) {
                enY += radius * 2 + paddingTop / 4f;
            }
//                if (textWidth > textHeightSpace) {
//                    maxJ -= (textWidth - textHeightSpace) / textEnHeight + 1;
//                }

            if (i == nowStation) {
                mPaint.setColor(Color.RED);
                if (i < singleStation1) {
                    if (busStation.isSubway()) {
                        canvas.drawRect(enX - textEnHeight / 2f, enY, enX - textEnHeight / 2f + textEnHeight, mViewHeight / 2f - radius * 2 - paddingTop / 1.5f - radius * 2 - paddingTop / 4f, mPaint);
                    } else {
                        canvas.drawRect(enX - textEnHeight / 2f, enY, enX - textEnHeight / 2f + textEnHeight, mViewHeight / 2f - radius * 2 - paddingTop / 1.5f, mPaint);
                    }
                } else {
                    if (textWidth < textSpace) {
                        canvas.drawRect(enX - textEnHeight / 2f, enY, enX - textEnHeight / 2f + textEnHeight, enY + textWidth, mPaint);
                    } else {
                        canvas.drawRect(enX - textEnHeight / 2f, enY, enX - textEnHeight / 2f + textEnHeight, mViewHeight - paddingTop / 2f, mPaint);
                    }
                }
                mTextEnPaint.setColor(Color.WHITE);
            } else if (i < nowStation) {
                mTextEnPaint.setColor(Color.GRAY);
            } else {
                mTextEnPaint.setColor(Color.BLACK);
            }
            mTextPath.reset();

            if (i < singleStation1) {
                mTextPath.moveTo(enX, enY - 1);
                if (busStation.isSubway()) {
                    mTextPath.lineTo(enX, mViewHeight / 2f - radius * 2 - paddingTop - radius * 2 - paddingTop / 4f);
                } else {
                    mTextPath.lineTo(enX, mViewHeight / 2f - radius * 2 - paddingTop);
                }
            } else {
                mTextPath.moveTo(enX, enY);
                mTextPath.lineTo(enX, mViewHeight + paddingTop / 4f);
            }
            canvas.drawTextOnPath(station, mTextPath, 0, 0 + textEnHeight / 4f, mTextEnPaint);
//                canvas.drawTextOnPath(station.toCharArray(), 0, count, mTextPath, 0, 0 + textEnHeight / 4f, mTextEnPaint);
//                canvas.drawPath(mTextPath, mTextEnPaint);
        }
    }

    private void drawStationSingle(Canvas canvas, int nowStation, List<BusStation> busStationList) {

        int totalStation = busStationList.size();
        mPaint.setTextSize(25);
        float textHeight = getFontHeight(mPaint);
        mPaint.setColor(Color.RED);
        canvas.drawRect(paddingTop, paddingTop + middleHeight + radiusSingle * 2 + paddingTop, paddingTop + radiusSingle * 2, paddingTop + 7 + middleHeight + radiusSingle * 2 + textHeight * 7, mPaint);

        mPaint.setColor(Color.BLACK);
//        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTypeface(Typeface.DEFAULT_BOLD);
        for (int i = 0; i < totalStation; i++) {
            String station = busStationList.get(i).getStationName();

            for (int j = 0; j < station.length(); j++) {
                canvas.drawText(station.substring(j, j + 1), paddingTop + 1 + (lineLength + radiusSingle * 2) * i, paddingTop + 2 + middleHeight + radiusSingle * 2 + textHeight * (j + 1), mPaint);
            }

        }
        String station = "shang hai ";
        Path path = new Path();
        RectF rectF = new RectF(paddingTop + 1 + (lineLength + radiusSingle * 2) * totalStation, paddingTop + middleHeight + radiusSingle * 2 + paddingTop, paddingTop + 1 + (lineLength + radiusSingle * 2) * totalStation + radiusSingle * 2, paddingTop + 7 + middleHeight + radiusSingle * 2 + textHeight * 7);
//        path.addRect(rectF, Path.Direction.CCW);
        path.moveTo(600, 300);
        path.lineTo(600, 350);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(1f);
        canvas.drawPath(path, mPaint);
//        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(0f);
        canvas.drawTextOnPath(station, path, 0, 0, mPaint);
//        canvas.drawText(station, paddingTop + 1 + (lineLength + radiusSingle * 2) * totalStation, paddingTop + 2 + middleHeight + radiusSingle * 2 + textHeight, mPaint);


    }


    private void drawCoordinate(Canvas canvas) {
        mPaint.setColor(Color.GREEN);
        canvas.drawLine(0, mViewHeight / 2, mViewWidth, mViewHeight / 2, mPaint);
        canvas.drawLine(mViewWidth / 2, 0, mViewWidth / 2, mViewHeight, mPaint);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mViewWidth = w;
        mViewHeight = h;
//        middleHeight = h / 10f;
        middleHeight = 0;
        Log.e(TAG, "onSizeChanged: " + "mViewWidth=" + mViewWidth + "  mViewHeight=" + mViewHeight);
    }

    /**
     * 得到字体高度，用于画Y轴字体与线居中
     *
     * @param paint
     * @return
     */
    protected float getFontHeight(Paint paint) {
        Paint.FontMetrics fm = paint.getFontMetrics();
        return fm.descent - fm.ascent;
    }

    private void cleanAll() {
        mPaint.reset();
        mLinePaint.reset();
        mCirclePaint.reset();
        mNumberPaint.reset();
        mTextZhPaint.reset();
        mTextEnPaint.reset();

        mLinePath.reset();
        mCirclePath1.reset();
        mCirclePath2.reset();
        mTextPath.reset();
//        mBusStationList.clear();
        mPointList.clear();
        mNumberPointList.clear();
        mTextZhPointList.clear();
        mTextEnPointList.clear();
    }

    public int getCurStation() {
        return curStation;
    }

    public void setCurStation(int curStation) {
        this.curStation = curStation;
        invalidate();
    }

    public void beginTest() {
        isTest = true;
        invalidate();
    }


}
