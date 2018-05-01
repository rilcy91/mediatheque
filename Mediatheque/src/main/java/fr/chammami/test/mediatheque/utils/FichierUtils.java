package fr.chammami.test.mediatheque.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class FichierUtils {
    public static final String DATE_PATTERN = "dd/MM/yyyy";

    private FichierUtils() {
	// constructeur privé pour cacher celui qui est implicite et public
    }

    public static Path getFichier(String path) {
	Path pathObject = Paths.get(path);

	if (!Files.exists(pathObject)) {
	    throw new IllegalArgumentException("Le fichier est introuvable pour le chemin spécifié : " + path);
	}

	return pathObject;
    }
}
