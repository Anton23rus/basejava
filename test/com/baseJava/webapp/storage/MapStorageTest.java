package com.baseJava.webapp.storage;

import com.baseJava.webapp.model.Resume;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapStorageTest extends AbstractStorageTest {
    public MapStorageTest() {
        super(new MapSorage());
    }

    @Test
    public void getAll() {
        Resume[] array = super.storage.getAll();
        assertEquals(3, array.length);
    }
}
