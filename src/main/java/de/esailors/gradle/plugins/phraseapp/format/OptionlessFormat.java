package de.esailors.gradle.plugins.phraseapp.format;

import com.mytaxi.apis.phrase.api.format.Format;
import org.apache.http.NameValuePair;

import java.util.Collections;
import java.util.List;

public class OptionlessFormat implements Format {

    private String formatName;

    public OptionlessFormat(String formatName) {
        this.formatName = formatName;
    }

    @Override
    public String getName() {
        return formatName;
    }

    @Override
    public List<NameValuePair> getOptions() {
        return Collections.emptyList();
    }
}
