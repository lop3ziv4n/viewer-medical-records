package ar.org.fleni.viewermedicalrecords.adapter.dto;

import java.io.Serializable;

/**
 * Created by ivlopez on 05/10/2016.
 */

public class ComponentDTO implements Serializable {

    /**
     * Recycler Item Generic ComponentDTO
     */
    private String title;

    /**
     * Recycler Item Generic ComponentDTO
     */
    private String detail;

    /**
     * @param title type String
     * @param detail type String
     */
    public ComponentDTO(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    /**
     * @return String
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title type String
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return String
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail type String
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}
