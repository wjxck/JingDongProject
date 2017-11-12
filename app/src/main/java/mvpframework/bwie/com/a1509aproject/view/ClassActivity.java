package mvpframework.bwie.com.a1509aproject.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import mvpframework.bwie.com.a1509aproject.R;
import mvpframework.bwie.com.a1509aproject.adapter.LeftAdapter;
import mvpframework.bwie.com.a1509aproject.adapter.RightAdapter;
import mvpframework.bwie.com.a1509aproject.bean.Catagory;
import mvpframework.bwie.com.a1509aproject.bean.ProductCatagoryBean;
import mvpframework.bwie.com.a1509aproject.presenter.ClassPresenter;
import mvpframework.bwie.com.a1509aproject.utils.GlideImageLoader;
import mvpframework.bwie.com.a1509aproject.view.IView.IClassActivity;

/**
 * 分类
 */
public class ClassActivity extends AppCompatActivity implements IClassActivity {

    private ListView mLvLeft;
    private ClassPresenter classPresenter;
    private LeftAdapter adapter;
    private List<String> groupList = new ArrayList<>();//一级列表数据
    private List<List<ProductCatagoryBean.DataBean.ListBean>> childList = new ArrayList<>();//二级列表数据
    private ExpandableListView mElv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        classPresenter = new ClassPresenter(this);
        initView();
        //去P层，调用getCatagory
        classPresenter.getCatagory();

        //给listview 设置点击事件
        mLvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.press(position);
                //请求对应的右侧数据
                //先获取cid
                Catagory.DataBean dataBean = (Catagory.DataBean) parent.getItemAtPosition(position);
                int cid = dataBean.getCid();
                classPresenter.getProductCatagory(cid + "");
            }
        });

    }

    private void initView() {
        mLvLeft = (ListView) findViewById(R.id.lv_left);
        mElv = (ExpandableListView) findViewById(R.id.elv);
        Banner banner = (Banner) findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        List<String> images = new ArrayList<>();
        images.add("http://img1.imgtn.bdimg.com/it/u=594559231,2167829292&fm=27&gp=0.jpg");
        images.add("http://pic4.nipic.com/20091217/3885730_124701000519_2.jpg");
        images.add("http://pic.58pic.com/58pic/13/74/51/99d58PIC6vm_1024.jpg");
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    @Override
    public void showData(List<Catagory.DataBean> list) {
        //创建适配器
        adapter = new LeftAdapter(this, list);
        mLvLeft.setAdapter(adapter);
    }

    /**
     * 用于elv展示数据
     *
     * @param list
     */
    @Override
    public void showElvData(List<ProductCatagoryBean.DataBean> list) {
        groupList.clear();
        childList.clear();
        //给二级列表封住数据
        for (int i = 0; i < list.size(); i++) {
            ProductCatagoryBean.DataBean dataBean = list.get(i);
            groupList.add(dataBean.getName());
            childList.add(dataBean.getList());
        }
        //创建适配器
        RightAdapter rightAdapter = new RightAdapter(this, groupList, childList);
        mElv.setAdapter(rightAdapter);
        //设置默认全部展开
        for (int i = 0; i < list.size(); i++) {
            mElv.expandGroup(i);
        }
    }
}
