package baza.slodycz.api.web;

import baza.slodycz.api.domain.Slodycz;
import baza.slodycz.api.services.SlodyczManager;
import baza.slodycz.api.services.SlodyczManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
public class SlodyczeApi {

    @Autowired
    SlodyczManager slodyczManager;

    @RequestMapping("/")
    public String index() {
        try {
            slodyczManager.createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Dziala";
    }


    @GetMapping("/slodycz/{id}")
    public Slodycz getSlodycz(@PathVariable("id") int id)  {
        return slodyczManager.getSlodycz(id);
    }

    @GetMapping("/slodycze")
    public List<Slodycz> getSlodycze()  {
        return slodyczManager.getAllSlodycz();
    }

    @PutMapping(value = "/slodycz",
            params = {"name","des"}
    )
    public void addSlodycz(@RequestParam("name") String name, @RequestParam("des") String description){
            slodyczManager.addSlodycz(new Slodycz(name,description));
    }

    @PutMapping(value = "/slodycze/",
    params = {"id","name","des"})
    public void updateSlodycz(@RequestParam("id") int id,
                              @RequestParam("name") String name,
                              @RequestParam("des") String desc ){
        slodyczManager.updateSlodycz(new Slodycz(name,desc), id);
    }

    @DeleteMapping(value = "/slodycze/",
    params = {"id"})
    void deleteSlodycz(@RequestParam("id") int id) {
        slodyczManager.deleteSlodycz(id);
    }

}
