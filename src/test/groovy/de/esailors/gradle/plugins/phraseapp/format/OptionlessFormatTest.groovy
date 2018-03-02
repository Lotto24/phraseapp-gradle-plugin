package de.esailors.gradle.plugins.phraseapp.format

import com.mytaxi.apis.phrase.api.format.Format
import org.junit.Test

import static junit.framework.Assert.assertEquals
import static junit.framework.Assert.assertTrue

class OptionlessFormatTest {

    @Test
    void builder_should_return_format_with_name() {
        Format format = new OptionlessFormat("i18next")

        assertEquals("i18next", format.getName())
    }

    @Test
    void should_return_empty_list() {
        Format format = new OptionlessFormat("i18next")

        assertTrue(format.getOptions().isEmpty())
    }
}
