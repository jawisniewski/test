import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Hebo on 08.11.2016.
 */
class dbconnectTest {
    dbconnect db;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
     db= new dbconnect();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {

            db.closeConnection();
    }
    @org.junit.jupiter.api.Test
    public void checkConnection(){
        assertNotNull(db);
    }

    @org.junit.jupiter.api.Test
    void createTable() throws Exception {
      db.dropTable();
        assertEquals(true,db.createTable());

        assertEquals(true,db.createTable());
    }
    @org.junit.jupiter.api.Test
    void dropTable() throws Exception {
        assertEquals(true,db.dropTable());

        assertEquals(true,db.dropTable());
    }

    @org.junit.jupiter.api.Test
    void insertCars() {
        db.createTable();
        Cars car = new Cars("MAN", "2010",201,"");
       boolean test= db.insertCars(car);
       assertEquals(true,test);

    }

    @org.junit.jupiter.api.Test
    void insertRun() {
        db.dropTable();
        db.createTable();
        Cars cars = new Cars ("MAN TGA","2010",200000,"");
        db.insertCars(cars);
        Run run = new Run("Poland-England","",2000,2000,1);
        boolean test= db.insertRun(run);
        assertEquals(true,test);

    }

    @org.junit.jupiter.api.Test
    void deleteRun() {
        db.dropTable();
        db.createTable();
        Cars cars = new Cars ("MAN TGA","2010",200000,"");
        db.insertCars(cars);
        Run run = new Run("Poland-England","",2000,2000,1);
        db.insertRun(run);
        boolean test=  db.deleteRun( "1" );
        assertEquals(true,test);
    }

    @org.junit.jupiter.api.Test
    void selectCars() {
        db.dropTable();
        db.createTable();
        Cars cars = new Cars ("MAN TGA","2010",200000,"");
        List<Cars> car2 = db.selectCars();
        assertEquals(0,car2.size());
        db.insertCars(cars);
        car2.addAll(db.selectCars());
      //  List<Cars> car = db.selectCars();

            assertNotEquals(0,car2.size());

    }

    @org.junit.jupiter.api.Test
    void selectRun() {
        db.dropTable();
        db.createTable();
        Cars cars = new Cars ("MAN TGA","2010",200000,"");
        db.insertCars(cars);
        Run run = new Run("Poland-England","",2000,2000,1);
        db.insertRun(run);

        List<Run> runs = db.selectRun();
assertEquals("Poland-England",runs.get(0).getName());
    }

    @org.junit.jupiter.api.Test
    void selectRunWithCar() {
        db.dropTable();
        db.createTable();
        Cars cars = new Cars ("MAN TGA","2010",200000,"");
        db.insertCars(cars);
        Run run = new Run("Poland-England","",2000,2000,1);
        db.insertRun(run);


        List<Run> carsRun= db.selectRunWithCar(1);


         assertNotNull( carsRun.size());
      }



    @org.junit.jupiter.api.Test
    void updateRun() {
        db.dropTable();
        db.createTable();
        Cars cars = new Cars ("MAN TGA","2010",200000,"");
        db.insertCars(cars);
        Cars cars2 = new Cars ("MAN TGA","2010",200000,"");
        db.insertCars(cars2);
        Run run = new Run("Poland-England","",2000,2000,1);
        db.insertRun(run);

        Boolean test=     db.updateRun(2,1);
   assertEquals(true,test);
    }

    @org.junit.jupiter.api.Test
    void updateRunDelete() {
        db.dropTable();
        db.createTable();
        Cars cars = new Cars ("MAN TGA","2010",200000,"");
        db.insertCars(cars);
        Cars cars2 = new Cars ("MAN TGX","2015",200000,"");
        db.insertCars(cars2);
        Run run = new Run("Poland-England","",2000,2000,1);
        db.insertRun(run);


        Boolean test=     db.updateRunDelete(1);
        assertEquals(true,test);
        Run run2 = new Run("Poland-France","",2000,2000,1);
        db.insertRun(run2);
        Run run3 = new Run("Poland-Greecce","",2000,4000,1);
        db.insertRun(run3);
        assertEquals(true, db.updateRunDelete(1));

        assertEquals(true, db.updateRunDelete(2));
    }

}