package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class Validator {
    public static List<String> validate(Address wrongAddresss) {
        List<String> notValidFields = new ArrayList<>();
        Field[] fields = wrongAddresss.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NotNull.class) && field.get(wrongAddresss) == null) {
                    notValidFields.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return notValidFields;
    }

    public static Map<String, List<String>> advancedValidate(Address wrongAddress) {
        Map<String, List<String>> notValidFields = new HashMap<>();
        Field[] fields = wrongAddress.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                String fieldValue = (String) field.get(wrongAddress);

                if (field.isAnnotationPresent(NotNull.class) && fieldValue == null) {
                    notValidFields.putIfAbsent(field.getName(), new ArrayList<>());
                    notValidFields.get(field.getName()).add("can not be null");
                } else if (field.isAnnotationPresent(MinLength.class)) {
                    int minLength = field.getAnnotation(MinLength.class).minLength();
                    if (fieldValue.length() < minLength) {
                        notValidFields.putIfAbsent(field.getName(), new ArrayList<>());
                        notValidFields.get(field.getName()).add("length less than " + minLength);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return notValidFields;
    }
}
// END
