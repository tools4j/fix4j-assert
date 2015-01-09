package org.fix4j.spec.fix50sp2;

import org.fix4j.test.fixspec.BaseFieldAndGroupTypes;
import org.fix4j.test.fixspec.BaseGroupType;

public class StandardTrailer extends BaseFieldAndGroupTypes {
    public StandardTrailer(){
        super(
            FieldTypes.SignatureLength.required(false),
            FieldTypes.Signature.required(false),
            FieldTypes.CheckSum.required(true)
        );
    }
}
