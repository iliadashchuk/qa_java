package yandex.praktikum;

import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionWrongSexTest {

    private  static final String EXPECTED_ERROR = "Используйте допустимые значения пола животного - самей или самка";
    private final String sex;

    @Parameterized.Parameters
    public static Object[][] gendersOfLion(){
        return new Object[][]{
                {"Сумка"},
                {"Бета-самец"},
                {"Альфа-самец"},
        };
    }

    public LionWrongSexTest(String sex){
        this.sex = sex;
    }

    @Test
    public void doesHaveManeWorksCorrectly() {
        Exception exception = Assert.assertThrows(Exception.class,
                () -> new Lion(sex, null));
        Assert.assertEquals(EXPECTED_ERROR,
                exception.getMessage());
    }
}
