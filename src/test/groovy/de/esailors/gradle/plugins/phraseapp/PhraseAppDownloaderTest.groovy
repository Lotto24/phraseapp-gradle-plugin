package de.esailors.gradle.plugins.phraseapp

import com.mytaxi.apis.phrase.api.format.Format
import com.mytaxi.apis.phrase.tasks.PhraseAppSyncTask
import de.esailors.gradle.plugins.phraseapp.extension.PhraseAppExtension
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

class PhraseAppDownloaderTest {
    public static final String AUTH_TOKEN = "authToken"
    public static final String PROJECT_ID = "projectId"

    private PhraseAppDownloader testDownloader
    private PhraseAppExtension extension
    private PhraseAppSyncTask syncTask

    @Before
    void setUp() throws Exception {
        syncTask = mock(PhraseAppSyncTask.class)
        extension = mock(PhraseAppExtension.class)
        testDownloader = new PhraseAppDownloader(extension, syncTask)
    }

    @Test
    void should_create_sync_task_constructor() {
        PhraseAppExtension extension = new PhraseAppExtension()
        extension.setAuthToken(AUTH_TOKEN)
        extension.setProjectId(PROJECT_ID)
        PhraseAppDownloader downloader = new PhraseAppDownloader(extension)

        assertNotNull(downloader.phraseAppSyncTask)
    }

    @Test
    void should_use_properties_default_format() {
        when(extension.getFormat()).thenReturn("properties")
        testDownloader.download()

        ArgumentCaptor<Format> argument = ArgumentCaptor.forClass(Format.class)
        verify(syncTask).setFormat(argument.capture())
        assertEquals("properties", argument.getValue().getName())
    }

    @Test
    void should_use_configured_format() {
        when(extension.getFormat()).thenReturn("i18next")
        testDownloader.download()

        ArgumentCaptor<Format> argument = ArgumentCaptor.forClass(Format.class)
        verify(syncTask).setFormat(argument.capture())
        assertEquals("i18next", argument.getValue().getName())
    }
}
