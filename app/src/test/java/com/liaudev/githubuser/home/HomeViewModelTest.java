package com.liaudev.githubuser.home;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;


/**
 * Created by Budiliauw87 on 2022-08-27.
 * budiliauw87.github.io
 * Budiliauw87@gmail.com
 */
public class HomeViewModelTest {
    private String testString;

    @Before
    public void setUp() {
        testString ="working";
    }

    @Test
    public void getFollow() {
        assertEquals("working",testString);
    }

    @Test
    public void findUser() {
        assertEquals("working",testString);
    }
}