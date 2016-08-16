package com.skytree.epubtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_login);
		ButterKnife.bind(this);
		// goMain(); // FIXME: 2016. 4. 3. remove
	}

	@Bind(R.id.etId)
	EditText etId;
	@Bind(R.id.etPass)
	EditText etPass;
	@Bind(R.id.ivBeUmLogo)
	ImageView ivBeumLogo;
	@Bind(R.id.ivCosmicLogo)
	ImageView ivCosmicLogo;

	@OnClick(R.id.btnSignIn)
	void signIn() {
		String id = etId.getText().toString().trim();
		String pw = etPass.getText().toString().trim();
		if (id.equals("test") && pw.equals("1234")) {
			goMain();
		} else {
			SimpleAlert.show(this, R.string.error_signin_fail);
		}
	}

	private void goMain() {
		startActivity(new Intent(this, HomeActivity.class));
		finish();
	}

}
