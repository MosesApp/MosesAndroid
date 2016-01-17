package me.mosesapp.moses;

import android.app.Application;
import android.support.v7.widget.LinearLayoutCompat;

import me.mosesapp.moses.dao.MosesDAO;
import me.mosesapp.moses.model.Group;
import me.mosesapp.moses.model.GroupUser;
import me.mosesapp.moses.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by thiago on 1/10/16.
 */
public class MosesApplication extends Application {

    private MosesDAO mMosesDAO;

    public MosesApplication(){
        super();
        this.mMosesDAO = new MosesDAO() {
            @Override
            public List<Group> getGroups() {
                Group g1 = new Group();
                g1.setName("Art Class");
                Group g2 = new Group();
                g2.setName("Moses' Friends");
                Group g3 = new Group();
                g3.setName("Skiing Meetup Group");
                Group g4 = new Group();
                g4.setName("Britney, Ashley and Me (BBFs)");
                return Arrays.asList(g1,g2,g3,g4);
            }

            @Override
            public List<User> getFriends(){
                User f1 = new User();
                f1.setName("Jonny");
                User f2 = new User();
                f2.setName("Ashley");
                User f3 = new User();
                f3.setName("Bruno");
                User f4 = new User();
                f4.setName("Britney");
                User f5 = new User();
                f5.setName("Brad");

                return Arrays.asList(f1,f2,f3,f4,f5);
            }

            @Override
            public List<GroupUser> getGroupUser(Long groupID){
                User f0 = new User();
                f0.setName("Me");
                GroupUser gu0 = new GroupUser();
                gu0.setUser(f0);
                gu0.setAdmin(true);

                User f1 = new User();
                f1.setName("Jonny");
                GroupUser gu1 = new GroupUser();
                gu1.setUser(f1);

                User f2 = new User();
                f2.setName("Ashley");
                GroupUser gu2 = new GroupUser();
                gu2.setUser(f2);

                User f3 = new User();
                f3.setName("Bruna");
                GroupUser gu3 = new GroupUser();
                gu3.setUser(f3);

                return Arrays.asList(gu0,gu1,gu2,gu3);
            }
        };
    }

    public MosesDAO getMosesDAO(){
        return mMosesDAO;
    }
}
