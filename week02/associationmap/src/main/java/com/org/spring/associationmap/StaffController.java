package com.org.spring.associationmap;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
@RequestMapping("/api/staff")
public class StaffController {
    private final StaffRepository staffRepo;
    private final StaffRolesRepository staffrolesRepo;

    @Autowired
    public StaffController(StaffRepository staffRepo, StaffRolesRepository staffrolesRepo) {
        this.staffRepo = staffRepo;
        this.staffrolesRepo = staffrolesRepo;
    }

    @PostMapping
    public ResponseEntity<Staff> create(@Valid @RequestBody Staff staff) {
        Staff savedStaff= staffRepo.save(staff);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedStaff.getId()).toUri();

        return ResponseEntity.created(location).body(savedStaff);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Staff> update(@PathVariable Integer id, @Valid @RequestBody Staff staff) {
        Optional<Staff> optionalStaff = staffRepo.findById(id);
        if (!optionalStaff.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        staff.setId(optionalStaff.get().getId());
        staffRepo.save(staff);

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Staff> delete(@PathVariable Integer id) {
        Optional<Staff> optionalStaff = staffRepo.findById(id);
        if (!optionalStaff.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        staffRepo.delete(optionalStaff.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getById(@PathVariable Integer id) {
        Optional<Staff> optionalStaff = staffRepo.findById(id);
        if (!optionalStaff.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalStaff.get());
    }

    @GetMapping
    public ResponseEntity<List<Staff>> getAll(Staff staff) {
        return ResponseEntity.ok(staffRepo.findAll());
    }
}
