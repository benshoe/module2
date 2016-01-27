import java.lang.reflect.Field;

public class MemberwiseComparable<T> {
    private final Class<T> classType;

    protected MemberwiseComparable(Class<T> classType)
    {
        this.classType = classType;
    }

    @Override
    public boolean equals(Object obj) {
        Class<?> c = classType;

        if(obj.getClass() != c) {
            return false;
        }

        do{
            Field[] fields = c.getDeclaredFields();

            for (int i = 0; i < fields.length; i++){
                fields[i].setAccessible(true);

                Object thisValue, thatValue;
                try {
                    thisValue = fields[i].get(this);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return false;
                }
                try {
                    thatValue = fields[i].get(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return false;
                }
                if(!thisValue.equals(thatValue)){
                    return false;
                }
            }

            c = c.getSuperclass();
        } while(c != null);

        return true;
    }

    // In real application it is required to provide implementation for hashCode() as well;
    // It goes beyond the scope of this discussion question
   /*
   @Override
   public int hashCode()
   {
       ...
   }*/

}