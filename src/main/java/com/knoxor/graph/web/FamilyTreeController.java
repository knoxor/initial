package com.knoxor.graph.web;

import com.knoxor.graph.model.Grandfather;
import com.knoxor.graph.model.Person;
import com.knoxor.graph.service.FamilyTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class FamilyTreeController {

    FamilyTreeService familyTreeService;

    @Autowired
    public FamilyTreeController(FamilyTreeService familyTreeService) {
        this.familyTreeService = familyTreeService;
    }

    @RequestMapping(value = "/familyTree/member", method = GET)
    public ResponseEntity<Iterable<Person>> createFamilyTreeMember() {
        Iterable<Person> members = familyTreeService.findAll();
        return ResponseEntity.ok(members);
    }


    @RequestMapping(value = "/familyTree/member", method = POST)
    public ResponseEntity<Person> createFamilyTreeMember(@RequestBody Grandfather member) {
        Person familyMember = familyTreeService.createFamilyMember(member);
        return ResponseEntity.ok(familyMember);
    }


    @RequestMapping(value = "/familyTree/family", method = PUT)
    public ResponseEntity<Person> updateFamilyTree(@RequestBody Person family) {
        return ResponseEntity.ok(null);
    }


    @RequestMapping(value = "/familyTree/member/{nodeId}", method = GET)
    public ResponseEntity<Person> getFamilyTree(@PathVariable("nodeId") Long nodeId) {

        return ResponseEntity.ok(familyTreeService.findMember(nodeId));
    }

    @RequestMapping(value = "/familyTree/member/{nodeId}/children", method = GET)
    public ResponseEntity<Person> getFamilyTreeChildren(@PathVariable("nodeId") String nodeId) {

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/familyTree/member/{nodeId}/parents", method = GET)
    public ResponseEntity<Person> getFamilyTreeParents(@PathVariable("nodeId") String nodeId) {

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/familyTree/{versionId}/member/{nodeId}/parents", method = GET)
    public ResponseEntity<Person> getFamilyTreeRootForVersion(@PathVariable("nodeId") String nodeId) {

        return ResponseEntity.ok(null);
    }
}
