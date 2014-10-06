package br.com.locar.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {

	private EditText usuario;
	private EditText senha;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginactivity);

		usuario = (EditText) findViewById(R.id.loginUsuario);
		senha = (EditText) findViewById(R.id.loginSenha);

		Button btnEntrar = (Button) findViewById(R.id.btnEntrar);
		btnEntrar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (usuario.getText().toString().equals("admin") && senha.getText().toString().equals("admin")) {
					startActivity(new Intent(LoginActivity.this, MainActivity.class));
				}
			}
		});

		TextView btnCadastrar = (TextView) findViewById(R.id.btnCadastrar);
		btnCadastrar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(LoginActivity.this, CadastrarNovoUsuario.class));
			}
		});
	}
}
