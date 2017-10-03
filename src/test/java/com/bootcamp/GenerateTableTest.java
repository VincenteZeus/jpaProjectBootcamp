package com.bootcamp;

import javax.persistence.*;
import org.testng.annotations.Test;
import java.util.Properties;

public class GenerateTableTest {

    String puSql = "tpJpaSql";
    String puDerby= "tpJpaDerby";

    @Test
    public void generateTablesSql() {
        Persistence.generateSchema(puSql, new Properties());
    }

    @Test
    public void generateTablesDerby() {
        Persistence.generateSchema(puDerby, new Properties());
    }

}