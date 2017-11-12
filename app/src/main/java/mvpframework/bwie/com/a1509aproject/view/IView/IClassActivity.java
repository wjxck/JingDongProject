package mvpframework.bwie.com.a1509aproject.view.IView;

import java.util.List;

import mvpframework.bwie.com.a1509aproject.bean.Catagory;
import mvpframework.bwie.com.a1509aproject.bean.ProductCatagoryBean;

/**
 * Created by peng on 2017/11/7.
 */

public interface IClassActivity {
    public void showData(List<Catagory.DataBean> list);

    public void showElvData(List<ProductCatagoryBean.DataBean> list);
}
