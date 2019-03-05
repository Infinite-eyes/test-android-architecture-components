package come.example.livedatatest;

import android.os.Bundle;

import java.math.BigDecimal;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/10/30 8:01 PM
 **/
public class MyFragment extends Fragment {


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LiveData<BigDecimal> myPriceListener;

        myPriceListener.observe(this,);

    }
}
