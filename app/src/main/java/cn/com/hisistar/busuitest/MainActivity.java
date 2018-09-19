package cn.com.hisistar.busuitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BusStationView busStationView;
    int curStation;
    List<BusStation> mBusStationList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
//        initEnStations();
        busStationView = findViewById(R.id.bus_station);

        Button nextBtn = findViewById(R.id.next_btn);
        curStation = 0;
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curStation++;
                if (curStation > 80)
                    curStation = 0;
                busStationView.setCurStation(curStation);
            }
        });
        Button next10Btn = findViewById(R.id.next_10_btn);
        next10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curStation = 10;
                busStationView.setCurStation(curStation);
            }
        });
        Button resetBtn = findViewById(R.id.reset_btn);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curStation = 0;
                busStationView.setCurStation(curStation);
            }
        });
        Button zhBtn = findViewById(R.id.Zh_btn);
        zhBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curStation = 0;
                initStations();
                busStationView.setBusStationList(mBusStationList);
                busStationView.setCurStation(curStation);

            }
        });
        Button enBtn = findViewById(R.id.En_btn);
        enBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curStation = 0;
                initEnStations();
                busStationView.setBusStationList(mBusStationList);
                busStationView.setCurStation(curStation);

            }
        });
        Button zhEnBtn = findViewById(R.id.Zh_En_btn);
        zhEnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curStation = 0;
//                initZhAndEnStations();
                initStation();
                busStationView.setBusStationList(mBusStationList);
//                busStationView.setCurStation(curStation);
                busStationView.beginTest();
            }
        });
    }

    private void initStations() {
        mBusStationList.clear();
        mBusStationList.add(new BusStation("时尚创意城总站时尚创意城总站时尚创意城总站时尚创意城总站", false));
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
        mBusStationList.add(new BusStation("百门前工业区百门前工业区百门前工业区百门前工业区百门前工业区", false));
//        mBusStationList.add(new BusStation("百门前工业区", false));
    }

    private void initEnStations() {
        mBusStationList.clear();
        mBusStationList.add(new BusStation(" A man was blissfully driving alongA man was blissfully driving alongA man was blissfully driving along", false));
        mBusStationList.add(new BusStation("the highway", false));
        mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
        mBusStationList.add(new BusStation("", false));
        mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
        mBusStationList.add(new BusStation(" candy", true));
        mBusStationList.add(new BusStation("waved its paw at the two humans", false));
        mBusStationList.add(new BusStation("told the man not to worry", false));
        mBusStationList.add(new BusStation("jumped up", true));
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
        mBusStationList.add(new BusStation("the highway", true));
        mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
        mBusStationList.add(new BusStation("Easter Bunny came to back life", false));
        mBusStationList.add(new BusStation("picked up the spilled eggs and", false));
        mBusStationList.add(new BusStation(" candy", false));
        mBusStationList.add(new BusStation("waved its paw at the two humans", false));
//        mBusStationList.add(new BusStation("told the man not to worry", false));
        mBusStationList.add(new BusStation("jumped up", false));
        mBusStationList.add(new BusStation(" A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("the highway", false));
        mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across the", false));
        mBusStationList.add(new BusStation("when he saw the Easter Bunny hopping1 across theA man was blissfully driving along", true));
    }

    private void initZhAndEnStations() {
        mBusStationList.clear();
        mBusStationList.add(new BusStation("时尚创意城总站时尚创意城总站时尚创意城总站时尚创意城总站时尚创意城总站时尚创意城总站时尚创意城总站时尚创意城总站时尚创意城总站时尚创意城总站时尚创意城总站时尚创意城总站 A man was blissfully driving alongssfully driving alongssfully driving alongssfully driving alongssfully driving along", false));
        mBusStationList.add(new BusStation("时尚创意城西A man was blissfullng along", false));
        mBusStationList.add(new BusStation("时尚创意城北A man was bly driving along", false));
        mBusStationList.add(new BusStation("A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("石凹公园A man was blissfuiving along", false));
        mBusStationList.add(new BusStation("华荣综合市场", false));
        mBusStationList.add(new BusStation("桃园宾馆A man was blissfully driving along", false));
        mBusStationList.add(new BusStation("大浪行政中心A man wlly driving along", false));
//        mBusStationList.add(new BusStation("大浪大浪大浪同富裕工业区A mablissfullymablissfully driving along", false));
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
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", false));
    }

    private void initStation() {
        mBusStationList.clear();
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));
        mBusStationList.add(new BusStation("龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心龙华妇幼中心AA man was blissfully driving alongully driving alongully driving alongully driving alongully driving along", true));

    }
}
