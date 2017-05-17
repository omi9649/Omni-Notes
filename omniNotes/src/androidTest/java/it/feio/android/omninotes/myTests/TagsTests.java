package it.feio.android.omninotes.myTests;

import android.support.v4.util.Pair;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import it.feio.android.omninotes.models.Note;
import it.feio.android.omninotes.models.Tag;
import it.feio.android.omninotes.utils.TagsHelper;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andy on 2017. 05. 17..
 */
public class TagsTests {

    @Test
    public void addTestTag(){
        Note n = new Note();
        n.setTitle("test");
        n.setContent("test content");
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag("first", 0));
        tags.add(new Tag("second", 1));
        tags.add(new Tag("third", 2));
        Integer [] selected = {0, 2};
        Pair<String, List<Tag>> result =  TagsHelper.addTagToNote(tags, selected, n);

        ArrayList<Tag> empty = new ArrayList<>();

        assertEquals(result.first, "first third");
        assertEquals(result.second, empty);




    }
}
