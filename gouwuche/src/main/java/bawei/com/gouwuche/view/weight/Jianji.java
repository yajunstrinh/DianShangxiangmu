package bawei.com.gouwuche.view.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import bawei.com.gouwuche.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 *@Auther:张亚军
 *@Date: 2019/8/14
 *@Time:11:48
 *@Description:15901514581
 * */public class Jianji extends LinearLayout {
    @BindView(R.id.jian_weight)
    TextView mJianWeight;
    @BindView(R.id.num_weight)
    TextView mNumWeight;
    @BindView(R.id.jia_weight)
    TextView mJiaWeight;
    private int Num=1;

    public Jianji(Context context) {
        super(context);
    }

    public Jianji(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.weightview, this);
        ButterKnife.bind(this,view);
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        this.Num = num;
        mNumWeight.setText(Num+"");
    }

    @OnClick({R.id.jian_weight, R.id.jia_weight})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jian_weight:
                        Num--;
                        if(Num<2){
                            Toast.makeText(getContext(), "没了", Toast.LENGTH_SHORT).show();
                        }else{
                            if(onCalicttener!=null){
                                onCalicttener.oncal(Num);
                            }
                        }

                break;
            case R.id.jia_weight:
                Num++;
                if(onCalicttener!=null){
                    onCalicttener.oncal(Num);
                }
                break;
        }
    }
    public interface OnCalicttener{
        void oncal(int Num);
    }
    OnCalicttener onCalicttener;
    public void setOnCalicttener(OnCalicttener onCalicttener){
        this.onCalicttener=onCalicttener;
    }
}
