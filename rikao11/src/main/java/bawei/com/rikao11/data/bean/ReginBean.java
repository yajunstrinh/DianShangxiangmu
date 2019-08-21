package bawei.com.rikao11.data.bean;

/*
 *@Auther:张亚军
 *@Date: 2019/8/15
 *@Time:8:57
 *@Description:15901514581
 * */public class ReginBean {

    /**
     * message : 该手机号已注册，不能重复注册！
     * status : 1001
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
