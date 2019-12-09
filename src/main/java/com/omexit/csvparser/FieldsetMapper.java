package com.omexit.csvparser;

public interface FieldsetMapper<T> {

    public T map(FieldSet fieldSet) throws Exception;
}
