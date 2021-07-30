package com.org.spring.associationmap;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/api/roles")
public class StaffRolesController {
    private final StaffRolesRepository staffrolesRepo;
    private final StaffRepository staffRepo;

    @Autowired
    public StaffRolesController(StaffRolesRepository staffrolesRepo, StaffRepository staffRepo) {
        this.staffrolesRepo = staffrolesRepo;
        this.staffRepo = staffRepo;
    }

    @PostMapping
    public ResponseEntity<StaffRoles> create(@RequestBody @Valid StaffRoles roles) {
        Optional<Staff> optionalStaff = staffRepo.findById(roles.getStaff().getId());
        if (!optionalStaff.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        roles.setStaff(optionalStaff.get());

        StaffRoles savedStaffRoles = staffrolesRepo.save(roles);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedStaffRoles.getId()).toUri();

        return ResponseEntity.created(location).body(savedStaffRoles);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<StaffRoles> update(@RequestBody @Valid StaffRoles roles, @PathVariable Integer id) {
        Optional<Staff> optionalStaff = staffRepo.findById(roles.getStaff().getId());
        if (!optionalStaff.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<StaffRoles> optionalStaffRoles = staffrolesRepo.findById(id);
        if (!optionalStaffRoles.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        roles.setStaff(optionalStaff.get());
        roles.setId(optionalStaffRoles.get().getId());
        staffrolesRepo.save(roles);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StaffRoles> delete(@PathVariable Integer id) {
        Optional<StaffRoles> optionalStaffRoles= staffrolesRepo.findById(id);
        if (!optionalStaffRoles.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        staffrolesRepo.delete(optionalStaffRoles.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<StaffRoles>> getAll(StaffRoles staffroles) {
        return ResponseEntity.ok(staffrolesRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffRoles> getById(@PathVariable Integer id) {
        Optional<StaffRoles> optionalStaffRoles = staffrolesRepo.findById(id);
        if (!optionalStaffRoles.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalStaffRoles.get());
    }
}
