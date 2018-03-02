package de.esailors.gradle.plugins.phraseapp.tasks;

import de.esailors.gradle.plugins.phraseapp.PhraseAppDownloader;
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
        PhraseAppDownloader downloader = new PhraseAppDownloader(settings);
        downloader.download();
        LOG.info("... finished DownloadTask for PhraseApp project with Id: $s !!!", settings.getProjectId());
    }

}
