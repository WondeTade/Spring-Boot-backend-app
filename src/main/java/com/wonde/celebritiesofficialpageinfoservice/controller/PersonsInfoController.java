package com.wonde.celebritiesofficialpageinfoservice.controller;

import com.wonde.celebritiesofficialpageinfoservice.model.PersonsInfo;
import com.wonde.celebritiesofficialpageinfoservice.repository.PersonInfoRepository;
import com.wonde.celebritiesofficialpageinfoservice.util.FieldErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/person/")
@CrossOrigin(origins = "*")
public class PersonsInfoController {

    private PersonInfoRepository personInfoRepository;

    @Autowired
    public PersonsInfoController(PersonInfoRepository personInfoRepository) {
        this.personInfoRepository = personInfoRepository;
    }

    @GetMapping("")
    public List<PersonsInfo> getAllPersonsDetails() {

        return personInfoRepository.findAll();
    }

    @GetMapping("id/{id}")
    public PersonsInfo getPersonDetailById(@PathVariable("id") Integer id) {
        return personInfoRepository.getOne(id);
    }

    @GetMapping("{name}")
    public Optional<List<PersonsInfo>> findByFullName(@PathVariable("name") String fullName) {
        return personInfoRepository.findByFullName(fullName);
    }

    @GetMapping("status/{status}")
    public Optional<List<PersonsInfo>> findByStatus(@PathVariable("status") String status) {
        return personInfoRepository.findByMaritalStatus(status);
    }

    @PostMapping("create")
    public PersonsInfo create(@Valid @RequestBody PersonsInfo personsInfo) {
            return personInfoRepository.save(personsInfo);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<FieldErrorMessage> fieldErrorMessages =
                fieldErrors.stream()
                        .map(fieldError ->
                                new FieldErrorMessage(fieldError.getField(),
                                        fieldError.getDefaultMessage()))
                                .collect(Collectors.toList());
        return fieldErrorMessages;
    }
    @PutMapping("/edit")
    public ResponseEntity<PersonsInfo> update(@RequestBody PersonsInfo personsInfo) {
        if (personInfoRepository.findById(personsInfo.getPersonId()).isPresent())
            return new ResponseEntity(personInfoRepository.save(personsInfo), HttpStatus.OK);
        else
            return new ResponseEntity(personsInfo.badRequestMessage(), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{name}")
    public void delete(@PathVariable Integer id) {
        personInfoRepository.deleteById(id);
    }

}

//
//    @GetMapping("/last-name/{name}")
//    public Optional<List<PersonsInfo>> findByLastName(@PathVariable("name") String lastName) {
//
//        return personInfoRepository.findByLastName(lastName);
//    }

//    @GetMapping("/name")
//    public Object findByQuery(@RequestParam(value = "first", required = false) String first_name,
//                              @RequestParam(value = "last", required = false) String last_name) {
//        if (first_name != null && last_name != null)
//            return personInfoRepository.findByFirstNameAndLastName(first_name, last_name);
//        else if (first_name != null)
//            return personInfoRepository.findByFirstName(first_name);
//        else if (last_name != null)
//            return personInfoRepository.findByLastName(last_name);
//        else
//            return personInfoRepository.findAll();
//    }
