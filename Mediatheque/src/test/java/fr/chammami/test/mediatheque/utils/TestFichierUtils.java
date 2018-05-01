package fr.chammami.test.mediatheque.utils;

import java.nio.file.Path;

import org.junit.Assert;
import org.junit.Test;

public class TestFichierUtils {
    private static final String PATH = "src/main/resources";

    @Test
    public void testGetFichierOK() {
	Path pathObject;
	pathObject = FichierUtils.getFichier(PATH);

	Assert.assertNotNull(pathObject);
    }
}
