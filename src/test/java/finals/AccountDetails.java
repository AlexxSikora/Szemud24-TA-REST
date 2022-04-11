package finals;
import org.json.JSONObject;

public class AccountDetails {
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

    public static final String EmptyEmailAcc = new JSONObject()
            .put("username", "")
            .put("password", "test1234")
            .toString();

    public static final String EmptyPasswordAcc = new JSONObject()
            .put("username", "alex.sikora@lppsa.com")
            .put("password", "")
            .toString();

    public static final String allBlankFieldsAcc = new JSONObject()
            .put("username", "")
            .put("password", "")
            .toString();
}
