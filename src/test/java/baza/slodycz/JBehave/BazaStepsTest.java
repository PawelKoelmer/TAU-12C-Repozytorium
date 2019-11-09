package baza.slodycz.JBehave;

import baza.slodycz.BazaSlodyczy;
import baza.slodycz.Slodycz;
import org.jbehave.core.annotations.*;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Parameters;
import org.jbehave.core.steps.Steps;


import static org.junit.Assert.assertEquals;

public class BazaStepsTest extends Steps {

    BazaSlodyczy bazaSlodyczy;
    Slodycz slodycz;

    @Given("an id equals $id")
    public void anIdEquals(int id){
    bazaSlodyczy = new BazaSlodyczy();
    bazaSlodyczy.insert(new Slodycz(id,"Czekolada","Slodka"));
    }
    @When("the item with id $id is added")
    public void get_added_item(int id){

        slodycz= bazaSlodyczy.getSingle(id);
    }
    @Then("check is in list with id equals $id")
    public void assert_is_equal(int id){

        assertEquals(id,slodycz.getId());
    }

    @Given("an Name equals $name")
    public void anNameEquals(String name){
        bazaSlodyczy = new BazaSlodyczy();
        bazaSlodyczy.insert(new Slodycz(1,name,"Slodka"));
    }
    @When("the item with name $name is added")
    public void get_added_item_by_name(String name){

        slodycz= bazaSlodyczy.getSingle_byName(name);
    }
    @Then("check is in list with name $name")
    public void assert_name_is_equal(String name){

        assertEquals(name,slodycz.getNazwa());
    }
    @Given("an Description equals $description")
    public void anDescriptionEquals(String description){
        bazaSlodyczy = new BazaSlodyczy();
        bazaSlodyczy.insert(new Slodycz(1,"Czekolada",description));
    }
    @When("the item with description $description is added")
    public void get_added_item_by_description(String description){

        slodycz= bazaSlodyczy.getSingle_byDescription(description);
    }
    @Then("check is in list with description $description")
    public void assert_description_is_equal(String description){

        assertEquals(description,slodycz.getOpis());
    }
    @Given("Create database: $items")
    public void create_database(ExamplesTable items){
        bazaSlodyczy = new BazaSlodyczy();
        for (Parameters row : items.getRowsAsParameters()) {
           int id = row.valueAs("id", Integer.class);
           String name = row.valueAs("name", String.class);
           String description = row.valueAs("description", String.class);
           bazaSlodyczy.insert(new Slodycz(id,name,description));
        }
    }
    @When("$count items in database")
    public void count_items(int count){

        assertEquals(count,bazaSlodyczy.getAll().size());
    }
    @When("Items are deleted")
    public void count_items(){
        bazaSlodyczy.getAll().clear();
    }
    @Then("table is empty")
    public void table_is_empty(){
        assertEquals(0,bazaSlodyczy.getAll().size());
    }

}
