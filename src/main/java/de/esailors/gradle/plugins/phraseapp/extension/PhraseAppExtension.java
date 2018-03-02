package de.esailors.gradle.plugins.phraseapp.extension;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configuration for this plugin
 *
 * @author m.winkelmann
 */
@Getter
@Setter
@ToString
public class PhraseAppExtension {

    private Logger LOG = LoggerFactory.getLogger(PhraseAppExtension.class);

    /**
     * The AuthToken you have created in your PhraseApp account to pull/push keys.
     * <p>
     * [REQUIRED]
     */
    private String authToken;

    /**
     * The internal PhraseApp project id to identify the messages you will pull/push.
     * <p>
     * [REQUIRED]
     */
    private String projectId;

    /**
     * The name of the folder the messagesDir should created.
     * <p>
     * [Optional]
     * <p>
     * Default: generated-resources
     */
    private String destinationDir = "generated-resources";

    /**
     * The name of the folder where the downloaded messages should be saved.
     * <p>
     * [Optional]
     * <p>
     * Default: messages - means a new messages folder in the {destinationDir} will be created.
     */
    private String destinationMessagesDir = "messages";

    /**
     * The prefix name of the messages files.
     * <p>
     * [Optional]
     * Default: messages_
     */
    private String messageFilePrefix = "messages_";

    /**
     * The file extension you want to download the messages keys.
     * <p>
     * [Optional]
     * Default: properties
     */
    private String fileFormat = "properties";

    /**
     * The format you want to download the messages keys. The file extension (see the fileFormat key) must match this
     * format, which is, however, not enforced.
     * [Optional]
     * Default: properties
     */
    private String format = "properties";


    public boolean isValid() {
        return authToken != null && projectId != null;
    }

    public void validate() {
        LOG.debug("Validate configuration ..");
        if (!isValid()) {
            LOG.error("Validation failed because of an invalid configuration: %s", this.toString());
            throw new IllegalArgumentException("Configuration is not valid!");
        }
        LOG.debug(".. validation of configuration successfully done!");
    }
}
