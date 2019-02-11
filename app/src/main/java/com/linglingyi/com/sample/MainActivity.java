package com.linglingyi.com.sample;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.linglingyi.com.samplelibrary.Logf;
import com.linglingyi.com.samplelibrary.TitleBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> objects;
    private ConvenientBanner banner;
    private TextView index;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        objects = new ArrayList<>();

        initData();

        TitleBar titleBar = findViewById(R.id.titleBar);
        index = findViewById(R.id.index);
        viewpager = findViewById(R.id.viewpager);
//        setviewpager();
        titleBar.addTitleBarClickListener(new TitleBar.TitleBarLeftClickListener() {
            @Override
            public void onLeftclick() {
                finish();
            }
        });

        titleBar.setOnBackPressListener(new TitleBar.OnBackPressListener() {
            @Override
            public void onBackpress() {

            }
        });

        banner = findViewById(R.id.banner);

        banner.stopTurning();
        banner.setOnPageChangeListener(new MyPageChangeListener());
        banner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new NetworkImageHolderView();
            }
        }, objects);

        banner.setcurrentitem(2);
        banner.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).create();
                dialog.setMessage("save this picture!");
                dialog.setButton(AlertDialog.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
            }
        });
    }

    private void setviewpager() {
        viewpager.setAdapter(new BannerAdapter(objects));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        objects.add("https://i.loli.net/2019/01/29/5c4fbc1e7834c.jpg");
                objects.add("https://i.loli.net/2019/01/29/5c4fbc1e8a931.jpg");
                        objects.add("https://i.loli.net/2019/01/29/5c4fbc1e8dcdd.jpg");
                                objects.add("https://i.loli.net/2019/01/29/5c4fbc1e9d2b3.jpg");
                                        objects.add("https://i.loli.net/2019/01/29/5c4fbc1ea0e83.jpg");
                                                objects.add("https://i.loli.net/2019/01/29/5c4fbc1ea8f36.jpg");
                                                        objects.add("https://i.loli.net/2019/01/29/5c4fbc1eaf898.jpg");
                                                                objects.add("https://i.loli.net/2019/01/29/5c4fbc1eb2402.jpg");
                                                                        objects.add("https://i.loli.net/2019/01/29/5c4fbc1eb32ac.jpg");
    }

    /**
     * 当ViewPager中页面的状态发生改变时调用
     *
     * @author Administrator
     */
    class MyPageChangeListener implements ViewPager.OnPageChangeListener {
        private int oldPosition = 0;

        /**
         * This method will be invoked when a new page becomes selected.
         * position: Position index of the new selected page.
         */
        public void onPageSelected(int position) {
            Logf.d("dots--", "position = " + position);
            index.setText((position +1) +"/" + (objects.size()));
        }

        public void onPageScrollStateChanged(int arg0) {

        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }
    }

    public class NetworkImageHolderView implements Holder<String> {
        private PhotoView imageView;

        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.main_page_image, null);
            imageView = (PhotoView) view.findViewById(R.id.image_page);

            return view;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            Logf.w("img--", "data = " + data);
            Glide.with(MainActivity.this)
                    .load(data)
                    .placeholder(R.mipmap.ic_launcher)
                    .dontAnimate()
                    .into(imageView);
//            imageView.setImageResource(data);
        }
    }

}
