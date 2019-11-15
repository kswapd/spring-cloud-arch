package dcits.models.logs;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 脱敏注解
 * @author Tim
 * @date  2018年5月21日 下午2:44:49
 */
@Target(value={ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SensitiveInfo {

    /**
     * 脱敏类别
     * @return
     */
    SensitiveUtils.sensitiveType Type();

}
