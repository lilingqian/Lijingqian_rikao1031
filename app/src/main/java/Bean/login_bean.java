package Bean;

/**
 * Created by lenovo on 2017/10/21.
 */

public class login_bean {


    /**
     * msg : 登录成功
     * code : 0
     * data : {"age":null,"createtime":"2017-10-19T00:00:00","gender":0,"icon":null,"mobile":"17601615389","money":0,"nickname":null,"password":"113456","uid":915,"username":"17601615389"}
     */

    public String msg;
    public String code;
    public DataBean data;

    public static class DataBean {
        /**
         * age : null
         * createtime : 2017-10-19T00:00:00
         * gender : 0
         * icon : null
         * mobile : 17601615389
         * money : 0
         * nickname : null
         * password : 113456
         * uid : 915
         * username : 17601615389
         */

        public Object age;
        public String createtime;
        public int gender;
        public Object icon;
        public String mobile;
        public int money;
        public Object nickname;
        public String password;
        public int uid;
        public String username;
    }
}
