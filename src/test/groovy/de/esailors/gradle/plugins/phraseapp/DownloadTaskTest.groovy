package de.esailors.gradle.plugins.phraseapp

import de.esailors.gradle.plugins.phraseapp.tasks.DownloadTask
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test
import static org.junit.Assert.*

/**
 * @author m.winkelmann
 */
class DownloadTaskTest {

    @Test
    public void should_be_able_to_add_task_to_project() {
        Project project = ProjectBuilder.builder().build()
        def task = project.task('download', type: DownloadTask)
        assertTrue(task instanceof DownloadTask)
    }

}