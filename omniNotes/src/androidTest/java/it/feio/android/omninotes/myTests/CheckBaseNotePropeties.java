package it.feio.android.omninotes.myTests;


import android.net.Uri;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

import it.feio.android.omninotes.models.Attachment;
import it.feio.android.omninotes.models.Category;
import it.feio.android.omninotes.models.Note;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CheckBaseNotePropeties {

    private Note test;
    private Category testCategory = new Category((long) 0, "testCategory","testDescription", "Green");
    private long id = 0;
    private long now = Calendar.getInstance().getTimeInMillis();
    private Double LAT = 47.4727579;
    private Double LON = 19.0597071;
    private ArrayList<Attachment> testList = new ArrayList<>();
    private boolean archive = true;



    @Before
    public void setUp(){
        test  = new Note();
        test.setCategory(testCategory);
        test.set_id(id);
        test.setAlarm(now);
        test.setLatitude(LAT);
        test.setLongitude(LON);
        test.setCreation(now);
        testList.add(new Attachment(Uri.EMPTY, "null"));
        test.setAttachmentsList(testList);
        test.setLastModification(now);
        test.setArchived(archive);
    }


    @Test
    public void checkNoteId(){
        assertEquals(test.get_id(), now, 0);
    }

    @Test
    public void checkNoteCategory(){
        assertEquals(test.getCategory(), testCategory);
    }

    @Test
    public void checkNoteAlarm(){
        assertEquals(test.getAlarm(), String.valueOf(now));
    }

    @Test
    public void checkNoteIdCoordinates(){
        assertEquals(test.getLatitude(), LAT);
        assertEquals(test.getLongitude(), LON);
    }


    @Test
    public void checkNoteCreation(){
        assertEquals(test.getCreation(), now, 0);
    }

    @Test
    public void checkNoteAttachment(){
        assertEquals(test.getAttachmentsList().size(), 1);
    }

    @Test
    public void checkNoteModification(){
        assertEquals(test.getLastModification(), now, 0);
        test.setTitle("UpdatedNote");
        test.setLastModification(Calendar.getInstance().getTimeInMillis());
        assertEquals(test.getLastModification(), Calendar.getInstance().getTimeInMillis(), 0);
    }

    @Test
    public void checkArchive(){
        assertNotEquals(test.isArchived(), archive);
    }
}
