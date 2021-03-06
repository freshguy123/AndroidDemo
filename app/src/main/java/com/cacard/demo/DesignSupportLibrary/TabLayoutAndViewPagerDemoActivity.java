//package com.cacard.demo.DesignSupportLibrary;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuItem;
//
//import com.cacard.demo.R;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//
///**
// * Created by cunqingli on 2015/9/18.
// */
//public class TabLayoutAndViewPagerDemoActivity extends AppCompatActivity {
//
//    @Bind(R.id.toolBar)
//    Toolbar toolbar;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        this.setContentView(R.layout.activity_tab_layout_and_view_pager);
//        ButterKnife.bind(this);
//        // 将ToolBar作为ActionBar
//        if (toolbar != null) {
//            this.setSupportActionBar(toolbar);
//            initToolBar();
//        }
//    }
//
//    private void initToolBar() {
//        // navigation button
//        toolbar.setNavigationIcon(android.R.drawable.ic_menu_add);
//
//        // title
//        toolbar.setTitle("Title");
//
//        // Subtitle
//        toolbar.setSubtitle("Subtitle");
//
//        // logo
//        toolbar.setLogo(android.R.drawable.ic_menu_compass);
//
//        // right menu
//        // 可在menu/main.xml里设置
//        // onCreateOptionsMenu
//        // onOptionsItemSelected处理点击事件
//
//        // not work!
//        //toolbar.inflateMenu(R.menu.main);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // ! work
//        getMenuInflater().inflate(R.menu.main, menu);
//
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_settings:
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//}
