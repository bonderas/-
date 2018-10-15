import org.junit.Test;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetClassNumber() {
       int a = this.getClassNumber();
       if (a > 45) {
            System.out.println("Метод возвращает число больше 45");
        }else {
            System.out.println("Метод НЕ возвращает число больше 45");
        }
    }
}
