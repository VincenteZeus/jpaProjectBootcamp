package com.bootcamp;

import javax.persistence.*;
import org.testng.annotations.Test;
import java.util.Properties;

public class GenerateTableTest {

    @Test
    public void generateTablesMysql() {
        Persistence.generateSchema("tpJpa", new Properties());
    }

}