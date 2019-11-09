package baza.slodycz;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;

import static org.junit.Assert.assertEquals;



public class CucumberStepsTest {

   BazaSlodyczy slodycze;
   Slodycz slodycz;
   Slodycz slodycztest;
   List list;


   @Given("An Name")
   public void an_Name() {
      slodycze = new BazaSlodyczy();
      slodycz = new Slodycz(2,"Czekolada","Słodka");
      slodycze.insert(slodycz);
   }

   @When("Search by name {string}")
   public void search_by_name(String name) {
      slodycztest = slodycze.getSingle_byName(name);
   }

   @Then("Name should be in list")
   public void name_should_be_in_list() {
      assertEquals(slodycz.getNazwa(),slodycztest.getNazwa());

   }

   @Given("An id")
   public void an_id() {
      slodycze = new BazaSlodyczy();
      slodycz = new Slodycz(2,"Czekolada","Słodka");
      slodycze.insert(slodycz);
   }

   @When("Search by {int}")
   public void search_by_id(Integer id) {
      slodycztest = slodycze.getSingle(id);
   }

   @Then("id should be in list")
   public void id_should_be_in_list() {
      assertEquals(slodycz.getId(),slodycztest.getId());
   }

   @Given("A Description")
   public void a_Description() {
      slodycze = new BazaSlodyczy();
      slodycz = new Slodycz(2,"Czekolada","Slodka");
      slodycze.insert(slodycz);
   }
   @When("Search by description {string}")
   public void search_by_description(String description) {
      slodycztest = slodycze.getSingle_byDescription(description);
   }

   @Then("Description should be in list")
   public void description_should_be_in_list() {
      assertEquals(slodycz.getId(),slodycztest.getId());
   }
   @Given("Put items in list")
   public void put_items_in_list(){
      slodycze = new BazaSlodyczy();
      slodycze.insert(new Slodycz(1,"Czekolada","Słodka"));
      slodycze.insert(new Slodycz(2,"Baton","Pawełek"));
      slodycze.insert(new Slodycz(3,"Pączek","Tłusty"));
   }

   @Given("^Get List of items to delete$")
   public void get_list_to_delete(DataTable dataTable) {
      list = dataTable.asList();

   }

   @When("Delete list of items")
   public void delete_list_of_items() {
      for (Object id:list) {
         slodycze.delete(Integer.parseInt(id.toString()));
      }
   }

   @Then("Check list is null")
   public void check_list_is_null() {
     assertEquals(true,slodycze.getAll().isEmpty());
   }
}




