package com.dandan.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @date：2020/11/19
 * @author：suchao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EqualsObject {
    private int id ;

    private String name;


    @Override
    public int hashCode() {
        return id+name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == null || this.getClass()!=obj.getClass()){
            return false;
        }
        if (this==obj){
            return true;
        }
        EqualsObject equalsObject = (EqualsObject) obj;
        if (equalsObject.getId()==this.id && equalsObject.getName()==this.name){
            return true;
        }
        return false;
    }
}

