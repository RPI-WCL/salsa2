package salsa.wwc.lang;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SalsaMsg {
    public int auxiliaryArgNum = 2;
}
