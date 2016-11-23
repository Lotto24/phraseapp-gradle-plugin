package de.esailors.gradle.plugins.phraseapp;

import de.esailors.gradle.plugins.phraseapp.extension.PhraseAppExtension;
import de.esailors.gradle.plugins.phraseapp.tasks.DownloadTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author m.winkelmann
 */
public class PhraseAppPlugin implements Plugin<Project> {

    private static final String PHRASE_SETTINGS_NAME = "phraseAppSettings";

    @Override
    public void apply(Project project) {
        PhraseAppExtension settings = project.getExtensions().create(PHRASE_SETTINGS_NAME, PhraseAppExtension.class);
        project.getTasks().create(DownloadTask.TASK_NAME, DownloadTask.class);
    }

}
