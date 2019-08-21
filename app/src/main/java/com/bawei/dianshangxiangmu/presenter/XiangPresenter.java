package com.bawei.dianshangxiangmu.presenter;

import com.bawei.dianshangxiangmu.data.Model.XiangModel;
import com.bawei.dianshangxiangmu.data.bean.XiangBean;
import com.bawei.dianshangxiangmu.view.interfacece.Constrans;

/*
 *@Auther:张亚军
 *@Date: 2019/8/15
 *@Time:17:30
 *@Description:15901514581
 * */public class XiangPresenter extends BasePresenter<Constrans.XiangView> {
     public void xingpresenter(String commodityId){
         XiangModel xiangModel = new XiangModel();
         xiangModel.XaingModel(commodityId,new Constrans.CallBackXiang() {
             @Override
             public void xiangnBack(XiangBean string) {
                 getView().xiang(string);
             }
         });
     }
}
