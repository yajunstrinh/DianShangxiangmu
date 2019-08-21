package bawei.com.rikao11.view.interfacece;

import bawei.com.rikao11.data.bean.DingBean;
import bawei.com.rikao11.data.bean.LoginBean;
import bawei.com.rikao11.data.bean.ReginBean;

/*
 *@Auther:张亚军
 *@Date: 2019/8/15
 *@Time:9:00
 *@Description:15901514581
 * */public interface Constans {
     public interface loginView{
         void showLogin(LoginBean loginBean);
     }
    public interface CallBackLogin{
        void callLogin(LoginBean string);
    }
    public interface reginView{
        void showRegin(ReginBean reginBean);
    }
    public interface CallBackRegin{
        void callRegin(ReginBean string);
    }
    public interface dingView{
        void dingRegin(DingBean dingBean);
    }
    public interface CallBackding{
        void callDing(DingBean dingBean);
}
}
