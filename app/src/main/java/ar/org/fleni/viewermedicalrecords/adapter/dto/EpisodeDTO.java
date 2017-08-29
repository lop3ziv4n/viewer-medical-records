package ar.org.fleni.viewermedicalrecords.adapter.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ar.org.fleni.viewermedicalrecords.mapper.Episode;

/**
 * Created by ivlopez on 26/09/2016.
 */
public class EpisodeDTO implements Serializable {

    /**
     * List Episode
     */
    private List<Episode> episodeList = new ArrayList<>();

    /**
     * @param episodeList type List
     */
    public EpisodeDTO(List<Episode> episodeList) {
        this.episodeList = episodeList;
    }

    /**
     * @return List
     */
    public List<Episode> getEpisodeList() {
        return episodeList;
    }

    /**
     * @param episodeList type List
     */
    public void setEpisodeList(List<Episode> episodeList) {
        this.episodeList = episodeList;
    }
}
