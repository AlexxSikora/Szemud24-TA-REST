package Finals.Data;

import org.json.JSONObject;

public class LoginPathData {
    public static final String correctLoginDetails = new JSONObject()
            .put("username", "alex.sikora@lppsa.com")
            .put("password", "test1234")
            .toString();

    public static final String incorrectEmailAcc = new JSONObject()
            .put("username", "alex.sikoraa@lppsa.com")
            .put("password", "test1234")
            .toString();

    public static final String incorrectPasswordAcc = new JSONObject()
            .put("username", "alex.sikora@lppsa.com")
            .put("password", "test12344")
            .toString();

    public static final String blankEmailAcc = new JSONObject()
            .put("username", "")
            .put("password", "test1234")
            .toString();

    public static final String blankPasswordAcc = new JSONObject()
            .put("username", "alex.sikora@lppsa.com")
            .put("password", "")
            .toString();

    public static final String blankFullAcc = new JSONObject()
            .put("username", "")
            .put("password", "")
            .toString();
}
