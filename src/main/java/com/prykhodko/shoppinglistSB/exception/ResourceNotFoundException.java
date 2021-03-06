//////////////////////////////////////////////////////////////
// The APIs will throw a ResourceNotFoundException whenever //
// a List with a given id is not found in the database.     //
//                                                         //
////////////////////////////////////////////////////////////

package com.prykhodko.shoppinglistSB.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Using of @ResponseStatus annotation in the above exception class.
 * This will cause Spring boot to respond with the specified HTTP status
 * code whenever this exception is thrown from the controller
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
