package mvpframework.bwie.com.a1509aproject.model.IModel;

import mvpframework.bwie.com.a1509aproject.bean.BaseBean;
import mvpframework.bwie.com.a1509aproject.net.OnNetListener;

/**
 * Created by peng on 2017/11/7.
 */

public interface IRegisterModel {
    public void register(String account, String pwd, OnNetListener<BaseBean> onNetListener);
}
