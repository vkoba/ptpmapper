package ru.vkoba.ptpmapper;

import org.junit.Test;
import ru.vkoba.testdata.SimpleFromClass;
import ru.vkoba.testdata.SimpleToClass;

import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: Ricoshet
 * Date: 25.11.12
 * Time: 0:15
 * To change this template use File | Settings | File Templates.
 */
public class PTPMapperImplTest {
    @Test
    public void simpleMappingTest() throws Exception {
        SimpleFromClass simpleFromClass = new SimpleFromClass();
        simpleFromClass.setValue1("String");
        simpleFromClass.setValue2(100);
        simpleFromClass.setValue3(432L);
        simpleFromClass.setValue4(false);

        PTPMapper<SimpleFromClass, SimpleToClass> ptpMapper = new PTPMapperImpl<SimpleFromClass, SimpleToClass>();
        SimpleToClass simpleToClass = ptpMapper.map(simpleFromClass, SimpleToClass.class);
        assertTrue(simpleToClass.getMapValue1().equals(simpleFromClass.getValue1()));
        assertTrue(simpleToClass.getMapValue2() == simpleFromClass.getValue2());
        assertTrue(simpleToClass.getMapValue3() == simpleFromClass.getValue3());
        assertTrue(simpleToClass.isMapValue4() == simpleFromClass.isValue4());

    }
}
