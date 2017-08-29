package ar.org.fleni.viewermedicalrecords.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.R;
import ar.org.fleni.viewermedicalrecords.mapper.Episode;

/**
 * Created by ivlopez on 23/09/2016.
 */
public class EpisodeFactory {

    private static EpisodeFactory factory = new EpisodeFactory();
    private List<Episode> episodes = new ArrayList<>();

    /**
     * @return EpisodeFactory
     */
    public static EpisodeFactory getInstance() {
        return factory;
    }

    /**
     *
     */
    private EpisodeFactory() {
        saveEpisode(new Episode("1115", "H", "H", "01/01/2011", "01/01/2012", "Se Fue", "1P 2A", DocumentFactory.getInstance().getDocuments().subList(0,1)));
        saveEpisode(new Episode("1116", "C", "U", "01/01/2014", "01/01/2015", "", "", DocumentFactory.getInstance().getDocuments().subList(1,2)));
        saveEpisode(new Episode("1118", "U", "U", "01/01/2015", "01/01/2016", "Se Fue", "", DocumentFactory.getInstance().getDocuments().subList(2,3)));
    }

    /**
     * @param episode type Episode
     */
    private void saveEpisode(Episode episode) {
        episodes.add(episode);
    }

    /**
     * @return List
     */
    public List<Episode> getEpisodes() {
        return episodes;
    }
}
