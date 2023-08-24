package com.example.Waivers.Controllers;
import com.example.Waivers.Entities.Waivers;
import com.example.Waivers.Services.WaiversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waivers")
public class WaiversController {
  WaiversService waiversService;
    public WaiversController(WaiversService waiversService){
        this.waiversService=waiversService;
    }

    @GetMapping
    public ResponseEntity<List<Waivers>> getAllWaivers() {
        List<Waivers> waivers = waiversService.getallWaivers();
        return new ResponseEntity<>(waivers, HttpStatus.OK);
    }

    @GetMapping({"/{waiverId}"})
    public ResponseEntity<Waivers> getaWaiver(@PathVariable Long waiverId) {
        return new ResponseEntity<>(waiversService.getWaiverById(waiverId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Waivers> saveWaiverType(@RequestBody Waivers waivers) {
        System.out.println(waivers);
        Waivers savedWaiver = waiversService.insert(waivers);
        return new ResponseEntity<>(savedWaiver, HttpStatus.CREATED);

    }

    @PutMapping({"/{waiverId}"})
    public ResponseEntity<Waivers> updateWaiver(@PathVariable("waiverId") Long waiverId, @RequestBody Waivers waivers) {
        waiversService.updateWaivers(waiverId, waivers);

        return new ResponseEntity<>(waiversService.getWaiverById(waiverId), HttpStatus.OK);


    }
}
