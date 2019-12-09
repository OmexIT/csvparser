package com.omexit.csvparser;

public class CSVReader<T> {

    private static final String DEFAULT_SEPARATOR = ",";
    private String separator;
    private FieldsetMapper<T> fieldsetMapper;

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
        return fieldsetMapper.map(new FieldSet(line.split(separator)));
    }
}