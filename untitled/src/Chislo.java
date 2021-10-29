public class Chislo<T extends Number> {
        private T value;

        public void setValue(T t){
            this.value = t;
        }
        public T getValue() {
            return value;
        }

        public void getAsDouble(T value){
            System.out.println(value.doubleValue());
        }

        public void getAsLong(T value){
            System.out.println(value.longValue());
        }

        public void getAsByte(T value){
            System.out.println(value.byteValue());
        }

        public void getAsFloat(T value){
            System.out.println((value.floatValue()));
        }

        public void getAsString(T value){
            System.out.println((value));
        }

        public void getAsShort(T value){
            System.out.println((value.shortValue()));
        }
}
