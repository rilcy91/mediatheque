1. Remplir un fichier CSV avec les colonnes : 
	type;titre;description;date_ajout;date_sortie;chanteurs;chansons;duree;acteurs;realisateur;auteurs;chapitres;nb_pages
	(exemple dans le dossier src/main/resources/donnees_mediatheque.csv)
2. Mettre le chemin du fichier de données à importer au format CSV dans mediatheque-api.jar/BOOT-INF/classes/application.properties
3. Lancer le jar 'mediatheque-api.jar' (java -jar mediatheque-api) - localhost:9090
4. Lancer le projet mediatheque-angular (dans le dossier mediapp npm install puis npm start) - localhost:4200
