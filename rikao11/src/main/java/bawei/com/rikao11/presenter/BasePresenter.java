package bawei.com.rikao11.presenter;

import java.lang.ref.WeakReference;

/*
 *@Auther:张亚军
 *@Date: 2019/8/15
 *@Time:8:58
 *@Description:15901514581
 * */public class BasePresenter<P> {

    private WeakReference<P> weakReference;

    public void attchLogin(P p){
        weakReference = new WeakReference<>(p);
     }
     public void detachLogin(){
        weakReference.clear();
     }
     public P getView(){
        return weakReference.get();
     }
}
