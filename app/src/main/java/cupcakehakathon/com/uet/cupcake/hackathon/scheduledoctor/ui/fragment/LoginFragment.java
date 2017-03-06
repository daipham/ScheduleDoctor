package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.R;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common.listener.Listener;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.utils.Constants;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.utils.PostDataUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.utils.ToastUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment implements Listener.loginStatus {


    private EditText edtLoginName, edtLoginPass;
    private Button btnLogin;

    private Listener.listenerLogin listenerLogin;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initVariables(Bundle saveInstanceState, View rootView) {
        edtLoginName = (EditText) rootView.findViewById(R.id.edtLoginName);
        edtLoginPass = (EditText) rootView.findViewById(R.id.edtLoginPass);
        btnLogin = (Button) rootView.findViewById(R.id.btnLogin);
    }

    @Override
    protected void initData(Bundle saveInstanceState) {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLogin();
            }
        });
    }


    public void clickLogin() {
        String name = edtLoginName.getText().toString();
        String pass = edtLoginPass.getText().toString();
        if (name.matches("")) {
            ToastUtils.quickToast(getActivity(), "Enter your name");
        } else if (pass.matches("")) {
            ToastUtils.quickToast(getActivity(), "Enter pass");
        } else {
            PostDataUtils postDataUtils = new PostDataUtils();
            postDataUtils.setLoginStatus(this);
            postDataUtils.login(getActivity(), name, pass);
        }
    }


    @Override
    public void loginSuccess(int id, int idFaculty) {
        Utils.setValueToPreferences(Constants.PREFERENCES_LOGIN, Constants.LOGIN_TRUE, getActivity());
        Utils.setValueToPreferences(Constants.PREFERENCES_LOGIN_ID, id + "", getActivity());
        Utils.setValueToPreferences(Constants.PREFERENCES_ID_FACULTY, idFaculty + "", getActivity());
        listenerLogin.startMain();
    }

    @Override
    public void loginFail() {
        ToastUtils.quickToast(getActivity(), "Some thing wrong. Please try again");
    }

    @OnClick(R.id.btnForgetPass)
    public void clickForgetPass() {
        ToastUtils.quickToast(getActivity(), "Fixing ...");
    }

    public void setListenerLogin(Listener.listenerLogin listenerLogin) {
        this.listenerLogin = listenerLogin;
    }

}
