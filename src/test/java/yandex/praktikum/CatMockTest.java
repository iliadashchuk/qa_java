package yandex.praktikum;

import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatMockTest {

    @Mock
    Feline feline;

    @Test
    public void getFoodWorksCorrectly() throws Exception{
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getSoundWorksCorrectly(){
        Cat cat = new Cat(feline);
        String actualSound = cat.getSound();
        String expectedSound = "Мяу";
        Assert.assertEquals(expectedSound, actualSound);
    }
}
