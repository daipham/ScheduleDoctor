package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common.listener;

/**
 * Created by NgocThai on 25/02/2017.
 */

public class Listener {

    public interface listenerLogin {

        void showLogin();

        void startMain();
    }

    public interface loginStatus {
        void loginSuccess(int id, int idFaculty);

        void loginFail();
    }

}
