package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import butterknife.ButterKnife;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.MainActivity;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.R;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common.listener.Listener;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.ui.fragment.LoginFragment;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.utils.Constants;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.utils.FragmentUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.utils.Utils;

public class LoginActivity extends BaseActivity implements Listener.listenerLogin {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void initVariables(Bundle saveInstanceState) {

    }

    @Override
    protected void initData(Bundle saveInstanceState) {

        ButterKnife.bind(this);
        // check login
        if (Utils.getValueFromPreferences(Constants.PREFERENCES_LOGIN, this) == null) {
            Utils.setValueToPreferences(Constants.PREFERENCES_LOGIN, Constants.LOGIN_FALSE, this);
        }
        if (Utils.getValueFromPreferences(Constants.PREFERENCES_LOGIN, this).equalsIgnoreCase(Constants.LOGIN_TRUE)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        // show fragment login
        LoginFragment loginFragment = new LoginFragment();
        loginFragment.setListenerLogin(this);
        FragmentUtils.addFragment(loginFragment, R.id.frmLogin, this);
    }

    @Override
    public void showLogin() {
        LoginFragment loginFragment = new LoginFragment();
        loginFragment.setListenerLogin(this);
        FragmentUtils.addFragment(loginFragment, R.id.frmLogin, this);
    }

    @Override
    public void startMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
