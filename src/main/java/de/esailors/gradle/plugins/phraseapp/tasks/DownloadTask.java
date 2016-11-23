package de.esailors.gradle.plugins.phraseapp.tasks;

import com.mytaxi.apis.phrase.api.format.JavaPropertiesFormat;
import com.mytaxi.apis.phrase.tasks.PhraseAppSyncTask;
import de.esailors.gradle.plugins.phraseapp.extension.PhraseAppExtension;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Task to download PhraseApp messages for all locales.
 *
 * @author m.winkelmann
 */
public class DownloadTask extends DefaultTask {

    public static final String TASK_NAME = "download";

    private Logger LOG = LoggerFactory.getLogger(DownloadTask.class);

    @TaskAction
    public void download() {
        PhraseAppExtension settings = getProject().getExtensions().findByType(PhraseAppExtension.class);
        settings.validate();

        LOG.info("Start DownloadTask for PhraseApp project with Id: %s ...", settings.getProjectId());
        PhraseAppSyncTask phraseAppSyncTask = new PhraseAppSyncTask(settings.getAuthToken(), settings.getProjectId());
        configure(phraseAppSyncTask, settings);
        phraseAppSyncTask.run();
        LOG.info("Finished DownloadTask for PhraseApp project with Id: $s !!!", settings.getProjectId());
    }

    private void configure(PhraseAppSyncTask phraseAppSyncTask, PhraseAppExtension settings) {
        String destinationDir = settings.getDestinationDir();
        phraseAppSyncTask.setGeneratedResourcesFoldername(destinationDir);
        LOG.info("Config: Destination is configured(else DEFAULT) - " + destinationDir);

        String messagesFolderName = settings.getDestinationMessagesDir();
        LOG.info("Config: MessageFolderName is configured - " + messagesFolderName);
        phraseAppSyncTask.setMessagesFoldername(messagesFolderName);

        String messageFilePrefix = settings.getMessageFilePrefix();
        LOG.info("Config: MessageFilePrefix is configured - " + messageFilePrefix);
        phraseAppSyncTask.setMessageFilePrefix(messageFilePrefix);

        // TODO - update Client Impl
        String messageFilePostfix = "." + settings.getFileFormat();
        LOG.info("Config: MessageFilePostfix is configured - " + messageFilePostfix);
        phraseAppSyncTask.setMessageFilePostfix(messageFilePostfix);

        // TODO - fileformat!
        String fileFormat = settings.getFileFormat();
        LOG.info("Config: format is configured - " + fileFormat);
        phraseAppSyncTask.setFormat(JavaPropertiesFormat.newBuilder().build());
    }

}
