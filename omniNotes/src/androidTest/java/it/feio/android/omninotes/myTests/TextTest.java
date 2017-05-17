package it.feio.android.omninotes.myTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.test.RenamingDelegatingContext;
import android.text.Spanned;

import org.junit.Test;

import it.feio.android.omninotes.db.DbHelper;
import it.feio.android.omninotes.models.Note;
import it.feio.android.omninotes.utils.TextHelper;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andy on 2017. 05. 17..
 */
public class TextTest{

    @Test
    public void parseTitleAndContextTest(){

        Note note = new Note();
        note.setTitle("simple title");
        note.setContent("content with #tag");
        Context test = new RenamingDelegatingContext(InstrumentationRegistry.getTargetContext(), "Mytest_");
        DbHelper dbHelper = DbHelper.getInstance(test);
        dbHelper.updateNote(note, true);

        Spanned [] result = TextHelper.parseTitleAndContent(test, note);

        assertEquals(result.length, 2);

    }
}
