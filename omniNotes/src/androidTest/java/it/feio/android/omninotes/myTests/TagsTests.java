package it.feio.android.omninotes.myTests;

import android.support.v4.util.Pair;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import it.feio.android.omninotes.BaseAndroidTestCase;
import it.feio.android.omninotes.models.Note;
import it.feio.android.omninotes.models.Tag;
import it.feio.android.omninotes.utils.TagsHelper;

/**
 * Created by Andy on 2017. 05. 17..
 */
public class TagsTests extends BaseAndroidTestCase {

    public void testAddTestTag(){
        Note n = new Note();
        n.setTitle("test");
        n.setContent("test content with #tag and #second");
        dbHelper.updateNote(n, true);

        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag("#first", 0));
        tags.add(new Tag("#second", 1));
        tags.add(new Tag("#third", 2));
        Integer [] selected = {0, 2};
        Pair<String, List<Tag>> result =  TagsHelper.addTagToNote(tags, selected, n);

        ArrayList<Tag> empty = new ArrayList<>();
        empty.add(new Tag("#second", 1));

        Assert.assertEquals("#first #third" , result.first);
        Assert.assertEquals(empty.size() , result.second.size());




    }
}
