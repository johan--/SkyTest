package com.skytree.epubtest;

import com.skytree.epub.Book;
import com.skytree.epub.ItemRef;
import com.skytree.epub.KeyListener;
import com.skytree.epub.SkyDRMControl;
import com.skytree.epub.SkyProvider;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class SkyDRMActivity extends Activity {
	RelativeLayout mainView;
	SkyDRMControl sdc;
	WebView webView;
	Button debugButton0, dubugButton1,debugButton2,debugButton3;
	SkySetting skySetting;
	SkyApplication app;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		app = (SkyApplication)getApplication();
		this.makeLayout();		
	}
	
	public void makeLayout() {
		mainView = new RelativeLayout(this);
		RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.FILL_PARENT,
				RelativeLayout.LayoutParams.FILL_PARENT);
		mainView.setLayoutParams(rlp);
		
		
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT); // width,height
		params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
		params.width = LayoutParams.MATCH_PARENT;
		params.height = LayoutParams.MATCH_PARENT;
		webView = new WebView(this);
		webView.setLayoutParams(params);
		webView.getSettings().setJavaScriptEnabled(true);        
		webView.setWebViewClient(new CustomClient());
		webView.getSettings().setUseWideViewPort(false);
		webView.getSettings().setPluginState(WebSettings.PluginState.ON);
		webView.getSettings().setPluginState(WebSettings.PluginState.ON_DEMAND);
		webView.getSettings().setDomStorageEnabled(true);
		webView.getSettings().setAllowFileAccess(true);
		
		mainView.addView(webView);
		
		DisplayMetrics metrics = getResources().getDisplayMetrics();
		float density = metrics.density;
		
        RelativeLayout.LayoutParams debugButton0Param = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT); // width,height
        debugButton0 = new Button(this);
        debugButton0.setText("Debug0");        
        debugButton0Param.leftMargin = 	(int)(10*density);
        debugButton0Param.topMargin = 	(int)(25*density);
        debugButton0Param.width = 		(int)(90*density);
        debugButton0Param.height = 		(int)(40*density);
        debugButton0.setLayoutParams(debugButton0Param);
        debugButton0.setId(8080);
        debugButton0.setOnClickListener(listener);
        debugButton0.setVisibility(1);        
        mainView.addView(debugButton0);
        
        RelativeLayout.LayoutParams debugButton2Param = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT); // width,height
        debugButton2 = new Button(this);
        debugButton2.setText("Debug1");        
        debugButton2Param.leftMargin = 	(int)(250*density);
        debugButton2Param.topMargin = 	(int)(25*density);
        debugButton2Param.width = 		(int)(90*density);
        debugButton2Param.height = 		(int)(40*density);
        debugButton2.setLayoutParams(debugButton2Param);
        debugButton2.setId(8082);
        debugButton2.setOnClickListener(listener);
        mainView.addView(debugButton2);		
		
		sdc = new SkyDRMControl(this);
		setContentView(mainView);		
	}
	
	class CustomClient extends WebViewClient {
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
	}
	
	
	private OnClickListener listener=new OnClickListener(){
		@Override
		public void onClick(View arg) {
	        if (arg.getId()==8080) {
	        	
	    		SkyProvider skyProvider = new SkyProvider();
	    		skyProvider.setKeyListener(new KeyDelegate());
	    		sdc.setContentProvider(skyProvider);
	    		
	    		String path = SkySetting.getStorageDirectory() + "/books/"+"sb0000004.epub";
	        	sdc.openFile(path);
	        	
	        	
	        }else if (arg.getId()==8082) {
	        	Log.w("Epub",sdc.getBaseURL());
	        	webView.loadUrl(sdc.getURL());
	        }
			
		}
	};
	
	class KeyDelegate implements KeyListener {
		@Override
		public String getKeyForEncryptedData(String uuidForContent, String contentName, String uuidForEpub) {
			// TODO Auto-generated method stub
			String key = app.keyManager.getKey(uuidForContent,uuidForEpub);
			return key;
		}

		@Override
		public Book getBook() {
			// TODO Auto-generated method stub
			return sdc.getBook();
		}		
	}
}
