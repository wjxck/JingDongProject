package mvpframework.bwie.com.a1509aproject.presenter;

import java.util.List;

import mvpframework.bwie.com.a1509aproject.bean.Catagory;
import mvpframework.bwie.com.a1509aproject.bean.ProductCatagoryBean;
import mvpframework.bwie.com.a1509aproject.model.ClassModel;
import mvpframework.bwie.com.a1509aproject.model.IModel.IClassModel;
import mvpframework.bwie.com.a1509aproject.net.OnNetListener;
import mvpframework.bwie.com.a1509aproject.view.IView.IClassActivity;

/**
 * Created by peng on 2017/11/7.
 */

public class ClassPresenter {

    private final IClassModel iclassModel;
    private IClassActivity iClassActivity;

    public ClassPresenter(IClassActivity iClassActivity) {
        this.iClassActivity = iClassActivity;
        iclassModel = new ClassModel();
    }

    public void getProductCatagory(String cid) {
        iclassModel.getProductCatagory(cid + "", new OnNetListener<ProductCatagoryBean>() {
            @Override
            public void onSuccess(ProductCatagoryBean productCatagoryBean) {
                //给二级列表设置数据
                iClassActivity.showElvData(productCatagoryBean.getData());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    //获取分类
    public void getCatagory() {
        iclassModel.getCatagory(new OnNetListener<Catagory>() {
            @Override
            public void onSuccess(Catagory catagory) {
                iClassActivity.showData(catagory.getData());
                //拿到右侧第一条数据
                List<Catagory.DataBean> dataBean = catagory.getData();
                int cid = dataBean.get(0).getCid();
                //获取右侧的数据
                getProductCatagory(cid + "");
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
