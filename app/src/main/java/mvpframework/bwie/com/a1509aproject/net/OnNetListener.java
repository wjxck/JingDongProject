package mvpframework.bwie.com.a1509aproject.net;

/**
 * Created by peng on 2017/11/7.
 * 网络请求回调接口
 */

public interface OnNetListener<T> {
    //成功回调
    public void onSuccess(T t);

    //失败回调
    public void onFailure(Exception e);
}
