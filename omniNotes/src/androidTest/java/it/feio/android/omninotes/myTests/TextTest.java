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
        note.setTitle("checked sym");
        note.setChecklist(true);
        note.setContent("[x] content");
        Context test = new RenamingDelegatingContext(InstrumentationRegistry.getTargetContext(), "Mytest_");
        DbHelper dbHelper = DbHelper.getInstance(test);
        dbHelper.updateNote(note, true);

        Spanned [] result = TextHelper.parseTitleAndContent(test, note);

        assertEquals(result.length, 2);
        assertEquals(result[1].toString(), "✓ content");
    }
}
