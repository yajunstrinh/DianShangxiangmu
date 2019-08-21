package bawei.com.rikao11.presenter;

import bawei.com.rikao11.data.bean.DingBean;
import bawei.com.rikao11.model.DingModel;
import bawei.com.rikao11.view.interfacece.Constans;

/*
 *@Auther:张亚军
 *@Date: 2019/8/16
 *@Time:9:27
 *@Description:15901514581
 * */public class DingPresenter extends BasePresenter<Constans.dingView>{
     public void dingpresenter(int status,int page,int count){
         DingModel dingModel = new DingModel();
         dingModel.Dingmodel(status,page,count,new Constans.CallBackding() {
             @Override
             public void callDing(DingBean dingBean) {
                 getView().dingRegin(dingBean);
             }
         });
     }
}
