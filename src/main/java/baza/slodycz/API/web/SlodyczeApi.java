package baza.slodycz.api.web;

import baza.slodycz.api.domain.Slodycz;
import baza.slodycz.api.services.SlodyczManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SlodyczeApi {

    @Autowired
    SlodyczManager slodyczManager;

    @RequestMapping("/")
    public String index() {
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

    @DeleteMapping("/slodycze/{id}")
    void deleteSlodycz(@PathVariable int id) {
        slodyczManager.deleteSlodycz(id);
    }

}
