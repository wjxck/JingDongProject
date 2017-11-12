package mvpframework.bwie.com.a1509aproject.model.IModel;

import mvpframework.bwie.com.a1509aproject.bean.LoginBean;
import mvpframework.bwie.com.a1509aproject.net.OnNetListener;

/**
 * Created by peng on 2017/11/7.
 */

public interface ILoginModel {
    public void login(String account, String pwd, OnNetListener<LoginBean> onNetListener);
}
