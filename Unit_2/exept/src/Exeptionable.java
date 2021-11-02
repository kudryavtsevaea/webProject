public interface Exeptionable {
    static void method(String str) throws myExeption{
        System.out.println("Изначальный пароль: " + str);
        for (int i = 0; i < str.length(); i++){
            if (Character.isLetter(str.charAt(i)))
                throw new myExeption("Пароль не может содержать буквы!");
        }
    };
}
