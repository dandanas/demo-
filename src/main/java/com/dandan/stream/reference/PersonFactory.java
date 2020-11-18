package com.dandan.stream.reference;

/**
 * @date：2020/11/16
 * @author：suchao
 */
public interface PersonFactory<P extends Person> {
   P create();
}
