import org.junit.Test;

public class MainClassTest extends MainClass
{


    @Test
    public void testGetLocalNumber() {
       int a = this.getLocalNumber();
       if (a ==14) {
            System.out.println("Метод возвращает число 14");
        }else {
            System.out.println("Метод НЕ возвращает число 14");
        }

    }

}
