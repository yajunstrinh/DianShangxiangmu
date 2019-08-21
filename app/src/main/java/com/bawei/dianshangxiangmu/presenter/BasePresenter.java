package com.bawei.dianshangxiangmu.presenter;

import java.lang.ref.WeakReference;

/*
 *@Auther:张亚军
 *@Date: 2019/8/13
 *@Time:14:28
 *@Description:15901514581
 * */public class BasePresenter<P> {

    private WeakReference<P> weakReference;

    public void attchView(P p){
        weakReference = new WeakReference<>(p);
     }
     public void detachView(){
        weakReference.clear();
     }
     public P getView(){
        return weakReference.get();
     }
}
