package coop.tecso.examen.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import coop.tecso.examen.service.HolderService;

@RunWith(SpringRunner.class)
@WebMvcTest(HolderController.class)
public class HolderControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private HolderController controller;

    @Autowired
    private HolderService service;

    @Ignore
    @Test
    public void canGetAllHolders() {

    }

    @Ignore
    @Test
    public void canGetAHolderById() {

    }

    @Ignore
    @Test
    public void canCreateANaturalPersonHolder() {

    }

    @Ignore
    @Test
    public void canCreateALegalPersonHolder() {

    }

    @Ignore
    @Test
    public void canModifyANaturalPersonHolder() {

    }

    @Ignore
    @Test
    public void canModifyALegalPersonHolder() {

    }

    @Ignore
    @Test
    public void canRemoveAHolder() {

    }
}
