package me.mosesapp.moses;

import android.app.Application;

import me.mosesapp.moses.dao.MosesDAO;
import me.mosesapp.moses.model.Group;

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
        };
    }

    public MosesDAO getMosesDAO(){
        return mMosesDAO;
    }
}
