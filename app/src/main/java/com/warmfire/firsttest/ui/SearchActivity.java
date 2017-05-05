package com.warmfire.firsttest.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.quinny898.library.persistentsearch.SearchBox;
import com.quinny898.library.persistentsearch.SearchResult;
import com.warmfire.firsttest.R;

import java.util.ArrayList;

/**
 * Created by warmfire on 2017/5/4.
 */

public class SearchActivity extends BaseActivity {

    // 设置标题
    ImageView img_back;
    TextView txt_title;
    SearchBox searchBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setStateBarColor(this, Color.parseColor("#FF3F51B5"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
        setListener();
        setSearchBox();
    }

    public void init(){
        // 设置标题
        img_back = (ImageView) findViewById(R.id.title_back);
        txt_title = (TextView) findViewById(R.id.title_title);
        searchBox = (SearchBox) findViewById(R.id.searchbox);
    }

    public void setListener(){
        txt_title.setText("搜索框");
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void setSearchBox(){

        searchBox.enableVoiceRecognition(SearchActivity.this);
        for(int x = 0; x < 10; x++){
            SearchResult option = new SearchResult("Result " + Integer.toString(x), getResources().getDrawable(R.drawable.ic_search_black_24dp));
            searchBox.addSearchable(option);
        }
        searchBox.setLogoText("搜索");
        searchBox.setMenuListener(new SearchBox.MenuListener(){

            @Override
            public void onMenuClick() {
                //Hamburger has been clicked
                Toast.makeText(SearchActivity.this, "Menu click", Toast.LENGTH_LONG).show();
            }

        });
        searchBox.setLogoTextColor(Color.parseColor("#000000"));
        searchBox.setSearchListener(new SearchBox.SearchListener(){

            @Override
            public void onSearchOpened() {
                //Use this to tint the screen
            }

            @Override
            public void onSearchClosed() {
                //Use this to un-tint the screen
            }

            @Override
            public void onSearchTermChanged(String s) {

            }

            @Override
            public void onSearch(String searchTerm) {
                Toast.makeText(SearchActivity.this, searchTerm +" Searched", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onResultClick(SearchResult result){
                //React to a result being clicked
            }


            @Override
            public void onSearchCleared() {

            }

        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            ArrayList<String> matches = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            searchBox.populateEditText(matches.get(0));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
