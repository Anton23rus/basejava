package com.baseJava.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                MapStorageValueTest.class,
                MapStorageKeyTest.class,
                ArrayStorageTest.class,
                SortedArrayStorageTest.class,
                ListStorageTest.class
        })
public class RunAllTests {
}
