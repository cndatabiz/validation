/**
 * 功能描述:
 *
 * @author tommy create on 2017-09-29-15:26
 */

package com.dataz.entity;

import com.dataz.validate.Language;

public class LanguageBean {
    @Language
    private String language;

    public String getLanguage () {
        return language;
    }

    public void setLanguage (String language) {
        this.language = language;
    }

}
