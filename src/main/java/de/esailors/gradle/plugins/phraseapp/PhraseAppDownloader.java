package de.esailors.gradle.plugins.phraseapp;

import com.mytaxi.apis.phrase.api.format.JavaPropertiesFormat;
import com.mytaxi.apis.phrase.tasks.PhraseAppSyncTask;
import de.esailors.gradle.plugins.phraseapp.extension.PhraseAppExtension;
import de.esailors.gradle.plugins.phraseapp.format.OptionlessFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class PhraseAppDownloader {

    private Logger LOG = LoggerFactory.getLogger(PhraseAppDownloader.class);

    private PhraseAppExtension phraseAppExtension;
    PhraseAppSyncTask phraseAppSyncTask;

    public PhraseAppDownloader(PhraseAppExtension phraseAppExtension) {
        this(phraseAppExtension, new PhraseAppSyncTask(phraseAppExtension.getAuthToken(), phraseAppExtension.getProjectId()));
    }

    public PhraseAppDownloader(PhraseAppExtension phraseAppExtension, PhraseAppSyncTask phraseAppSyncTask) {
        Objects.requireNonNull(phraseAppExtension);

        this.phraseAppExtension = phraseAppExtension;
        this.phraseAppSyncTask = phraseAppSyncTask;
    }

    public void download() {
        String destinationDir = phraseAppExtension.getDestinationDir();
        phraseAppSyncTask.setGeneratedResourcesFoldername(destinationDir);
        LOG.debug("Config: Destination is configured(else DEFAULT) - " + destinationDir);

        String messagesFolderName = phraseAppExtension.getDestinationMessagesDir();
        LOG.debug("Config: MessageFolderName is configured - " + messagesFolderName);
        phraseAppSyncTask.setMessagesFoldername(messagesFolderName);

        String messageFilePrefix = phraseAppExtension.getMessageFilePrefix();
        LOG.debug("Config: MessageFilePrefix is configured - " + messageFilePrefix);
        phraseAppSyncTask.setMessageFilePrefix(messageFilePrefix);

        // TODO - update Client Impl
        String messageFilePostfix = "." + phraseAppExtension.getFileFormat();
        LOG.debug("Config: MessageFilePostfix is configured - " + messageFilePostfix);
        phraseAppSyncTask.setMessageFilePostfix(messageFilePostfix);

        String format = phraseAppExtension.getFormat();
        LOG.debug("Config: format is configured - " + format);
        if (JavaPropertiesFormat.NAME.equals(format)) {
            phraseAppSyncTask.setFormat(JavaPropertiesFormat.newBuilder().build());
        } else {
            phraseAppSyncTask.setFormat(new OptionlessFormat(format));
        }
    }
}
