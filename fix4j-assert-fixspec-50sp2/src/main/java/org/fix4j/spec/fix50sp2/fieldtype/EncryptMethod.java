package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class EncryptMethod extends BaseFieldType {
    public static final EncryptMethod INSTANCE = new EncryptMethod();

    private EncryptMethod() {
        super(
            "EncryptMethod",
            98,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PKCS__DES_PROPRIETARY = new Field(EncryptMethod.INSTANCE, Values.PKCS__DES_PROPRIETARY.getOrdinal());
        public final Field DES_ECB_MODE = new Field(EncryptMethod.INSTANCE, Values.DES_ECB_MODE.getOrdinal());
        public final Field PKCS_PROPRIETARY = new Field(EncryptMethod.INSTANCE, Values.PKCS_PROPRIETARY.getOrdinal());
        public final Field NONE__OTHER = new Field(EncryptMethod.INSTANCE, Values.NONE__OTHER.getOrdinal());
        public final Field PEM__DESMD5_SEE_APP_NOTE_ON_FIX_WEB_SITE = new Field(EncryptMethod.INSTANCE, Values.PEM__DESMD5_SEE_APP_NOTE_ON_FIX_WEB_SITE.getOrdinal());
        public final Field PGP__DESMD5_SEE_APP_NOTE_ON_FIX_WEB_SITE = new Field(EncryptMethod.INSTANCE, Values.PGP__DESMD5_SEE_APP_NOTE_ON_FIX_WEB_SITE.getOrdinal());
        public final Field PGP__DES_DEFUNCT = new Field(EncryptMethod.INSTANCE, Values.PGP__DES_DEFUNCT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PKCS__DES_PROPRIETARY("3"),
        DES_ECB_MODE("2"),
        PKCS_PROPRIETARY("1"),
        NONE__OTHER("0"),
        PEM__DESMD5_SEE_APP_NOTE_ON_FIX_WEB_SITE("6"),
        PGP__DESMD5_SEE_APP_NOTE_ON_FIX_WEB_SITE("5"),
        PGP__DES_DEFUNCT("4");

        private final String ordinal;

        private Values(final String ordinal) {
            this.ordinal = ordinal;
        }

        @Override
        public String getOrdinal() {
            return ordinal;
        }
    }
}
