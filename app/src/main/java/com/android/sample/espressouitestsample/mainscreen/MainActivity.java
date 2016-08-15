package com.android.sample.espressouitestsample.mainscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.android.sample.espressouitestsample.BaseActivity;
import com.android.sample.espressouitestsample.R;

/**
 * Created by mayowa.adegeye on 31/05/2016.
 * todo 0 Android UI Instrumentation test with Espresso [Tutorial]
 *
 * @see <a href="http://mayojava.github.io/android/android-ui-instrumentation-test-with-espresso/?utm_source=Android+Weekly&utm_campaign=2a657cc8e1-Android_Weekly_218&utm_medium=email&utm_term=0_4eb677ad19-2a657cc8e1-338009597"></a>
 *
 * Co 2 loai test:
 * Local unit tests:
 * Integration test: chạy trên máy Android,  simulate user interactions and write functional UI tests.
 *
 */
public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setupToolbar(toolbar);

        //start fragment
        startFragment(MainFragment.newInstance());
    }
}
