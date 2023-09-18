package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@QuarkusTest
public class LabSeqServiceTest {
    @Inject
    LabSeqService labSeqService;

    static List<Integer> labseqValues;

    @BeforeAll
    public static void setup(){
        labseqValues= new ArrayList<>(Arrays.asList(0, 1, 0, 1, 1, 1, 1, 2, 2, 2, 3));

    }

    @Test
    public void testLabseqInitialValues(){
        List<Integer> labseqCalculatedValues= new ArrayList<>();
        for(int i=0; i<=10;i++){
            labseqCalculatedValues.add(labSeqService.labseqMethod(i));
        }
        Assertions.assertEquals(labseqValues,labseqCalculatedValues);
    }
}
