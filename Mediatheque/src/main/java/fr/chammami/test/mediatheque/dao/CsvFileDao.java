package fr.chammami.test.mediatheque.dao;

public abstract class CsvFileDao<T> extends FileDao<T> {
    protected static final String DEFAULT_SEPARATOR = ";";

    protected String separator;

    protected CsvFileDao() {
	super();
    }

    protected CsvFileDao(String path) {
	this(path, DEFAULT_SEPARATOR);
    }

    protected CsvFileDao(String path, String separator) {
	super(path);
	this.separator = separator;
    }
}
