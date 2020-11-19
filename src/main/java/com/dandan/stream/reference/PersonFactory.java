package com.dandan.stream.reference;

import lombok.NoArgsConstructor;

/**
 * @date：2020/11/16
 * @author：suchao
 */
public interface PersonFactory<P extends Person> {
   P create();

   //P creat1(String firstName, String lastName);
}
