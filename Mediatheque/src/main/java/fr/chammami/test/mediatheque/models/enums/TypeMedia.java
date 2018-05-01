package fr.chammami.test.mediatheque.models.enums;

public enum TypeMedia {
    DVD("DVD"), CD("CD"), LIVRE("Livre"), MAGAZINE("Magazine"), UNKNOWN("Inconnu");

    private String label;

    TypeMedia(String label) {
	this.label = label;
    }

    public static TypeMedia getEnumByLabel(String label) {
	TypeMedia typeMedia;

	if (DVD.label.equalsIgnoreCase(label)) {
	    typeMedia = DVD;
	} else if (CD.label.equalsIgnoreCase(label)) {
	    typeMedia = CD;
	} else if (LIVRE.label.equalsIgnoreCase(label)) {
	    typeMedia = LIVRE;
	} else if (MAGAZINE.label.equalsIgnoreCase(label)) {
	    typeMedia = MAGAZINE;
	} else {
	    typeMedia = UNKNOWN;
	}

	return typeMedia;
    }

    public String getLabel() {
	return label;
    }
}
