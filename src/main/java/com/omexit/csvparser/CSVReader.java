package com.omexit.csvparser;

import com.omexit.csvparser.annotations.AnnotationHandler;

public class CSVReader<T> {

    private static final String DEFAULT_SEPARATOR = ",";
    private String separator;
    private FieldsetMapper<T> fieldsetMapper;
    private AnnotationHandler annotationHandler=new AnnotationHandler();

    /***
     * Initialize fieldset mapper with default line separator
     *
     * @param fieldsetMapper
     */
    public CSVReader(FieldsetMapper<T> fieldsetMapper) {
        this(DEFAULT_SEPARATOR, fieldsetMapper);
    }

    /***
     * Initialize fieldset mapper and line separator
     * @param separator
     * @param fieldsetMapper
     */
    public CSVReader(String separator, FieldsetMapper<T> fieldsetMapper) {
        this.separator = separator;
        this.fieldsetMapper = fieldsetMapper;
    }

    /***
     * Parse CSV line to an object
     *
     * @param line
     * @return An object
     * @throws Exception
     */
    public T readLine(String line) throws Exception {
        T t = fieldsetMapper.map(new FieldSet(line.split(separator)));
        annotationHandler.handle(t);
        return t;
    }
}