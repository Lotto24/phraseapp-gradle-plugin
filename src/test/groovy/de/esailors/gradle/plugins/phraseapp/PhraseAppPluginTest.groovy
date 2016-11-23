package de.esailors.gradle.plugins.phraseapp

import de.esailors.gradle.plugins.phraseapp.tasks.DownloadTask
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test
import static org.junit.Assert.*

/**
 * @author m.winkelmann
 */
class PhraseAppPluginTest {

    @Test
    public void plugin_should_add_task_download_to_project() {
        Project project = ProjectBuilder.builder().build()
        def plugins = project.getPlugins()
        plugins.apply 'de.esailors.gradle.plugins.phraseapp'
        assertTrue(project.tasks.download instanceof DownloadTask)
    }

}